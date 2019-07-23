package Question1;

import static org.junit.Assert.*;
import org.junit.Test;

public class SparseMatrixTestCase {
	
	
	@Test
	public void SparseMatrixTest1 () {
		
		int [][] matrix1 = {{0,0,1}, {0,3,0}, {1,0,0}};
		int [][] result = {{0,2,1}, {1,1,3}, {2,0,1}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		assertArrayEquals(result,sp1.getMatrix());
				
	}

	@Test
	public void SparseMatrixTest2 () {
		
		int [][] matrix1 = {{0,0,1}, {0,3,0}, {1,0,0}};
		int [][] matrix2 = {{1,0,0}, {0,0,0}, {0,0,1}};
		int [][] matrix3 = {{1,0,1}, {0,3,0}, {1,0,1}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		SparseMatrix sp2 = new SparseMatrix(matrix2);
		
		assertArrayEquals(matrix3,sp1.addMatrix(sp2));		
	}
	
	@Test
	public void SparseMatrixTest3 () {
		
		int [][] matrix1 = {{0,0,1}, {2,0,3}, {0,1,0}};		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		
		assertFalse(sp1.isSymmetrical());				
	}
	
	@Test
	public void SparseMatrixTest4 () {
		
		int [][] matrix1 = {{0,10,0,12}, {0,0,0,0}, {0,0,5,0}, {15,12,0,0}};
		int [][] matrix2 = {{0,0,0,15}, {10,0,0,12}, {0,0,5,0}, {12,0,0,0}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		
		assertArrayEquals(matrix2,sp1.getTranspose());						
	}
	
	@Test
	public void SparseMatrixTest5 () {
		
		int [][] matrix1 = {{0,1,}, {2,0}};
		int [][] matrix2 = {{1,0,3}, {2,0,0}};
		
		int [][] result = {{2,0,0}, {2,0,6}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		SparseMatrix sp2 = new SparseMatrix(matrix2);
		
		/*
		int [][] result2 = sp1.multiplyMatrix(sp2);
		for(int i = 0; i < sp1.getRowSize(); i++){
			for(int j=0; j < sp2.getColSize(); j++)
			{
				System.out.print(result[i][j]+"  ");
			}
			System.out.println();
		}
		*/
		assertArrayEquals(result,sp1.multiplyMatrix(sp2));						
	}
}
