import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Integer> min = new ArrayList<>();
        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            if(min.isEmpty() || nums[i] < nums[min.get(min.size() - 1)] ) {
                min.add(i);
            }
            
            res = Math.max(res, i - bs(nums, i, min));
        }
        return res;
    }
    int bs(int[] nums, int i, List<Integer> min) {
        int target = nums[i];
        int l = 0;
        int r = min.size();
        int mid;
        int res = Integer.MAX_VALUE / 2;
        while(l <= r) {
            mid = l + (r - l) / 2;
            if(nums[min.get(mid)] <= target) {
                res = min.get(mid);
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        

        return res;
    }
}