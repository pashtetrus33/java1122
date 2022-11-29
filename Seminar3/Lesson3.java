import java.util.*;

public class Lesson3 {

    int i = 7;

    public static void main(String[] args) {

        int[] aI = new int[10];
        aI[0] = 4;
        aI[1] = 55;
        aI[2] = Integer.parseInt("45");

        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        array1.add(new Integer(7));
        array1.add(7);
        array1.add(234);
        array1.add(57);
        int tmp = array1.get(3);
        array1.size();
        array1.set(2, 0);
        array1.remove(1);
        array1.remove(2);
        //array1.ensureCapacity(100);

        array1.clear();
        for (int i = 0; i < 5; i++) {
            array1.add(new Random().nextInt(10));
        }

        for (int i = 0; i < 3; i++) {
            array2.add(new Random().nextInt(10));
        }

//        for (int i = 0; i < array1.size(); i++) {
//            array1.remove(i);
//        }

//        for (Integer i: array1) {
//            i = 35;
//            System.out.println(i);
//        }

//        ListIterator<Integer> iterator = array1.listIterator(args.length/5);
//        while (iterator.hasPrevious()) {
//            Integer i = iterator.previous();
//            if (i<20) iterator.remove();
//        }

        array1.forEach(i -> System.out.println(i));
        System.out.println();
        array2.forEach(i -> System.out.println(i));
        System.out.println("----------------");

//        array1.removeAll(array2);
//        array1.retainAll(array2);
//        array1.forEach(i -> System.out.println(i));
//        System.out.println();
//        array2.forEach(i -> System.out.println(i));

//        array1.add(new Float(1.5f));
//        array1.add(new String("One"));
//
//        if (array1.get(0) instanceof String) {}

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        };

        array1.sort(c);

        array1.forEach(n -> System.out.println(n));

        array1.isEmpty();
        List l1 = array1.subList(2, array1.size()-2);

        array1.trimToSize();
        array1.indexOf(7);

        LinkedList<String> strings = new LinkedList<>();
        //strings.get(5);

        System.out.println(Collections.nCopies(6, new String("Hello")));

    }
}