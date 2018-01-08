import java.util.ArrayList;

public class Board {
    public int num0s;
    public Block[][] _board;
    
    public Board() {
	num0s = 16;
	_board = new Block[2][2];
	for (int i = 0; i < 2; i++) {
	    for (int i2 = 0; i2 < 2; i++) {
		_board[i][i2] = new Block();
	    }
	}
    }
    /*
    public void addBlock() {//Adds a block of value 2 or 4 on an empty space
	ArrayList<int[]> empty = new ArrayList<int[]>(); //ArrayList for empty spots
	
	for (int i = 0; i < 2; i++) {//Look through the _board for empty spots
	    for (int i2 = 0; i < 2; i++) {
		if (_board[i][i2].isEmpty()) {//Add empty spot into the ArrayList
		    int[] adding = new int[2];
		    adding[0] = i;
		    adding[1] = i2;
		    empty.add(adding);
		}
	    }
	}

	if (empty.size() == 0) {return;}//D

	int[] selected = empty.get((int)(empty.size() * Math.random()));

	_board[ selected[0] ][ selected[1] ].set( ((int)(Math.random()*2) + 1 ) * 2);
    } */

    public void addBlock() {
	int pos = (int)(Math.random() * num0s);
	int index = 0;
	for (int r = 0; r < 4; r++) {
	    for (int c = 0; c < 4; c++) {
		if (index == pos) {
		    board[r][c] = ((int)(Math.random()*2)+1)*2;
		    num0s--;
		    return;
		}
		index++;
	    }
	}
    }
}
