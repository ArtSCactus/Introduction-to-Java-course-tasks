package com.completedtasks.unit3;

import org.junit.Assert;
import org.junit.Test;

public class MatrixTest {

    @Test
    public void biggestElement() {
        double[][] matrix = new double[][]{
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {5, 9, 10, 99, 4},
                {11, 12, 13, 14}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(99, testObject.biggestElement(),0.0000000001);
    }

    @Test
    public void leastElement() {
        double[][] matrix = new double[][]{
                {0, 1, 2, 3, 4},
                {5, 6, -1, 8, 9},
                {5, 9, 10, 99, 4},
                {11, 12, 13, 14}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(-1, testObject.leastElement(),0.0000000001);
    }

    @Test
    public void geometricAverage() {
        double[][] matrix = new double[][]{
                {2,2,3,10},
                {1,4,5,6}
        };
    Matrix testObject = new Matrix(matrix);
    Assert.assertEquals(3.309750919646873, testObject.geometricAverage(), 0.000001);
}

    @Test
    public void arithmeticAverage() {
        double[][] matrix = new double[][]{
                {5,5,10,13},
                {4,2,1,9}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(6.125, testObject.arithmeticAverage(), 0.000001);
    }

    @Test
    public void localMin() {
        double[][] matrix = new double[][]{
                {5,5,10,13},
                {4,2,1,9}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(1, testObject.localMin(),0.0000000001);
    }
    @Test
    public void localMinEqualElements() {
        double[][] matrix = new double[][]{
                {1,1,1,1},
                {1,1,1,1}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(-1, testObject.localMin(),0.0000000001);
    }

    @Test
    public void localMax() {
        double[][] matrix = new double[][]{
                {5,9,5,5},
                {5,5,10,5}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(9, testObject.localMax(),0.0000000001);
    }

    @Test
    public void localMaxEqualElements() {
        double[][] matrix = new double[][]{
                {5,5,5,5},
                {5,5,5,5}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(-1, testObject.localMin(),0.0000000001);
    }

    @Test
    public void transpose() {
        double[][] matrix = new double[][]{
                {4,4,4,4},
                {5,5,5,5},
                {6,6,6,6},
                {7,7,7,7}
        };
        double[][] expected = new double[][]{
                {4,5,6,7},
                {4,5,6,7},
                {4,5,6,7},
                {4,5,6,7}
        };
        Matrix testObject = new Matrix(matrix);
        testObject.transpose();
        Assert.assertArrayEquals(expected, testObject.getMatrix());
    }

    @Test
    public void transposeExceptionCaseOne() {
        double[][] matrix = new double[][]{
                {4,4,4,4},
                {5,5,5,5},
                {6,6,6,6},
        };
        double[][] expected = new double[][]{
                {4,5,6},
                {4,5,6},
                {4,5,6},
                {4,5,6}
        };
        Matrix testObject = new Matrix(matrix);
        testObject.transpose();
        Assert.assertArrayEquals(expected, testObject.getMatrix());
    }

    @Test
    public void transposeExceptionCaseTwo() {
        double[][] matrix = new double[][]{
                {4,4,4},
                {5,5,5},
                {6,6,6},
                {7,7,7}
        };
        double[][] expected = new double[][]{
                {4,5,6,7},
                {4,5,6,7},
                {4,5,6,7},
        };
        Matrix testObject = new Matrix(matrix);
        testObject.transpose();
        Assert.assertArrayEquals(expected, testObject.getMatrix());
    }

    @Test
    public void brokenMatrixTransposeOne() {
        double[][] matrix = new double[][]{
                {4,4,4,4},
                {5},
                {6,6},
        };
        double[][] expected = new double[][]{
                {4,5,6},
                {4,0,6},
                {4,0,0},
                {4,0,0}
        };
        Matrix testObject = new Matrix(matrix);
        testObject.transpose();
        Assert.assertArrayEquals(expected, testObject.getMatrix());
    }

    @Test
    public void brokenMatrixTransposeTwo() {
        double[][] matrix = new double[][]{
                {4,2},
                {4},
                {4,6},
                {4,6,7},
                {8,9,10,11}
        };
        double[][] expected = new double[][]{
                {4,4,4,4,8},
                {2,0,6,6,9},
                {0,0,0,7,10},
                {0,0,0,0,11}
        };
        Matrix testObject = new Matrix(matrix);
        testObject.transpose();
        Assert.assertArrayEquals(expected, testObject.getMatrix());
    }
    @Test
    public void isSquare(){
        double[][] matrix = new double[][]{
                {4,4,4,4},
                {5,5,5,5},
                {6,6,6,6},
                {7,7,7,1}
        };
        Matrix testObject = new Matrix(matrix);
        Assert.assertEquals(true, testObject.isSquare());
    }
}
