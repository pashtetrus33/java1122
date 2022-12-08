// Урок 6. Хранение и обработка данных ч3: множество коллекций Set
// Реализовать множество (set) с помощью TreeMap. Создать метод add, добавляющий элемент в ваше множество. Объявить и инициализировать компаратор с обратной (от большего к меньшеиу) логикой сортировки. Объявить и инициализировать TreeSet использующий ваш компаратор. Добавить несколько эллементов в сет и вывести в консоль.

package dz_6;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class dz_6 {
    public static void main(String[] args) {
        SetFromTreeMap set1 = new SetFromTreeMap();
        System.out.println(set1);

        set1.add("Banana");
        set1.add("Apple");
        set1.add("Orange");
        set1.add("Pineapple");
        set1.add("Pear");
        set1.add("Peach");
        set1.add("Apple");
        set1.add("Banana");

        // System.out.println("Множество 1: " + set1);
        System.out.println("Множество 1: " + set1.read());
        System.out.printf("Размер множества 1: " + set1.getSize() + "\n");

        Iterator<String> iter = set1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Set<String> set2 = new TreeSet<>();
        set2.add("Banana");
        set2.add("Apple");
        set2.add("Orange");
        set2.add("Pineapple");
        set2.add("Pear");
        set2.add("Peach");
        set2.add("Apple");
        set2.add("Banana");

        System.out.println("Множество 2: " + set2);

        //Объявить и инициализировать компаратор с обратной (от большего к меньшеиу) логикой сортировки.
        SetComparator setComp = new SetComparator();
        //Объявить и инициализировать TreeSet использующий ваш компаратор.
        TreeSet<String> set3 = new TreeSet<>(setComp);
        set3.add("Banana");
        set3.add("Apple");
        set3.add("Orange");
        set3.add("Pineapple");
        set3.add("Pear");
        set3.add("Peach");
        set3.add("Apple");
        set3.add("Banana");
        //Добавить несколько эллементов в сет и вывести в консоль.
        System.out.println("Множество 3: " + set3);

    }

}
// Реализовать множество (set) с помощью TreeMap.
class SetFromTreeMap implements Iterable<String> {
    private static final Map<String, Object> MAPINTERNAL = new TreeMap<>();
    private static final Object OBJ = new Object();
    //Создать метод add, добавляющий элемент в ваше множество.
    public void add(String str) {
        MAPINTERNAL.put(str, OBJ);
    }

    public int getSize() {
        return MAPINTERNAL.size();
    }

    public String read() {
        return MAPINTERNAL.keySet().toString();
    }

    @Override
    public String toString() {
        String res = "";
        for (String element : MAPINTERNAL.keySet()) {
            res += element.toString() + ", ";

        }
        return res;
    }

    @Override
    public Iterator<String> iterator() {
        return MAPINTERNAL.keySet().iterator();

    }

}
//Объявить и инициализировать компаратор с обратной (от большего к меньшеиу) логикой сортировки.
class SetComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}