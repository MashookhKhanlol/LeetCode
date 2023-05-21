package com.mashukh.Stacks;

import java.util.Stack;

public class PostfixExpressions {

    public static void main(String[] args) {
        String str = "264*8/+3-";
        postfix(str);
    }

    public static void postfix(String str){
        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                int val1 = vs.pop();
                int val2 = vs.pop();
                vs.push(operation(val2,val1,ch));

                String vs1 = ps.pop();
                String vs2 = ps.pop();
                ps.push(ch + vs2 + vs1);

                String is1 = is.pop();
                String is2 = is.pop();
                is.push("(" + is2 + ch +is1 + ")");
            }

            else{
                vs.push(ch - '0');
                is.push(ch +"");
                ps.push(ch + "");
            }
        }

        System.out.println(is.pop());
        System.out.println(ps.pop());
        System.out.println(vs.pop());
     }

     public static int operation(int val1, int val2 , char opt){
        if(opt == '+'){
            return val1 + val2;
        }
        else if(opt == '-'){
            return val1 - val2;
        }
        else if(opt == '*'){
            return val1*val2;
        }
        else{
            return val1/val2;
        }
     }
}
