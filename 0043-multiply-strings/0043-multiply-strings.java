class Solution {
    public String multiply(String num1, String num2) {
        // Base case: if either number is "0", the product is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n1 = num1.length();
        int n2 = num2.length();
        // The product of two numbers of length n1 and n2 can have at most n1 + n2 digits
        int[] pos = new int[n1 + n2];

        // Multiply each digit and store in the result array
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;     // Tens place for this partial product
                int p2 = i + j + 1; // Ones place for this partial product
                
                int sum = mul + pos[p2];
                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }

        // Convert the array to a String, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
