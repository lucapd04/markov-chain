/*
 * the vector class is a derived class from matrix used to gather information from the state vector
 * the super() function is used in this case to borrow members from the constructors and getElement() method from the Matrix class
 */
public class Vector extends Matrix {

	public Vector(int c) {
		super(1, c);

	}

	public Vector(int c, double[] linArr) {
		super(1, c, linArr);
	}

	public double getElement(int c) {
		return super.getElement(0, c);
	}

}
