import java.io.*;

public class writeFile {
    private BufferedWriter fw;
    String fileName ;
    public writeFile(String fileName) throws IOException{
        this.fileName = fileName;
        init();
    }

    private void init() throws IOException{
        File file = new File(this.fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fw = new BufferedWriter(new OutputStreamWriter(fos));

    }
    public void process(String str) throws IOException{
        fw.write(str);
    }

    public void newL() throws IOException{
        fw.newLine();
    }
    public void close() throws IOException{
        fw.close();
    }
    public void flush() throws IOException{
        fw.flush();
    }
}
