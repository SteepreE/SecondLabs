package Studies;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private OrderParams orderParams;

    private final int rowsCount;
    private final int colsCount;

    private final int[][] matrix;

    public Matrix(int size){
        this.rowsCount = size;
        this.colsCount = size;

        this.matrix = new int[rowsCount][colsCount];
        fillRand();

        orderParams = new OrderParams(this.matrix);
    }

    public Matrix(int rows, int cols){
        this.rowsCount = rows;
        this.colsCount = cols;

        this.matrix = new int[rowsCount][colsCount];
        fillRand();

        orderParams = new OrderParams(this.matrix);
    }

    public Matrix(int[][] matrix){
        this.rowsCount = matrix.length;
        this.colsCount = matrix[0].length;

        this.matrix = matrix;

        orderParams = new OrderParams(this.matrix);
    }

    public void fill(){
        Scanner s = new Scanner(System.in);

        for (int row = 0; row < rowsCount; row++){
            for (int col = 0; col < colsCount; col++){
                System.out.println("Enter [" + row + "][" + col + "] element:");
                matrix[row][col] = s.nextInt();
            }
        }

        orderParams = new OrderParams(this.matrix);
    }

    private void fillRand(){
        Random r = new Random();

        for (int row = 0; row < rowsCount; row++){
            for (int col = 0; col < colsCount; col++){
                matrix[row][col] = 10 + r.nextInt(41);
            }
        }
    }

    public void print(){
        for (int row = 0; row < rowsCount; row++){
            for (int col = 0; col < colsCount; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getTransposedMatrix(){
        int[][] tMatrix = matrix;

        for (int row = 0; row < rowsCount; row++){
            for (int col = 0; col < colsCount; col++){
                tMatrix[row][col] = tMatrix[col][row];
            }
        }

        return tMatrix;
    }

    public Matrix[] findIncludedMatrices(int size){
        int matrixCounter = (rowsCount - size + 1)*(colsCount - size + 1);
        Matrix[] matrices = new Matrix[matrixCounter];

        matrixCounter = 0;
        for (int row = 0; row <rowsCount - size + 1; row++){
            for (int col = 0; col <colsCount - size +1; col++){
                matrices[matrixCounter++] = findMatrix(size, row, col);
            }
        }

        return matrices;
    }

    private Matrix findMatrix(int size, int row, int col){
        int[][] tempMatrix = new int[size][size];

        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                tempMatrix[i][j] = this.matrix[row + i][col + j];
            }
        }

        return new Matrix(tempMatrix);
    }

    public OrderParams getOrderParams() {
        return orderParams;
    }
}

