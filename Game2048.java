import cs1.Keyboard;
public class Game2048{
    public static void main(String [] args){
	Board b = new Board();
	b.addBlock();
	b.addBlock();
	while (b.gameStatus().equals("Ongoing")){
	    System.out.println(b);
	    System.out.println("Pick a direction: Up, Down, Left, or Right.");
	    String input = Keyboard.readString();
	    if (input.equals("u") || input.equals("U"))
		b.slideUp();
	    else if (input.equals("d") || input.equals("D"))
		b.slideDown();
	    else if (input.equals("l") || input.equals("L"))
		b.slideLeft();
	    else if (input.equals("r") || input.equals("R"))
		b.slideRight();
	    else{
		System.out.println("Invalid move. Please try again.");
		input = Keyboard.readString();
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
