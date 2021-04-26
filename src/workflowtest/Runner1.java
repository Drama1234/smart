package workflowtest;

import it.cnr.isti.smartfed.test.TestResult;
import workflowmapping.GeneticAllocator;
import workflowmapping.GeneticAllocator1;
import workflowmapping.GreedyAllocator;
import workflowmapping.RandomAllocator;
import workflowmapping.RoundRobinAllocator;

public class Runner1 {
	public static void main(String[] args) {
		String[] files = new String[] {"RemoteSense_83_1","RemoteSense_83_2","RemoteSense_83_3"};
		runworkflow(files);
	}
	
	private static void runworkflow(String[] filenames) {
		WorkflowDataset dataset = new WorkflowDataset(20, filenames,70);
		TestResult.reset();
		GeneticAllocator allocator = new GeneticAllocator();
		System.out.println("----------------------基于时间和成本的遗传算法---------------------------------------------------------");
		for(int i= 0 ; i < 5; i++) {
			allocator.setRandomSeed(i*7);
			Experiment experiment = new Experiment(allocator, dataset, i*7);
			experiment.run();
		}
		double AverageMakespan = TestResult.getCompletion().getMean();
		double AverageCost = TestResult.getCost().getMean();
		
		System.out.println("AverageMakespan:"+AverageMakespan);
		System.out.println("AverageCost:"+AverageCost);
		
		TestResult.reset();
		GeneticAllocator1 allocator1 = new GeneticAllocator1();
		System.out.println("---------------------基于多个目标约束的遗传算法---------------------------------------------------------");
		for(int i= 0 ; i < 5; i++) {
			allocator.setRandomSeed(i*7);
			Experiment experiment1 = new Experiment(allocator1, dataset, i*7);
			experiment1.run();
		}
		double AverageMakespan1 = TestResult.getCompletion().getMean();
		double AverageCost1 = TestResult.getCost().getMean();
		
		System.out.println("AverageMakespan:"+AverageMakespan1);
		System.out.println("AverageCost:"+AverageCost1);

		TestResult.reset();
		RandomAllocator allocator2 = new RandomAllocator();
		System.out.println("----------------随机算法------------------------------------");
		for(int i= 0 ; i < 5; i++) {
			allocator.setRandomSeed(i*7);
			Experiment experiment2 = new Experiment(allocator2, dataset, i*7);
			experiment2.run();
		}
		double AverageMakespan2 = TestResult.getCompletion().getMean();
		double AverageCost2 = TestResult.getCost().getMean();
		
		System.out.println("AverageMakespan:"+AverageMakespan2);
		System.out.println("AverageCost:"+AverageCost2);
		
		TestResult.reset();
		GreedyAllocator allocator3 = new GreedyAllocator();
		System.out.println("------------------------贪婪算法-------------------------------------------------");
		for(int i= 0 ; i < 5; i++) {
			allocator.setRandomSeed(i*7);
			Experiment experiment3 = new Experiment(allocator3, dataset, i*7);
			experiment3.run();
		}
		double AverageMakespan3 = TestResult.getCompletion().getMean();
		double AverageCost3 = TestResult.getCost().getMean();
		
		System.out.println("AverageMakespan:"+AverageMakespan3);
		System.out.println("AverageCost:"+AverageCost3);
		
		TestResult.reset();
		RoundRobinAllocator allocator4 = new RoundRobinAllocator();
		System.out.println("----------------轮询算法-------------------------------------------");
		for(int i= 0 ; i < 5; i++) {
			allocator.setRandomSeed(i*7);
			Experiment experiment4 = new Experiment(allocator4, dataset, i*7);
			experiment4.run();
		}
		double AverageMakespan4 = TestResult.getCompletion().getMean();
		double AverageCost4 = TestResult.getCost().getMean();
		
		System.out.println("AverageMakespan:"+AverageMakespan4);
		System.out.println("AverageCost:"+AverageCost4);
	}
}
