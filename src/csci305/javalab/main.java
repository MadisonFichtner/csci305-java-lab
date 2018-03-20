package csci305.javalab;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Player[] allPlayers = {new Human("Human"), new StupidBot("StupidBot"), new RandomBot("RandomBot"),
				new IterativeBot("IterativeBot"), new LastPlayBot("LastPlayBot"), new MyBot("MyBot")};
		
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
		
		int player1Score = 0;
		int player2Score = 0;
		for(int i = 1; i <= 5; i++) {
			Element element1 = player1.play();
			Element element2 = player2.play();
			
			System.out.println("\nRound " + i + ":");
			System.out.println("	Player 1 chose " + element1.getName());
			System.out.println("	Player 2 chose " + element2.getName());
			Outcome outcome = element1.compareTo(element2);
			System.out.println("	" + outcome.getRule());
			if(outcome.getResult() == "Win") {
				System.out.println("	Player 1 won the round");
				player1Score++;
			}
			else if(outcome.getResult() == "Lose") {
				System.out.println("	Player 2 won the round");
				player2Score++;
			}
			else
				System.out.println("	Round was a tie");
		}
		
		System.out.println("\nThe score is " + player1Score + " to " + player2Score + ".");
		if(player1Score > player2Score)
			System.out.println("Player 1 wins the game");
		else if(player2Score > player1Score)
			System.out.println("Player 2 wins the game");
		else
			System.out.println("Game was a draw");
	}
}
