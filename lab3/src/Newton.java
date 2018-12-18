public class Newton {
    private double arr[][];
    private int n ;
    Newton(double[][] arr, int n){
        this.arr = arr;
        this.n = n;
    }
    //find n!
    private double fact(int n){
        double res = 1;
        for(int i=2;i<=n;i++) res*=i;
        return res;
    }
    // find delta (^delta) i
    private double findDelta(int i, int delta){
        if (delta == 0) return 1;
        if (delta == 1){
            double res = arr[1][i+1] - arr[1][i];
            return res;
        }
        else return findDelta(i+1,delta-1) - findDelta(i,delta-1);
    }
    /**
     * this function use for equidistant nodes
     * 3 - 4 - 5 - 6 (Xi - X(i-1) = const)
     * @return double
     */
    public double solve_equal(double x){
        if (x < (arr[0][n-1]+arr[0][0])/2) {
            double tmp_ =1;
            //find the max be hon x
            int k = 0;
            while ((arr[0][k]<x) && (k<n)) k++;
            k--;

            double tmp = (x - arr[0][k])/(arr[0][k+1]-arr[0][k]);
            double res = arr[1][k];

            for(int i=1;i<n-k;i++){
                tmp_ = 1;
                for(int j=0;j<i;j++) tmp_ *= (tmp-j); // t(t-1)(t-2)...(t-n+1)
                double tg = findDelta(k,i);
                res += (tmp_/fact(i)) * tg;
            }
            return res;
        }else{
            double tmp_;

            double tmp = (x - arr[0][n-1])/(arr[0][1]-arr[0][0]);
            double res = arr[1][n-1];

            for(int i=1;i<n;i++){
                tmp_ = 1;
                for(int j=0;j<i;j++) tmp_ *= (tmp+j);
                res += (tmp_/fact(i))*findDelta(n-1-i,i);
            }
            return  res;
        }
    }

    private double findFk(int k1, int k2){
        double tmp = arr[1][k2] -arr[1][k1];
        tmp /= (arr[0][k2]-arr[0][k1]);
        return tmp;
    }
    private double findFk(int k1,int k2,int k3){
        double tmp = findFk(k2,k3) - findFk(k1,k2);
        tmp /= (arr[0][k3]-arr[0][k1]);
        return tmp;
    }
    /**
     * this function use for un-euidistant nodes (Xi - X(i-1) != const)
     * @param x
     * @return double
     */
    public double solve_not_equal(double x){
        int k =0;
        while ((arr[0][k] < x) && (k<n)) k++;
        if (k>=2) k-=2;
        else k = 0;

        double res = 0;

        res += arr[1][k] + findFk(k,k+1)* (x-arr[0][k]) + findFk(k,k+1,k+2) * (x-arr[0][k])* (x-arr[0][k+1]);

        k++;
        res+= arr[1][k] + findFk(k,k+1)* (x-arr[0][k]) + findFk(k,k+1,k+2) * (x-arr[0][k])* (x-arr[0][k+1]);
        res /=2;

        return res;
    }
}
