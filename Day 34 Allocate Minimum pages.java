//You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

//Each student receives atleast one book.
//Each student is assigned a contiguous sequence of books.
//No book is assigned to more than one student.
//The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

class Solution {
    public static boolean isPossible(int[] arr, int k, int maxPages) {
        int studentsRequired = 1;
        int currentPages = 0;

        for (int pages : arr) {
            if (pages > maxPages) {
                return false;
            }

            if (currentPages + pages > maxPages) {
                studentsRequired++;
                currentPages = pages;
                if (studentsRequired > k) {
                    return false;
                }
            } else {
                currentPages += pages;
            }
        }

        return true;
    }

    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
}
