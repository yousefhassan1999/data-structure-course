package linked_list_junite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import linked_list_classe.PolynomialSolver;
import linked_list_classe.single_linked_liist;

class PolynomialSolver_junite {
	PolynomialSolver test1;
	single_linked_liist test2;
	
	public void creat_linked_list() {
		test2 = new single_linked_liist();
		int[][]arr_test=new int[1][2];
		arr_test[0][0]=5;
		arr_test[0][1]=6;
		int[][]arr_test1=new int[1][2];
		arr_test1[0][0]=7;
		arr_test1[0][1]=8;
		test2.add(arr_test);
		test2.add(arr_test1);
	}
	public int[][] create_array(int[][]arr){
		arr[0][0]=5;
		arr[0][1]=6;
		arr[1][0]=7;
		arr[1][1]=8;
		return arr;
	}
	
	public int[][] create_array1(int[][]arr){
		arr[0][0]=3;
		arr[0][1]=4;
		arr[1][0]=1;
		arr[1][1]=2;
		arr[2][0]=7;
		arr[2][1]=9;
		return arr;
	}
	public int[][] create_array2(int[][]arr){
		arr[0][0]=5;
		arr[0][1]=-6;
		arr[1][0]=7;
		arr[1][1]=8;
		return arr;
	}
	
	//the point that i test 
	//please enter this point to check this function 
	//(5, 6), (7, 8)
	//(3, 4), (1, 2), (7, 9)
	@Test
	void test_read_point() throws Exception {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		create_array(arr);
		int[][]arr2=test1.readPoints();
		assertEquals(arr[1][0],arr2[0][0]);
		assertEquals(arr[0][0],arr2[1][0]);
		assertEquals(arr[1][1],arr2[0][1]);
		assertEquals(arr[0][1],arr2[1][1]);
		int[][]arr1=new int[3][3];
		create_array1(arr1);
		int[][]arr3=test1.readPoints();
		assertEquals(arr1[2][0],arr3[0][0]);
		assertEquals(arr1[1][0],arr3[2][0]);
		assertEquals(arr1[0][0],arr3[1][0]);
		assertEquals(arr1[0][1],arr3[1][1]);
		assertEquals(arr1[1][1],arr3[2][1]);
		assertEquals(arr1[2][1],arr3[0][1]);
	}
	
	@Test
	void test_setPolynomial() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		arr=create_array(arr);
		test1.setPolynomial('A',arr);
		int[][]arr1=new int[2][1];
		arr1=(int[][]) test1.A.get(1);
		int[][]arr2=new int[2][1];
		arr2=(int[][]) test1.A.get(2);
		assertEquals(7,arr1[0][0]);
		assertEquals(8,arr1[0][1]);
		assertEquals(5,arr2[0][0]);
		assertEquals(6,arr2[0][1]);
	}
	
	@Test
	void test_sort() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		arr=create_array(arr);
		test1.setPolynomial('A',arr);
		int[][]arr1=new int[2][1];
		arr1=(int[][]) test1.A.get(1);
		int[][]arr2=new int[2][1];
		arr2=(int[][]) test1.A.get(2);
		assertEquals(7,arr1[0][0]);
		assertEquals(8,arr1[0][1]);
		assertEquals(5,arr2[0][0]);
		assertEquals(6,arr2[0][1]);
	}
	
	@Test
	void test_set_terms() {
		creat_linked_list();
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		arr=create_array(arr);
		int[][]arr1=new int[2][2];
		arr1=test1.setTerms(test2);
		assertEquals(arr1[0][0],arr[0][0]);
		assertEquals(arr1[0][1],arr[0][1]);
		assertEquals(arr1[1][0],arr[1][0]);
		assertEquals(arr1[1][1],arr[1][1]);
	}
	
	@Test
	void test_string_print() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		arr=create_array2(arr);
		test1.setPolynomial('A',arr);
		String check ="8x^7 + -6x^5";
		String check1 =test1.print('A');
		assertEquals(check,check1);
	}
	
	@Test
	void test_clear() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		arr=create_array(arr);
		test1.setPolynomial('A',arr);
		assertNotNull(test1.A.get(1));
		assertEquals(false,test1.A.isEmpty());
		test1.clearPolynomial('A');
		assertEquals(null,test1.A.get(1));
		assertEquals(true,test1.A.isEmpty());
	}
	
	@Test
	void test_evaluatePolynomial() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		arr=create_array(arr);
		test1.setPolynomial('A',arr);
		float z =test1.evaluatePolynomial('A',1);
		assertEquals(14.000,z);
	}
	
	public void set_two_poly(int[][]arr,int[][]arr1) {
		arr=create_array(arr);
		arr1=create_array1(arr1);
		test1.setPolynomial('A',arr);
		test1.setPolynomial('B',arr1);
	}
	@Test
	void test_add() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		int[][]arr1=new int[3][2];
		set_two_poly(arr,arr1);
		int[][]RESULT=new int[4][2];
		RESULT=test1.add('A', 'B');
		assertEquals(arr[0][0],RESULT[0][0]);
		assertEquals(17,RESULT[0][1]);
		assertEquals(arr[1][0],RESULT[1][0]);
		assertEquals(arr[1][1],RESULT[1][1]);
		assertEquals(arr1[1][0],RESULT[2][0]);
		assertEquals(arr1[1][1],RESULT[2][1]);
		assertEquals(arr1[2][0],RESULT[3][0]);
		assertEquals(arr1[2][1],RESULT[3][1]);
		String check ="17x^7 + 6x^5 + 4x^3 + 2x^1";
		String check1 =test1.print('R');
		assertEquals(check,check1);
	}
	
	@Test
	void test_subtract() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		int[][]arr1=new int[3][2];
		set_two_poly(arr,arr1);
		int[][]RESULT=new int[4][2];
		RESULT=test1.subtract('A', 'B');
		assertEquals(7,RESULT[0][0]);
		assertEquals(-1,RESULT[0][1]);
		assertEquals(5,RESULT[1][0]);
		assertEquals(6,RESULT[1][1]);
		assertEquals(3,RESULT[2][0]);
		assertEquals(-4,RESULT[2][1]);
		assertEquals(1,RESULT[3][0]);
		assertEquals(-2,RESULT[3][1]);
		String check ="-1x^7 + 6x^5 + -4x^3 + -2x^1";
		String check1 =test1.print('R');
		assertEquals(check,check1);

	}
	@Test
	void test_multiply() {
		test1=new PolynomialSolver() ;
		int[][]arr=new int[2][2];
		int[][]arr1=new int[3][2];
		set_two_poly(arr,arr1);
		int[][]RESULT=new int[5][2];
		RESULT=test1.multiply('A', 'B');
		assertEquals(14,RESULT[0][0]);
		assertEquals(72,RESULT[0][1]);
		assertEquals(12,RESULT[1][0]);
		assertEquals(54,RESULT[1][1]);
		assertEquals(10,RESULT[2][0]);
		assertEquals(32,RESULT[2][1]);
		assertEquals(8,RESULT[3][0]);
		assertEquals(40,RESULT[3][1]);
		assertEquals(6,RESULT[4][0]);
		assertEquals(12,RESULT[4][1]);
		String check ="72x^14 + 54x^12 + 32x^10 + 40x^8 + 12x^6";
		String check1 =test1.print('R');
		assertEquals(check,check1);
	}
}
