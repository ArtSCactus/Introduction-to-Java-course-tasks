package com.completedtasks.unit3;

import java.util.Arrays;

/**
 * Task condition:
 * Задана матрица размера N x M. Необходимо выполнить следующие действия:
 * - найти экстремальные значения (минимальный и максимальный элементы) данной матрицы;
 * - найти среднеарифметическое и среднегеометрическое значения всех элементов матрицы;
 * - найти позицию первого встретившегося локального минимума (максимума), а если таких элементов нет, то возвратить -1 (локальный минимум
 * – это элемент, который меньше любого из своих соседей; локальный максимум – это элемент, который больше любого из своих соседей);
 * - транспонировать матрицу (при решении данного задания не рекомендуется задействовать дополнительную память).
 * <p>
 * This class in aimed to work with double matrix. Each matrix is class object.
 *
 * @author ArtSCactus
 * @version 0.5
 */
public class Matrix {

    /**
     * Main matrix storage
     */
    private double[][] matrix;

    /**
     * Initializes empty matrix.
     * <p>
     * Initializes double type matrix with length 0.
     */
    public Matrix() {
        matrix = new double[0][];
    }

    /**
     * Initializes empty matrix with fixed rows and columns.
     * <p>
     * Initializes matrix of double type with given rows and column.
     * Each element has default value (0).
     *
     * @param rows    - rows for matrix
     * @param columns - columns for matrix
     */
    public Matrix(int rows, int columns) {
        matrix = new double[rows][columns];
    }

    /**
     * Initializes matrix with given 2-dimensional array.
     *
     * @param matrix
     */
    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Returns double type matrix.
     *
     * @return (double) matrix
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Returns amount of elements in the current matrix.
     * <p>
     * Method calls private method countElements();
     *
     * @return countElements();
     * @see Matrix#countElements()
     */
    public int size() {
        return countElements();
    }

