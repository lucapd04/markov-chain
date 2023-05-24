public class Matrix {
	private int numRows;
	private int numCols;
	private double[][] data;

	/*
	 * constructor which assigns the instance variables with the values in the
	 * parameter
	 */
	public Matrix(int r, int c) {
		numRows = r;
		numCols = c;
		data = new double[numRows][numCols];
	}

	/*
	 * another constructor which converts an array into a matrix with the inputed
	 * dimensions
	 */
	public Matrix(int r, int c, double[] linArr) {
		numRows = r;
		numCols = c;
		data = new double[numRows][numCols];
		double[] array = linArr;
		int position = 0;

		/*
		 * for loop which places each element from the array into the newly formed 2D
		 * array
		 */
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++, position++) {
				data[i][j] = array[position];
			}
		}
	}

	/*
	 * series of getters which return the number of rows, columns and also the
	 * elements of the matrix one setter which change the value of one element in
	 * the matrix
	 */
	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public double[][] getData() {
		return data;
	}

	public double getElement(int r, int c) {
		return data[r][c];
	}

	public void setElement(int r, int c, double value) {
		data[r][c] = value;
	}

	/*
	 * the transpose method transposes the matrix, as in it flips the columns and
	 * rows of the matrix, inverting the position of the elements and the dimension
	 */
	public void transpose() {
		int tRows = numCols;
		int tCols = numRows;
		double[][] transpose = new double[tRows][tCols];

		/*
		 * for loop picks values in the matrix and places them in their new location
		 * within the transpose matrix variable
		 */
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				transpose[j][i] = data[i][j];
			}
		}

		/*
		 * changing the dimension and elements of the original matrix to match with the
		 * transposed matrix
		 */
		this.numRows = tRows;
		this.numCols = tCols;
		this.data = transpose;
	}

	/*
	 * the multiply method multiplies all the values in the matrix by a certain
	 * scalar value
	 */
	public Matrix multiply(double scalar) {
		Matrix multiples = new Matrix(this.numRows, this.numCols);

		/*
		 * a new matrix object named "multiples" is used to store the multiplied matrix
		 */
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numCols; j++) {
				multiples.data[i][j] = this.data[i][j] * scalar;
			}
		}

		return multiples;
	}

	/*
	 * another multiply method but it multiplies the matrix by another matrix
	 * instead of a scalar value
	 */
	public Matrix multiply(Matrix other) {
		double[] values = new double[this.numCols];
		double[] otherValues = new double[other.numCols];

		/*
		 * if statement to verify if the multiplication is possible
		 */
		if (this.numCols != other.numRows) {
			return null;

		} else {

			/*
			 * first two for loops go through each index in the product matrix, where the
			 * new values will be stored in
			 */
			Matrix product = new Matrix(this.numRows, other.numCols);
			for (int i = 0; i < this.numRows; i++) {
				for (int j = 0; j < other.numCols; j++) {

					/*
					 * 2 for loops, one gathers each value in the rows of "this" matrix, and the
					 * other gathers each value in the columns of "other" matrix
					 */
					for (int k = 0; k < this.numCols; k++) {
						values[k] = this.data[i][k];
					}
					for (int l = 0; l < other.numRows; l++) {
						otherValues[l] = other.data[l][j];
					}

					/*
					 * multiplies each respective value in both arrays
					 */
					product.data[i][j] = 0;
					for (int m = 0; m < values.length; m++) {
						product.data[i][j] += values[m] * otherValues[m];
					}
				}
			}

			return product;
		}
	}

	/*
	 * toString() method converts the matrix into a string which can be displayed
	 * and visualized
	 */
	@Override
	public String toString() {
		if (this.numRows == 0 || this.numCols == 0) {
			return "Empty matrix";

		} else {
			String matrix = "";
			for (int i = 0; i < this.numRows; i++) {
				for (int j = 0; j < this.numCols; j++) {
					matrix += String.format("%8.3f", this.data[i][j]);
				}

				matrix += "\n";
			}
			return matrix;
		}
	}
}
