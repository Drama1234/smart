package workflowtest;

import it.cnr.isti.smartfed.test.TestResult;
import workflowmapping.GeneticAllocator;

public class Runner1 {
	public static void main(String[] args) {
		String[] files = new String[] {"RemoteSense_13_1","RemoteSense_13_2","RemoteSense_13_3"};
		runworkflow(files);
	}
	
	private static void runworkflow(String[] filenames) {
		WorkflowDataset dataset = new WorkflowDataset(20, filenames);
		GeneticAllocator allocator = new GeneticAllocator();
		System.out.println("基于时间和成本的遗传算法");
		allocator.setRandomSeed(7);
		Experiment experiment = new Experiment(allocator, dataset, 7);
		experiment.run();
		
		double makespan = TestResult.getCompletion().getMean();
		double cost = TestResult.getCost().getMean();
		double realduration = TestResult.getRealDuration().getMean();
		
		System.out.println("makespan:"+makespan);
		System.out.println("cost:"+cost);
		System.out.println("realduration:"+realduration);
	}

}
