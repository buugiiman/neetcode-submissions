class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] pairs = new int[position.length][2];
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < pairs.length; i++) {
            double currentTime = (double) (target - pairs[i][0]) / pairs[i][1];

            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }

        return stack.size();
    }
}
