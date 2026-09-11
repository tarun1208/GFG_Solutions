class Solution {
    public int sameMod(int[] arr) {
        int n = arr.length;

        boolean allEqual = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[0]) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) return -1;

        int g = 0;
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - arr[0]);
            if (diff > 0) {
                g = gcd(g, diff);
            }
        }

        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                if (i * i == g) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}