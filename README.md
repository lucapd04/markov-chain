# markov-chain
The Markov Chain project consists of 3 classes: MarkovChain, Matrix and Vector. The program revolves around the concept of polymorphism, with Matrix and Vector being subclasses of MarkovChain.  The Matrix class creates a matrix, while the Vector class is a subclass of Matrix responsible for gathering a vector from that matrix. The MarkovChain class creates a new matrix following the Markov Chain principle, multiplying the matrix by the probability vector for a fixed amount of times. How the matrix is multiplied is dependent on the two Multiply methods, which overload one another depending on which parameter is sent through.
