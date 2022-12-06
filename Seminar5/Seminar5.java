package Seminar5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Seminar5 {

    public static void main(String[] args) {

        Map<Integer, String> mp = new HashMap<>();
        Set<Integer> mpkeyset = mp.keySet();
        mp.clear();
        System.out.println(mp);
        mp.put(0, "Zero");
        System.out.println(mp);
        System.out.println(mpkeyset);
        System.out.println(mp.get(32));

        if (mp.get(32) != null)
            System.out.println("Not null");

        System.out.println(mp.containsKey(3));
        System.out.println(mp.containsValue("Three"));
        System.out.println(mp.entrySet());

        Set<Map.Entry<Integer, String>> eSat = mp.entrySet();
        System.out.println(eSat);
        mp.getOrDefault(32, "Default");
        mp.remove(8);
        mp.replace(5, "Five");
        mp.replace(5, "Five", "5");
        System.out.println(mp.size());
        System.out.println(mp.values());

        mp.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
        mp.compute(5, (k, v) -> v = v + "!");
        mp.computeIfAbsent(6, k -> ciA());
        mp.computeIfPresent(6, (k, v) -> ciA(v));
        System.out.println(mp);

        mp.putIfAbsent(7, "Seven");

        for (int i : mpkeyset) {
            mp.compute(i, (k, v) -> v = v + ":" + String.valueOf(i) + "!");
        }
    }

    static String ciA() {
        return "!";
    }

    static String ciA(String v) {
        return v + "!";
    }

}