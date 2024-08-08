/**
 * LeetCode 438 Find All Anagrams in a String (Medium)
 * answer derived from 242 Valid Anagrams and added sliding window logic
 * TC: O(N), SC: O(1)
 */

class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> ans = new ArrayList<>();
			int[] freqS = new int[26];
			int[] freqP = new int[26];
			int sLen = s.length(), pLen = p.length();
			if(pLen>sLen) return ans;
            // looping through length equivalent of String p, calc freq of letters 
			for(int i=0;i<pLen;i++)
			{
				freqS[s.charAt(i)-'a']++;
				freqP[p.charAt(i)-'a']++;
			}
            // loop through start index to last possible position of anagram in s
			for(int i=0;i<=sLen-pLen;i++)
			{
				boolean flag = true;
                // check freq of each letter
				for(int j=0;j<26;j++)
				{
                    // non-equivalent freq of letter indicates non anagram, breaks letter loop
					if(freqS[j]!=freqP[j])
					{
						flag = false;
						break;
					}
				}
                // add start index for valid anagram
				if(flag==true) ans.add(i);
                // remove freq added for char at start index
				freqS[s.charAt(i)-'a']--;
                // if next increment by pLen doesnt exceed sLen,
                // add new end of possible anagram to freq arr
				if(i+pLen < sLen) freqS[s.charAt(i+pLen)-'a']++;
			}
			return ans;
		}
	}
