import java.io.*;

public class readFile {
    private BufferedReader fw;
    private int X,Y;
    private String fileName ;
    public readFile(String fileName) throws IOException{
        this.fileName = fileName;
        init();
    }

    private void init()throws IOException{
        File file = new File(this.fileName);
        FileInputStream fos = new FileInputStream(file);
        fw = new BufferedReader(new InputStreamReader(fos));
    }

    public void close() throws IOException{
        fw.close();
    }
    public String readLine()throws IOException{
        String tmp = fw.readLine();
        return tmp;
    }
}
