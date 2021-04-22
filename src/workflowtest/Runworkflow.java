//package workflowtest;
//
//
//
//import it.cnr.isti.smartfed.test.TestResult;
//import workflowmapping.GeneticAllocator;
//
//public class Runworkflow {
//	public String filename;
//	
//	public Runworkflow(String filename) {
//		this.filename = filename;
//	}
//	
//	public void runworkflow() {
//		WorkflowDataset dataset = new WorkflowDataset(20, filename);
//		
//		TestResult.reset();
//		GeneticAllocator allocator = new GeneticAllocator();
//		System.out.println("基于时间和成本的遗传算法");
////		allocator.setPolicyType();//全局网络		
////		for(int i= 0;i<10;i++) {
//			allocator.setRandomSeed(7);
//			Experiment experiment = new Experiment(allocator, dataset, 7);
//			experiment.run();
//		
//		double makespan = TestResult.getCompletion().getMean();
//		double cost = TestResult.getCost().getMean();
//		double realduration = TestResult.getRealDuration().getMean();
//		
//		System.out.println("makespan:"+makespan);
//		System.out.println("cost:"+cost);
//		System.out.println("realduration:"+realduration);
//		System.out.println();
//		
////		sb.append(filename).append("\t");
////		sb.append(makespan).append("\t").append(cost).append("\t").append(realduration).append("\t\n");
//	}
//}
//
//class RunworkflowThread extends Runworkflow implements Runnable{
//	
//	public RunworkflowThread(String filename) {
//		super(filename);
//		// TODO Auto-generated constructor stub
//		//this.Runworkflow = Runworkflow;
//	}
//	
//	@Override
//	public void run() {
//		//String filename = null;
//		runworkflow();
//	}
//}
