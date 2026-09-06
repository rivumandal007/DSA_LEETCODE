class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] arr = new int [n+m];
        int i = 0, j = 0;
        int k = 0;
        while(i < n && j < m){
            if(nums1[i] >= nums2[j]){
                arr[k] = nums2[j];
                j++;
            }else{
                arr[k] = nums1[i];
                i++;
            }
            k++;
        }
        for(int p = i; p < n; p++){
            arr[k] = nums1[p];
            k++;
        }
        for(int p = j; p < m; p++){
            arr[k] = nums2[p];
            k++;
        }
         
        if((n+m) % 2 == 0){
            int no1 = arr[(n+m)/2];
            int no2 = arr[(n+m)/2 - 1];
           
            return ((double) no1 + (double) no2) / 2.00;
        }

        return arr[(n+m) / 2 ];
    }
}