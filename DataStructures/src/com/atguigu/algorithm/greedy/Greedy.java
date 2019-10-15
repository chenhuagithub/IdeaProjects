package com.atguigu.algorithm.greedy;

import java.time.temporal.Temporal;
import java.util.*;

/**
 * 贪心算法
 * @author chenhua
 */
public class Greedy {
    public static void main(String[] args) {
        Map<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);

        ArrayList<String> allArea = new ArrayList<>();
        allArea.add("北京");
        allArea.add("上海");
        allArea.add("天津");
        allArea.add("广州");
        allArea.add("深圳");
        allArea.add("成都");
        allArea.add("杭州");
        allArea.add("大连");
        System.out.println(allArea);
        HashSet<String> tempSet = new HashSet<>();
        Map<String, Integer> maxCover = new HashMap<>();
        HashSet<String> selectors = new HashSet<>();
        String maxKey = null;
        while (allArea.size() > 0) {
            for (String key : broadcasts.keySet()) {
                tempSet = broadcasts.get(key);
                tempSet.retainAll(allArea);
                maxCover.put(key, tempSet.size());
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                selectors.add(maxKey);
                allArea.removeAll(broadcasts.get(maxKey));
                maxKey = null;
            }
        }

        System.out.println("selectors="+selectors);



    }
}
