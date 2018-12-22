public class findValue {
    public static double solve(int number, double x){
        double res =0;
        switch (number){
            case 1: res = Math.pow(x,2) + 3*x + 7 ; break;
            case 2: res = Math.exp(x);break;
            case 3: res = 4*x + 8; break;
            case 4: res = Math.cos(x)/2 ; break;
        }
        return res;
    }
}
