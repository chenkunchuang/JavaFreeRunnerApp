/**
 * 
 */
package raceGame;

import java.util.*;


/**
 * @author cchuang
 * This is the Application of race
 */
public class RaceApp {
	    
    
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args){

		RaceMgr raceMgr = new RaceMgr();

		Scanner sc = new Scanner(System.in);
		String wait = "";
		
		while (wait.equals(""))
		{	
			System.out.println("Welcome to the Marathon Race Runner Program" + "\n");
			System.out.println("Select your data source: " + "\n");
			System.out.println("1. Derby database");
			System.out.println("2. XML file");
			System.out.println("3. Text file");
			System.out.println("4. Default two runners");
			System.out.println("5. Exit");
			System.out.print ("\n");
			int choice = Validator.getInt(sc, "Enter your choice: ", 1, 5);
			
			if (choice ==5 )
			{
				System.out.println("Thank you for using my Marathon Race Program");
				break;
			}
			else
				raceMgr.StartRun(choice);
			
			
			
				System.out.print("\n"+"Press Enter to continue...");
				wait = sc.nextLine().trim();
				while(!wait.isEmpty()){
					System.out.println("Wrong input!" + "\n" + "Please Press Enter to continue");
					wait = sc.nextLine().trim();
				}

		}
		sc.close();
}
	

	/**
	 * Passing arraylist of runners and interrupt all runners
	 * @param winner  this is the winner who calls Finish method
	 */
	public static synchronized void Finish (ThreadRunner winner) {
		System.out.println(winner.getName() + " : 1000" + "\n" +
				winner.getName() + " : I finished!" + "\n" +    
                "\n" + "The race is over! The " + 
                winner.getName() + " is the winner." + "\n");
	
		RaceMgr.RunIsOver(winner);
	
	}
	


}
