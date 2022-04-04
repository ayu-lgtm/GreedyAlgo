
import java.util.Collections;
import java.util.PriorityQueue;

class Coins_Problem {
    public static void main(String args[]) {
        Integer arr[] = { 10, 5, 2, 1 };
        int Amount = 57;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer x : arr) {
            pq.add(x);
        }

        int res = 0;
        while (pq.isEmpty() == false) {
            int n = pq.poll();
            if (n <= Amount) {
                int c = Amount / n;
                res += c;
                Amount -= c * n;
            }
            if (Amount == 0) {
                break;
            }
        }
        System.out.print(res);
    }
}