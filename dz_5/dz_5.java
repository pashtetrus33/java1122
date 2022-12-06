// Урок 5. Хранение и обработка данных ч2: множество коллекций Map
// 1.Создать словарь HashMap. Обобщение <Integer, String>.
// 2.Заполнить тремя ключами (индекс, цвет), добавить ключь, если не было!)
// 3.Изменить значения дописав восклицательные знаки. *Создать TreeMap, заполнить аналогично.
// 4.*Увеличить количество элементов таблиц до 1000 случайными ключами и общей строкой.
// 5.**Сравнить время прямого и случайного перебора тысячи элементов словарей.
package dz_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class dz_5 {
    public static void main(String[] args) {

        // 1.
        Map<Integer, String> dict = new HashMap<>();
        // 2.
        dict.putIfAbsent(999, "Red");
        dict.putIfAbsent(998, "Green");
        dict.putIfAbsent(997, "Blue");
        System.out.println("HashMap: " + dict);
        // 3.
        for (int i : dict.keySet()) {
            dict.compute(i, (k, v) -> v = v + "!");
        }
        System.out.println("HashMap: " + dict);
        // 3.*
        Map<Integer, String> treedict = new TreeMap<>();
        treedict.putIfAbsent(999, "Red!");
        treedict.putIfAbsent(998, "Green!");
        treedict.putIfAbsent(997, "Blue!");
        System.out.println("TreeMap: " + treedict);
        // 4.*
        String testValue = "TestValue";
        for (int index = 0; index < 997; index++) {
            int randomKey;
            do {
                randomKey = new Random().nextInt(997);
            } while (dict.containsKey(randomKey) && treedict.containsKey(randomKey));
            //System.out.println("Random key: " + randomKey + " Hash of key: " + Integer.hashCode(randomKey));
            dict.put(randomKey, testValue);
            treedict.put(randomKey, testValue);
        }
        //System.out.println("HashMap: " + dict);
        // System.out.println("TreeMap: " + treedict);

        // 5.
        long currentTime = System.currentTimeMillis();
        int index =0;
        for (int i : dict.keySet()) {

            System.out.println(index + " Direct access to HashMap Key: " + i + " Value: " + dict.get(i));
            index++;

        }
        long deltaTime1 = System.currentTimeMillis() - currentTime;
        
        currentTime = System.currentTimeMillis();
        index =0;
        for (int i : treedict.keySet()) {
            System.out.println(index + " Direct access to TreeMap Key: " + i + " Value: " + treedict.get(i));
            index++;
        }
        long deltaTime2 = System.currentTimeMillis() - currentTime;


        currentTime = System.currentTimeMillis();
        for (index = 0; index < 1000; index++) {
            int i = new Random().nextInt(1000);
            System.out.println(index +" Random access to HashMap Key: " + i + " Value: " + dict.get(i));
        }  
        long deltaTime3 = System.currentTimeMillis() - currentTime;

        currentTime = System.currentTimeMillis();
        for (index = 0; index < 1000; index++) {
            int i = new Random().nextInt(1000);
            System.out.println(index +" Random access to TreeMap Key: " + i + " Value: " + treedict.get(i));
        }  
        long deltaTime4 = System.currentTimeMillis() - currentTime;

        System.out.println("DeltaTime for direct access of HashMap is " + deltaTime1);
        System.out.println("DeltaTime for direct access of TreeMap is " + deltaTime2);
        System.out.println("DeltaTime for random access of HashMap is " + deltaTime3);
        System.out.println("DeltaTime for random access of TreeMap is " + deltaTime4);

    }
}
