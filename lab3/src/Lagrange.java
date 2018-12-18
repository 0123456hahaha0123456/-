class Lagrange {
    private double arr[][];
    private double x1;
    private int n;
    public Lagrange(double arr[][], double x1,int n){
        this.arr = arr;
        this.x1 = x1;
        this.n = n;
    }

    public double solve(){
        double res = 0;
        for(int i=0;i<n;i++){
            double res1 = 1;
            for(int j=0;j<n;j++) if (i!=j) res1 *= (x1-arr[0][j]) / (arr[0][i] - arr[0][j]);
            res+= res1 * arr[1][i];
        }
        return res;
    }
}
