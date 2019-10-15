package com.atguigu.digui;

/**
 * @author chenhua
 */
public class MiGong {

    public static void main(String[] args) {

        int[][] map = map(8, 7);
        for(int[] row : map){
            for(int va : row){
                System.out.print(va+ " ");
            }
            System.out.println();
        }
        System.out.println("----------------------");

        setWay(map, 1,1);
        for(int[] row : map){
            for(int va : row){
                System.out.print(va+ " ");
            }
            System.out.println();
        }

    }


    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map, i+1, j)){
                    return true;
                }else if(setWay(map, i, j+1)){
                    return true;
                }else if(setWay(map, i-1, j)){
                    return true;
                }else if(setWay(map, i+1, j)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }

        }

    }

    /**
     * 创建地图 1 表示墙
     * @param row
     * @param column
     * @return
     */
    public static int[][] map(int row, int column){
        int [][] mapArray = new int[row][column];

        for (int i = 0; i < row; i++) {
            mapArray[i][0] = 1;
            mapArray[i][column-1] = 1;
        }

        for (int i = 0; i < column; i++) {
            mapArray[0][i] = 1;
            mapArray[row - 1][i] = 1;
        }

        // 设置挡板
        mapArray[3][1] = 1;
        mapArray[3][2] = 1;
//        mapArray[1][2] = 1;
//        mapArray[2][2] = 1;


        return mapArray;
    }

}
