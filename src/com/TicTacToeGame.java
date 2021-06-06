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
	 * @ Show the board so that user can choose a cell
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
}
