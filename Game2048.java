import cs1.Keyboard;
public class Game2048{
    public Board b;
    public static void newGame(){
	for (int x = 0; x < 4; x++){
	    for (int y = 0; y < 4; y++){
		b[x][y] = "    ";
	    }
	}
    }
    public static void main(String [] args){
	newGame();
	while (b.gameStatus().equals("Ongoing")){
	    b.addBlock();
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
	}
    }
}