import java.util.Scanner;

public class Lab4 {
    public static final double eps = Math.pow(10,-6);
    public static final double res[] = {13.833333,4.670774,14,0.499822};
    private final int n = 5;
    private int number;
    private int method;
    private void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose function, which you like to calculate integral");
        System.out.println("1 :  integral from (1 to 2) of f(x) = x^2 + 3x + 7");//13.8(3)
        System.out.println("2 :  integral from (1 to 2) of f(x) = e^x");//4.671
        System.out.println("3 :  integral from (1 to 2) of f(x) = 4x+8");//14
        System.out.println("4 :  integral from (1 to 2) of f(x) = cos(x)/2");//0.9996
        number = sc.nextInt();
        System.out.println("Please choose method you want");
        System.out.println("1: Rectangle method");
        System.out.println("2: Trapezium method");
        System.out.println("3: Simpson method");
        method = sc.nextInt();
    }

    private void find1(){
        Rectangle duc = new Rectangle(number,n,1,2);
        duc.solve();
    }

    private void find2(){
        Trapezium duc = new Trapezium(number,n,1,2);
        duc.solve();
    }

    private void find3(){
        Simpson duc = new Simpson();
    }

    private void solve(){
        switch (method){
            case 1: find1(); break;
            case 2: find2(); break;
            case 3: find3(); break;
        }

    }
    public static void main(String[] args){
        Lab4 duc = new Lab4();
        duc.input();
        duc.solve();
    }
}
