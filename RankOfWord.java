public class RankOfWord {
    // finds a rank of a word (no repetition of letter)
    public int rankWord(String str){
        List<Character> lst = new ArrayList<>();
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            lst.add(ch);
        }
        
        Collections.sort(lst);
        
        int index_i =0;
        int index_j = 0;
        int total = 0;
        
        while(lst.size() > 0){
            if(lst.get(index_j) == str.charAt(index_i)){
                lst.remove(index_j);
                index_j = 0;
                index_i++;
            }
            else{
                total += factorial(lst.size()-1);
                index_j++;
            }    
        }
        
        total += 1;
        return total;    
    }
    
    public int factorial(int n){
        if (n == 0){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }
}
