class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 0;
        int left = 0;
        int right = plants.length - 1;
        
        int waterA = capacityA;
        int waterB = capacityB;

        while (left < right) {
            if (waterA < plants[left]) {
                count++;
                waterA = capacityA; 
            }
            waterA -= plants[left];
            left++;
            
            if (waterB < plants[right]) {
                count++;
                waterB = capacityB; 
            }
            waterB -= plants[right];
            right--;
        }

        if (left == right) {
            int maxWater = Math.max(waterA, waterB);
            if (maxWater < plants[left]) {
                count++;
            }
        }
        
        return count;
    }
}
