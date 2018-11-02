import java.lang.Math;

public class Newton {
    private double epsinol;
    private double  _a;
    private double _b;
    private int _n;
    private double[] Fx;
    public Newton(double _a,double _b,double epsinol,double[] arr){
        this._a = _a;
        this._b = _b;
        this.epsinol = epsinol;
        this._n = 0;
        this.Fx = arr;
    }
    public int get_n(){
        return this._n;
    }

    private double derivative(double _x){
        double res = 3*Fx[0]* Math.pow(_x,2) + 2*Fx[1]*Math.pow(_x,1) + Fx[2];
        return res;
    }
    public double findFx(double _x){
        double res = Fx[0]* Math.pow(_x,3) + Fx[1]*Math.pow(_x,2)+ Fx[2]*Math.pow(_x,1) + Fx[3];
        return res;
    }
    private double _derivative(double _x){ // F''(x)
        double res = 6*Fx[0]*_x + 2*Fx[1];
        return res;
    }

    private double findRot(double _tmp){
        this._n = 0;
        while (true){
            this._n ++;
            double tmp = _tmp - (findFx(_tmp)/ derivative(_tmp));
            //System.out.println(_tmp + " | " +findFx(_tmp)+ " | " + derivative(_tmp) + " | " + tmp + " | " +Math.abs(tmp-_tmp) );
            if ((Math.abs(tmp-_tmp))<this.epsinol) return tmp;
            _tmp = tmp;
        }
    }
    public double solve(){
        if (findFx(this._a )* findFx(this._b) >0) return (Math.pow(10,9)+7);
        if (this._a <= findRot(this._a) && this._b >= findRot(this._a)) return findRot(_a);
        else if (this._a <= findRot(this._b) && this._b >= findRot(this._b)) return findRot(_b);
        else if (this._a <= findRot((this._b+this._a)/2) && this._b >= findRot((this._b+this._a)/2)) return findRot((this._b+this._a)/2);
        return (Math.pow(10,9));
    }
}
