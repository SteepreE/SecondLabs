package Studies;

public class Main {

    public static void main(String[] args) {
        Matrix mainMatrix = new Matrix(5,6);
        mainMatrix.print();

        Matrix[] matrices = mainMatrix.findIncludedMatrices(3);

        for (Matrix matrix: matrices){
            matrix.print();
        };
    }
}