    /**
     * Counts size of current matrix.
     */
    private int countElements() {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            counter += matrix[row].length;
        }
        return counter;
    }

    /**
     * Randomly fills current matrix 
     *
     * Gives each element random value, that min < element value < max.
     *
     * @param min - minimal value
     * @param max - maximal value
     */
    public void generate(double min, double max) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                matrix[rowIndex][columnIndex] = (double) (Math.random() * max) + min;
            }
        }
    }

    /**
     * Returns the biggest element in matrix.
     *
     * @return (double) biggest element
     */
    public double biggestElement() {
        double biggestElement = matrix[0][0];
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                if (biggestElement < matrix[rowIndex][columnIndex]) {
                    biggestElement = matrix[rowIndex][columnIndex];
                }
            }
        }
        return biggestElement;
    }

    /**
     * Returns the least element in matrix.
     *
     * @return (double) least element
     */
    public double leastElement() {
        double leastElement = matrix[0][0];

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                if (leastElement > matrix[rowIndex][columnIndex]) {
                    leastElement = matrix[rowIndex][columnIndex];
                }
            }
        }

        return leastElement;
    }

    /**
     * Returns geometric average for matrix.
     *
     * @return (double) geometric average
     */
    public double geometricAverage() {
        double product = 1;

        for (double[] row : matrix) {
            for (double element : row) {
                product *= element;
            }
        }

        return Math.pow(product, (double) 1 / countElements());
    }

    /**
     * Returns arithmeticAverage for matrix.
     *
     * @return (double) arithmetic average
     */
    public double arithmeticAverage() {
        double sum = 0;

        for (double[] row : matrix) {
            for (double element : row) {
                sum += element;
            }
        }

        return sum / countElements();
    }



    /**Finds position of localMax/localMin in one row matrix.
     *
     * This method is a part of {@code localMax()} and {@code localMin()} methods.
     * Not an independent method.
     *
     * @param mode 1-for local max, 0 - for local min
     * @return localMax/localMin's serial number (from top to down, from left on right)
     */
    private int oneRowCase(int mode){
        if (matrix.length==0){
            return -1;
        }
        switch(mode) {
            //for local maximum
            case(1):
                //only one element
                if (matrix[0].length == 1) {
                    return 0;
                }
                for (int column = 0; column < matrix[0].length; column++) {
                    //beginning of the row
                    if (column == 0) {
                        if (matrix[0][0] > matrix[0][1]) {
                            return column;
                        }
                    }
                    //middle of the row
                    if (column > 0 & column < matrix[0].length - 1) {
                        if (matrix[0][column] > matrix[0][column - 1] &
                                matrix[0][column] > matrix[0][column + 1]) {
                            return column;
                        }
                    }
                    //end of the row
                    if (column == matrix[0].length - 1) {
                        if (matrix[0][column] > matrix[0][column - 1]) {
                            return column;
                        }
                    }
                }
                break;
                //for local minimum
            case(0):
                //only one element
                if (matrix[0].length == 1) {
                    return 0;
                }
                for (int column = 0; column < matrix[0].length; column++) {
                    //beginning of the row
                    if (column == 0) {
                        if (matrix[0][0] < matrix[0][1]) {
                            return column;
                        }
                    }
                    //middle of the row
                    if (column > 0 & column < matrix[0].length - 1) {
                        if (matrix[0][column] < matrix[0][column - 1] &
                                matrix[0][column] < matrix[0][column + 1]) {
                            return column;
                        }
                    }
                    //end of the row
                    if (column == matrix[0].length - 1) {
                        if (matrix[0][column] < matrix[0][column - 1]) {
                            return column;
                        }
                    }
                }
                break;
        }
        return -1;
    }

    /**Finds serial number of first localMax/localMin in the first row.
     *
     * This method is a part of {@code localMax()} and {@code localMin()} methods.
     * Not an independent method.
     *
     * @param counter - current serial number
     * @param mode - 1 for local max mode, 0 - for local min mode
     * @return if serial number wasn't, will be returned current counter (to continue search)
     */
    private int firstRowCase(int counter, int mode){
        switch (mode) {
            case(1):
            for (int column = 0; column < matrix[0].length; column++) {
                //start of row
                if (column == 0) {
                    if (matrix[0][column] > matrix[0][column + 1] &
                            matrix[1][column] > matrix[0 + 1][column]) {
                        return counter;
                    }
                } else {
                    //middle of row
                    if (column > 0 & column < matrix[0].length - 1) {
                        if (matrix[0][column] > matrix[0][column + 1] &
                                matrix[0][column] > matrix[0 + 1][column] &
                                matrix[0][column] > matrix[0][column - 1]) {
                            return counter;
                        }
                    }
                }
                //end of row
                if (column == matrix[0].length - 1) {
                    if (matrix[0][column] > matrix[0][column - 1] &
                            matrix[0][column] > matrix[0 + 1][column]) {
                        return counter;
                    }
                }
                counter++;
            }
            break;
            case(0):
                for (int column = 0; column < matrix[0].length; column++) {
                    //start of row
                    if (column == 0) {
                        if (matrix[0][column] < matrix[0][column + 1] &
                                matrix[0][column] < matrix[0+ 1][column]) {
                            return counter;
                        }
                    } else {
                        //middle of row
                        if (column > 0 & column < matrix[0].length - 1) {
                            if (matrix[0][column] < matrix[0][column + 1] &
                                    matrix[0][column] < matrix[0 + 1][column] &
                                    matrix[0][column] < matrix[0][column - 1]) {
                                return counter;
                            }
                        }
                    }
                    //end of row
                    if (column == matrix[0].length - 1) {
                        if (matrix[0][column] < matrix[0][column - 1] &
                                matrix[0][column] < matrix[0 + 1][column]) {
                            return counter;
                        }
                    }
                    counter++;
                }
        }
        return counter;
    }

    /**Finds serial number of local max or local min in the last row of matrix.
     *
     * This method is a part of {@code localMax()} and {@code localMin()} methods.
     * Not an independent method.
     *
     * @param row - number of last row in matrix
     * @param counter - current counter
     * @param mode - 1 for local max mode, 0 for local min mode
     * @return serial number of localMin/localMax in the last matrix row. Does not returns anything if it wasn't found.
     */
    private int lastRowCase(int row, int counter, int mode) {
        switch (mode) {
            //local max mode
            case (1):
                for (int column = 0; column < matrix[row].length; column++) {
                    //beginning of the row
                    if (column == 0) {
                        if (matrix[row][column] > matrix[row][column + 1] &
                                matrix[row][column] > matrix[row - 1][column]) {
                            return counter;
                        }
                    } else {
                        if (column > 0 & column < matrix[row].length - 1) {
                            //middle of the row
                            if (matrix[row][column] > matrix[row][column + 1] &
                                    matrix[row][column] > matrix[row][column - 1] &
                                    matrix[row][column] > matrix[row - 1][column]) {
                                return counter;
                            }
                        }
                    }
                    //end of row
                    if (column == matrix[row].length - 1) {
                        if (matrix[row][column] > matrix[row][column - 1] &
                                matrix[row][column] > matrix[row - 1][column]) {
                            return counter;
                        }
                    }
                    counter++;
                }
                break;
                // local min mode
            case (0):
                for (int column = 0; column < matrix[row].length; column++) {
                    //beginning of the row
                    if (column == 0) {
                        if (matrix[row][column] < matrix[row][column + 1] &
                                matrix[row][column] < matrix[row - 1][column]) {
                            return counter;
                        }
                    } else {
                        if (column > 0 & column < matrix[row].length - 1) {
                            //middle of the row
                            if (matrix[row][column] < matrix[row][column + 1] &
                                    matrix[row][column] < matrix[row][column - 1] &
                                    matrix[row][column] < matrix[row - 1][column]) {
                                return counter;
                            }
                        }
                    }
                    //end of row
                    if (column == matrix[row].length - 1) {
                        if (matrix[row][column] < matrix[row][column - 1] &
                                matrix[row][column] < matrix[row - 1][column]) {
                            return counter;
                        }
                    }
                    counter++;
                }
                break;
        }
        return -1;
    }
    /**
     * Returns serial number of first met local maximum.
     * <p>
     * If local maximum does not exists, will be returned local minimum.
     * Serial number begins from 0;
     *
     * @return (double) local maximum (matrix element) if it exists, localMin() otherwise.
     */
    public double localMax() {
        if(matrix.length==0){
            return -1;
        }
        if(matrix.length<2){
            return oneRowCase(1); //1-for local max mode
        }
        int counter=0;
        //More than 1 row
        for (int row = 0; row < matrix.length; row++) {
            if (row == 0) {
                counter=firstRowCase(counter,1); // 1 - for local max mode
            } else {
                //not first and not last row
                if (row > 0 & row < matrix.length - 1) {

                    for (int column = 0; column <= matrix[row].length; column++) {
                        //beginning of the row
                        if (column == 0) {
                            if (matrix[row][column] > matrix[row][column + 1] &
                                    matrix[row][column] > matrix[row - 1][column] &
                                    matrix[row][column] > matrix[row + 1][column]) {
                                return counter;
                            }
                        } else {
                            //middle of the row
                            if (column > 0 & column < matrix[row].length - 1) {
                                if (matrix[row][column] > matrix[row][column + 1] &
                                        matrix[row][column] > matrix[row][column - 1] &
                                        matrix[row][column] > matrix[row - 1][column] &
                                        matrix[row][column] > matrix[row + 1][column]) {
                                    return counter;
                                }
                            }
                        }
                        //end of the row
                        if (column == matrix[row].length - 1) {
                            if (matrix[row][column] > matrix[row][column - 1] &
                                    matrix[row][column] > matrix[row - 1][column] &
                                    matrix[row][column] > matrix[row + 1][column]) {
                                return counter;
                            }
                        }
                    }
                } else {
                   return lastRowCase(row,counter,1);//1 for local max mode
                    }
                }
            }
            counter++; // next element
        return -1;
    }

    /**
     * Returns serial number of first met local minimum.
     * <p>
     * If local minimum does not exists returns -1.
     * Serial number begins from 0.
     *
     * @return (double) local minimum (matrix element) if it exists. -1 otherwise
     */
    public double localMin() {
        if (matrix.length==0){
            return -1;
        }
        if(matrix.length<2){
            return oneRowCase(0); //1-for local max mode
        }
        int counter=0;
        //More than 1 row
        for (int row = 0; row < matrix.length; row++) {
            if (row == 0) {
                counter=firstRowCase(counter,0); // 1 - for local max mode
            } else {
                //not first and not last row
                if (row > 0 & row < matrix.length - 1) {

                    for (int column = 0; column <= matrix[row].length; column++) {
                        //beginning of the row
                        if (column == 0) {
                            if (matrix[row][column] < matrix[row][column + 1] &
                                    matrix[row][column] < matrix[row - 1][column] &
                                    matrix[row][column] < matrix[row + 1][column]) {
                                return counter;
                            }
                        } else {
                            //middle of the row
                            if (column > 0 & column < matrix[row].length - 1) {
                                if (matrix[row][column] < matrix[row][column + 1] &
                                        matrix[row][column] < matrix[row][column - 1] &
                                        matrix[row][column] < matrix[row - 1][column] &
                                        matrix[row][column] < matrix[row + 1][column]) {
                                    return counter;
                                }
                            }
                        }
                        //end of the row
                        if (column == matrix[row].length - 1) {
                            if (matrix[row][column] < matrix[row][column - 1] &
                                    matrix[row][column] < matrix[row - 1][column] &
                                    matrix[row][column] < matrix[row + 1][column]) {
                                return counter;
                            }
                        }
                    }
                } else {
                    return lastRowCase(row,counter,0);//1 for local max mode
                }
            }
        }
        counter++; // next element
        return -1;
    }

    /**
     * Transposes matrix.
     * <p>
     * Transposes only square and rectangular matrix.
     * Deprecated to use on two-dimensional arrays with variable length rows.
     * If this method will be used on two-dimensional arrays with variable length rows, matrix will be translated to
     * square matrix type, where all missed elements will be 0. Example:
     * 4 2
     * 4
     * 4 6
     * 4 6 7
     * 8 9 10 11
     * <p>
     * Will be:
     * <p>
     * 4 4 4 4 8
     * 2 0 6 6 9
     * 0 0 0 7 10
     * 0 0 0 0 11
     * This method can recursively call itself, but only 1 time (to make matrix square type and repeat).
     *
     * @version 1.2
     */
    public void transpose() {
        if (isSquare()) {
            for (int row = 0; row < matrix.length; row++) {
                for (int column = row + 1; column < matrix[row].length; column++) {
                    //swapping elements
                    matrix[row][column] = matrix[row][column] + matrix[column][row];
                    matrix[column][row] = matrix[row][column] - matrix[column][row];
                    matrix[row][column] = matrix[row][column] - matrix[column][row];
                }
            }
        } else {
            // if matrix not square, we need to make it square and swap elements.
            // if amount of rows, bigger than amount of columns, it means, that transposed matrix will have
            // amount of rows, that equals old amount of columns and vice versa
            if (matrix.length > matrix[0].length) {
                int oldBiggestColumns = biggestRowLength();
                changeColumns(matrix.length);
                transpose();
                changeRows(oldBiggestColumns);
            } else {
                //otherwise, amount of columns will be equals to the old amount of rows and vice versa
                int oldRows = matrix.length;
                changeRows(biggestRowLength());
                if (isVariableLength()) {
                    changeColumns(biggestRowLength());
                }
                transpose();
                changeColumns(oldRows);
            }
        }
    }

    /**
     * Checking matrix on rows with variable length.
     * <p>
     * This method checks the matrix is there any rows with different length.
     * Returns true if such rows are exists, false otherwise.
     * <p>
     * FORBIDDEN to use outside of transpose() algorithm. This method is a part of it.
     *
     * @return true if matrix does have rows with different length, false otherwise
     * @see Matrix#transpose()
     * @deprecated - part of only one algorithm
     */
    private boolean isVariableLength() {
        for (int index = 0; index < matrix.length; index++) {
            if (matrix[index].length != matrix[0].length) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find biggest length of row in matrix.
     * <p>
     * This method is find the longest row in the matrix and returns it length.
     * FORBIDDEN to use outside of {@code transpose()} algorithm. This method is a part of it.
     *
     * @return (int) length of the biggest row
     * @deprecated - part of only one algorithm
     */
    private int biggestRowLength() {
        int biggestLength = 0;
        for (double[] row : matrix) {
            if (row.length > biggestLength) {
                biggestLength = row.length;
            }
        }
        return biggestLength;
    }

    /**
     * Settings new length to all matrix rows.
     * <p>
     * This method is setting new row length for each row.
     * <p>
     * FORBIDDEN to use outside of {@code transpose()} algorithm. This method is a part of it.
     *
     * @param newColumns - new rows length
     * @see Matrix#transpose()
     * @deprecated - part of only one algorithm
     */
    private void changeColumns(int newColumns) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.copyOf(matrix[row], newColumns);
        }
    }

    /**
     * Settings new amount of rows to the matrix.
     * <p>
     * This method is settings new amount of rows to the current matrix.
     * If new amount of rows is bigger, than old, all new rows will be initialized with 0 (default) elements.
     * Otherwise unnecessary rows will be deleted.
     * <p>
     * FORBIDDEN to use outside of {@code transpose()} algorithm. This method is a part of it.
     *
     * @param newRows - new amount of rows
     * @see Matrix#transpose()
     * @deprecated - part of only one algorithm
     */
    private void changeRows(int newRows) {
        int matrixOldSize = matrix.length;
        matrix = Arrays.copyOf(matrix, newRows);
        if (newRows > matrixOldSize) {
            for (int index = matrixOldSize; index < matrix.length; index++) {
                matrix[index] = new double[matrix[matrixOldSize - 1].length];
            }
        }

    }

    /**
     * Prints to console current matrix.
     */
    public void toConsole() {
        System.out.println("Matrix with " + countElements() + " elements:");
        for (int row = 0; row < matrix.length; row++) {
            for (int columns = 0; columns < matrix[row].length; columns++) {
                System.out.print(matrix[row][columns] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Is matrix square validation.
     * <p>
     * Returns true if current matrix is square. False otherwise.
     *
     * @return true if matrix is square, false otherwise
     */
    public boolean isSquare() {
        for (int index = 0; index < matrix.length; index++) {
            if (matrix.length != matrix[index].length) {
                return false;
            }
        }
        return true;
    }

    /**
     * Is matrix square validation.
     * <p>
     * This method is much faster than method isSquare(). But it does not check full array.
     * It checks only equality of amount of rows and length of first row.
     * Deprecated to use, if you are not sure, that your array can be only square or rectangular.
     *
     * @return true if matrix is square, false otherwise
     * @see Matrix#isSquare()
     */
    public boolean isSquareFast() {
        if (matrix.length == matrix[0].length) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns given matrix as string.
     * <p>
     * Returns string row, that contains matrix values.
     * Example of method output:
     * 1 2 3 4
     * 4 3 2 1
     * 5 6 7 8
     *
     * @param array - massive, that will be showed in String
     * @return String row, that looks like in example.
     */
    public String print(double[][] array) {
        String twoDimArray = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int columns = 0; columns < matrix[row].length; columns++) {
                twoDimArray += matrix[row][columns] + " ";
            }
            twoDimArray += "\n";
        }
        return twoDimArray;
    }

}
