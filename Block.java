public class Block{
    private int _num;
    public Block(){
	_num=0;
    }
    public boolean isEmpty(){
	return _num==0;
    }
    public int set(int newVal){
	int oldVal=_num;
	_num=newVal;
	return oldVal;
    }
    public int get(){
	return _num;
    }
    public String toString(){
	String retStr=""+_num;
	for(int i=0; i<4-retStr.length();i++){
	    retStr=" "+retStr;
	}
	return retStr;
    }
}
