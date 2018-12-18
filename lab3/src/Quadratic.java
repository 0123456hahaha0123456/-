public class Quadratic {
    private double arr[][];
    private double x;
    private int n;
    public Quadratic(double arr[][], double x1,int n){
        this.arr = arr;
        this.x = x1;
        this.n = n;
    }

    private double findDet(double x1,double x2,double x3, double y1,double y2,double y3,double z1, double z2,double z3){
        double res = x1*y2*z3 + x2*y3*z1 + x3*y1*z2 - x1*z2*y3 - y1*x2*z3 - z1*y2*x3;
        return res;
    }
    private double process(int x,int y, int z){
        double res = 0;
        double a,b,c;
        double det = findDet(Math.pow(arr[0][x],2), arr[0][x], 1, Math.pow(arr[0][y],2), arr[0][y], 1, Math.pow(arr[0][z],2), arr[0][z], 1 );
        double detA = findDet(arr[1][x], arr[0][x], 1, arr[1][y], arr[0][y], 1, arr[1][z], arr[0][z], 1 );
        double detB = findDet(Math.pow(arr[0][x],2), arr[1][x], 1, Math.pow(arr[0][y],2), arr[1][y], 1, Math.pow(arr[0][z],2), arr[1][z], 1 );
        double detC = findDet(Math.pow(arr[0][x],2), arr[0][x], arr[1][x], Math.pow(arr[0][y],2), arr[0][y], arr[1][y], Math.pow(arr[0][z],2), arr[0][z], arr[1][z]);
        a = detA/det;
        b = detB/det;
        c = detC/det;
        res = a * Math.pow(this.x,2) + b * this.x + c;
        return res;
    }
    public double solve(){
        int i = 0;
        while ((arr[0][i]< this.x) && (i<this.n)) i++;
        if (i>1){ // neu ben trai co 2 phan tu >> thi chon 1 phai 2 trai
            return process(i-2,i-1,i);
        }
        else { // chon 2 phai 1 trai
            return process(i,i+1,i+2);
        }
    }
}
