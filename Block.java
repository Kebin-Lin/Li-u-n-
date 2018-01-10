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
    if (_num == 0) {return "    ";}
    String retStr=""+_num;
    while (retStr.length() < 4) {retStr = " " + retStr;}
    return retStr;
  }
}
