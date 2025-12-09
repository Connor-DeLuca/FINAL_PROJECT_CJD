

public class Application {

	public static void main(String[] args) {
		Boolean playAgain = true;
		
		while (playAgain) {
			Game gameManager = new Game();
			gameManager.start();
			// ask if the user would like to play again... if so, restart the game
			System.out.println("Would you like to play again?");
			System.out.println("1: Yes");
			System.out.println("2: No");
			int playAgainChoice = gameManager.promptMenuChoice("",1,2);
			if (playAgainChoice == 1) {
				playAgain = true;
			}
			else {
				playAgain = false;
			}
		}
		
		System.exit(0);
		// I learned how to end the process with this site:
		// https://www.geeksforgeeks.org/java/system-exit-in-java/
	
	}

}
