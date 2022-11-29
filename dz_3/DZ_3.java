import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// Урок 3. Коллекции JAVA: Введение
// 1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
// 2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
// 3. Вставить элемент в список в первой позиции.
// 4. Извлечь элемент (по указанному индексу) из заданного списка.
// 5. Обновить определенный элемент списка по заданному индексу.
// 6. Удалить третий элемент из списка.
// 7. Поиска элемента в списке по строке.
// 8. Создать новый список и добавить в него несколько елементов первого списка.
// 9. Удалить из первого списка все элементы отсутствующие во втором списке.
// 10. *Сортировка списка.
// 11. *Сравнить время работы пункта 3 для ArrayList и LinkedList.

public class DZ_3 {
    public static void main(String[] args) {
        // 1.
        List<String> arL1 = new ArrayList<>();
        arL1.add("White");
        arL1.add("Green");
        arL1.add("Yellow");
        arL1.add("Blue");
        arL1.add("Red");
        System.out.println("1. " + arL1);

        // 2.
        for (int index = 0; index < arL1.size(); index++) {
            arL1.set(index, arL1.get(index) + "!");
        }

        // for (String str : arL1) {
        // str += "!";
        // System.out.println(str+= "!");
        // }

        System.out.println("2. " + arL1);

        // 3.
        // arL1.add(0, "Orange!");
        arL1.add(1, "Black!");
        System.out.println("3. " + arL1);

        // 4.
        String str = arL1.get(3);
        System.out.println("4. " + str);

        // 5.
        arL1.set(2, "Purple!");
        System.out.println("5. " + arL1);

        // 6.
        arL1.remove(2);
        System.out.println("6. " + arL1);

        // 7.
        System.out.println("7. Позиция строки \"Yellow!\" в списке: " + arL1.indexOf("Yellow!"));

        // 8.
        List<String> arL2 = new ArrayList<>();
        arL2.add(arL1.get(0));
        arL2.add(arL1.get(2));
        arL2.add(arL1.get(3));
        System.out.println("8. List2: " + arL2);

        // 9.
        System.out.println("9. List1 before removing:  " + arL1);
        arL1.retainAll(arL2);
        System.out.println("9. List1 after:  " + arL1);

        // 10
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str2.length() - str1.length();
            }
        };
        System.out.println("10. List1 before sorting:  " + arL1);
        Collections.sort(arL1);
        System.out.println("10. List1 before sorting by default:  " + arL1);
        arL1.sort(c);
        System.out.println("10. List1 after sorting with comporator by length:  " + arL1);

        // 11.
        List<String> arLL1 = new LinkedList<>();
        arLL1.add("White");
        arLL1.add("Green");
       
        long t1 = System.nanoTime();
        arL1.add(1, "Black!");
        System.out.println("11. Time for add element in ArrayList: " + (System.nanoTime() - t1) + " nanoseconds" );


        t1 = System.nanoTime();
        arLL1.add(1, "Black!");
        System.out.println("11. Time for add element in LinkedList: " + (System.nanoTime() - t1) + " nanoseconds" );

    }

}