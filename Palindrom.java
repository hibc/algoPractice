/**
 * Created by arirang on 11/19/16.
 */

/*
  This program counts the number of all substring that is palindrom.
  Ex: "020020" -> "0, 2002, 020, 2, 00, 020020" total of 6 substrings that are palindrom.
  output : 
  0
  2002
  020
  2
  00
  020020
  Total number of palindrom substring: 6
*/

import java.util.*;

public class Palindrom {


    public static void main(String[] args){

        Palindrom p = new Palindrom();
        int answer = p.subPalin("020020");
        System.out.println("Total number of palindrom substring: "+ answer);
    }

    private static int subPalin(String str){
        Set<String> set = new HashSet<>();
        palinPartition(str, set, 0);
        for(String s: set){
            System.out.println(s);
        }
        return set.size();
    }

    private static void palinPartition(String str, Set<String> set, int offset){
        if (offset == str.length()){
            return;
        }

        for(int i=offset+1; i<=str.length(); i++){
            String prefix = str.substring(offset, i);
            if( checkPalin(prefix)){
                set.add(prefix);
                palinPartition(str, set, i);
            }
        }
    }

    private static boolean checkPalin(String str){
        int start = 0;
        int end = str.length()-1;

        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }

        return true;
    }
}
