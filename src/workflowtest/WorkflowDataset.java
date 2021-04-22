package workflowtest;

import java.util.ArrayList;
import java.util.List;

import application.Application;
import federation.resources.FederationDatacenter;
import workflowDatacenter.DatacenterGenerator;
import workflowDatacenter.WorkflowGenerator;
import workflownetworking.InternetEstimator;


public class WorkflowDataset implements InterfaceDataSet{
	protected long seed = 77;
	
	private String[] filenames;
	private int numOfDatacenters;
	
//	public WorkflowDataset(String filename)
//	{
//		this.filename = filename;
////		this.numOfDatacenters = numOfDatacenters;
//	}
	
	public WorkflowDataset(int numOfDatacenters,String[] filenames) {
		this.numOfDatacenters = numOfDatacenters;
		this.filenames = filenames;
	}
	
	public void setSeed(long seed)
	{
		this.seed = seed;
	}
	
//	 public void setFilename(String[] filenames) {
//		this.filenames = filenames;
//	}
	
	@Override
	public List<FederationDatacenter> createDatacenters(){
		DatacenterGenerator dg = new DatacenterGenerator(this.seed*15);
		int numHost = 50  * numOfDatacenters; // it will assign more or less 1000 host to each datacenter
		List<FederationDatacenter> dcs = dg.getDatacenters(numOfDatacenters, numHost);
		return dcs;
	}

	@Override
	public List<Application> createApplications(int userId,List<FederationDatacenter> datacenters) {
		List<Application> apps = new ArrayList<Application>();
		for (String filename : filenames) {
			apps.add(new WorkflowGenerator(filename, userId, datacenters));
		}
		return apps;
	}
	

	@Override
	public InternetEstimator createInternetEstimator(List<FederationDatacenter> datacenters) {
		InternetEstimator inetEst = new InternetEstimator(datacenters, seed);
		return inetEst;
	}

//	@Override
//	public List<List<Application>> createMultiworkflow(int userId, List<FederationDatacenter> datacenters) {
//		List<List<Application>> multiworkflow = new ArrayList<List<Application>>();
//		multiworkflow.get(0).add(new WorkflowGenerator(filename, userId, datacenters));
//		return null;
//	}
}
