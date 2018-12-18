/*
    Name : Tran Trung Duc
    Group : P3202
    ITMO
    Variant : 18
 */
import java.io.IOException;
import java.lang.*;

public class Lab3 {
    public double arr[][] = new double[2][10] ;
    private int n;
    private void input(String fileName) throws IOException{
        readFile inp = new readFile(fileName);
        String tmp;
        int i =0;
        while ((tmp = inp.readLine())!= null ){
            String[] _tmp = tmp.split("\\s+");
            this.n = _tmp.length;
            for(int j=0;j<n;j++) arr[i][j] = Double.parseDouble(_tmp[j]);
            i++;
        }
    }
    private void process(){
        double x1 =0.610;
        //2.1
        linear tmp = new linear(arr,x1,n);
        System.out.printf("Linear. x = %.3f -> f(x) =  %.3f\n",x1,tmp.solve());

        Quadratic _tmp = new Quadratic(arr,x1,n);
        System.out.printf("Quadratic. x = %.3f -> f(x) = %.3f\n",x1,_tmp.solve());

        //2.2
        Lagrange tmp_ = new Lagrange(arr,x1,n);
        System.out.printf("Lagrange. x = %.3f -> f(x) = %.3f\n",x1,tmp_.solve());
        //2.4
        Newton duc_ = new Newton(arr,n);
        x1 = 0.628;
        System.out.printf("Newton not equal (xi-x(i-1) != const). x = %.3f -> f(x) = %.3f\n",x1,duc_.solve_not_equal(x1));
    }

    private void solve(){
        //2.3
        Newton duc = new Newton(arr,n);
        double tmp = 0.545;
        System.out.printf("Newton equal. x = %.3f -> y = %.3f\n",tmp,duc.solve_equal(tmp));
        tmp = 0.7565;
        System.out.printf("Newton equal. x = %.3f -> y = %.3f\n",tmp,duc.solve_equal(tmp));
    }
    public static void main(String[] args) throws IOException{
        Lab3 duc = new Lab3();
        String fileName = "D:\\Russia\\thirdsemester\\math\\lab3\\input.txt";// table 2
        duc.input(fileName);
        duc.process();

        fileName = "D:\\Russia\\thirdsemester\\math\\lab3\\input1.txt";//table 6
        duc.input(fileName);
        duc.solve();

    }
}