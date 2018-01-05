import java.util.ArrayList;

public class Board {
    public Block[][] _board;
    
    public Board() {
	_board = new Block[2][2];
	for (int i = 0; i < 2; i++) {
	    for (int i2 = 0; i2 < 2; i++) {
		_board[i][i2] = new Block();
	    }
	}
    }

    public void addBlock() {//Adds a block of value 2 or 4 on an empty space
	ArrayList<int[]> empty = new ArrayList<int[]>();
	
	for (int i = 0; i < 2; i++) {
	    for (int i2 = 0; i < 2; i++) {
		if (_board[i][i2].isEmpty()) {
		    int[] adding = {i1,i2};
		    empty.add(adding);
		}
	    }
	}

	if (empty.size() == 0) {return;}

	int[] selected = empty.get((int)(empty.size() * Math.random()));

	_board[ selected[0] ][ selected[1] ].set( ((int)(Math.random()*2) + 1 ) * 2);
    }
    
}
