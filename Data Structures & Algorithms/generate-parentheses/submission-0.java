class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(sb, n, n, result);

        return result;
    }

    private void backtrack(StringBuilder sb,
                           int open,
                           int close,
                           List<String> result) {

        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        // Add '('
        if (open > 0) {
            sb.append('(');
            backtrack(sb, open - 1, close, result);
            sb.deleteCharAt(sb.length() - 1);   // Backtrack
        }

        // Add ')'
        if (open < close) {
            sb.append(')');
            backtrack(sb, open, close - 1, result);
            sb.deleteCharAt(sb.length() - 1);   // Backtrack
        }
    }
}