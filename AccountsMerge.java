/**
 * LeetCode 721 Accounts Merge (Medium)
 * go through each account and map the email to the corresponding account list index number
 * go through each account again and find all accounts and hence emails tied to the same person
 * via dfs and tracking visited accounts
 * alt method: union find
 * TC: O(N Log N) sorting O(Log N) * worst case operations on total emails N incl dupes O(N)
 */
// 3rd impl

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> accountMap = new HashMap<String, List<Integer>>();
        List<List<String>> ans = new LinkedList<>();
        boolean[] visited = new boolean[accounts.size()];
        // map accounts tied to each email by index id
        // eg. 'johnsmith@mail.com' : [0,1]
        for(int i=0; i<accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            for(int j = 1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if(!accountMap.containsKey(email)) {
                    accountMap.put(email, new ArrayList<>());
                }
                accountMap.get(email).add(i);
            }
        }
        // go through each account to find common emails and add to ans list
        for(int i=0; i<accounts.size(); i++) {
            // TreeSet for auto sort on insert
            Set<String> set = new TreeSet<>();
            dfs(i, accounts, accountMap, visited, set);
            if(!set.isEmpty()) {
                // convert treeset to linkedlist
                List<String> ll = new LinkedList<String>(set);
                ll.add(0, accounts.get(i).get(0));
                ans.add(ll);
            }
        }
        return ans;
    }

    private void dfs(int curr, List<List<String>> accounts, Map<String, List<Integer>> accountMap, 
                    boolean[] visited, Set<String> set) {
                        if(visited[curr]) return;
                        visited[curr] = true;
                        for(int i=1; i<accounts.get(curr).size(); i++) {
                            String email = accounts.get(curr).get(i);
                            set.add(email);
                            for(int ind : accountMap.get(email)) {
                                dfs(ind, accounts, accountMap, visited, set);
                            }
                        }
                    }
}
