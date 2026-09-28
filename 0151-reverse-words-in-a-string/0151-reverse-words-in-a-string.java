class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) {
                break;
            }

            // Find the beginning of the word
            int end = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Add a space between words
            if (result.length() > 0) {
                result.append(' ');
            }

            // Append the word
            result.append(s, i + 1, end + 1);
        }

        return result.toString();
    }
}