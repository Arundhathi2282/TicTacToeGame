package com;

import java.util.*;

public class TicTacToeGame {
	static char board[][] = new char[3][3];

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
		System.out.println(letter);
		chooseLetter();
		playerChoice(letter);
		checkingForWinner();
		checkCpuWin();
		cornerCheck();
		subsequentChoice();
	}

	/**
	 * @ Creating Board for the Tic Tac Toe Game
	 */
	public static void createBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/**
	 * @ Choosing Letter a letter to play the game
	 */
	static char letter;

	public static void chooseLetter() {
		Scanner scanner = new Scanner(System.in);
		tossCheck();
		char letter = scanner.next().charAt(0);
		switch (letter) {
		case 'X':
			System.out.println("You have choosen X,continue to play");
			showBoard();
			playerChoice(letter);
			break;
		case 'O':
			System.out.println("You have choosen O,continue to play");
			showBoard();
			playerChoice(letter);
			break;
		default:
			System.out.println("Invalid, coose again");
			chooseLetter();
		}
	}

	/**
	 * @ Show the board so that user can choose a valid cell
	 */
	public static void showBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
	}

	/**
	 * @ Allowing user to make a desired move
	 */
	public static void playerChoice(char letter) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			int playerChoice = scanner.nextInt();
			switch (playerChoice) {
			case 1:
				checkingForFreeSpace();
				board[0][0] = letter;
				showBoard();
				computerChoice();
				break;
			case 2:
				checkingForFreeSpace();
				board[0][1] = letter;
				showBoard();
				computerChoice();
				break;
			case 3:
				checkingForFreeSpace();
				board[0][2] = letter;
				showBoard();
				computerChoice();
				break;
			case 4:
				checkingForFreeSpace();
				board[1][0] = letter;
				showBoard();
				computerChoice();
				break;
			case 5:
				checkingForFreeSpace();
				board[1][1] = letter;
				showBoard();
				computerChoice();
				break;
			case 6:
				checkingForFreeSpace();
				board[1][2] = letter;
				showBoard();
				computerChoice();
				break;
			case 7:
				checkingForFreeSpace();
				board[2][0] = letter;
				showBoard();
				computerChoice();
				break;
			case 8:
				checkingForFreeSpace();
				board[2][1] = letter;
				showBoard();
				computerChoice();
				break;
			case 9:
				checkingForFreeSpace();
				board[2][2] = letter;
				showBoard();
				computerChoice();
				break;
			}
		}
	}

	public static void computerChoice() {
		int computerChoice;
		Random random = new Random();
		if (letter == 'X') {
			computerChoice = 1 + random.nextInt(9);
			System.out.println(computerChoice);
			switch (computerChoice) {
			case 1:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 2:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 3:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 4:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 5:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 6:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 7:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 8:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;
			case 9:
				checkingForFreeSpace();
				board[0][0] = 'O';
				showBoard();
				break;

			}
		}
	}

	/**
	 * @ Checking for free space to make a move
	 */
	public static boolean checkingForFreeSpace() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != letter) {
					return true;
				} else {
					playerChoice(letter);
				}
			}
		}
		return false;
	}

	/**
	 * @ checking toss to know who is going to start the game first
	 */
	public static String tossCheck() {
		Random random = new Random();
		String user;
		int randomCheck = random.nextInt(2);
		if (randomCheck == 1) {
			System.out.println("Player won the toss");
			user = "Player";
		} else {
			System.out.println("Computer won the toss");
			user = "CPU";
		}
		return user;
	}
	public static boolean cornerCheck() {
		boolean result = checkingForWinner();
		if(result == false) {
			checkingForFreeSpace();
			board[0][0]=letter;
			checkingForFreeSpace();
			board[0][2]=letter;
			checkingForFreeSpace();
			board[2][0]=letter;
			checkingForFreeSpace();
			board[2][2]=letter;
			return true;
		}
		return false;
	}
	public static void subsequentChoice() {
		boolean check = cornerCheck();
		if(check == false) {
			board[1][1] = letter;
		}
		if(board[1][1] == letter) {
			checkingForFreeSpace();
			board[1][0]=letter;
			checkingForFreeSpace();
			board[1][0]=letter;
		}
	}

	/**
	 * @return If computer gets its turn, it first check for the win then make a
	 *         move
	 */
	public static boolean checkCpuWin() {
		String name = tossCheck();
		if (name.equals("CPU")) {
			checkingForWinner();
			playerChoice(letter);
		}
		return false;
	}

	/**
	 * @return Checking if there is a winner or not
	 */
	public static boolean checkingForWinner() {
		return (checkForRow() || checkForColumn() || checkForDiagonal());
	}

	/**
	 * @return checking for row equality
	 */
	public static boolean checkForRow() {
		for (int i = 0; i < board.length; i++) {
			if (check(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return checking for column equality
	 */
	public static boolean checkForColumn() {
		for (int i = 0; i < board.length; i++) {
			if (check(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return checking for diagonal equality
	 */
	public static boolean checkForDiagonal() {
		for (int i = 0; i < board.length; i++) {
			if (check(board[0][0], board[1][1], board[2][2]) == true
					|| check(board[0][2], board[1][1], board[2][0]) == true) {
				return true;
			}
		}
		return false;
	}

	public static boolean check(char c1, char c2, char c3) {
		return ((c1 == c2) && (c2 == c3));

	}
}
