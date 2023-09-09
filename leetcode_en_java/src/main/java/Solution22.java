import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution22 {

    /*
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



        Example 1:

        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]
        Example 2:

        Input: n = 1
        Output: ["()"]


        Constraints:

        1 <= n <= 8
     */



    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        insertBracket(result, "", 0, n, n, 0);

        return result;
    }

    public void insertBracket(List<String> result, String currentResult, int leftInStack, int leftCount, int rightCount, int action) {
        // action = 0, insert left bracket
        // action = 1, insert right bracket

        if (action == 0) {
            leftCount--;
            leftInStack++;
            currentResult += "(";
            if (leftCount > 0) {
                insertBracket(result, currentResult, leftInStack, leftCount, rightCount, 0);
            }
            insertBracket(result, currentResult, leftInStack, leftCount, rightCount, 1);
        } else {
            rightCount--;
            currentResult += ")";
            leftInStack--;
            if (leftCount == 0 && rightCount == 0) {
                result.add(currentResult);
                return;
            }
            if (leftInStack > 0) {
                insertBracket(result, currentResult, leftInStack, leftCount, rightCount, 1);
            }

            if (leftCount > 0) {
                insertBracket(result, currentResult, leftInStack, leftCount, rightCount, 0);
            }
        }
    }

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        System.out.println(solution.generateParenthesis(3));
    }

}
