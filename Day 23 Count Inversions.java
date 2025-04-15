// Given an array of integers arr[]. Find the Inversion Count in the array.
// Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum.

class Solution
{
    // Function to count inversions in the array.
    static int inversionCount(int arr[])
    {
        // Your Code Here
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int arr[], int left, int right)
    {
        int count = 0;
        if (left < right)
        {
            int mid = (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    static int merge(int arr[], int left, int mid, int right)
    {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left, swaps = 0;

        while (i < n1 && j < n2)
        {
            if (leftArr[i] <= rightArr[j])
            {
                arr[k++] = leftArr[i++];
            }
            else
            {
                arr[k++] = rightArr[j++];
                swaps += (n1 - i); // Count inversions
            }
        }

        while (i < n1)
            arr[k++] = leftArr[i++];
        while (j < n2)
            arr[k++] = rightArr[j++];

        return swaps;
    }
}