package net.sf.classifier4J.vectorspace;

import junit.framework.TestCase;

/**
 * @author <a href="mailto:lars@trieloff.net">Lars Trieloff</a>
 *
 */
public class DoubleVectorUtilsTest extends TestCase {
    public void testDoubleVectorUtils() {
        assertNotNull(new DoubleVectorUtils());
    }
    /*
     * Test method for 'net.sf.classifier4J.vectorspace.DoubleVectorUtils.scalarProduct(double[], double[])'
     */
    public void testScalarProductDoubleArrayDoubleArray() {
        //simple calculation
        assertEquals(1d, (DoubleVectorUtils.scalarProduct(new double[] { 1, 0,
                1 }, new double[] { 1, 0, 0 })), 0.00001d);
        //one vector truncated
        assertEquals(1d, (DoubleVectorUtils.scalarProduct(new double[] { 1, 0,
                1 }, new double[] { 1 })), 0.00001d);
        //one vector missing
        try {
            assertEquals(1d, (DoubleVectorUtils.scalarProduct(new double[] { 1, 0,
                    1 }, null)), 0.00001d);
            fail("Illegal argument left undetected");
        } catch (IllegalArgumentException iae) {
            //nothing to be done here
        }
    }

    /*
     * Test method for 'net.sf.classifier4J.vectorspace.DoubleVectorUtils.vectorLength(double[])'
     */
    public void testVectorLengthDoubleArray() {
        //one simple calculation
        assertEquals(1d, DoubleVectorUtils.vectorLength(new double[] {1}), 0.00001d);
        //illegal argument
        try {
            assertEquals(1d, DoubleVectorUtils.vectorLength((double[]) null), 0.00001d);
            fail();
        } catch (IllegalArgumentException iae) {
            //nothing to be done here
        }
    }

    /*
     * Test method for 'net.sf.classifier4J.vectorspace.DoubleVectorUtils.cosineOfVectors(double[], double[])'
     */
    public void testCosineOfVectorsDoubleArrayDoubleArray() {
        //orthogonal
        assertEquals(0d, DoubleVectorUtils.cosineOfVectors(new double[] {1,0}, new double[] {0,1}), 0.00001d);
        //parallel
        assertEquals(1d, DoubleVectorUtils.cosineOfVectors(new double[] {1,1}, new double[] {1,1}), 0.00001d);
        //one argument null
        try {
            assertEquals(1d, DoubleVectorUtils.cosineOfVectors(new double[] {1,1}, null), 0.00001d);
            fail();
        } catch (IllegalArgumentException iae) {
            //nothing to be done here
        }
        //one argument zero
        assertEquals(0d, DoubleVectorUtils.cosineOfVectors(new double[] {1,1}, new double[] {0,0}), 0.00001d);
    }

}
