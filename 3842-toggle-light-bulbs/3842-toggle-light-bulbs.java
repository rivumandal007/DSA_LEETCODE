class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet <Integer> h = new HashSet <>();
        for(int i = 0; i < bulbs.size(); i++){
            if(h.contains(bulbs.get(i))){
                h.remove(bulbs.get(i));
            }else{
                h.add(bulbs.get(i));
            }
            

        }
        ArrayList <Integer> li = new ArrayList<>();
        for(int x : h){
            li.add(x);
        }
        Collections.sort(li);
        return li;

    }
}