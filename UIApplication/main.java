package UIApplication;

import java.util.Scanner;

import linked_list_classe.PolynomialSolver;

public class main {

	/*
	 * please make sure while entering the polynomial terms(coff1, exp1), 
	 * to enter it as the following format(the given in the lab)
	 * (exp1, coff1), (exp2, coff2), ..
	 * ###MAKE SURE TO ADD A SPACE AFTER EACH COMMA###
	 * examples:
	 * (2, 1), (0, 2)
	 * (-1, 2), (0, 1), (-2, 1), (1, 3)
	 */
	
	
	//main for user interface and using the required methods
	public static void main(String[] args) throws Exception {
			PolynomialSolver PS = new PolynomialSolver();
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			boolean A = false,B = false,C = false,R = false;//booleans to check if the Polynomial is set
			char poly,firstOperand;
			System.out.println("Please choose an action");
			System.out.println("-----------------------");
			System.out.println("1- Set a polynomial variable");
			System.out.println("2- Print the value of a polynomial variable");
			System.out.println("3- Add two polynomials");
			System.out.println("4- Subtract two polynomials");
			System.out.println("5- Multiply two polynomials");
			System.out.println("6- Evaluate a polynomial at some point");
			System.out.println("7- Clear a polynomial variable");
			System.out.println("====================================================================");
			while(true) {//will keep running forever unless user enter invalid input
				int Operation = in.nextInt();//read required operation
				switch(Operation) {
				case 1 ://set Polynomial
					System.out.println("Insert the variable name: A, B or C");
					poly = Character.toUpperCase((in.next().trim().charAt(0)));
					switch(poly){
						case'A':
							A= true;
							break;
						case'B':
							B= true;
							break;
						case'C':
							C= true;
							break;
						default:
							throw new Exception("Undefined polynomial");
				}
					System.out.println("Insert the polynomial terms in the form:");
					System.out.println("(exponent1, coeff1), (exponent2, coeff2), ..");
					int terms[][] = PS.readPoints();
					System.out.println("Polynomial "+poly+" is set");
					PS.setPolynomial(poly,terms);
					break;
				case 2 ://print Polynomial
					if(A||B||C||R) {
						while(true) {
							System.out.println("Insert the variable name: A, B , C or R");
							poly = Character.toUpperCase((in.next().trim().charAt(0)));
								if(poly=='A'||poly=='B'||poly=='C'||poly=='R') {
									if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)||(poly=='R'&&R)) {
										System.out.print("Value in "+poly+" : ");
										System.out.println(PS.print(poly));
										break;
									}
									else
										System.out.println("Variable not set");
								}
								else
									throw new Exception("Undefined polynomial");
								}
						}
					else
						System.out.println("Not enough polynomials are set");
					break;
				case 3 ://add 2 Polynomials
					if(A||B||C) {
						while(true) {
							System.out.println("Insert first operand variable name: A, B or C");
							poly = Character.toUpperCase((in.next().trim().charAt(0)));
							if(poly=='A'||poly=='B'||poly=='C') {
								if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)) {
									firstOperand = poly;
									break;
								}
								else
									System.out.println("Variable not set");
							}
							else
								throw new Exception("Undefined polynomial");
							}
						while(true) {
							System.out.println("Insert the second operand variable name: A, B or C");
							poly = Character.toUpperCase((in.next().trim().charAt(0)));
							if(poly=='A'||poly=='B'||poly=='C') {
								if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)) {
									PS.add(firstOperand,poly);
									System.out.print("Result set in R: ");
									poly = 'R';R = true;
									System.out.println(PS.print(poly));
									break;
								}
								else
									System.out.println("Variable not set");
							}
							else
								throw new Exception("Undefined polynomial");
							}
					}
						else
								System.out.println("Not enough polynomials are set");
					break;
				case 4 ://subtract 2 Polynomials
					if(A||B||C) {
						while(true) {
							System.out.println("Insert first operand variable name: A, B or C");
							poly = Character.toUpperCase((in.next().trim().charAt(0)));
							if(poly=='A'||poly=='B'||poly=='C') {
								if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)) {
									firstOperand = poly;
									break;
								}
								else
									System.out.println("Variable not set");
							}
							else
								throw new Exception("Undefined polynomial");
							}
							while(true) {
							System.out.println("Insert the second operand variable name: A, B or C");
							poly = Character.toUpperCase((in.next().trim().charAt(0)));
							if(poly=='A'||poly=='B'||poly=='C') {
								if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)) {
									PS.subtract(firstOperand,poly);
									System.out.print("Result set in R: ");
									poly = 'R';R = true;
									System.out.println(PS.print(poly));
									break;
								}
								else
									System.out.println("Variable not set");
							}
							else
								throw new Exception("Undefined polynomial");
							}
					}
					else
							System.out.println("Not enough polynomials are set");
					break;
				case 5 :// multiply 2 Polynomials
					if(A||B||C) {
						while(true) {
						System.out.println("Insert first operand variable name: A, B or C");
						poly = Character.toUpperCase((in.next().trim().charAt(0)));
						if(poly=='A'||poly=='B'||poly=='C') {
							if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)) {
								firstOperand = poly;
								break;
							}
							else
								System.out.println("Variable not set");
						}
						else
							throw new Exception("Undefined polynomial");
						}
						while(true) {
						System.out.println("Insert the second operand variable name: A, B or C");
						poly = Character.toUpperCase((in.next().trim().charAt(0)));
						if(poly=='A'||poly=='B'||poly=='C') {
							if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)) {
								PS.multiply(firstOperand,poly);
								System.out.print("Result set in R: ");
								poly = 'R';R=true;
								System.out.println(PS.print(poly));
								break;
							}
							else
								System.out.println("Variable not set");
						}
						else
							throw new Exception("Undefined polynomial");
						}
					}
					else
						System.out.println("Not enough polynomials are set");
					break;
				case 6 ://evaluate Polynomial
					if(A||B||C||R) {
						while(true) {
						System.out.println("Insert the variable name: A, B , C or R");
						poly = Character.toUpperCase((in.next().trim().charAt(0)));
						if(poly=='A'||poly=='B'||poly=='C'||poly=='R') {
							if((poly=='A'&&A)||(poly=='B'&&B)||(poly=='C'&&C)||(poly=='R'&&R)) {
								System.out.println("Insert the required value");
								float value = in.nextFloat();
								System.out.println("Result is :"+PS.evaluatePolynomial(poly, value));
								break;
							}
							else
								System.out.println("Variable not set");
						}
						else
							throw new Exception("Undefined polynomial");
						}
					}
					else
						System.out.println("Not enough polynomials are set");
					break;
				case 7 :// clear a Polynomial
					System.out.println("Insert the variable name: A, B or C");
					poly = Character.toUpperCase((in.next().trim().charAt(0)));
					switch(poly){
					case'A':
						A= false;
						PS.clearPolynomial(poly);
						break;
					case'B':
						B= false;
						PS.clearPolynomial(poly);
						break;
					case'C':
						C= false;
						PS.clearPolynomial(poly);
						break;
					default:
						throw new Exception("Undefined polynomial");
					}
					System.out.println("Polynomial "+poly+" is cleared");
					break;
				default ://undefined operation
					throw new Exception("Undefined Operation");
				}
				System.out.println("====================================================================");
				System.out.println("Please choose an action");//prepare for new operation
				System.out.println("-----------------------");
				System.out.println("1- Set a polynomial variable, ... etc");
			}
	}
}
