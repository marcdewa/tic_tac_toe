package tic_tac_toe;

public class BoardPrinter {
	private Board board;

	public BoardPrinter(Board board) {
		super();
		this.board = board;
	}
	
	public void print() {
		Side[][] grids = board.getGrids();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				Side g = grids[i][j];
				if(g == Side.O) {
					System.out.print("O");
				}
				if(g == Side.X) {
					System.out.print("X");
				}
				if(g == Side.Neutral) {
					System.out.print("X");
				}
			}
			System.out.println("");
		}
	}
}
