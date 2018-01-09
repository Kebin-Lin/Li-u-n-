import cs1.Keyboard;
public class Game2048{
    private Board b;
    public static void newGame(){
        for (int x = 0; x < 4; x++){
	    for (int y = 0; y < 4; y++){
	        b._board[x][y] = "    ";
	    }
	}
    }
    public static void main(String []args){
	newGame();
	while (b.gameStatus().equals("Ongoing")){
	    b.addBlock();
	    System.out.println(b);
	    System.out.println("Pick your move:");
	    String input = Keyboard.readString();
	    if (input.equals("u")){
		b.slideUp();
	    }
	    else if (input.equals("d")){
		b.slideDown();
	    }
	    else if (input.equals("l")){
		b.slideLeft();
	    }
	    else if (input.equals("r")){
		b.slideRight();
	    }
	    
	}
    }
}
