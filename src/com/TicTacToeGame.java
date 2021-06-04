package com;
import java.util.*;
public class TicTacToeGame {
	static int board[][] = new int[3][3];
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
		System.out.println("Board is created");
		chooseLetter();
	}
	public static void createBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				board[i][j]=' ';
			}
		}
	}
	public static void chooseLetter() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a letter from X, O to play the game");
		char letter = scanner.next().charAt(0);
		switch(letter) {
			case 'X' : System.out.println("Player has choosen X to play the game");
			break;
			case 'O' : System.out.println("Player has choosen O to play the game");
			break;
			default : System.out.println("Invalid, please enter a valid character");
		}
	}
}
