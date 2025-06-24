// Given an array of points where each point is represented as points[i] = [xi,
// yi] on the X-Y plane and an integer k, return the k closest points to the
// origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidean distance,
// defined as:

// sqrt( (x2 - x1)2 + (y2 - y1)2 )

// Note: You can return the k closest points in any order, driver code will sort
// them before printing.

class Solution {
  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
        (a, b) -> Integer.compare(distance(b), distance(a)));

    for (int[] point : points) {
      maxHeap.offer(point);
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }

    int[][] result = new int[k][2];
    for (int i = 0; i < k; i++) {
      result[i] = maxHeap.poll();
    }
    return result;
  }

  private int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }
}
