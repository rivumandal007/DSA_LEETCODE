class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        if(nums.length == 1){
            return Math.abs(nums[0] - k);
        }

        
        int n = nums.length;
        Arrays.sort(nums);

        
        long ans = 0;
        if(n % 2 != 0){
            int mid = n / 2;
            int prev = mid-1;
            int next = mid + 1;
            int count = 1;
            while(nums[mid] != k){
                if(nums[mid] > k){
                    int gap = Math.abs(k - nums[mid]);                  
                    int eleGap = nums[mid] - nums[prev];
                    if(eleGap == 0){
                        prev--;
                        count++;
                    }
                    if(prev < 0){
                        ans += count * gap;
                        break;
                    }
                    nums[mid] = gap > eleGap ? nums[mid] - eleGap : nums[mid] - gap;
                    ans += gap > eleGap ? count * eleGap : count * gap;
                }
                if(nums[mid] < k){
                    int gap = Math.abs(k - nums[mid]);                  
                    int eleGap = Math.abs(nums[next] - nums[mid]);
                    if(eleGap == 0){
                        next++;
                        count++;
                    }
                    if(next > n-1){
                        ans += count * gap;
                        break;
                    }
                    nums[mid] = gap > eleGap ? nums[mid] + eleGap : nums[mid] + gap;
                    ans += gap > eleGap ? count * eleGap : count * gap;
                }
            }

        }else {
            int mid = n / 2;
            int prev = mid - 1;
            int next = mid + 1;
            int count = 1;

            while (nums[mid] != k) {

                if (nums[mid] > k) {
                    int gap = nums[mid] - k;

                    if (prev < 0) {
                        ans += (long) count * gap;
                        break;
                    }

                    int eleGap = nums[mid] - nums[prev];

                    if (eleGap == 0) {
                        prev--;
                        count++;
                        continue;
                    }

                    if (gap > eleGap) {
                        nums[mid] -= eleGap;
                        ans += (long) count * eleGap;
                    } else {
                        nums[mid] = k;
                        ans += (long) count * gap;
                    }
                }

                if (nums[mid] < k) {
                    int gap = k - nums[mid];

           
                    if (next >= n) {
                        ans += (long) count * gap;
                        break;
                    }   

                    int eleGap = nums[next] - nums[mid];

                    if (eleGap == 0) {
                        next++;
                        count++;
                        continue;
                    }

                    if (gap > eleGap) {
                        nums[mid] += eleGap;
                        ans += (long) count * eleGap;
                    } else {
                        nums[mid] = k;
                        ans += (long) count * gap;
                    }
                }
            }
        }
        return ans;

        
    }
}