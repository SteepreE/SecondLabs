package Studies;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private OrderParams orderParams;

    private final int rowsCount;
    private final int colsCount;

    private boolean isTempMatrix = false;

    private final int[][] matrix;

    public Matrix(int size){
        this.rowsCount = size;
        this.colsCount = size;

        this.matrix = new int[rowsCount][colsCount];
        fillRand();

        orderParams = new OrderParams(matrix);
    }

    public Matrix(int rows, int cols){
        this.rowsCount = rows;
        this.colsCount = cols;

        this.matrix = new int[rowsCount][colsCount];
        fillRand();

        orderParams = new OrderParams(matrix);
    }

    public Matrix(int[][] matrix){
        this.rowsCount = matrix.length;
        this.colsCount = matrix[0].length;

        this.matrix = matrix;

        orderParams = new OrderParams(matrix);
    }

    public Matrix(int[][] matrix, boolean isTempMatrix){
        this.rowsCount = matrix.length;
        this.colsCount = matrix[0].length;

        this.isTempMatrix = isTempMatrix;

        this.matrix = matrix;
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

    public void printSpiral(boolean isFromStart){
        Matrix tempMatrix;

        if (isFromStart) {
            tempMatrix = this;
        } else {
            tempMatrix = getReversedMatrix();
        }

        while(tempMatrix.matrix.length != 1){
            for (int col = 0; col < tempMatrix.colsCount; col++){
                System.out.print(tempMatrix.matrix[0][col] + " ");
            }
            tempMatrix = transform(tempMatrix);
        }
        System.out.println(tempMatrix.matrix[0][0]);
    }

    private Matrix transform(Matrix matrix){
        int[][] tempMatrix = new int[matrix.rowsCount-1][matrix.colsCount];

        for (int row = 0; row < matrix.rowsCount-1; row++){
            for (int col = 0; col < matrix.colsCount; col++){
                tempMatrix[row][col] = matrix.matrix[row + 1][matrix.colsCount - col - 1];
            }
        }

        return new Matrix(tempMatrix, true).getTransposedMatrix();
    }

    public Matrix getTransposedMatrix(){
        int[][] tMatrix = new int[colsCount][rowsCount];

        for (int row = 0; row < colsCount; row++){
            for (int col = 0; col < rowsCount; col++){
                tMatrix[row][col] = matrix[col][row];
            }
        }

        return (isTempMatrix) ? new Matrix(tMatrix, true) : new Matrix(tMatrix);
    }

    public Matrix getReversedMatrix(){
        int[][] reversedMatrix = new int[rowsCount][colsCount];

        for (int row = 0; row < rowsCount; row++){
            for (int col = 0; col < colsCount; col++){
                reversedMatrix[row][col] = matrix[rowsCount - row - 1][colsCount - col - 1];
            }
        }

        return (isTempMatrix) ? new Matrix(reversedMatrix, true) : new Matrix(reversedMatrix);
    }

    public Matrix[] findIncludedMatrices(int size){
        int matrixCounter = (rowsCount - size + 1)*(colsCount - size + 1);
        Matrix[] matrices = new Matrix[matrixCounter];

        matrixCounter = 0;
        for (int row = 0; row < rowsCount - size + 1; row++){
            for (int col = 0; col < colsCount - size +1; col++){
                matrices[matrixCounter++] = findMatrix(size, row, col);
            }
        }

        return matrices;
    }

    private Matrix findMatrix(int size, int currentRow, int currentCol){
        int[][] tempMatrix = new int[size][size];

        for (int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                tempMatrix[row][col] = this.matrix[currentRow + row][currentCol + col];
            }
        }

        return new Matrix(tempMatrix);
    }

    public OrderParams getOrderParams(){
        return orderParams;
    }
}