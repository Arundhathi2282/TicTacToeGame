package com;

import java.util.*;

public class TicTacToeGame {
	static char board[][] = new char[3][3];

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
		System.out.println("Board is created");
		System.out.println(letter);
		chooseLetter();
		playerChoice(letter);
	}

	/**
	 * @CreatingBoard
	 */
	public static void createBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	/**
	 * @ChoosingLetter
	 */
	static char letter;

	public static void chooseLetter() {
		tossCheck();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a letter from X, O to play the game");
		char letter = scanner.next().charAt(0);
		switch (letter) {
		case 'X':
			System.out.println("You have choosen X to play the game");
			System.out.println("The board is : ");
			showBoard();
			playerChoice(letter);
			break;
		case 'O':
			System.out.println("You have choosen O to play the game");
			System.out.println("The board is : ");
			showBoard();
			playerChoice(letter);
			break;
		default:
			System.out.println("Invalid, please enter a valid character");
			chooseLetter();
		}
	}

	/**
	 * @Showboard
	 */
	public static void showBoard() {
		int k = 1;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Character.forDigit(k++, 10);
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
	}

	/**
	 * @Allowingusertomakeadesiredmove
	 */
	public static void playerChoice(char letter) {
		char choice;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			System.out.println("Player1 Turn :");
			choice = scanner.next().charAt(0);
			System.out.println(choice);
			checkingForFreeSpace();
			replace(board, choice, letter);
			showBoard();
			System.out.println("Player2 Turn :");
			choice = scanner.next().charAt(0);
			System.out.println(choice);
			checkingForFreeSpace();
			replace(board, choice, letter);
			showBoard();
		}
		System.out.println("Player1 Turn :");
		choice = scanner.next().charAt(0);
		System.out.println(choice);
		checkingForFreeSpace();
		replace(board, choice, letter);
		showBoard();
	}

	/**
	 * 
	 * @param board
	 * @param find
	 * @param replace
	 */
	public static void replace(char board[][], char find, char replace) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == find) {
					board[i][j] = replace;
					return;
				}
			}
		}
	}

	/**
	 * @ Checking for free space to make a move
	 */
	public static void checkingForFreeSpace() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != letter) {
					System.out.println("Yes,there is a free space you can make a move");
					return;
				} else {
					System.out.println("No, there is no free space choose another choice");
					playerChoice(letter);
				}
			}
		}
	}

	/**
	 * @ Toss to check who plays first
	 */
	public static void tossCheck() {
		Random random = new Random();
		int randomCheck = random.nextInt(2);
		int isPlayer1 = 0;
		if (randomCheck == isPlayer1) {
			System.out.println("Player1 won the toss");
		} else {
			System.out.println("Player2 won the toss");
		}
	}
}
