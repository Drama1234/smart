package workflowmapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.Vm;

import application.Application;
import federation.resources.FederationDatacenter;
import workflowfederation.UtilityPrint;

public class MappingSolution {
	private HashMap<Cloudlet, FederationDatacenter> mapping;
	private boolean valid = true;
	private String allocatorName = "UNKNOWN";
	private Application application;
	
	/**
	 * It constructs a MappingSolution, given an application. The solutions should be 
	 * set with the set method. 
	 * @param application
	 */
	public MappingSolution(Application application)
	{
		this.application = application;
		mapping = new HashMap<Cloudlet, FederationDatacenter>();
	}
	
	public HashMap<Cloudlet, FederationDatacenter> getMapping() {
		return mapping;
	}
	
	public void set(Cloudlet cloudlet, FederationDatacenter dc){
		mapping.put(cloudlet, dc);
	}
	
	public FederationDatacenter unset(Cloudlet cloudlet){
		return mapping.remove(cloudlet);
	}
	
	public Application getApplication(){
		return application;
	}
	
	public boolean isValid(){
		return valid;
	}
	
	public void setValid(boolean valid){
		this.valid = valid;
	}

	public String getAllocatorName() {
		return allocatorName;
	}

	public void setAllocatorName(String allocatorName) {
		this.allocatorName = allocatorName;
	}

	@Override
	public String toString() {
		final int maxLen = 5;
		printMapping();
		return "[MappingSolution] First " + maxLen + " results"
				+ (mapping != null ? toString(mapping.entrySet(), maxLen): null);
	}
	
	public static<T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
		  List<T> list = new ArrayList<T>(c);
		  java.util.Collections.sort(list);
		  return list;
	}
	
	public void printMapping(){
		Set<Cloudlet> s = mapping.keySet();
		SortedSet<Cloudlet> ss  = new TreeSet<Cloudlet>(new Comparator<Cloudlet>() {
			@Override
			public int compare(Cloudlet first, Cloudlet second) {
				if (first.getCloudletId() > second.getCloudletId()) 
					return 1; //greater
				else if (first.getCloudletId() < second.getCloudletId())
					return -1; //smaller
				return 0; // equal
			}
		});
		for (Cloudlet c : s)
			ss.add(c);
		
		for (Cloudlet c : ss)
			System.out.println("c# "+ c.getCloudletId() + ", d#" +  mapping.get(c).getId());
	}
	
	/**
	 * toString helper
	 */
	private String toString(Collection<Entry<Cloudlet, FederationDatacenter>> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append( "\n ");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(" ");
			Entry<Cloudlet, FederationDatacenter> n = (Entry<Cloudlet, FederationDatacenter>) iterator.next();
			Vm vm = application.getVertexForCloudlet(n.getKey()).getAssociatedVm(n.getKey());
			builder.append(UtilityPrint.toString(n.getKey()) + "("+UtilityPrint.toString(vm)+")-> " + n.getValue()+"\n");
		}
		builder.append("Is valid: "+this.isValid());
		builder.append("\nAllocator: "+this.allocatorName);
		return builder.toString();
	}
	
	/**
	 * Check if this mapping is the same solution than the 
	 * given target mapping	 
	 * @param target
	 * @return
	 */
	public boolean isSameSolution(MappingSolution target)
	{
		// Check that this and target have the same size
		if (mapping.size() != target.getMapping().size())
			return false;
		
		// Check the values of this against target
		for (Cloudlet c: mapping.keySet())
		{
			FederationDatacenter targetValue = target.getMapping().get(c);
			FederationDatacenter thisValue = mapping.get(c);
			
			if (targetValue != null && thisValue != null)
			{
				if (targetValue.getId() != thisValue.getId())
					return false;
			}
		}
		return true;
	}
}
