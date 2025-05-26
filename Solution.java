/*
 * GFG: https://www.geeksforgeeks.org/problems/maximum-sum-combination/0
 */
import java.util.*;


class Solution {
    static class Sum {
        int sum;
        int i;
        int j;

        Sum(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Sum sum1 = (Sum) o;
            return i == sum1.i && j == sum1.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    static List<Integer> maxCombinations(int N, int K, int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        List<Integer> result = new ArrayList<>();
        Set<Sum> visited = new HashSet<>();

        PriorityQueue<Sum> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.sum, a.sum));

        Sum initialSumObj = new Sum(A[N - 1] + B[N - 1], N - 1, N - 1);
        maxHeap.offer(initialSumObj);
        visited.add(initialSumObj);

        while (K > 0 && !maxHeap.isEmpty()) {
            Sum currentSum = maxHeap.poll();
            result.add(currentSum.sum);
            K--;

            int i = currentSum.i;
            int j = currentSum.j;

            if (i - 1 >= 0) {
                Sum nextSumA = new Sum(A[i - 1] + B[j], i - 1, j);
                if (!visited.contains(nextSumA)) {
                    maxHeap.offer(nextSumA);
                    visited.add(nextSumA);
                }
            }

            if (j - 1 >= 0) {
                Sum nextSumB = new Sum(A[i] + B[j - 1], i, j - 1);
                if (!visited.contains(nextSumB)) {
                    maxHeap.offer(nextSumB);
                    visited.add(nextSumB);
                }
            }
        }

        return result;
    }


}
