package Graphs.Hard.AccountsMerge;
// https://takeuforward.org/practice/dsa/accounts-merge?category=hard-problems-ii&source=strivers-a2z-dsa-sheet

import java.util.*;

// Time Complexity: O(N * alpha + N log N) using Disjoint Set
// Space Complexity: O(N) for Disjoint Set and email mappings
class Solution {
    public static List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        int n = accounts.size();
        DSU dsu = new DSU(n);

        Map<String, Integer> hashMap = new HashMap<>();// {ele -> index}

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (hashMap.containsKey(email)) {
                    dsu.unionBySize(i, hashMap.get(email));
                } else {
                    hashMap.put(email, i);
                }
            }
        }

        List<List<String>> mergedMails = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            mergedMails.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            int index = dsu.findUlParent(entry.getValue());

            mergedMails.get(index).add(entry.getKey());
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMails.get(i).size() == 0)
                continue;

            List<String> account = new ArrayList<>();

            account.add(accounts.get(i).get(0));

            Collections.sort(mergedMails.get(i));

            account.addAll(mergedMails.get(i));

            ans.add(account);

        }

        return ans;
    }
}

class DSU {
    int[] parent, size;

    public DSU(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUlParent(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = findUlParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUlParent(u);
        int ulp_v = findUlParent(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

public class AccountsMerge {
    public static void main(String[] args) {

    }
}
