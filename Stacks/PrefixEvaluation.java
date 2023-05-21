package com.mashukh.Stacks;

import java.util.Stack;

public class PrefixEvaluation {

    public static void prefix(String str){

        Stack<Integer> vs = new Stack<>();
        Stack<String> ps = new Stack<>();
        Stack<String> is = new Stack<>();


        for(int i=str.length() -1; i>= 0; i--) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = vs.pop();
                int v2 = vs.pop();
                vs.push(operaion(v1, v2, ch));

                String s1 = ps.pop();
                String s2 = ps.pop();
                ps.push(s1 + s2 + ch);

                String i1 = is.pop();
                String i2 = is.pop();
                is.push("(" + i1 + ch + i2 + ")");
            } else {
                vs.push(ch - '0');
                is.push(ch + "");
                ps.push(ch + "");
            }
        }

        System.out.println(vs.pop());
        System.out.println(is.pop());
        System.out.println(ps.pop());
    }

    public static int operaion(int v1, int v2, char optr){
        if(optr == '+'){
            return v1+v2;
        }
        else if(optr == '-'){
            return v1-v2;
        }
        else if(optr == '*'){
            return v1*v2;
        }
        else{
            return v1/v2;
        }
    }

    public static void main(String[] args) {
        String str = "-+2/*6483";
        prefix(str);
    }
}
