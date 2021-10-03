package Studies;

public class Main {

    public static void main(String[] args) {
        Matrix mainMatrix = new Matrix(5,6);
        System.out.println(mainMatrix.getOrderParams().orderType);
        mainMatrix.print();

        Matrix[] matrices = mainMatrix.findIncludedMatrices(3);

        for (Matrix matrix: matrices){
            System.out.println(matrix.getOrderParams().orderType);
            matrix.printSpiral(true);
            matrix.print();
        };

        int[] numbers = new CustomString("46 75 89 90").getAllNumbers();

        for (int number: numbers){
            if (number%5==0){
                System.out.println(number);
            }
        }
    }
}