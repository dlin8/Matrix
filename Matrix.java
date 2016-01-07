/* Derek Lin
   APCS1 pd5
   HW55 -- Don't Think You Are. Know You Are.
   2016-01-07 */

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
  Categorize runtime of each. 
  Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    //Instance Variables
    private Object[][] matrix;

    //Constructors
    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
	//System.out.println(matrix.length);
    }

    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object[a][a];
	//System.out.println(matrix.length);
    }

    //Methods
    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length;
    }
    //O(1)   

    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r][c];
    }
    //O(1)

    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return matrix[r][c] == null;
    }
    //O(1)

    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object temp = matrix[r][c];
	matrix[r][c] = newVal;
	return temp;
    }
    //O(1)

    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String retStr = "";
	for(int i = 0; i < matrix.length; i++){
	    for(int x = 0; x < matrix[i].length; x++){
		retStr += matrix[i][x] + " ";
	    }
	    retStr += "\n";
	}
	return retStr;
    }
    //O(n^2)

    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	boolean truth = true;
	if(!(rightSide instanceof Matrix)){
	    truth = false;
	}
	if(((Matrix)rightSide).matrix.length != this.matrix.length){
	    truth = false;
	}
	for(int i = 0; i < matrix.length; i++){
	    for(int x = 0; x < matrix[i].length; x++){
		if(this.matrix[i][x] != ((Matrix)rightSide).matrix[i][x]){
		    truth = false;
		}
	    }
	}
	return truth;
    }
    //O(n^2)

    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	Object[] temp = new Object[matrix.length];
	for(int i = 0; i < matrix.length; i++){
	    temp[i] = matrix[i][c1];
	}
	for(int x = 0; x < matrix.length; x++){
	    matrix[x][c1] = matrix[x][c2];
	}
	for(int y = 0; y < matrix.length; y++){
	    matrix[y][c2] = temp[y];
	}
    }
    //O(n)
    public boolean isFull(){
	boolean truth = true;
	for(int r = 0; r < matrix.length; r++){
	    for(int c = 0; c < matrix[r].length; c++){
		if(matrix[r][c] == null){
		    truth = false;
		}
	    }
	}
	return truth;
    }
    //O(n^2)
    public Object[] getRow(int r){
	return matrix[r];
    }
    //O(1)
    public Object[] getCol(int c){
	Object[] col = new Object[matrix.length];
	for(int i = 0; i < matrix.length; i++){
	    col[i] = matrix[i][c];
	}
	return col;
    }
    //O(n)
    public Object[] setRow(int r, Object[] newRow){
	Object[] temp = this.getRow(r);
	for(int i = 0; i < matrix.length; i++){
	    matrix[r][i] = newRow[i];
	}
	return temp;
    }
    //O(n)
    public Object[] setCol(int c, Object[] newRow){
	Object[] temp = this.getCol(c);
	for(int i = 0; i < matrix.length; i++){
	    matrix[i][c] = newRow[i];
	}
	return temp;
    }
    //O(n)
    public void Transpose(){
	Object[][] replacement = new Object[this.size()][this.size()];
	for(int r = 0; r < matrix.length; r++){
	    for(int c = 0; c < matrix[r].length; c++){
		replacement[r][c] = matrix[c][r];
	    }
	}
	System.out.println("Transpose!");
	matrix = replacement;
    }

    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	Object[] temp = new Object[matrix.length];
	for(int i = 0; i < matrix.length; i++){
	    temp[i] = matrix[r1][i];
	}
	for(int x = 0; x < matrix.length; x++){
	    matrix[r1][x] = matrix[r2][x];
	}
	for(int y = 0; y < matrix.length; y++){
	    matrix[r2][y] = temp[y];
	}
    }
    //O(n)

    //main method for testing
    public static void main( String[] args ) {
	/*
	//Creation
	Matrix matrixOne = new Matrix();
	System.out.println("isEmpty testing");
	System.out.println(matrixOne.isEmpty(0,0));
	matrixOne.set(0,0,"00");
	System.out.println(matrixOne.isEmpty(0,0));
	matrixOne.set(0,1,"01");
	matrixOne.set(1,0,"10");
	matrixOne.set(1,1,"11");
	System.out.println("Matrix One gets.");
	System.out.println(matrixOne.get(0,0));
	System.out.println(matrixOne.get(0,1));
	System.out.println(matrixOne.get(1,0));
	System.out.println(matrixOne.get(1,1));
	Matrix matrixTwo = new Matrix(2);
	matrixTwo.set(0,0,"00");	
	matrixTwo.set(0,1,"01");
	matrixTwo.set(1,0,"10");
	matrixTwo.set(1,1,"11");
	System.out.println("Matrix Two gets.");
	System.out.println(matrixTwo.get(0,0));
	System.out.println(matrixTwo.get(0,1));
	System.out.println(matrixTwo.get(1,0));
	System.out.println(matrixTwo.get(1,1));
	Matrix matrixThree = new Matrix(3);
	matrixThree.set(0,0,"00");	
	matrixThree.set(0,1,"01");
	matrixThree.set(0,2,"02");
	matrixThree.set(1,0,"10");
	matrixThree.set(1,1,"11");
	matrixThree.set(1,2,"12");
	matrixThree.set(2,0,"20");
	matrixThree.set(2,1,"21");
	matrixThree.set(2,2,"22");
	System.out.println("Matrix Three gets.");
	System.out.println(matrixThree.get(0,0));
	System.out.println(matrixThree.get(0,1));
	System.out.println(matrixThree.get(0,2));
	System.out.println(matrixThree.get(1,0));
	System.out.println(matrixThree.get(1,1));
	System.out.println(matrixThree.get(1,2));
	System.out.println(matrixThree.get(2,0));
	System.out.println(matrixThree.get(2,1));
	System.out.println(matrixThree.get(2,2));
	//Size
	System.out.println("Sizes");
	System.out.println(matrixOne.size());
	System.out.println(matrixTwo.size());
	System.out.println(matrixThree.size());
	//To String
	System.out.println("toString()");
	System.out.println(matrixOne);
	System.out.println(matrixTwo);
	System.out.println(matrixThree);
	//Equals
	System.out.println("equals()");
	System.out.println(matrixOne.equals(matrixTwo));
	System.out.println(matrixOne.equals(matrixThree));
	//Swap Row and Col
	System.out.println("Row Swap");
	matrixThree.swapRows(0,2);
	System.out.println(matrixThree);
	matrixThree.swapRows(0,2);
	System.out.println(matrixThree);
	System.out.println("Col Swap");
	matrixThree.swapColumns(0,2);
	System.out.println(matrixThree);
	matrixThree.swapColumns(0,2);
	System.out.println(matrixThree);
	*/

	/*
	Matrix matrixFour = new Matrix(2);
	System.out.println(matrixFour.isFull());
	matrixFour.set(0,0,"a");
	matrixFour.set(0,1,"b");

	matrixFour.set(1,0,"c");
	matrixFour.set(1,1,"d");
	*/

	/*
	System.out.println(matrixFour.isFull());
	Object[] row = matrixFour.getRow(0);
	Object[] col = matrixFour.getCol(0);
	Object[] newRow = {"a","c"};
	Object[] newCol = {"a","b"};
	System.out.println(row[0]);
	System.out.println(row[1]);
	System.out.println(col[0]);
	System.out.println(col[1]);
	System.out.println(matrixFour);
	matrixFour.setRow(0, newRow);
	matrixFour.setCol(0, newCol);
	System.out.println(matrixFour);
	*/

	Matrix matrixFour = new Matrix(4);
	matrixFour.set(0,0,"a");
	matrixFour.set(0,1,"b");
	matrixFour.set(0,2,"c");
	matrixFour.set(0,3,"d");

	matrixFour.set(1,0,"e");
	matrixFour.set(1,1,"f");
	matrixFour.set(1,2,"g");
	matrixFour.set(1,3,"h");

	matrixFour.set(2,0,"i");
	matrixFour.set(2,1,"j");
	matrixFour.set(2,2,"k");
	matrixFour.set(2,3,"l");

	matrixFour.set(3,0,"m");
	matrixFour.set(3,1,"n");
	matrixFour.set(3,2,"o");
	matrixFour.set(3,3,"p");

	System.out.println(matrixFour);
	matrixFour.Transpose();
	System.out.println(matrixFour);
    }

}//end class Matrix
