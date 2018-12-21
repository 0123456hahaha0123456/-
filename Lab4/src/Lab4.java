import java.util.Scanner;

public class Lab4 {
    int n ;
    private void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose function, which you like to calculate integral");
        System.out.println("1 :  integral from (1 to 2) of f(x) = x^2 + 3x + 7");//13.8(3)
        System.out.println("2 :  integral from (1 to 2) of f(x) = e^x");//4.671
        System.out.println("3 :  integral from (1 to 2) of f(x) = 4x+8");//14
        System.out.println("4 :  integral from (1 to 2) of f(x) = cos(x)/2");//0.9996
        System.out.println("Please choose method you want");
    }
    public static void main(String[] args){
        Lab4 duc = new Lab4();
        duc.input();
    }
}
