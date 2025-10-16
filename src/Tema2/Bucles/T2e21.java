package Tema2.Bucles;
public class T2e21 {
    public static void main(String[] args) {
        int a = 1;
        int sum =0;
        while (a <= 1000) {
            a = a + 1;
            if (a % 2 ==0) {
                sum = sum + a;
            }
        }
        System.out.println(sum);
    }
}
