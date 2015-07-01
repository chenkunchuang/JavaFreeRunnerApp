package raceGame;

import java.util.LinkedList;


/**
 * This class is the module to manage all runners
 * @author cchuang
 *
 */
public class RaceMgr extends Thread{
	
	public static LinkedList<ThreadRunner> runnerDB = new LinkedList<>();
	
	public static void RunIsOver(ThreadRunner winner){
		for( ThreadRunner runnerDB_i : runnerDB  )
			runnerDB_i.interrupt();
	}
	
	/**
	 * 
	 * @param runner to add the runner info to DB
	 */
	
	public static void AddRunner(ThreadRunner runner){
		
		runnerDB.add(runner);
			
	}
	

	/**
	 * This is to load the runner info from the source
	 * @param choice: to choose which source to read from for runner information
	 */
	public void StartRun(int choice){
		runnerDB.clear();
		switch (choice)
		{
			case 1:
				System.out.println("Derby database is not supported");
				break;
				
			case 2:
				ThreadRunner Xml = new XmlRunners();
				Xml.LoadSourceAndRun();
				break;
				
			case 3:
				ThreadRunner Text = new TextRunners();
				Text.LoadSourceAndRun();
				break;
				
			case 4:
				ThreadRunner Default = new DefaultRunners();
				Default.LoadSourceAndRun();
				break;
				
			default:
				break;
		}
		// To wait all threads finish before preceeding
		 try {
			 	for(ThreadRunner runnerDB_i : runnerDB)
			 		runnerDB_i.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
