import java.util.Scanner;

public class Example {
    public static void main(String[] args){
        System.out.println("Hello Example"); 

        int zahl = 42;
        System.out.println(zahl);

        String foo = "I am foo";
        System.out.println(foo);
    
        char bar = 'a';
        System.out.println(bar);

        Scanner scanner =  new Scanner(System.in);
        
        String input = scanner.next();
        System.out.println(input);
    }
}