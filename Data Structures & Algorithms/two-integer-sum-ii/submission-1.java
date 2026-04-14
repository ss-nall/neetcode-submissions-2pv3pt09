class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int first = 0;
        int last = numbers.length-1;
        while (first < last) {
            if (numbers[first] + numbers[last] == target) {
                return new int[] {first+1, last+1};
            } else if (numbers[first] + numbers[last] > target) {
                last -= 1;
            } else if (numbers[first] + numbers[last] < target) {
                first += 1;
            }
        }
        return numbers;
    }
}
