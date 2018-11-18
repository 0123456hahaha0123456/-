import java.io.IOException;

public class Solution {
    private final double maxint = Math.pow(10,9)+7;
    private int x;
    private double[] arrX = new double[20];
    private double[] arrY = new double[20];
    private int n ;
    private double[][] res = new double[20][5];
    private double[][] heso = new double[5][5];
    private Solution(){
        this.x = -1;
    }
    private void input(readFile input) throws  IOException{
        n = 0;
        String tmp;
        tmp = input.readLine();
        String[] numbers = tmp.split("\\s+");
        n = numbers.length;
        for(int i=0;i<n;i++) arrX[i] = Double.parseDouble(numbers[i]);

        tmp = input.readLine();
        numbers = tmp.split("\\s+");
        for(int i=0;i<n;i++) arrY[i] = Double.parseDouble(numbers[i]);
    }
    /*    1         2         3        4          5
       F =ax+b	F=ax2+bx+c	F=aebx	F=a+blnx	F=axb
     */
    private double findDet(double a11, double a12, double a13,
                            double a21, double a22, double a23,
                           double a31, double a32, double a33)
    {
        double res = 0;
        res += a11 * a22 * a33;
        res += a12 * a23 * a31;
        res += a13 * a21 * a32;
        res -= a13 * a22 * a31;
        res -= a12 * a21 * a33;
        res -= a11 * a23 * a32;
        return res;
    }
    private void writeRes(double S, double a, double b, double c){
        heso[0][this.x] = S;
        heso[1][this.x] = Math.sqrt(S/n);
        heso[2][this.x] = a;
        heso[3][this.x] = b;
        heso[4][this.x] = c;
    }
    private void logarithmicFunc(){
        this.x++;
        double a,b;
        double SX=0,SXX=0,SXY=0,SY=0;
        double S = 0;
        for(int i=0;i<n;i++){
            SX += Math.log(arrX[i]);
            SY += arrY[i];
            SXX += Math.log(arrX[i]) * Math.log(arrX[i]);
            SXY += Math.log(arrX[i]) * arrY[i];
        }
        a = (SY*SXX - SXY*SX)/(n*SXX - SX*SX);
        b = (SXY*n - SY*SX)/(n*SXX-SX*SX);
        for(int i=0;i<n;i++){
            res[i][this.x] = a + b*Math.log(arrX[i]);
            S+= Math.pow(res[i][this.x]-arrY[i],2);
        }
        writeRes(S,a,b,maxint);
    }
    private void exponentialFunc(){
        this.x ++;
        double a,b;
        double SX=0,SXX=0,SXY=0,SY=0;
        for(int i=0;i<n;i++) {
            SX += arrX[i];
            SY += Math.log(arrY[i]);
            SXX += arrX[i] * arrX[i];
            SXY += arrX[i] * Math.log(arrY[i]);
        }
        double S = 0;
        a = (SXX*SY-SX*SXY)/(SXX*n-SX*SX); a = Math.exp(a);
        b = (SXY * n - SX*SY) / (SXX*n - SX*SX);
        for(int i=0;i<n;i++){
            res[i][this.x] = a* Math.exp(b*arrX[i]);
            S += Math.pow(res[i][this.x] - arrY[i],2);
        }
        writeRes(S,a,b,maxint);
    }
    private void polynomialFunc(){
        this.x++;
        double a,b,c;
        double SX=0,SY=0, SXY=0, SXX=0, SXXX=0, SXXY=0, SXXXX = 0;
        for(int i=0;i<n;i++){
            SX += arrX[i];
            SY += arrY[i];
            SXX += arrX[i] * arrX[i];
            SXXX += arrX[i] * arrX[i] * arrX[i];
            SXXY += arrX[i] * arrX[i] * arrY[i];
            SXXXX += arrX[i] * arrX[i] * arrX[i]* arrX[i];
            SXY += arrX[i] * arrY[i];
        }
        double det = findDet(n,SX,SXX,SX,SXX,SXXX,SXX,SXXX,SXXXX);
        double det1 = findDet(SY,SX,SXX,SXY,SXX,SXXX,SXXY,SXXX,SXXXX);
        double det2 = findDet(n,SY,SXX,SX,SXY,SXXX,SXX,SXXY,SXXXX);
        double det3 = findDet(n,SX,SY,SX,SXX,SXY,SXX,SXXX,SXXY);
        a = det1/det;
        b = det2/det;
        c = det3/det;
        double S =0 ;
        for(int i=0; i<n;i++){
            res[i][this.x] = c* Math.pow(arrX[i],2) + b * arrX[i] + a;
            S += Math.pow(res[i][this.x] - arrY[i],2);
        }
        writeRes(S,a,b,c);
    }
    private void linearFunc(){
        this.x ++;
        double SX=0,SXX=0,SXY=0,SY=0;
        for(int i=0;i<n;i++) {
            SX += arrX[i];
            SY += arrY[i];
            SXX += arrX[i] * arrX[i];
            SXY += arrX[i] * arrY[i];
        }

        double a = (SXY * n - SX*SY) / (SXX*n - SX*SX);
        double b = (SXX*SY-SX*SXY)/(SXX*n-SX*SX);
        double S = 0;
        for(int i=0;i<n;i++){
            res[i][this.x] = a* arrX[i] + b;
            S += Math.pow(res[i][this.x] - arrY[i],2);
        }
        writeRes(S,a,b,maxint);
    }
    private void powerFunc(){
        this.x++;
        double a,b;
        double SX=0,SXX=0,SXY=0,SY=0;
        for(int i=0;i<n;i++){
            SX += Math.log(arrX[i]);
            SY += Math.log(arrY[i]);
            SXX += Math.log(arrX[i]) * Math.log(arrX[i]);
            SXY += Math.log(arrX[i]) * Math.log(arrY[i]);
        }
        a = (SY * SXX - SXY*SX)/(n*SXX - SX*SX); a = Math.exp(a);
        b = (n*SXY - SY*SX)/(n*SXX-SX*SX);
        double S = 0;
        for(int i=0;i<n;i++){
            res[i][this.x] = a * Math.pow(arrX[i],b);
            S += res[i][this.x] - arrY[i];
        }
        writeRes(S,a,b,maxint);
    }
    private void solve(){
        linearFunc();
        polynomialFunc();
        exponentialFunc();
        logarithmicFunc();
        powerFunc();
    }
    private void output(writeFile out)throws IOException{
        out.process(String.format("%18s%22s%20s%20s%20s%20s","Вид Ф(х)","Линейная","Полиномиальная","Экспоненциальная","Логарифмическая","Степенная"));
        out.newL();
        out.process(String.format("%10s%10s%20s%20s%20s%20s%20s","X","Y","F=ax+b","F=ax^2+bx+c","F=ae^(bx)","F=a+blnx","F=ax^b"));
        out.newL();
        for(int i=0;i<n;i++){
            out.process(String.format("%10.3f",arrX[i]) + String.format("%10.3f",arrY[i]));
            for(int j=0;j<5;j++) out.process(String.format("%20.3f",res[i][j]));
            out.newL();
        }
        for(int i=0;i<5;i++){
            String tmp=null;
            switch (i){
                case 0 : tmp = "S"; break;
                case 1 : tmp = "δ"; break;
                case 2 : tmp = "a"; break;
                case 3 : tmp = "b"; break;
                case 4 : tmp = "c"; break;
            }
            if (heso[i][0]!=maxint) out.process(String.format("%15s%25.3f",tmp,heso[i][0]));
            else out.process(String.format("%15s%25s",tmp,"-"));
            for(int j=1;j<5;j++) if (heso[i][j] != maxint) out.process(String.format("%20.3f",heso[i][j]));
            else out.process(String.format("%20s","-"));
            out.newL();
        }
        double tmp = maxint;
        int tg =0;
        for(int i=0;i<5;i++){
            if (heso[1][i]< tmp) { tmp = heso[1][i]; tg = i;}
        }
        switch (tg){
            case 0 : System.out.println(String.format("f(x) = %.3fx + %.3f",heso[2][tg],heso[3][tg])); break;
            case 1 : System.out.println(String.format("f(x) = %.3fx^2 + %.3fx + %.3f",heso[2][tg],heso[3][tg],heso[4][tg])); break;
            case 2 : System.out.println(String.format("f(x) = %.3f * e^(%.3fx)",heso[2][tg],heso[3][tg])); break;
            case 3 : System.out.println(String.format("f(x) = %.3f + %.3flnx",heso[2][tg],heso[3][tg])); break;
            case 4 : System.out.println(String.format("f(x) = %.3f * x^%.3f",heso[2][tg],heso[3][tg])) ; break;
        }
    }
    public static void main(String[] args){
        String filepath = "D:\\Russia\\thirdsemester\\math\\lab2\\";
        try {
            readFile input = new readFile(filepath+"input.txt");
            writeFile output = new writeFile(filepath+"output.txt");

            Solution duc = new Solution();
            duc.input(input);
            duc.solve();
            duc.output(output);
            input.close();
            output.close();
        }
        catch (IOException e){
            System.out.println("Bye bye");
        }
    }
}
