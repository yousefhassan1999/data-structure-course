package linked_list_intterface;

public interface IPolynomialSolver {
	void setPolynomial(char poly, int[][] terms);
	String print(char poly);
	void clearPolynomial(char poly);
    float evaluatePolynomial(char poly, float value);
	int[][] add(char poly1, char poly2);
	int[][] subtract(char poly1, char poly2);
	int[][] multiply(char poly1, char poly2);
   }
