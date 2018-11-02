import java.io.*;
import java.util.Scanner;
public class program {
    private double epsinol;
    private double _a;
    private double _b;
    private double[] Fx = new double[4];

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please write down Fx values");
        Fx[0] = sc.nextDouble();
        Fx[1] = sc.nextDouble();
        Fx[2] = sc.nextDouble();
        Fx[3] = sc.nextDouble();
    }
    public void solve(writeFile _duc) throws  IOException{
        _duc.process("Method BinarySearch");
        _duc.process("a = " + _a + " b = " + _b + " epsinol = " + epsinol);
        binarySearch _tmp = new binarySearch(_a,_b,epsinol,Fx);
        if (_tmp.findFx(this._a )* _tmp.findFx(this._b) >0){
            _duc.process("Wrong interval");
            return;
        }

        int _sign = (_tmp.findFx(_a) < _tmp.findFx(_b)) ? 1 : -1;

        double res = _tmp.search(_a,_b,0,_sign);
        if (res != Math.pow(10,9)) _duc.process("x = " + res + ";  " + "times = " +_tmp.get_n() + "; "+ "f(x) = " +_tmp.findFx(res));
        else _duc.process("Wrong interval");
        _duc.flush();
    }

    public void _solve(writeFile _duc) throws IOException{
        _duc.process("Method Newton");
        _duc.process("a = " + _a + "; b = " + _b + "; epsinol = " + epsinol);
        Newton duc = new Newton(_a,_b,epsinol,Fx);
        double res = duc.solve();
        if (res != Math.pow(10,9)) _duc.process("x = " + res + ";  " + "times = " +duc.get_n() + "; "+ "f(x) = " +duc.findFx(res));
        else _duc.process("Wrong interval");
        _duc.flush();
    }

    public static void main(String[] args){
        try{
            File file = new File("output.txt");
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(fos));

            writeFile _duc = new writeFile(fw);

            program duc = new program();
            duc.input();
            Scanner sc = new Scanner(System.in);
            int count = 0;
            while (true){
                System.out.println("Do you want to continue check? Y/N ");
                String tmp = sc.next();
                if (tmp.equals("N")) break;
                System.out.println("Please write down a,b,epsinol");
                duc._a = sc.nextDouble();
                duc._b = sc.nextDouble();
                duc.epsinol = sc.nextDouble();
                _duc.process(++count  + ") " +"F(x) = -2.4x^3 +  1.27x^2 +  8.63x+ 2.31");
                System.out.println("Which method do you want to check : BinaryDiving(B) or NewTon(N) ?");
                if (sc.next().equals("B")) duc.solve(_duc);
                else duc._solve(_duc);
                _duc.process("");
            }
            _duc.close();
            return;
        } catch (IOException e){
            System.out.println("bye bye");
        }

    }
}
