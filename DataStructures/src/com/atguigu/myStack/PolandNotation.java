package com.atguigu.myStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {
        // 为了说明方便, 逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = "10+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(suffixExpression);
//        System.out.println(list);
        List<String> list1 = parseSuffixExpressionList(list);
//        System.out.println(list1);
//        List<String> list = getList(suffixExpression);
        int caculator = caculator(list1);
        System.out.println(suffixExpression+"="+caculator);


    }


    // 中缀表达式转化为后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls){
        System.out.println("========="+ls);
        // 定义一个栈s1, 用于中间的转化栈
        Stack<String> s1 = new Stack<>();
        // 定义一个ArrayList, 用于存放后缀表达式
        ArrayList<String> s2 = new ArrayList<>();

        // 循环遍历中缀表达式的list进行中缀表达式到后缀表达式的转化
        for(String str : ls){
            // 如果是数字, 直接加入到s2中
            if(str.matches("\\d+")){
                s2.add(str);
                // 如果是括号"(", 直接入栈s1
            }else if(str.equals("(")){
                s1.push(str);
                // 如果是右括号(, 我们把s1中的元素出栈, 并添加到s2中, 直到遇到左括号)
            }else if(str.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                // 弹出左括号(
                s1.pop();
            }else {
                // 如果str优先级小于s1栈顶优先级, 我们要把栈s1中弹出, 并加入s2中, 直到时str优先级大于栈顶元素优先级
                while (s1.size() != 0 && operPriority(str) <= operPriority(s1.peek())){
                    s2.add(s1.pop());
                }
                s1.push(str);
            }
        }

        // 将剩余s1中的元素弹出加入到s2中
        while (s1.size() > 0){
            s2.add(s1.pop());
        }


        return s2;
    }

    // 定义符号的优先级
    public static int operPriority(String oper){

        int result = 0;

        switch (oper){
            case "+":
            case "-":
                return result = 1;
            case "*":
            case "/":
                return result = 2;
            default:
                System.out.println("没有该符号");
        }

        return result;

    }


    // 将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s){
        // 定义一个List存放字符串分割后的字符
        ArrayList<String> ls = new ArrayList<>();
        int index = 0;
        char c;
        String str = "";

        while (index <= s.length()- 1){
            // 判断是否为数字
            if(s.charAt(index) < '0' || s.charAt(index) > '9'){
                // 不为数字执行该if语句
                c = s.charAt(index);
                ls.add(c+"");
                index++;
            }else {
                // 为数字执行else
                str = ""; //每次执行else都要把str置为空串, 避免与上次重叠
                while (s.charAt(index) >= '0' && s.charAt(index) <='9'){
                    c = s.charAt(index);
                    str += c;
                    if(index == s.length() - 1){
                        System.out.println("最后一个");
                        index++;
                        break;
                    }
                    index++;
                }
                ls.add(str);

            }

        }

        return ls;
    }


    // 把字符串中的数据转化为list中存起来
    public static List<String> getList(String suffixExpression){
        // 使用空格分割字符串
        String[] s = suffixExpression.split(" ");
        // 定义一个List对象
        ArrayList<String> stringArrayList = new ArrayList<>();
        // 循环遍历数组, 并把字符串存到List对象中
        for(String str : s){
            stringArrayList.add(str);
        }

        return stringArrayList;
    }


    // 计算器逻辑
    public static int caculator(List<String> list){
        // 定义一个栈, 用于存放数据
        Stack<String> stack = new Stack<>();
        // 循环判断list对象中的元素是数字还是符号
        for(String str : list){
            // 如果是数字, 直接入栈
            // 正则表达式匹配多位整数
            if(str.matches("\\d+")){
                stack.push(str);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = operate(num1, num2, str);
                // 把整形转化为字符串型
                stack.push(Integer.toString(result));
            }
        }

        return Integer.parseInt(stack.pop());
    }


    // 计算
    public static int operate(int num1, int num2, String oper){
        int result = 0;
        switch (oper){
            case "+": result = num1 + num2;break;
            case "-": result = num1 - num2;break;
            case "*": result = num1 * num2;break;
            case "/": result = num1 / num2;break;
            default: throw new RuntimeException("符号输入错误");
        }
        return result;
    }

}
