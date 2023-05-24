public class MarkovChain {
	private Vector stateVector;
	private Matrix transitionMatrix;

	/*
	 * vector object and matrix object are declared
	 */
	public MarkovChain(Vector sVector, Matrix tMatrix) {
		stateVector = sVector;
		transitionMatrix = tMatrix;
	}

	/*
	 * isValid() method checks whether it is possible to attain a probability matrix
	 * from the state vector and transition matrix
	 */
	public boolean isValid() {
		double totalVector = 0.0;
		double totalRow = 0.0;

		/*
		 * checks whether the matrix is square and if each row of transition matrix and
		 * the state vector add up to 1.0
		 */
		if (transitionMatrix.getNumRows() == transitionMatrix.getNumCols()
				&& transitionMatrix.getNumRows() == stateVector.getNumCols()) {
			for (int i = 0; i < stateVector.getNumCols(); i++) {
				totalVector += stateVector.getElement(i);
			}

			if (0.99 >= totalVector || totalVector >= 1.01) {
				return false;
			}

			for (int j = 0; j < transitionMatrix.getNumRows(); j++) {
				for (int k = 0; k < transitionMatrix.getNumCols(); k++) {
					totalRow += transitionMatrix.getElement(j, k);
				}

				if (0.99 >= totalRow || totalRow >= 1.01) {
					return false;
				}

				totalRow = 0;

			}

			return true;
		}

		else {
			return false;
		}
	}

	/*
	 * method which returns the probability matrix based on how many states does the
	 * transition matrix go through
	 */
	public Matrix computeProbabilityMatrix(int numSteps) {
		Matrix probabilityMatrix = transitionMatrix;
		if (this.isValid() == false) {
			return null;
		} else {
			for (int i = 0; i < numSteps - 1; i++) {
				probabilityMatrix = probabilityMatrix.multiply(transitionMatrix);
			}

			return stateVector.multiply(probabilityMatrix);
		}
	}
}
