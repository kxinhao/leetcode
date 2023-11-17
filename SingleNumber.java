class Solution {
    //summation of unique elements * 2 - array sum
    /*
    public int singleNumber(int[] nums) {

        int sum1 = 0;
        int arraySum = 0;
        Set<Integer> hashset = new HashSet<Integer>(); 

        for(int i : nums) {
            arraySum += i;
            hashset.add(i);
        }

        Iterator<Integer> iter = hashset.iterator();

        while(iter.hasNext()) {
            sum1 += iter.next();
        }
        
        return sum1*2-arraySum;
    }
    */
    //bit manipulation with XOR: 2 identical values cancel each other in XOR
    public int singleNumber(int[] nums) {
       
        int single = 0;

        for(int i : nums) {
            single ^= i;
        }
        
        return single;
    }
}
