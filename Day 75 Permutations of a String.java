// Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.





class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);  // Sort to handle duplicates
        backtrack(new StringBuilder(), chars, used, result, new HashSet<>());
        return result;
    }

    private void backtrack(StringBuilder current, char[] chars, boolean[] used, ArrayList<String> result, Set<String> seen) {
        if (current.length() == chars.length) {
            String perm = current.toString();
            if (!seen.contains(perm)) {
                result.add(perm);
                seen.add(perm);
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.append(chars[i]);

            backtrack(current, chars, used, result, seen);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
