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
			showBoard();
			playerChoice(letter);
			break;
		case 'O':
			showBoard();
			playerChoice(letter);
			break;
		default:
			chooseLetter();
		}
	}

	/**
	 * @ Show the board so that user ca
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
	 * @ Allowing user to make a desired move
	 */
	public static void playerChoice(char letter) {
		char choice;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 2; i++) {
			choice = scanner.next().charAt(0);
			checkingForFreeSpace();
			replace(board, choice, letter);
			showBoard();
			choice = scanner.next().charAt(0);
			checkingForFreeSpace();
			replace(board, choice, letter);
			showBoard();
		}
		choice = scanner.next().charAt(0);
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
					return;
				} else {
					playerChoice(letter);
				}
			}
		}
	}

	/**
	 * @ checking toss to know whose gonna start the game
	 */
	public static void tossCheck() {
		Random random = new Random();
		int randomCheck = random.nextInt(2);
		if (randomCheck == 1) {
			System.out.println("Player won the toss");
		} else {
			System.out.println("Computer won the toss");
		}
	}
	/**
	 * @return
	 * Checking if there is a winner or not
	 */
	public static boolean checkingForWinner() {
		return (checkForRow() || checkForColumn() || checkForDiagonal());
	}

	/**
	 * @return
	 *  checking for row equality
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
	 * @return
	 * checking for column equality
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
	 * @return
	 * checking for diagonal equality
	 */
	public static boolean checkForDiagonal() {
		for (int i = 0; i < board.length; i++) {
			if (check(board[0][0], board[1][1], board[2][2]) == true || check(board[0][2], board[1][1], board[2][0]) == true)  {
				return true;
			}
		}
		return false;
	}
	public static boolean check(char c1, char c2, char c3) {
		return ((c1 == c2) && (c2 == c3));
		
	}
}
