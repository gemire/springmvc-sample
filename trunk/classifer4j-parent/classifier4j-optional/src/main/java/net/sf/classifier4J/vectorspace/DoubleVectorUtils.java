package net.sf.classifier4J.vectorspace;

import net.sf.classifier4J.vector.VectorUtils;

/**
 * @auth.or <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class DoubleVectorUtils extends VectorUtils {
    /**
     * Calculates the scalar product of two vectors. Opposed to 
     * {@link VectorUtils#scalarProduct(int[], int[])} this is not limited
     * to vectors of the same size. 
     * @param one first vector
     * @param two second vector
     * @return scalar product of two vectors
     * @throws IllegalArgumentException
     */
    public static double scalarProduct(double[] one, double[] two) throws IllegalArgumentException {
        if ((one == null) || (two == null)) {
            throw new IllegalArgumentException(Messages.getString("DoubleVectorUtils.0")); //$NON-NLS-1$
        }
        double result = 0;
        //first consider only the parts where both vectors have an entry
        for (int i = 0; i < Math.min(one.length, two.length); i++) {
            result += one[i] * two[i];
        }
        //then, assume the second vector is padded with zeros. As the entries of two vectors are
        //multiplied and multiplication with zero is zero, nothing will be added to the result.
        return result;
    }
    /**
     * Calculates the length of a vector of doubles.
     * @param vector a vector of doubles
     * @return the length of the vector
     * @throws IllegalArgumentException illegal vector
     */
    public static double vectorLength(double[] vector) throws IllegalArgumentException {
        if (vector == null) {
            throw new IllegalArgumentException(Messages.getString("DoubleVectorUtils.0")); //$NON-NLS-1$
        }
        
        double sumOfSquares = 0d;
        for (int i = 0; i < vector.length; i++) {
            sumOfSquares = sumOfSquares + (vector[i] * vector[i]);
        }
        
        return Math.sqrt(sumOfSquares);
    }
    /**
     * Calculates the cosine of two vectors. Opposed to {@link VectorUtils#cosineOfVectors(int[], int[])}
     * this is not limited to vectors of identical length.
     * @param one first vector
     * @param two second vector
     * @return cosine of the angles of the two vectors
     * @throws IllegalArgumentException illegal vectors provided
     */
    public static double cosineOfVectors(double[] one, double[] two) throws IllegalArgumentException {
        if ((one == null) || (two == null)) {
            throw new IllegalArgumentException(Messages.getString("DoubleVectorUtils.0")); //$NON-NLS-1$
        }
        double denominater = (vectorLength(one) * vectorLength(two));
        if (denominater == 0) {
            return 0;
        }
        return (DoubleVectorUtils.scalarProduct(one, two)/denominater);
    }

}
