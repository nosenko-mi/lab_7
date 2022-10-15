package com.example;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
    private Double[][] matrix;

    public Matrix(){}

    public Matrix(Double[][] matrix) {
        this.matrix = matrix;
    }

    public double getGeometricMean(){
        double root = 0;
        double result = -1;
        double product = 1;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] > 0){
                    product *= matrix[i][j];
                    root++;
                }
            }
        }
        if (root > 1){
            result = Math.pow(product, 1/root);
        }
        return result;
    }

    public void generateMatrix(int m, int n, int min, int max){
        Double[][] newMatrix = new Double[m][n];
        Random random = new Random();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                newMatrix[i][j] = (double) (random.nextInt(max - min) + min);
            }
        }

        this.matrix = newMatrix;
    }

    public Double[] getSumAndAmount(Double left, Double right){
        Double sum = 0., amount = 0.;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] >= left && matrix[i][j] <= right){
                    sum += matrix[i][j];
                    amount++;
                }
            }
        }
        return new Double[]{sum, amount};
    }

    public Double getRowSum(int row){
        Double sum = 0.;
        if (row >= matrix[0].length){
            return null;
        }
        for (Double[] doubles : matrix) {
            sum += doubles[row];
        }
        return sum;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix).replace("], ", "]\n");
    }
}
