package com.atguigu.huffmantree;

import java.util.*;

public class HuffmanTreeCode {

    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        NodeCode huffmanTree = createHuffmanTree(str);
        preOreder(huffmanTree);
        getCode(huffmanTree, "", stringBuilder);
        System.out.println(huffmanCode);
        for (Map.Entry<Byte, String> code : huffmanCode.entrySet()){
            System.out.print((char)(int)code.getKey()+"="+code.getValue()+"\t");
        }

    }

    public static void preOreder(NodeCode root){
        if (root != null) {
            root.preOreder();
        }else {
            System.out.println("树为空, 无法进行前序遍历");
        }
    }

    // 创建赫夫曼树
    public static NodeCode createHuffmanTree(String str){
        ArrayList<NodeCode> nodeCodes = new ArrayList<>();
        byte[] bytes = str.getBytes();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes){
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b, 1);
            }else {
                counts.put(b, count + 1);
            }
        }

        // 创建赫夫曼树
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()){
            nodeCodes.add(new NodeCode(entry.getKey(), entry.getValue()));
        }


        while (nodeCodes.size() > 1){
            Collections.sort(nodeCodes);
            NodeCode leftNode = nodeCodes.get(0);
            NodeCode rightNode = nodeCodes.get(1);
            NodeCode parentNode = new NodeCode(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            nodeCodes.remove(leftNode);
            nodeCodes.remove(rightNode);
            nodeCodes.add(parentNode);
        }

        return nodeCodes.get(0);
    }

    public static Map<Byte, String> huffmanCode = new HashMap<>();
    public static StringBuilder stringBuilder = new StringBuilder();
    // 生成赫夫曼编码
    public static void getCode(NodeCode nodeCode, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (nodeCode != null) {
            if (nodeCode.data == null) {
                getCode(nodeCode.left, "0", stringBuilder1);
                getCode(nodeCode.right, "1", stringBuilder1);
            }else {
                huffmanCode.put(nodeCode.data, stringBuilder1.toString());
            }
        }


    }

}





class NodeCode implements Comparable<NodeCode>{

    public Byte data;
    public int weight;
    public NodeCode left;
    public NodeCode right;

    public NodeCode(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NodeCode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(NodeCode o) {
        return this.weight - o.weight;
    }

    // 前序遍历
    public void preOreder(){
        System.out.println(this);
        if (this.left != null) {
            this.left.preOreder();
        }
        if (this.right != null) {
            this.right.preOreder();
        }
    }


}
