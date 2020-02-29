package tic_tac_toe;

import java.util.Scanner;

public class Board {
	private int[][] grids;
	
	//1 -> O
	//-1 -> X
	private int turn;
	
	public Board() {
		grids = new int[3][3];
		turn = 1;
	}
	
	public boolean isWin(int side) {
		//vertical
		for(int i = 0; i < 3; i++) {
			boolean win = true;
			for(int j = 0; j < 3; j++) {
				int g = grids[i][j];
				if(g != side) {
					win = false;
					break;
				}
			}
			if(win) return true;
		}
		
		//horizontal
		for(int i = 0; i < 3; i++) {
			boolean win = true;
			for(int j = 0; j < 3; j++) {
				int g = grids[j][i];
				if(g != side) {
					win = false;
					break;
				}
			}
			if(win) return true;
		}
		
		//diagonal kiri atas sampai kanan bawah
		boolean win = true;
		for(int i = 0, j = 0; i < 3; i++, j++) {
			int g = grids[i][j];
			if(g != side) {
				win = false;
				break;
			}
		}
		if(win) return true;
		
		//diagonal kanan atas sampai kiri bawah
		win = true;
		for(int i = 0, j = 2; i < 3; i++, j--) {
			int g = grids[i][j];
			if(g != side) {
				win = false;
				break;
			}
		}
		if(win) return true;
		
		return false;
	}
	
	Scanner scan = new Scanner(System.in);
	public void doTurn() throws Exception {
		String s = turn == 1 ? "O" : "X";
		System.out.print(s + " turn: ");
		
		String move = scan.nextLine();
		if(move.length() != 2) {
			throw new Exception("invalid move: query must be 2 characters");
		}
		
		char c1 = move.charAt(0);
		char c2 = move.charAt(1);
		
		if(c1 < 'A' || c1 > 'C') {
			throw new Exception("invalid move: 1st chars");
		}
		
		if(c2 < '1' || c2 > '3') {
			throw new Exception("invalid move: 2nd chars");	
		}
		
		if(grids[c1-'A'][c2-'1'] != 0) {
			throw new Exception("invalid move: already occupied");
		}
		
		grids[c1-'A'][c2-'1'] = turn;
		turn *= -1;
	}
	
	public boolean isDraw() {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				int g = grids[i][j];
				if(g == 0) return false;
			}
		}
		return true;
	}
	
	public void print() {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int g = grids[i][j];
				switch (g) {
				case 1:
					System.out.print("O");
					break;
				case -1:
					System.out.print("X");
					break;
				default:
					System.out.print("-");
					break;
				}
			}
			System.out.println("");
		}
	}
}
