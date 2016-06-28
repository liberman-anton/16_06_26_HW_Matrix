package tel_ran.math;

public class MatrixTestAppl {

	public static void main(String[] args) {
		Matrix<Integer> matrix = new Matrix<Integer>();
		Integer[] ar = {1,2,3};
		Integer[] ar1 = {4,5,6,7};
		Integer[] ar2 = {8,3,10,11,12};
		matrix.addRow(ar1);
		for(int i = 0; i < 11; i++)
			matrix.addColumn(ar);
		matrix.addRow(ar2);
		System.out.println(matrix);
		matrix.transp();
		System.out.println(matrix);matrix.transp();
		System.out.println(matrix);
		Object[][] arr = matrix.getMatrixArray();
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < arr[0].length; j++){
					System.out.println(arr[i][j]);			
			}
	}

}
