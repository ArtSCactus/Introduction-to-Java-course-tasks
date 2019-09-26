package com.completedtasks.unit3;

/** Task condition:
 * Задана матрица размера N x M. Необходимо выполнить следующие действия:
 * - найти экстремальные значения (минимальный и максимальный элементы) данной матрицы;
 * - найти среднеарифметическое и среднегеометрическое значения всех элементов матрицы;
 * - найти позицию первого встретившегося локального минимума (максимума), а если таких элементов нет, то возвратить -1 (локальный минимум
 * – это элемент, который меньше любого из своих соседей; локальный максимум – это элемент, который больше любого из своих соседей);
 * - транспонировать матрицу (при решении данного задания не рекомендуется задействовать дополнительную память).
 *
 * This class in aimed to work with integer matrix. Each matrix is class object.
 *
 * @author ArtSCactus
 * @version 0.1
 */
public class Matrix{

    /**Main matrix storage*/
    int[][] matrix;

    Matrix(){
        matrix=new int[0][];
    }

    Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
    }

    /**Generates matrix from random number.
     *
     * @param min - minimal value
     * @param max - maximal value
     */
    public void generate(int min, int max) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                matrix[rowIndex][columnIndex] = (int) (Math.random() * max) + min;
            }
        }
    }

    /**Returns the biggest element in matrix.
     *
     * @return (int) biggest element
     */
    public int biggestElement() {
        int biggestElement = matrix[0][0];
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                if (biggestElement < matrix[rowIndex][columnIndex]) {
                    biggestElement = matrix[rowIndex][columnIndex];
                }
            }
        }
        return biggestElement;
    }

    /**Returns the least element in matrix.
     *
     * @return (int) least element
     */
    public int leastElement() {
        int leastElement = matrix[0][0];

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                if (leastElement > matrix[rowIndex][columnIndex]) {
                    leastElement = matrix[rowIndex][columnIndex];
                }
            }
        }

        return leastElement;
    }

    /**Returns geometric average for matrix.
     *
     * @return (double) deometric average
     */
    public double geometricAverage() {
        double product = 1;

        for (int[] row : matrix) {
            for (int element : row) {
                product *= element;
            }
        }

        return Math.pow(product, (double) 1/matrix.length);
    }

    /**Returns arithmeticAverage for matrix.
     *
     * @return (double) arithmetic average
     */
    public double arithmeticAverage(){
        double sum=0;

        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }

        return sum/matrix.length;
    }

    /*
        I just did not have time to finish this methods.

    Planned:
    -safety methods to find next and previous number in matrix (neighbors)
    -matrix transpose
    * */

    /*
    private int next(int rowIndex, int columnIndex){
        if (indexOfCurrentNumber+1>matrix[rowIndex].length){
        return matrix[rowIndex][columnIndex];
        } else return matrix[rowIndex][columnIndex+1];
    }

    public int localMin(){

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                if (matrix[rowIndex][columnIndex] < matrix[rowIndex][columnIndex+1] &
                        matrix[rowIndex][columnIndex] < matrix[rowIndex][columnIndex-1] ) {
                }
            }
        }

    }*/

}
