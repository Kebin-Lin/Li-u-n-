public class BoardTester{
    public static void slideLeft(int[] arr){
	for(int p=1; p<4; p++){
	    for(int i=0;i<3;i++){
		if (arr[i]==0){
		    arr[i]=arr[i+1];
		    arr[i+1]=0;
		}
	    }
	}
    }
    public static void merge(int[] arr){
	for(int i=0;i<3;i++){
	    if(arr[i]==arr[i+1]){
		arr[i]*=2;
		arr[i+1]=0;
		slideLeft(arr);
	    }
	}
    }
    public static void main(String[] args){
	int[] arrTest=new int [4];
	arrTest[0]=4;
	arrTest[1]=2;
	arrTest[2]=2;
	arrTest[3]=0;
	slideLeft(arrTest);
	merge(arrTest);
	System.out.println(arrTest[0]);
	System.out.println(arrTest[1]);
	System.out.println(arrTest[2]);
	System.out.println(arrTest[3]);
    }
}
