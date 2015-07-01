/**
 * 
 */
package raceGame;
import io.*;

/**
 * This is the class to create a thread for each runner
 * @author cchuang
 * 
 * 
 */
public abstract class ThreadRunner extends Thread implements RunnerLoadSource{
	
	private int runnerSpeed, restPercentage, distanceComplete;
	
	public ThreadRunner(){}
	public ThreadRunner(String name, int runnerSpeed, int restPercentage){
		super(name);
		distanceComplete = 0;
		this.runnerSpeed = runnerSpeed;
		this.restPercentage =  restPercentage;	
		
	}

	@Override
	public void run() {
			while (!this.isInterrupted())
			{
				if ( ( 100*Math.random() > restPercentage ) )
				{
				   
						distanceComplete += runnerSpeed;
						if(distanceComplete <1000)
							System.out.println(this.getName() + " : " + distanceComplete);
				  
					else
					{	
						RaceApp.Finish(this);
						break;
					}
				}
			    try
			    {
			    	Thread.sleep(100);
			    }
			    catch(InterruptedException e)
			    {
			    	//System.out.println(this);
			    	break;
			    
			    }
		}	
			if(distanceComplete < 1000)
	    		System.out.println(this);
			    
       
		    
		
}
	
	
	/**
	 * 
	 *  Print how many distance the runner complete 
	 *  
	 */
	@Override
	public String toString(){
		return this.getName() + " : You beat me fair and square." ;
	}
	
	/**
	 * This is to load the runner info from the source
	 */
	public void LoadSourceAndRun(){
		ChooseSource();
		ReadyRun();
	}
	
	/**
	 * This is to choose which source to use
	 */
	public abstract void ChooseSource();
	
	/**
	 * Start all runners
	 */
	public void ReadyRun(){
		for (ThreadRunner runner_i : RaceMgr.runnerDB)
		{
			runner_i.start();
		}
	}
}
