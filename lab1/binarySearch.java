import java.lang.Math;
public class binarySearch {
    private double epsinol;
    private double  _a;
    private double _b;
    private int _n;
    private double[] Fx;
    public binarySearch(double _a,double _b,double epsinol,double[] arr){
        this._a = _a;
        this._b = _b;
        this.epsinol = epsinol;
        this._n = 0;
        this.Fx = arr;
    }
    public double  get_a(){
        return this._a;
    }
    public double get_b(){
        return this._b;
    }
    public double getEpsinol(){
        return this.epsinol;
    }

    public int get_n(){
        return this._n;
    }
    public double findFx(double _x){
        double res = Fx[0]* Math.pow(_x,3) + Fx[1]*Math.pow(_x,2)+ Fx[2]*Math.pow(_x,1) + Fx[3];
        return res;
    }
    public double search(double left, double right, int n,int sign){
        while (left<right){
            n++;
            double mid = (left+right) / 2;
            //System.out.println(left +" " + right +' '+ mid +' ' + findFx(left) + ' ' + findFx(right) + ' ' + findFx(mid) + ' '+ Math.abs(left - right));
            if (Math.abs(findFx(mid))<epsinol) {
                this._n = n;
                this._a = left;
                this._b = right;
                return mid;
            }

            if (sign*findFx(mid)>0) right= mid;
            else left = mid;
        }
        return (Math.pow(10,9));
    }
}
//-2.4  1.27 8.63 2.31