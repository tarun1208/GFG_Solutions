class Solution {
    public int solve(int n, String s) {
        Set<Character> occupied = new HashSet<>();
        Set<Character> turnedAway = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (turnedAway.contains(ch)) {
                continue;
            }

            if (occupied.contains(ch)) {
                occupied.remove(ch);
            } else {
                if (occupied.size() < n) {
                    occupied.add(ch);
                } else {
                    turnedAway.add(ch);
                }
            }
        }

        return turnedAway.size();
    }
}