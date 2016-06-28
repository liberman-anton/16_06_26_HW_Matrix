package tel_ran.math;


public class Matrix<T> {
	T [][] matrix;
	int capacityRow = 10;
	int capacityColumn = 10; 
	int nRow = 0;
	int nColumn = 0;
	
	@SuppressWarnings("unchecked")
	public Matrix(){
	matrix = (T[][])new Object[capacityRow][capacityColumn];
	//	T[] matixR = (T[]) Array.newInstance(getClass(), capacityRow);
	}
	@SuppressWarnings("unchecked")
	public Matrix(int capacityRow, int capacityColumn){
		this.capacityRow = capacityRow;
		this.capacityColumn = capacityColumn;
		matrix = (T[][]) new Object[capacityRow][capacityColumn];
	}
	
	@Override
	public String toString() {
		String res = "";
		for(int i = 0; i < nRow; i++){
			for(int j = 0; j < nColumn; j++){
				res += matrix[i][j] + "\t"; 
			}
			res += "\n";
		}
		return res;
	}
	public void addColumn(T[] column){
		if(column.length >= capacityRow){
			increaseCapacityRow();
		}
		if(this.nColumn >= capacityColumn){
			increaseCapacityColumn();
		}
		for(int i = 0; i < column.length; i++)
			matrix[i][this.nColumn] = column[i];
		this.nColumn++;
		if(column.length > this.nRow)
			this.nRow = column.length;
	}
	
	@SuppressWarnings("unchecked")
	private void increaseCapacityRow() {
		capacityRow *= 2;
		T[][] tmp = (T[][])new Object[capacityRow][capacityColumn];
		for(int i = 0; i < nRow; i++){
			System.arraycopy(matrix[i], 0, tmp[i], 0, nColumn);
		}
		matrix = tmp;
	}
	@SuppressWarnings("unchecked")
	private void increaseCapacityColumn() {
		capacityColumn *= 2;
		T[][] tmp = (T[][])new Object[capacityRow][capacityColumn];
		for(int i = 0; i < nRow; i++){
			System.arraycopy(matrix[i], 0, tmp[i], 0, nColumn);
		}
		matrix = tmp;
	}
	public void addRow(T[] row){
		if(this.nRow >= capacityRow){
			increaseCapacityRow();
		}
		if(row.length >= capacityColumn){
			increaseCapacityColumn();
		}
		System.arraycopy(row, 0, matrix[nRow], 0, row.length);	
		this.nRow++;
		if(row.length > this.nColumn)
			this.nColumn = row.length;
	}
	
	public void transp(){
		if(this.nColumn >= capacityRow){
			increaseCapacityRow();
		}
		if(this.nRow >= capacityColumn){
			increaseCapacityColumn();
		}
		T obj;
		if(nColumn > nRow){
			for(int j = 0; j < nColumn; j++)
				for(int i = 0; i < j; i++){
						obj = (T) matrix[j][i];
						matrix[j][i] = matrix[i][j];
						matrix[i][j] = obj;				
				}
		}else{
			for(int i = 0; i < nRow; i++)
				for(int j = 0; j < i; j++){
						obj = (T) matrix[j][i];
						matrix[j][i] = matrix[i][j];
						matrix[i][j] = obj;				
				}
			
		}
		int nRowOld = nRow;
		nRow = nColumn;
		nColumn = nRowOld;
	}
	
	@SuppressWarnings({ "unchecked"})
	public T[][] getMatrixArray(){
		T[][] res = (T[][])new Object[nRow][nColumn];
		for(int i = 0; i < nRow; i++)
			for(int j = 0; j < nColumn; j++){
					res[i][j] = (T) matrix[i][j];			
			}
		return (T[][])res;
	}
}
