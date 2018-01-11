import cs1.Keyboard;
public class Game2048{
    public static void main(String [] args){
	Board b = new Board();
	b.addBlock();
	b.addBlock();
	boolean badInput = false;
	while (b.gameStatus().equals("Ongoing")){
	    for (int i = 0; i < 64; i++) { System.out.println(); }
	    System.out.println("Score: " + b.getScore());
	    System.out.println(b);
	    System.out.println("Pick a direction: Up, Left, Down, or Right.");
	    System.out.println("Type in w, a, s, or d for each direction, respectively.");
	    if (badInput) {System.out.println("Invalid move. Please try again.");}
	    else {System.out.println();}
	    badInput = false;
	    String input = Keyboard.readString().toLowerCase();
	    if (input.equals("w"))
		b.slideUp();
	    else if (input.equals("s"))
		b.slideDown();
	    else if (input.equals("a"))
		b.slideLeft();
	    else if (input.equals("d"))
		b.slideRight();
	    else{
		badInput = true;
	    }
	}
	if (b.gameStatus().equals("Loss")){
	    System.out.println(b);
	    System.out.println("Sorry, you lost.");
	}
	else{
	    System.out.println(b);
	    System.out.println("Congrats! You won!");
	}
    }
}
