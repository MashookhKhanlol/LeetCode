package com.mashukh.Stacks;

import java.util.Stack;

public class InfixExpressions {

    public static int precedence(char ch){
        if(ch == '+'){
            return 1;
        }
        else if(ch == '-'){
            return 1;
        }
        else if(ch == '*'){
            return 2;
        }
        else{
            return 2;
        }
    }

    public static int operation(int v2 , int v1, char ch){

        if(ch == '+'){
            return v1+v2;
        }
        else if(ch == '-'){
            return v1-v2;
        }
        else if(ch == '*'){
            return v1*v2;
        }
        else{
            return v1/v2;
        }
    }

    public static void infix(String str){
        Stack<Character> optors = new Stack<>();
        Stack<Integer> oprnds = new Stack<>();

        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                optors.push(ch);
            } else if (Character.isDigit(ch)) {
                oprnds.push(ch - '0');
            } else if (ch == ')') {
                while(optors.peek()!= '('){
                    char optor = optors.pop();
                    int v1 = oprnds.pop();
                    int v2 = oprnds.pop();

                    int opv = operation(v1,v2 , optor);

                    oprnds.push(opv);
                }
                optors.pop();
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                while(optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())){
                    char optor = optors.pop();
                    int v1 = oprnds.pop();
                    int v2 = oprnds.pop();

                    int opv = operation(v1,v2 , optor);

                    oprnds.push(opv);
                }
                optors.push(ch);
            }
        }
        while(optors.size() !=0){
            char optor = optors.pop();
            int v1 = oprnds.pop();
            int v2 = oprnds.pop();

            int opv = operation(v1,v2 , optor);

            oprnds.push(opv);
        }

        System.out.println(oprnds.peek());
    }

    public static void main(String[] args) {
        String str = "3*7*8+7";

        infix(str);
    }
}
