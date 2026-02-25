package Stacks_and_Queues.Medium.CelebrityProblem;
// https://takeuforward.org/practice/dsa/celebrity-problem?category=faqs&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N) using two pointers or elimination
// Space Complexity: O(1)
class Solution {
    public int celebrity(int[][] M) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < M.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int p1 = st.pop();
            int p2 = st.pop();

            if (M[p1][p2] == 1) {
                st.push(p2);
            } else {
                st.push(p1);
            }
        }

        int celebrityPerson = st.pop();

        for (int i = 0; i < M.length; i++) {
            if (i == celebrityPerson) {
                continue;
            }

            if (M[i][celebrityPerson] == 0 || M[celebrityPerson][i] == 1) {
                return -1;
            }
        }

        return celebrityPerson;
    }
}

public class CelebrityProblem {
    public static void main(String[] args) {

    }
}
