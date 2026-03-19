import java.util.Scanner;


public class Main{
    public static void main (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the lenght of Fibonacci");
        int fib = scanner.nextInt(); 
        System.out.print("Your number is: "+fib+"\n");
        int fibSum=Fibonacci(fib);
        System.out.println("The fibonnaci number at that place is: "+ fibSum);
    }
    static int Fibonacci(int i){
        if (i >1){
            int ret= Fibonacci(i-1)+Fibonacci(i-2);
            return ret;
        } else if (i ==1) {
            return 1;
        } else {
            return 0;
        }
    }
}