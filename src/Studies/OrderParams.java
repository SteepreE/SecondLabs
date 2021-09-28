package Studies;

public class OrderParams {
    public boolean isOrderly;
    public String orderType;

    public OrderParams(int[][] matrix){
        checkOrderParams(matrix);
    }

    private void checkOrderParams(int[][] matrix){
        boolean nextIsMore;
        int i=1;

        while (matrix[i-1][i-1]==matrix[i][i]){
            i++;
            if (i==matrix.length){
                isOrderly = true;
                orderType = "Все элементы равны";
                return;
            }
        }

        nextIsMore = (matrix[i-1][i-1]<matrix[i][i]);

        while (i < matrix.length){
            if (    (matrix[i - 1][i - 1] > matrix[i][i] && nextIsMore) ||
                    (matrix[i - 1][i - 1] < matrix[i][i] && !nextIsMore)){
                isOrderly = false;
                orderType = "Не упорядочна";
                return;
            }
            i++;
        }

        String orderedBy = (nextIsMore) ? "по возрастанию" : "по убыванию";
        isOrderly = true;
        orderType = "Упорядочна " + orderedBy;
    }
}
