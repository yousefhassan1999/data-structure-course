package linked_list_classe;

import java.util.Scanner;

import linked_list_intterface.IPolynomialSolver;

public class PolynomialSolver implements  IPolynomialSolver{
	//4 required list A B C R
	public single_linked_liist A = new single_linked_liist();
	public single_linked_liist B = new single_linked_liist();
	public single_linked_liist C = new single_linked_liist();
	public single_linked_liist R = new single_linked_liist();
		//2 more lists to help in some operations
	single_linked_liist mList = new single_linked_liist();
	single_linked_liist save = new single_linked_liist();

		/* read points function 
		 * used to read the input format of polynomial terms as required format
		 * and change it to integer array which will be used in setting the polynomial
		 */
		public int[][] readPoints() throws Exception {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			String input =in.nextLine();
			int i=0;
			int n=0;
			boolean negative;//boolean to check if the number is negative
			for(i=0;i<input.length();i++)
				if(input.charAt(i)=='(') 
					n++;
			i=0;
			if(n==0)
				throw new Exception("invalid input");
			int arr[][] =new int[n][2];
			while(i<input.length()) {
				n--;negative = false;
				if(input.charAt(i++)=='(') {
					arr[n][0]=arr[n][1]=0;
					if(Character.isDigit(input.charAt(i))||input.charAt(i)=='-') {
						if(input.charAt(i)=='-') { 
							negative = true;i++;
						}
						while(Character.isDigit(input.charAt(i))) {
							arr[n][0] *= 10;
							arr[n][0] += Character.getNumericValue(input.charAt(i++));
						}
						if(negative)
							arr[n][0] *= -1;
					}
					else
						throw new Exception("invalid input");
					if(input.charAt(i++)==','&&input.charAt(i++)==' ') {
						negative = false;
						if(Character.isDigit(input.charAt(i))||input.charAt(i)=='-')
							if(input.charAt(i)=='-') { 
								negative = true;i++;
							}
							while(Character.isDigit(input.charAt(i))) {
								arr[n][1] *= 10;
								arr[n][1] += Character.getNumericValue(input.charAt(i++));
							}
							if(negative)
								arr[n][1] *= -1;
					}
					else
						throw new Exception("invalid input");
		
				}
				else
					throw new Exception("invalid input");
				if(!((input.charAt(i++)==')')&&(n==0||(input.charAt(i++)==','&&input.charAt(i++)==' '))))
					throw new Exception("invalid input");
			}
			sortterms(arr);
			return arr;
		}
		
		
		/*sort terms
		 * used to sort polynomial terms if the user entered it in unordered
		 */
		public void sortterms(int[][] terms) {
			int i,j,temp;
			for(i=0;i<terms.length;i++) {
				  for(j =1; j < (terms.length-i); j++){  
	                  if(terms[j-1][0] < terms[j][0]){  
	                         temp = terms[j-1][0];  
	                         terms[j-1][0] = terms[j][0];  
	                         terms[j][0] = temp;
	                         temp = terms[j-1][1];  
	                         terms[j-1][1] = terms[j][1];  
	                         terms[j][1] = temp; 
	                 }  
				  }
			}
			
		}
		
		/*setPolynomial
		 * used to set a polynomial from the given terms
		 */
		public void setPolynomial(char poly, int[][] terms) {
			single_linked_liist X = new single_linked_liist();
			sortterms(terms);
			switch(poly){
			case'A':
				X = A;
				break;
			case'B':
				X = B;
				break;
			case'C':
				X = C;
				break;
			}
				for(int i=0 ; i<terms.length;i++) {
					int arr[][]=new int [1][2];
					arr[0][0]=terms[i][0];
					arr[0][1]=terms[i][1];
					X.add(arr);
				}
		}
		
		/*set terms
		 * used to get the terms in a list and put them in an array
		 */
		public int[][] setTerms(single_linked_liist X) {
			int[][] terms = new int[X.size()][2];
			int i =0;
			while(i<X.size()) {
				int arr [][]= (int[][]) X.get(i+1);
				terms[i][0]=arr[0][0];
				terms[i][1]=arr[0][1];
				i++;
			}
			return terms;
		}

		/*print
		 *used to print  polynomial
		 */
		public String print(char poly) {
			single_linked_liist p1 = new single_linked_liist();
			switch(poly){
			case'A':
				p1 = A;
				break;
			case'B':
				p1 = B;
				break;
			case'C':
				p1 = C;
				break;
			case'R':
				p1 = R;
				break;
			}
			String equation=new String();
			int n=0;
			int arr1 [][];
			while(n<p1.size()) {
				arr1 = (int[][]) p1.get(n+1);
				String s1,s2;
				s1=Integer.toString(arr1[0][0]);
				s2=Integer.toString(arr1[0][1]);
				if(arr1[0][0]==0)
					equation+=s2;
				else
					equation+=s2+"x^"+s1;
				n++;
				if(n<p1.size()) {
						equation+= " + ";
				}
				
			}
			return equation;
			}
		/*clear polynomial
		 * used to clear a polynomial
		 */
		public void clearPolynomial(char poly) {
			single_linked_liist p = new single_linked_liist();
			switch(poly){
			case'A':
				p = A;
				break;
			case'B':
				p = B;
				break;
			case'C':
				p = C;
				break;
			}
			p.clear();
		}
		
