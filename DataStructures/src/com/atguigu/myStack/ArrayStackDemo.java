package com.atguigu.myStack;

import java.util.Scanner;

public class ArrayStackDemo {


    public void caculator(){
        // 表达式 3+2*6-2
        String expression = "30+2*6-2+11";
        // 数据栈
        ArrayStack numStack = new ArrayStack(10);
        // 符号栈
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        // 拼接数字的字符串
        String keepNum = "";

        // 扫描算数表达式
        while (true){
            ch = expression.substring(index, index + 1).charAt(0);

            // 判断ch是数据还是符号
            if(operStack.isPoer(ch)){
                // 判断当前的符号栈是否为空
                if(!operStack.isEmpty()){
                    // 符号栈顶不为空的话要判断优先级
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 把运算之后的结果入数据栈
                        numStack.push(res);
                        // 把当前的符号入符号栈
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }else {
                    // 直接入符号栈
                    operStack.push(ch);
                }

            }else {
                // 如果是数字则直接入数字栈
//                numStack.push(ch - 48);


                // 处理多位数字的问题
                keepNum += ch;


                // 因为index+2在字符串的最后可能会产生越界的问题, 所以要判断是否扫描到字符串的最后一位
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    // 判断后一位是否是数字, 如果是则继续扫描
                    if(operStack.isPoer(expression.substring(index+1, index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }



            }

            // index + 1 并判断是否扫描到expresion最后
            index++;
            if(index >= expression.length()){
                break;
            }
        }


        // 顺序取出符号栈和数据栈中的元素进行计算
        while (true){
            // 如果符号栈为空, 则说明计算到最后的结果
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        System.out.println("*********************");
        System.out.println(expression+" = "+res);
    }

    public void aaa(){
        ArrayStack arrayStack = new ArrayStack(4);
        String key = " ";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show: 显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 入栈");
            System.out.println(" pop: 出栈");
            System.out.println();
            System.out.print(">>>");
            key = scanner.next();
            switch (key){
                case "show": arrayStack.showStack(); break;
                case "exit": loop = false; break;
                case "push":
                    System.out.println(">>");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;

                case "pop":
                    System.out.println("出栈元素--->"+arrayStack.pop());
                    break;
                default:
                    System.out.println("输入错误");
            }
        }
    }

    public static void main(String[] args) {

        ArrayStackDemo arrayStackDemo = new ArrayStackDemo();
        arrayStackDemo.caculator();


    }
}


class ArrayStack{

    private int maxSize;
    private int[] stack;
    private int top;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    // 满栈
    public boolean isFull(){
        return this.top == this.maxSize-1;
    }

    // 空栈
    public boolean isEmpty(){
        return this.top == -1;
    }

    // 入栈
    public void push(int param){
        // 判断是否栈是否为满
        if(isFull()){
            System.out.println("栈已满, 无法插入数据");
            return;
        }
        this.top++;
        this.stack[top] = param;
    }

    // 出栈
    public int pop(){
        //判断栈是否为空
        if(isEmpty()){
            throw new RuntimeException("栈为空, 无法出栈");
        }
        int value = this.stack[this.top];
        this.top--;
        return value;
    }


    // 查看栈顶
    public int peek(){
        return this.stack[this.top];
    }


    // 输出栈
    public void showStack(){
        // 判断栈是否为空
        if(isEmpty()){
            System.out.println("栈为空~~");
            return;
        }
        System.out.println("**********栈的输出结果***********");
        for (int i = this.top; i >= 0 ; i--) {
            System.out.print(stack[i]+"  ");
        }
        System.out.println();
    }


    // 规定运算优先级
    public int priority(int oper){
        switch (oper){
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
        }
        return -1;
    }

    // 判断是否是一个运算符
    public boolean isPoer(char val){
        return val == '+' || val == '-' || val== '*' || val == '/';
    }

    // 计算
    public int cal(int num1, int num2, int oper){
        int result = 0;
        switch (oper){
            case '+': result = num1 + num2;break;
            case '-': result = num2 - num1;break;
            case '*': result = num1 * num2;break;
            case '/': result = num2 / num1;break;
        }
        return result;
    }


}
