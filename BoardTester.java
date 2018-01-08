public class BoardTester{
    public static void slideLeftRow(int[] arr){
	for(int p=1; p<4; p++){
	    for(int i=0;i<3;i++){
		if (arr[i]==0){
		    arr[i]=arr[i+1];
		    arr[i+1]=0;
		}
	    }
	}
    }
    public static void mergeLeft(int[] arr){
	for(int i=0;i<3;i++){
	    if(arr[i]==arr[i+1]){
		arr[i]*=2;
		arr[i+1]=0;
		slideLeftRow(arr);
	    }
	}
    }
    public static void slideLeft(int[][] arr){
	for(int i=0;i<4;i++){
	    slideLeftRow(arr[i]);
	    mergeLeft(arr[i]);
	}
    }
    public static void slideRightRow(int[] arr){
	for(int p=1; p<4; p++){
	    for(int i=3;i>0;i--){
		if (arr[i]==0){
		    arr[i]=arr[i-1];
		    arr[i-1]=0;
		}
	    }
	}
    }
    public static void mergeRight(int[] arr){
	for(int i=3;i>0;i--){
	    if(arr[i]==arr[i-1]){
		arr[i]*=2;
		arr[i-1]=0;
		slideRightRow(arr);
	    }
	}
    }
    public static void slideRight(int[][] arr){
	for(int i=0;i<4;i++){
	    slideRightRow(arr[i]);
	    mergeRight(arr[i]);
	}
    }
    public static void slideUpCol(int[][] arr, int c){
	for(int p=1; p<4; p++){
	    for(int i=0;i<3;i++){
		if (arr[i][c]==0){
		    arr[i][c]=arr[i+1][c];
		    arr[i+1][c]=0;
		}
	    }
	}
    }
    public static void mergeUp(int[][] arr, int c){
	for(int i=0;i<3;i++){
	    if(arr[i][c]==arr[i+1][c]){
		arr[i][c]*=2;
		arr[i+1][c]=0;
		slideUpCol(arr,c);
	    }
	}
    }
    public static void slideUp(int[][] arr){
	for(int i=0;i<4;i++){
	    slideUpCol(arr,i);
	    mergeUp(arr,i);
	}
    }
    public static void slideDownCol(int[][] arr, int c){
	for(int p=1; p<4; p++){
	    for(int i=3;i>0;i--){
		if (arr[i][c]==0){
		    arr[i][c]=arr[i-1][c];
		    arr[i-1][c]=0;
		}
	    }
	}
    }
    public static void mergeDown(int[][] arr, int c){
	for(int i=3;i>0;i--){
	    if(arr[i][c]==arr[i-1][c]){
		arr[i][c]*=2;
		arr[i-1][c]=0;
		slideDownCol(arr,c);
	    }
	}
    }
    public static void slideDown(int[][] arr){
	for(int i=0;i<4;i++){
	    slideDownCol(arr,i);
	    mergeDown(arr,i);
	}
    }
    public static void string(int[][] arr){
	String foo = "";
	for( int i =0; i < 4; i++ ) {
	    foo += "| ";
	    for( int j=0; j < 4; j++ ) {
		foo +=arr[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}
	
	System.out.println(foo);
    }
    public static void main(String[] args){
	int[][] arrTest=new int [4][4];
	for(int r=0;r<4;r++){
	    for(int c=0; c<4;c++){
		arrTest[r][c]=2* (int)(Math.random()*3);
	    }
	}
	string(arrTest);
	slideUp(arrTest);
	string(arrTest);
    }
}

