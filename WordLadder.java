/**
 * LeetCode 127 Word Ladder (Hard)
 * Double ended BFS
 * cost of exploring each layer increases exponentially, so 2 half depth BFS is superior
 * to a single full depth BFS
 * TC: O(b^(d/2) + b^(d/2)) vs O(b^d) when doing single full length BFS
 * SC: O()
 * /

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> dict = new HashSet<>(wordList), startSet = new HashSet<>(),
                    endSet = new HashSet<>(), visited = new HashSet<>();
        // init sets with start word and end word, initial addition of start word counts as 1
        // transformation so len starts at 1
        startSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        
        // while values present in either start or end Set, 
        while(!startSet.isEmpty() && !endSet.isEmpty()) {
            // swap if startSet is larger then endSet so we will always be working with smaller set
            // so that the number of words to go through is minimized
            if(startSet.size()>endSet.size()) {
                Set<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            // tmpSet to store valid target words formed and to replace in startSet
            Set<String> tmpSet = new HashSet<>();
            // go through each word in dict(wordList) and 
            // find valid words that are 1 char distance away from the
            // start word taken from startSet and keep track of visited words in dict
            for(String word : startSet) {
                char[] wordArr = word.toCharArray();
                for(int i = 0; i<wordArr.length; i++) {
                    // to swap the char in word under consideration
                    char tmpChar = wordArr[i];
                    for(char c = 'a'; c<='z'; c++) {
                        
                        // swap in new char and form the String
                        wordArr[i] = c;
                        String target = new String(wordArr);
                        // once endSet has the target word formed in this iteration of change,
                        // we can return the number of changes needed + this round of iteration
                        if(endSet.contains(target)) return len+1;
                        // validity testing of the word formed before accepting addition
                        // to transformed list
                        if(dict.contains(target)) {
                            tmpSet.add(target);
                            dict.remove(target);
                        }
                   
                    }
                    // swap back the original char
                    wordArr[i] = tmpChar;
                }
            }
            startSet = tmpSet;
            // increment len to account for current iteration of transformations
            len++;
        }
        return 0;
    }
}
