public class Rectangle {
    private int number;
    private int n;
    private double a;
    private double b;
    private double h ;
    Rectangle(int number,int n,double a,double b){
        this.number = number;
        this.n = n;
        this.a = a;
        this.b = b;
    }

    private double lValue(){
        double res = 0;
        for(int i = 0;i<n;i++){
            res += findValue.solve(number,a+i*h);
        }
        return res*this.h;
    }
    private double rValue(){
        double res = 0;
        for(int i = 1;i<=n;i++){
            res += findValue.solve(number,a+i*h);
        }
        return res*this.h;
    }
    private double mValue(){
        double res = 0;
        for(double i = 0;i<n;i++){
            res += findValue.solve(number,a+h*(i+0.5));
        }
        return res*this.h;
    }
    public void solve(){
        double res =0;
        while (true){
            h = (b-a)/n;
            res = mValue();
            if (Math.abs(res - Lab4.res[number-1]) <= Lab4.eps) {
                System.out.println(res + " " + n );
                return;
            }
            n*=2;
        }
    }
}
