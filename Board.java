public class Board {
    public int _maxNum;
    public int _num0s;
    public Block[][] _board;

    public Board() {
	_maxNum = 0;
	_num0s = 16;
	_board = new Block[4][4];
	for (int i = 0; i < 4; i++) {
	    for (int i2 = 0; i2 < 4; i2++) {
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
	int pos = (int)(Math.random() * _num0s);
	int index = 0;
	if (_num0s == 0) {return;}
	for (int r = 0; r < 4; r++) {
	    for (int c = 0; c < 4; c++) {
		if(_board[r][c].isEmpty()){
		    if (index == pos) {
			_board[r][c].set(((int)(Math.random()*2)+1)*2);
			_num0s--;
			return;
		    }
		    index++;
		}
	    }
	}
    }

    public int slideLeftRow(int r){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=0;i<3;i++){
		if (_board[r][i].isEmpty()){
		    if(!_board[r][i+1].isEmpty()){
			_board[r][i].set(_board[r][i+1].get());
			_board[r][i+1].set(0);
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeLeft(int r){
	int merges=0;
	for(int i=0;i<3;i++){
	    if((_board[r][i].get()==_board[r][i+1].get())&&!_board[r][i].isEmpty()){
		_board[r][i].set(_board[r][i].get()*2);
		if(_board[r][i].get()>_maxNum){
		    _maxNum=_board[r][i].get();
		}
		_board[r][i+1].set(0);
		_num0s++;
		slideLeftRow(r);
		merges++;
	    }
	}
	return merges;
    }
    public void slideLeft(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideLeftRow(i);
	    merges+=mergeLeft(i);
	}
	if(moves+merges>0){
	    addBlock();
	}
    }
    public int slideRightRow(int r){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=3;i>0;i--){
		if (_board[r][i].isEmpty()){
		    if(!_board[r][i-1].isEmpty()){
			_board[r][i].set(_board[r][i-1].get());
			_board[r][i-1].set(0);
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeRight(int r){
	int merges=0;
	for(int i=3;i>0;i--){
	    if((_board[r][i].get()==_board[r][i-1].get())&&!_board[r][i].isEmpty()){
		_board[r][i].set(_board[r][i].get()*2);
		if(_board[r][i].get()>_maxNum){
		    _maxNum=_board[r][i].get();
		}
		_board[r][i-1].set(0);
		_num0s++;
		slideRightRow(r);
		merges++;
	    }
	}
	return merges;
    }
    public void slideRight(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideRightRow(i);
	    merges+=mergeRight(i);
	}
	if(moves+merges>0){
	    addBlock();
	}
    }
    public int slideUpCol(int c){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=0;i<3;i++){
		if (_board[i][c].isEmpty()){
		    if(!_board[i+1][c].isEmpty()){
			_board[i][c].set(_board[i+1][c].get());
			_board[i+1][c].set(0);
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeUp(int c){
	int merges=0;
	for(int i=0;i<3;i++){
	    if((_board[i][c].get()==_board[i+1][c].get())&&!_board[i][c].isEmpty()){
		_board[i][c].set(_board[i][c].get()*2);
		if(_board[i][c].get()>_maxNum){
		    _maxNum=_board[i][c].get();
		}
		_board[i+1][c].set(0);
		_num0s++;
		slideUpCol(c);
		merges++;
	    }
	}
	return merges;
    }
    public void slideUp(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideUpCol(i);
	    merges+=mergeUp(i);
	}
	if(moves+merges>0){
	    addBlock();
	}
    }
    public int slideDownCol(int c){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=3;i>0;i--){
		if (_board[i][c].isEmpty()){
		    if(!_board[i-1][c].isEmpty()){
			_board[i][c].set(_board[i-1][c].get());
			_board[i-1][c].set(0);
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeDown(int c){
	int merges=0;
	for(int i=3;i>0;i--){
	    if((_board[i][c].get()==_board[i-1][c].get())&&!_board[i][c].isEmpty()){
		_board[i][c].set(_board[i][c].get()*2);
		if(_board[i][c].get()>_maxNum){
		    _maxNum=_board[i][c].get();
		}
		_board[i-1][c].set(0);
		_num0s++;
		slideDownCol(c);
		merges++;
	    }
	}
	return merges;
    }
    public void slideDown(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideDownCol(i);
	    merges+=mergeDown(i);
	}
	if(moves+merges>0){
	    addBlock();
	}
    }

    public int slideLeftRowTest(int r){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=0;i<3;i++){
		if (_board[r][i].isEmpty()){
		    if(!_board[r][i+1].isEmpty()){
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeLeftTest(int r){
	int merges=0;
	for(int i=0;i<3;i++){
	    if((_board[r][i].get()==_board[r][i+1].get())&&!_board[r][i].isEmpty()){
      		merges++;
	    }
	}
	return merges;
    }
    public int slideLeftTest(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideLeftRowTest(i);
	    merges+=mergeLeftTest(i);
	}
	return moves+merges;
    }
    public int slideRightRowTest(int r){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=3;i>0;i--){
		if (_board[r][i].isEmpty()){
		    if(!_board[r][i-1].isEmpty()){
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeRightTest(int r){
	int merges=0;
	for(int i=3;i>0;i--){
	    if((_board[r][i].get()==_board[r][i-1].get())&&!_board[r][i].isEmpty()){
		merges++;
	    }
	}
	return merges;
    }
    public int slideRightTest(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideRightRowTest(i);
	    merges+=mergeRightTest(i);
	}
	return moves+merges;
    }
    public int slideUpColTest(int c){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=0;i<3;i++){
		if (_board[i][c].isEmpty()){
		    if(!_board[i+1][c].isEmpty()){
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeUpTest(int c){
	int merges=0;
	for(int i=0;i<3;i++){
	    if((_board[i][c].get()==_board[i+1][c].get())&&!_board[i][c].isEmpty()){
		merges++;
	    }
	}
	return merges;
    }
    public int slideUpTest(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideUpColTest(i);
	    merges+=mergeUpTest(i);
	}
        return moves+merges;
    }
    public int slideDownColTest(int c){
	int moves=0;
	for(int p=1; p<4; p++){
	    for(int i=3;i>0;i--){
		if (_board[i][c].isEmpty()){
		    if(!_board[i-1][c].isEmpty()){
			moves++;
		    }
		}
	    }
	}
	return moves;
    }
    public int mergeDownTest(int c){
	int merges=0;
	for(int i=3;i>0;i--){
	    if((_board[i][c].get()==_board[i-1][c].get())&&!_board[i][c].isEmpty()){
		merges++;
	    }
	}
	return merges;
    }
    public int slideDownTest(){
	int moves=0;
	int merges=0;
	for(int i=0;i<4;i++){
	    moves+=slideDownColTest(i);
	    merges+=mergeDownTest(i);
	}
	return moves+merges;
    }
    public String gameStatus() {
	if (_maxNum >= 2048) {return "Win";}
	if (slideRightTest()+slideLeftTest()+slideUpTest()+slideDownTest()>0) {return "Ongoing";}
	return "Loss";
    }
    public int getMax() { return _maxNum; }
    public String toString(){
	String foo = "----------------------\n";
	for( int i =0; i < 4; i++ ) {
	    foo += "| ";
	    for( int j=0; j < 4; j++ ) {
		foo +=_board[i][j] + "|"; //get(i+1,j+1)
	    }
	    foo += "\n----------------------\n";
	}
	
	return foo;
    }
    public static void main(String[] args) {
	Board b=new Board();
	b.addBlock();
	b.addBlock();
        System.out.println(b);
	for(int i=0;i<6;i++){
	    b.slideUp();
	    System.out.println(b);
	    b.slideLeft();
	    System.out.println(b);
	    b.slideDown();
	    System.out.println(b);
	    b.slideRight();
	    System.out.println(b);
	}
	System.out.println(b.getMax());
    }
}
