import java.util.ArrayList;
import java.util.List;

public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = null;

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }

                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            prevRow = row;
        }

        return prevRow;
    }

    public static void main(String[] args) {
        Solution119 solution119 = new Solution119();
        System.out.println(solution119.getRow(1));
    }

}
