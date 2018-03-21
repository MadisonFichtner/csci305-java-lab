package csci305.javalab;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Create array of every type of player to simplify setting new players later
		Player[] allPlayers = {new Human("Human"), new StupidBot("StupidBot"), new RandomBot("RandomBot"),
				new IterativeBot("IterativeBot"), new LastPlayBot("LastPlayBot"), new MyBot("MyBot")};
		
		//Output for the user choosing 2 players
		System.out.println("Please choose two players:");
		System.out.println("(1) Human");
		System.out.println("(2) StupidBot");
		System.out.println("(3) RandomBot");
		System.out.println("(4) IterativeBot");
		System.out.println("(5) LastPlayBot");
		System.out.println("(6) MyBot\n");
		System.out.println("Select player 1: ");
		Player player1 = allPlayers[in.nextInt() - 1];
		System.out.println("Select player 2: ");
		Player player2 = allPlayers[in.nextInt() - 1];
		System.out.println("\n" + player1.getName() + " vs " + player2.getName() + ". Go!\n");
		
		//The 5 rounds of the game
		int player1Score = 0;
		int player2Score = 0;
		for(int i = 1; i <= 5; i++) {
			//Create new elements for each player for each round
			Element element1 = player1.play();										
			Element element2 = player2.play();
			
			//Sets the opponents previous play each round for the lastplaybot
			player1.last = element2;
			player2.last = element1;
			
			//Sets the players previous play for each round for mybot
			player1.lastElement = element1;
			player2.lastElement = element2;
			
			//Output for each rounds results
			System.out.println("\nRound " + i + ":");
			System.out.println("	Player 1 chose " + element1.getName());
			System.out.println("	Player 2 chose " + element2.getName());
			Outcome outcome = element1.compareTo(element2);
			System.out.println("	" + outcome.getRule());
			
			//If player one won the round
			if(outcome.getResult() == "Win") {
				System.out.println("	Player 1 won the round");
				player1Score++;
				player1.won = true;
				player2.won = false;
			}
			
			//If player 2 one the round
			else if(outcome.getResult() == "Lose") {
				System.out.println("	Player 2 won the round");
				player2Score++;
				player1.won = false;
				player2.won = true;
			}
			
			//If the players tied
			else
				System.out.println("	Round was a tie");
		}
		
		//Output for final score
		System.out.println("\nThe score is " + player1Score + " to " + player2Score + ".");
		
		//If player1 had a higher score
		if(player1Score > player2Score)
			System.out.println("Player 1 wins the game");
		
		//If player 2 had a higher score
		else if(player2Score > player1Score)
			System.out.println("Player 2 wins the game");
		
		//If players tied
		else
			System.out.println("Game was a draw");
	}
}
