package com.mashukh.Stacks;

public class NormalStack {
    int[] data;
    int tos;

    public NormalStack(int cap){
        data = new int[cap];
        tos =-1;
    }

    void push(int val){
        if(tos == data.length -1){
            System.out.println("stack underflow");
        }
        else{
            tos++;
            data[tos] = val;
        }
    }

    int size(){
        return tos+1;
    }

    void display(){
        for(int i =0; i<data.length ;i++){
            System.out.print(data[i] + "");
        }
        System.out.println();
    }

    int top(){
        if(tos == -1){
            System.out.println("Stack underflow");
        }
        else{
            return data[tos];
        }
        return 0;
    }

    int pop(){
        if(tos == -1){
            System.out.println("Stack underflow");
        }
        else{
            int val = data[tos];
            tos--;
            return val;
        }
        return tos;
    }


}
