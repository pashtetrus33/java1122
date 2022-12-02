import java.util.Arrays;

public class SolutionTest {

  public static void main(String[] args) {
    System.out.println("hello");
    int[] a1 = new int[] { 1, 2, 2 };
    int[] b1 = new int[] {};

    System.out.println("b1 " + Arrays.toString(b1));
    System.out.println(b1.length);

    System.out.println(Arrays.toString(arrayDiff(a1, b1)));
  }

  public static int[] arrayDiff(int[] a, int[] b) {

    int k = 0;
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < b.length; j++) {
        if (a[i] != b[j])
          k++;
      }

    System.out.println(k);
    int[] tmp = new int[k];
    k = 0;
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < b.length; j++)
        if (a[i] != b[j]) {
          tmp[k] = a[i];
          k++;
        }
    if (b.length == 0)
      return a;
    else
      return tmp;
  }
}
