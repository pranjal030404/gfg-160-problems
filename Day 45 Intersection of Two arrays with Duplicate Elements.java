// Given two integer arrays a[] and b[], you have to find the intersection of the two arrays. Intersection of two arrays is said to be elements that are common in both arrays. The intersection should not have duplicate elements and the result should contain items in any order.

// Note: The driver code will sort the resulting array in increasing order before printing.

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }
        for (int num : b) {
            if (setA.contains(num)) {
                result.add(num);
            }
        }
        return new ArrayList<>(result);
    }
}