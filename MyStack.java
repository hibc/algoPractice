/**
 * Created by arirang on 11/21/16.
 */

import java.util.*;

public class MyStack {
    private static Deque<Integer> ms;

    MyStack(){
        ms = new LinkedList<>();
    }

    public static void inc(int bottom, int add){
        List<Integer> lst = new ArrayList<>();

        for(int i=0;i<bottom; i++){
            if(ms.size() < 1){
                break;
            }
            else{
                lst.add(ms.removeFirst());
            }
        }

        for(int i = lst.size() -1; i>= 0; i--){
            ms.addFirst(lst.get(i) + add);
        }
    }

    public static void push(int n){
        ms.addLast(n);
    }

    public static int pop(){
        return ms.removeLast();
    }

    public static int size(){
        return ms.size();
    }

    public static boolean isEmpty(){
        if (ms.size() < 1){
            return true;
        }
        else{
            return false;
        }
    }

    public static int peek(){
        return ms.getLast();
    }

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int tc = read.nextInt();
        read.nextLine();

        MyStack ms = new MyStack();
        String input = "";

        for(int i=0; i<tc; i++){
            input = read.nextLine();
            String[] split = input.split("\\s+");

            if (split[0].equals("push")){
                ms.push(Integer.parseInt(split[1]));
                System.out.println(ms.peek());
            }
            else if(split[0].equals("pop")){
                if (ms.size() < 1){
                    System.out.println("EMPTY");
                }
                else {
                    ms.pop();
                    if (ms.size() < 1)
                        System.out.println("EMPTY");
                    else
                        System.out.println(ms.peek());
                }
            }
            else if(split[0].equals("inc")){
                ms.inc(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                if (ms.size() < 1)
                    System.out.println("EMPTY");
                else
                    System.out.println(ms.peek());
            }
        }
    }
}
