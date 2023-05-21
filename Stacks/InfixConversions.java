package com.mashukh.Stacks;

import java.util.Stack;

public class InfixConversions {

    public static void main(String[] args) {
        String st = "(4+4*2*2)";

        conversion(st);
    }


    public static void conversion(String str){
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i=0; i< str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                ops.push(ch);
            }
            else if(ch >='a' && ch<='z' || ch>= 'A' && ch <= 'Z' || ch >= '0' && ch <='9'){
                post.push(ch + "");
                pre.push(ch + "");
            }
            else if(ch == ')'){
                while(ops.peek() != '(' && ops.size()!=0){
                    process(ops,pre,post);
                }
                ops.pop();
            }
            else if(ch == '+' || ch== '-' || ch == '*' || ch == '/'){
                while(ops.size() > 0 && ops.peek() != '(' &&precedence(ch) <= precedence(ops.peek())){
                    process(ops, pre, post);
                }
                ops.push(ch);
            }

        }

        while(ops.size()>0){
            process(ops,pre,post);
        }
        System.out.println(pre.pop());
        System.out.println(post.pop());
    }

    public static void process(Stack<Character> ops, Stack<String> pre , Stack<String> post){
        char opv = ops.pop();
        String post1 = post.pop();
        String post2 = post.pop();
        post.push(post1 + post2 + opv);

        String pre1 = pre.pop();
        String pre2 = pre.pop();
        pre.push(opv + pre1 + pre2);
    }
    public static int precedence(char oprt){
        if(oprt == '+' || oprt == '-'){
            return 1;
        }
        else if(oprt == '*' || oprt == '/'){
            return 2;
        }
        else{
            return 0;
        }
    }
}
