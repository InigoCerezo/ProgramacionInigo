package Tema2.Bucles;
public class T2e27 {
    public static void main(String[] args) {
        int contadorPrimos = 0;
        int num=2;
        boolean primo;
        while(contadorPrimos<20){
            primo = true;
            for (int i = num -1; i>1; i--){
                if (num % i == 0){
                    primo = false;
                    break;
                }
            }
            if (primo) {
                System.out.println(num + " es primo");
                contadorPrimos++;
            }
            num++;
        }
    }
}
