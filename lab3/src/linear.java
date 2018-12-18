public class linear {
    private double arr[][];
    private double x;
    private int n;
    public linear(double arr[][], double x1,int n){
        this.arr = arr;
        this.x = x1;
        this.n = n;
    }
    public double solve(){
        int i=0;
        while ((arr[0][i]< this.x) && (i<n)) i++;

        double a = (arr[1][i] - arr[1][i-1])/(arr[0][i]-arr[0][i-1]);
        double b = (arr[1][i-1] - a* arr[0][i-1]);
        double res = a * this.x + b;
        return res;
    }
}
