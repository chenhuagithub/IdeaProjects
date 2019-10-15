package com.atguigu.sparsearray;

public class AparseArray {


    public static void main(String[] args) {

        // 1. 创建原始数组
        int[][] chessArray = new int[11][11];
        // 2. 0表示没有妻子, 1表示黑子, 2表示篮子
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        for(int[] row : chessArray){
            for(int data : row){
                System.out.print(data+"  ");
            }
            System.out.println();
        }

        // 统计原数组有用数据的个数
        int sum = 0;
        // 获取数组中非0数据的个数
        for(int[] row : chessArray){
            for(int data : row){
                if(data != 0){
                    sum++;
                }
            }
        }


        // 原始数组转化为稀疏数组
        // 创建稀疏数组
        int[][] sparesArr = new int[sum+1][3];
        // 初始化稀疏数组的第一列元素
        sparesArr[0][0] = chessArray.length;
        sparesArr[0][1] = chessArray[0].length;
        sparesArr[0][2] = sum;
        // 稀疏数组计数器, 即稀疏数组的行
        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                // 判断数组元素是否为0
                if(chessArray[i][j] != 0){
                    count++;
                    sparesArr[count][0] = i;
                    sparesArr[count][1] = j;
                    sparesArr[count][2] = chessArray[i][j];
                }
            }
        }


        System.out.println("-----------------------------------");
        // 输出稀疏数组
        for(int[] row : sparesArr){
            for(int data : row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }


        System.out.println("++++++++++++++++++++++++++++++++++");
        int[][] chessArrayReturn = new int[sparesArr[0][0]][sparesArr[0][1]];
        for (int i = 1; i < sparesArr.length; i++) {
            // 行
            int row = sparesArr[i][0];
            //列
            int colum = sparesArr[i][1];
            // 值
            int value = sparesArr[i][2];

            // 赋值原始数组
            chessArrayReturn[row][colum] = value;
        }

        System.out.println("===============================");
        for(int[] row : chessArrayReturn){
            for(int data : row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }


    }


}