		/*evaluate polynomial
		 * used to evaluate a polynomial with the given value
		 */
		public float evaluatePolynomial(char poly, float value) {
			float result=0;
			single_linked_liist p = new single_linked_liist();
			switch(poly){
			case'A':
				p = A;
				break;
			case'B':
				p = B;
				break;
			case'C':
				p = C;
				break;
			}
			int n=0;
			while(n<p.size()) {
				int arr1 [][]= (int[][]) p.get(n+1);
				result+=Math.pow(value,arr1[0][0])*arr1[0][1];
				n++;
			}
			return result;
		}

		/*add
		 * used to add 2 polynomials
		 */
		public int[][] add(char poly1, char poly2) {
			single_linked_liist p1 = new single_linked_liist();
			single_linked_liist p2 = new single_linked_liist();
			R.clear();
			switch(poly1){
			case'A':
				p1 = A;
				break;
			case'B':
				p1 = B;
				break;
			case'C':
				p1 = C;
				break;
			case's':
				p1 = save;
				break;
			}
			switch(poly2){
			case'A':
				p2 = A;
				break;
			case'B':
				p2 = B;
				break;
			case'C':
				p2 = C;
				break;
			case'm':
				p2 = mList;
				break;
			}
			int n1=0,n2=0;
			while(n1<p1.size()&&n2<p2.size()) {
				int arr1 [][]= (int[][]) p1.get(n1+1);
				int arr2 [][]= (int[][]) p2.get(n2+1);
				if(arr1[0][0]>arr2[0][0]) {
					R.add(arr1);
					n1++;
				}
				if(arr1[0][0]<arr2[0][0]) {
					R.add(arr2);
					n2++;
				}
				if(arr1[0][0]==arr2[0][0]) {
					int arr[][] ={{arr1[0][0],arr1[0][1]+arr2[0][1]}};
					R.add(arr);
					n1++;n2++;
				}
			}
			while(n1<p1.size()) {
				int arr1 [][]= (int[][]) p1.get(n1+1);
				R.add(arr1);
				n1++;
			}
			while(n2<p2.size()) {
				int arr2 [][]= (int[][]) p2.get(n2+1);
				R.add(arr2);
				n2++;
			}
			int terms[][] = setTerms(R);
			return terms;
		}

		/*subtract
		 * used to subtract 2 polynomials
		 */
		public int[][] subtract(char poly1, char poly2) {
			int terms[][];
			if(poly1!=poly2) {//two different polynomials
				int arr[][] = {{0,-1}};
				mList = multiplyList(poly2,arr);//get the addition inverse of the 2nd polynomial
				add(poly1,'m');//add the first with the addition inverse second polynomial
				terms = setTerms(R);
			}
			else {//user want to subtract 2 same polynomials which will always gives 0
				 R.clear();
				 terms = new int[1][2];
				 terms[0][0] = terms[0][1] = 0;
				 R.add(terms);
			}
			return terms;	
		}

		/*multiply
		 * used to multiply 2 polynomials
		 */
		public int[][] multiply(char poly1, char poly2) {
			int n =0;
			single_linked_liist p1 = new single_linked_liist();
			switch(poly1){
			case'A':
				p1 = A;
				break;
			case'B':
				p1 = B;
				break;
			case'C':
				p1 = C;
				break;
			}
			save.clear();
			/*multiply of 2 polynomials is result of sum (addition)
			 * of multiply of one polynomial with all the terms of the other 
			 */
			while(n<p1.size()) {
				mList.clear();
				mList = multiplyList(poly2,(int[][]) p1.get(n+1));//multiply the second with the (n+1) term of the first
				int arr[][]={{0,1}};
				add('s','m');
				n++;
				save = multiplyList('R',arr);
			}
			int terms[][] = setTerms(R);
			return terms;	
			}
		
		
		/*multiply list
		 * used to help us in multiply and subtract
		 * as both of them will be considered addition
		 * this function will return a new list which is the result multiply of 
		 * a list (many terms) and a array(one term)
		 */
		public single_linked_liist multiplyList(char poly,int arr[][]) {
			single_linked_liist p = new single_linked_liist();
			single_linked_liist s = new single_linked_liist();
			int n =0;
			switch(poly){
			case'A':
				p = A;
				break;
			case'B':
				p = B;
				break;
			case'C':
				p = C;
				break;
			case'R':
				p = R;
				break;
			}
			while(n<p.size()) {
				int arrS[][] = new int [1][2];
				int arrP[][]= (int[][]) p.get(n+1);
			    arrS[0][0] = arrP[0][0] + arr[0][0];
				arrS[0][1] = arrP[0][1] * arr[0][1];
				s.add(arrS);
				n++;
			}
			return s;
		}
}
