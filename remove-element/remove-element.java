class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length,
            last = k - 1,
            back = last;
        
        for (int i = last; i >= 0; i--) {
            int current = nums[i];
            
            //System.out.println("k: " + k + "\ni: " + i + "\nback: " + back + "\nnums[i]: " + nums[i] + "\nnums[back]: " + nums[back]);
            
            if (current == val) {
                if (i < back) {
                    int temp = current;
                    nums[i] = nums[back];
                    nums[back] = temp;
                }
                
                back--;
                k--;
            }
        }
        
        return k;
    }
}