package raceGame;

/**
 * This is for default two runners
 * @author cchuang
 *
 */
public class DefaultRunners extends ThreadRunner{
	
	public DefaultRunners(){}
	
	public DefaultRunners(String name, int speed, int rest){
		super(name, speed, rest);
	}
	
	/**
	 * This is to choose from default runners
	 */
	@Override
	public void ChooseSource(){
		
		ThreadRunner runner1 = new DefaultRunners("Tortoise",10,0);
		ThreadRunner runner2 = new DefaultRunners("Hare",100,90);
		
		RaceMgr.AddRunner(runner1);
		RaceMgr.AddRunner(runner2);
		//RaceMgr.createRunnerThread("Hare",100,80);
	}
	

}
