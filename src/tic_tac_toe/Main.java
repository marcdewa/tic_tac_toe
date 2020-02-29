package tic_tac_toe;

public class Main {
	public Main() {
		Board b = new Board();
		do{
			b.print();
			try {
				b.doTurn();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(b.isWin(1)) {
				System.out.println("O winner!");
				break;
			}
			
			if(b.isWin(-1)) {
				System.out.println("X winner!");
				break;
			}
	
			if(b.isDraw()) {
				System.out.println("draw");
				break;
			}
		} while(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
