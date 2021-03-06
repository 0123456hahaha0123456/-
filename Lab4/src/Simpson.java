public class Simpson {
    private int number;
    private int n;
    private double a;
    private double b;
    private double h ;
    Simpson(int number,int n,double a,double b){
        this.number = number;
        this.n = n;
        this.a = a;
        this.b = b;
    }

    public void solve(){
        while (true){
            double res = findValue.solve(number,a) + findValue.solve(number,b);
            h = (b-a)/n;
            for(int i=1;i<n;i++){
                if (i%2 == 1) res += 4*findValue.solve(number,a+i*h);
                else res+= 2*findValue.solve(number,a+i*h);
            }
            res *= h/3;
            if (Math.abs(res - Lab4.res[number-1]) <= Lab4.eps) {
                System.out.println(res + " " + n);
                return;
            }
            n*=2;
        }
    }
}
