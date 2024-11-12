/**
 * LeetCode 721 Accounts Merge (Medium)
 * ** use treeset for sort on insertion
 * via graph and dfs: (simple code)
 *  - go through each account and map the email to the corresponding account list index number
 *  - go through each account again and find all accounts and hence emails tied to the same person
 *  - dfs and track visited accounts
 * alt method: union find (emphasis on performance)
 * Graph + DFS TC: O(N Log N) sorting O(Log N) * worst case operations 
 *                 on total emails N incl dupes O(N)
 * Union Find TC: O(Log N)
 */

// 1st impl
// Union Find soln
class Solution {
    class UnionFind {
        int[] parent;
        int[] weight;
        
        public UnionFind(int num) {
            parent = new int[num];
            weight = new int[num];
            
            // initial assignment of parent and weight to each element
            for(int i =  0; i < num; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }
        
        public void union(int a, int  b) {
            int rootA = root(a);
            int rootB = root(b);
            
            if (rootA == rootB) {
                return;
            }
            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA;
                weight[rootA] += weight[rootB];
            } else {
                parent[rootA] = rootB;
                weight[rootB] += weight[rootA];
            }
        }
        
        public int root(int a) {
            if (parent[a] == a) {
                return a;
            }
            parent[a] = root(parent[a]);
            return parent[a];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();

        UnionFind uf = new UnionFind(size);

        // prepare a hash with unique email address as key and index in accouts as value
        HashMap<String, Integer> emailToId = new  HashMap<>();
        for(int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            for(int j = 1; j < details.size(); j++) {
                String email = details.get(j);
				// if we have already seen this email before, merge the account "i" with previous account
				// else add it to hash
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else  {
                    emailToId.put(email, i);
                }
            }
        }
        
        // prepare a hash with index in accounts as key and list of unique email
        // address for that account as value
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(String key : emailToId.keySet()) {
            int root = uf.root(emailToId.get(key));
            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<String>());
            }
            idToEmails.get(root).add(key);
        }
        
        // collect the emails from idToEmails, sort it and add account name at
        // index 0 to get the final list to add to final return List
        List<List<String>> mergedDetails =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails =  idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            mergedDetails.add(emails);
        }
        return  mergedDetails;
    }
}

// 3rd impl
// Graph + DFS soln
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
