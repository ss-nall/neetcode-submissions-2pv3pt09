class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        //Creating a matrix to pair the two different arrays of position and speed
        double[][] cars = new double[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        //Sort by position descending
        Arrays.sort(cars,(a,b) -> Double.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();

        for(int i=0;i<n;i++){
            double pos = cars[i][0];
            double spd = cars[i][1];

            double time = (target-pos)/spd;

            stack.push(time);
            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }

        }
        return stack.size();

    }
}
