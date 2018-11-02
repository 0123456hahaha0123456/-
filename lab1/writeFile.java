import java.io.BufferedWriter;
import java.io.IOException;

public class writeFile {
    BufferedWriter bw ;
    public writeFile(BufferedWriter fw){
        this.bw = fw;
    }

    public void process(String str) throws IOException{
        bw.write(str);
        bw.newLine();
    }

    public void close() throws IOException{
        bw.close();
    }
    public void flush() throws IOException{
        bw.flush();
    }
}
