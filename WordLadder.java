/*
 * LeetCode 127 Word Ladder (Hard)
 * Double ended BFS (forward and reverse search, ends when both ends meet)
 * cost of exploring each layer increases exponentially, so 2 half depth BFS is superior
 * to a single full depth BFS
 * TC: O(M^(N/2) + M^(N/2)) 
 * vs O(M^N) when doing single full length BFS
 * M=length of word, N=wordList.size()
 * simplified O(M^(N/2))
 * SC: O(N)
 * /
// 3rd impl

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        // HashSet operations take O(1) due to hashing
        Set<String> dict = new HashSet<>(wordList), startSet = new HashSet<>(),
                    endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        // init sets with start word and end word, initial addition of start word counts as 1
        // transformation so len starts at 1
        int len = 1;
        
        // while values present in either start Set, 
        while(!startSet.isEmpty()) {
            // swap if startSet is larger then endSet so we will always be working with smaller set
            // so that the number of words to go through is minimized
            // basically a reversal of search direction from the other point
            if(startSet.size()>endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            // tmpSet to store valid target words formed and to replace in startSet
            Set<String> tmpSet = new HashSet<>();
            // go through each word in startSet(aka transformation list) and 
            // find valid words that are 1 char distance away from the
            for(String word : startSet) {
                char[] wordArr = word.toCharArray(); // O(N) where N=word.length()
                for(int i = 0; i<wordArr.length; i++) {
                    // to swap the char in word under consideration
                    char tmpChar = wordArr[i];
                    for(char c = 'a'; c<='z'; c++) {
                        // swap in new char and form the String
                        wordArr[i] = c;
                        String target = new String(wordArr); // O(N) where N=wordArr.length
                        // once endSet has the target word formed in this iteration of change,
                        // we can return the number of changes needed + this round of iteration
                        if(endSet.contains(target)) return len+1;
                        // validity testing of the word formed before accepting addition
                        if(dict.contains(target)) {
                            tmpSet.add(target);
                            dict.remove(target);
                        }
                   
                    }
                    // swap back the original char
                    wordArr[i] = tmpChar;
                }
            }
            // startSet is replaced with set of valid words found after current startSet is gone tru
            startSet = tmpSet;
            // increment len to account for current iteration of transformations
            len++;
        }
        // rmb to return 0 if endWord can not be reached
        return 0;
    }
}
