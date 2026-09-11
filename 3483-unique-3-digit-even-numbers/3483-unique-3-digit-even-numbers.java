class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> numbers = new HashSet<>();
        for (int first = 0; first < digits.length; first++) {
            if (digits[first] == 0)
                continue;
            for (int second = 0; second < digits.length; second++) {
                if (second == first)
                    continue;
                for (int third = 0; third < digits.length; third++) {
                    if (third == first || third == second)
                        continue;
                    if (digits[third] % 2 != 0)
                        continue;
                    int number = digits[first] * 100 + digits[second] * 10 + digits[third];
                    numbers.add(number);
                }
            }
        }
        return numbers.size();
    }
}