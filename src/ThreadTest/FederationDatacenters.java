package ThreadTest;

import java.util.List;

import federation.resources.FederationDatacenter;
import workflowDatacenter.DatacenterGenerator;

public class FederationDatacenters {
	private int numOfDatacenters;
	
	public FederationDatacenters(int numOfDatacenters) {
		this.numOfDatacenters = numOfDatacenters;
	}
	
	public List<FederationDatacenter> createFederationDatacenters(){
		
		DatacenterGenerator dg = new DatacenterGenerator(70*15);
		int numHost = 50  * numOfDatacenters; // it will assign more or less 1000 host to each datacenter
		List<FederationDatacenter> dcs = dg.getDatacenters(numOfDatacenters, numHost);
		return dcs;
	}

}
