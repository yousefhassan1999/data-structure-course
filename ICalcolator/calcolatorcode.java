package ICalcolator;

public class calcolatorcode implements ICalcolator {
	public int add(int a , int y) {
		return a+y;
	}
	public float divide (int a , int y) throws RuntimeException  {

	    if (a==0 && y<0) //thats for zero divided by negative number equal -0 
	    {
			y=y*(-1);
			return (float)a/(float)y;
		}	
	    else if (y!=0) 
	    	return (float)a/(float)y;
		else 
			throw new RuntimeException(" can't divide by zero ");
	}
}
