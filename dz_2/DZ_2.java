
// Урок 2. Почему вы не можете не использовать API
// 1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
// 2. Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
// 3. Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
// 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
// 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
// 6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
// 7. Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

public class DZ_2 {
    static StringBuilder tmp = new StringBuilder();

    public static void main(String[] args) {
        String s = "Hello";
        String seq = "olleH";
        // 1
        System.out.println("1.");
        isSubstring(s, seq);
        // 2
        System.out.println("2.");
        isReverse(s, seq);
        // 3
        System.out.println("3.");
        StringBuilder task3 = new StringBuilder("Cтрока наоборот");
        System.out.println("Переворот строки \"" + task3 + "\" есть \"" + stringReverse(task3) + "\"");
        // 4
        System.out.println("4.");
        StringBuilder s1 = expressionCreate(3, 56, " + ");
        StringBuilder s2 = expressionCreate(3, 56, " - ");
        StringBuilder s3 = expressionCreate(3, 56, " * ");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        // 5
        System.out.println("5.");
        expressionChange_1(s1, "равно");
        expressionChange_1(s2, "равно");
        expressionChange_1(s3, "равно");

        // 6
        s1 = expressionCreate(3, 56, " + ");
        s2 = expressionCreate(3, 56, " - ");
        s3 = expressionCreate(3, 56, " * ");
        System.out.println("6.");
        expressionChange_2(s1, "равно");
        expressionChange_2(s2, "равно");
        expressionChange_2(s3, "равно");

        // 7
        System.out.println("7.");
        stringCreate(s1, '=', 100);
        // System.out.println(s1);
        expressionChange_2(s1, " равно ");
        stringCreate(s1, '=', 100);
        System.out.println(s1);
        expressionChangeWithString(s1, "равно");

    }

    // Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей
    // все символы другой строки.
    private static void isSubstring(String s, String seq) {
        if (s.indexOf(seq) != -1)
            System.out.println("Подстрока: \"" + seq + "\" входит в строку: \"" + s + "\".");
        else
            System.out.println("Подстрока: \"" + seq + "\" НЕ входит в строку: \"" + s + "\".");

    }

    // Напишите программу на Java, чтобы проверить, являются ли две данные строки
    // вращением друг друга.
    private static void isReverse(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        sb1.reverse();
        if (sb1.compareTo(sb2) == 0)
            System.out.println("Cтроки: \"" + s1 + "\" и \"" + s2 + "\" - являются вращением друг друга.");
        else
            System.out.println("Cтроки: \"" + s1 + "\" и \"" + s2 + "\" - НЕ являются вращением друг друга.");

    }

    // Напишите программу на Java, чтобы проверить, являются ли две данные строки
    // вращением друг друга.
    private static StringBuilder stringReverse(StringBuilder s1) {

        if (s1.length() == 0)
            return tmp;
        else {
            tmp.append(s1.charAt(s1.length() - 1));
            return stringReverse(s1.deleteCharAt(s1.length() - 1));
        }

    }

    // Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 +
    // 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
    private static StringBuilder expressionCreate(int x, int y, String sign) {
        int result = 0;
        switch (sign) {
            case " + ":
                result = x + y;
                break;
            case " - ":
                result = x - y;
                break;
            case " * ":
                result = x * y;
                break;
        }

        StringBuilder expression = new StringBuilder();
        expression.append(x);
        expression.append(sign);
        expression.append(y);
        expression.append(" = ");
        expression.append(result);
        return expression;

    }

    // Замените символ “=” на слово “равно”. Используйте методы
    // StringBuilder.insert(),StringBuilder.deleteCharAt().
    private static void expressionChange_1(StringBuilder str, String word) {
        str.insert(7, word);
        str.deleteCharAt(12);
        System.out.println(str);
    }

    // Замените символ “=” на слово “равно”. Используйте методы
    // StringBuilder.replace().
    private static void expressionChange_2(StringBuilder str, String word) {
        long m = System.currentTimeMillis();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '=') {
                str.replace(i, i + 1, word);
            }
        }
        System.out.println("Delta time for StringBuilder method: " + (System.currentTimeMillis() - m) + " мс");
        System.out.println(str);
    }

    // Замените символ “=” на слово “равно”. Используйте метод String
    private static void expressionChangeWithString(StringBuilder str, String word) {
        String str1 = str.toString();
        long m = System.currentTimeMillis();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '=') {
                str1.replace(word, str1);
            }
        }
        System.out.println("Delta time for String method: " + (System.currentTimeMillis() - m) + " мс");
        System.out.println(str);
    }


    private static StringBuilder stringCreate(StringBuilder str, char addChar, int quantity) {
        for (int index = 0; index < quantity; index++) {
            str.append(addChar);
        }
        return str;
    }
}