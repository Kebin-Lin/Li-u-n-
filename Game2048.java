import cs1.Keyboard;
public class Game2048{
    public static void main(String [] args){
	Board b = new Board();
	b.addBlock(); //Add two blocks for the start of a board
	b.addBlock();
	boolean badInput = false;
	while (b.gameStatus().equals("Ongoing")){
	    for (int i = 0; i < 64; i++) { System.out.println(); } //"Clears" terminal
	    System.out.println("Score: " + b.getScore()); //Prints the score of the board
	    System.out.println(b); //Prints board
	    System.out.println("Pick a direction: Up, Left, Down, or Right."); //Prints instructions
	    System.out.println("Type in w, a, s, or d for each direction, respectively.");
	    if (badInput) {System.out.println("Invalid move. Please try again.");} //If a bad move was made last iteration, this message displays
	    else {System.out.println();} //Else it's a blank line
	    badInput = false; //Resets badInput
	    String input = Keyboard.readString().toLowerCase();
	    if (input.equals("w")) //Does action based on input
		b.slideUp();
	    else if (input.equals("s"))
		b.slideDown();
	    else if (input.equals("a"))
		b.slideLeft();
	    else if (input.equals("d"))
		b.slideRight();
	    else{
		badInput = true; //Sets badInput for next iteration
	    }
	}
	if (b.gameStatus().equals("Loss")){ //Returns loss message
	    System.out.println(b);
	    System.out.println("Sorry, you lost.");
	}
	else{ //Returns win message
	    System.out.println(b);
	    System.out.println("Congrats! You won!");
	}
    }
}
