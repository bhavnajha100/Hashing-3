//TC :- O(n)
//SC :- O(n)
class RepeatedDNASequences {
    //Using Robin karp - for pattern finding
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n <= 10) return new ArrayList<>();
        HashMap<Character, Long> map = new HashMap<>();
        map.put('A', 1l);
        map.put('C', 2l);
        map.put('G', 3l);
        map.put('T', 4l);
        long hash = 0l;
        long kl = (long)Math.pow(4, 9); //pow(4, n-1);

        HashSet<Long> allStrs = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for(int i = 0; i < n; i++) {
            //proces out going characer
            if(i >= 10){
                char out = s.charAt(i-10);
                hash = hash - (kl * map.get(out));
            }
            //process incoming Character
            char in = s.charAt(i);
            hash = hash*4 + map.get(in);
            if(allStrs.contains(hash)){
                res.add(s.substring(i-9, i+1));
            } else {
                allStrs.add(hash);
            }
        }
        return new ArrayList<>(res);
    }
}