package com;

public class TicTacToeGame {
	static int board[][] = new int[3][3];
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
		System.out.println("Board is created");
	}
	public static void createBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j =0;j<board.length;j++) {
				board[i][j]=' ';
			}
		}
	}
}
