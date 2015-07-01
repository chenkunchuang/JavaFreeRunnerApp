package raceGame;

import java.io.*;
import java.nio.file.*;



/**
 * This is loading runners infomation from text file 
 * @author cchuang
 *
 */
public class TextRunners extends ThreadRunner{
	
	/**
	 * Default constructor doing nothing
	 */
	public TextRunners(){}
	/**
	 * TextRunner constructor
	 * @param name: runner name
	 * @param speed: runner speed
	 * @param rest: runner rest percentage
	 */
	public TextRunners(String name, int speed, int rest) {
		super(name, speed, rest);
	}
	
	/**
	 * Read from txt file for runner information
	 */
	@Override
	public void ChooseSource(){
		Path filePath = Paths.get("FinalTextData.txt");
		File fileObj = filePath.toFile();
        if(Files.exists(filePath))
        {
			try (BufferedReader in = new BufferedReader(
									 new FileReader(fileObj)))
			{
				
				String line = in.readLine();
				while(line !=null)
				{	
					//Read from Text file 
					String[] columns = line.split("\\s+");
					
						String runnerName = columns[0];
						String runnerSpeed = columns[1];
						String runnerRest =  columns[2];
								
					//load the runner info
					ThreadRunner runner = new TextRunners(runnerName, Integer.parseInt(runnerSpeed), Integer.parseInt(runnerRest));
					RaceMgr.AddRunner(runner);
					
					line = in.readLine();
				}
			}
			catch (IOException e)
			{
				System.out.println(e);
			}
			
		}
	}
}
