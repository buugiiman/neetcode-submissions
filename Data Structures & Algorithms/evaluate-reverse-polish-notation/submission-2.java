class Solution {
    public int evalRPN(String[] tokens) {

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch(tokens[i]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return result;
        
    }
}
