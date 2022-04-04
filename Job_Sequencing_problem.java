
// { Driver Code Starts
import java.io.*;

import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class Job_Sequencing_problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            // adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]),
                        Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            // function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends

class Mycmp implements Comparator<Job> {
    public int compare(Job a, Job b) {
        return b.profit - a.profit;
    }
}

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Your code here

        int main[] = new int[2];
        Arrays.sort(arr, new Mycmp());

        int max_deadline = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (max_deadline < arr[i].deadline) {
                max_deadline = arr[i].deadline;
            }
        }

        int res[] = new int[max_deadline];

        for (int i = 0; i < n; i++) {
            if (res[arr[i].deadline - 1] == 0) {
                res[arr[i].deadline - 1] = arr[i].profit;
            } else {
                for (int j = arr[i].deadline - 1; j >= 0; j--) {
                    if (res[j] == 0) {
                        res[j] = arr[i].profit;
                        break;
                    }
                }
            }
        }

        int sum = 0, count = 0;
        for (int x : res) {
            if (x != 0) {
                sum += x;
                count++;
            }
        }

        main[0] = count;
        main[1] = sum;

        return main;

    }
}
