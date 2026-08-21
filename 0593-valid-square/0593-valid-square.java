class Solution {
    public static double distrance(int[] d1, int [] d2){
        
        double squareRoot = Math.sqrt(((d2[0] - d1[0]) * (d2[0] - d1[0])) + ((d2[1] - d1[1]) * (d2[1] - d1[1]))); 
        return squareRoot;

    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //Distrance Between p1 and p3
        double a1 = distrance(p1, p3);
        //Distrance Between p1 and p4
        double a2 = distrance(p1, p4);
        //Distrance Between p2 and p3
        double a3 = distrance(p2, p3);
        //Distrance Between p2 and p4
        double a4 = distrance(p2, p4);

        //diagonal 1
        double di1 = distrance(p1, p2);
        //diagonal 2
        double di2 = distrance(p3, p4);
        System.out.println(a1 + " " + a2 + " " + a3 + " " + a4 + " " + di1 + " " + di2);
        
       HashMap<Double, Integer> map = new HashMap<>();

        map.put(a1, map.getOrDefault(a1, 0) + 1);
        map.put(a2, map.getOrDefault(a2, 0) + 1);
        map.put(a3, map.getOrDefault(a3, 0) + 1);
        map.put(a4, map.getOrDefault(a4, 0) + 1);
        map.put(di1, map.getOrDefault(di1, 0) + 1);
        map.put(di2, map.getOrDefault(di2, 0) + 1);


        if (map.size() != 2) {
            return false;
        }
        double num1 = 0.0;
        double num2 = 0.0;
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 4) {
                num1 = entry.getKey();
            }
            if (entry.getValue() == 2) {
                num2 = entry.getKey();
            }
        }
        System.out.print(num1 + " " + num2);
        

        return map.containsValue(4) && map.containsValue(2) && (num1 < num2);


        

        
    }
}