package Tema3.ModularParte1;
import java.util.Scanner;
import static Tema3.ModularParte1.T3E1.numberSign;

public class T3E2 {
    public static boolean isAdult(int a){
        if(numberSign(a-18)>=0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una edad:");
        int a = scanner.nextInt();
        boolean result = isAdult(a);
        if(result){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }
}
