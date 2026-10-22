class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        /*in will add all the freuency inthe hash set if the freq already contains
        //then i will just return false if my freuency is unique then i will add all and return true;*/
     
        for(int key:map.keySet()){
            if(set.contains(map.get(key))){
                return false;
            }
            set.add(map.get(key));
           
        }
        return true;
    }
}