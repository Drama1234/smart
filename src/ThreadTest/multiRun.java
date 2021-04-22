//package ThreadTest;
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Calendar;
//import java.util.List;
//
//import org.cloudbus.cloudsim.Log;
//import org.cloudbus.cloudsim.core.CloudSim;
//
//import federation.resources.FederationDatacenter;
//import federation.resources.ResourceCounter;
//import it.cnr.isti.smartfed.test.TestResult;
//import workflowfederation.Federation;
//import workflowfederation.MonitoringHub;
//import workflowmapping.GeneticAllocator;
//import workflownetworking.InternetEstimator;
//import workflowtest.WorkflowDataset;
//
//public class multiRun {
//	public static void main(String[] args) {
//		Runtime run = Runtime.getRuntime();
//		
//		//initialize only one datacenters to make sure all the processes under the same circumstance
//		/*
//		 * do something here;
//		 * new datacenters
//		 * 
//		*/
//		
//		
//		
//		//and write to des file so that all children processes can read the same circumstance
//		
//		/* do something here;
//		 * write attribute to the des file such as String desfile = "makeSame.xml"
//		 * assert: content of desfile unchanged during invoke multi-processes
//		 */
//		
//		//first create federation and datacenters, then create multiple application by multiple thread
//		TestResult.reset();
//		GeneticAllocator allocator = new GeneticAllocator();
//		
//		// init the cloudsim simulator
//		Log.enable();
//		int num_user = 1;   // users
//		Calendar calendar = Calendar.getInstance();
//		boolean trace_flag = true;  // trace events
//		CloudSim.init(num_user, calendar, trace_flag);
//		
//		//创建Federation
//		Federation federation = new Federation(allocator,77);
//		CloudSim.addEntity(federation);
//		
//		// 重新设置资源统计
//		ResourceCounter.reset();
//		
//		WorkflowDataset dataset = new WorkflowDataset(20);
//		
//		// 创建数据中心
//		List<FederationDatacenter> datacenters = dataset.createDatacenters();
//		System.out.println("数据中心数量："+datacenters.size());
//		federation.setDatacenters(datacenters);
//		
//		allocator.setRandomSeed(77);
//		
//		// 创建网络
//		InternetEstimator internetEstimator = dataset.createInternetEstimator(datacenters);
//		allocator.setNetEstimator(internetEstimator);
//		
//		//创建监控
//		int schedulingInterval = 1; // probably simulation time
//		MonitoringHub monitor = new MonitoringHub(datacenters, schedulingInterval);
//		CloudSim.addEntity(monitor);
//		allocator.setMonitoring(monitor);
//		
//		
//		String[] files = new String[] {"RemoteSense_13_1","RemoteSense_13_2","RemoteSense_13_3"};
//		for(int i = 0;i < files.length;i++) {
//			Process p = null;
//			//to start a Runner.java
//			//file[i] is the input file
//			//desfile is the datacenters parameter setting
//			String cmd = "java -jar smart.jar " + files[i];// + desfile;
//			try {
//				p = run.exec(cmd);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
////			BufferedInputStream in1 = new BufferedInputStream(p.getInputStream());
////			BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
////			String s1;
////			try {
////				while ((s1 = br1.readLine()) != null)
////					System.out.println(s1);
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//		}
//	}
//}
