import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class bufferreader{
    public static void main(String a[]){
        String sourcefile="C:\\Users\\tusha\\Downloads\\hola.txt";
        String destfile="C:\\Users\\tusha\\Downloads\\hi.txt";
        try(
            BufferedReader br=new BufferedReader(new FileReader(sourcefile));
            BufferedWriter bw=new BufferedWriter(new FileWriter(destfile));
        ){
            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
            System.out.println("File copied successfully by  bufferedreader & bufferedwriter");

        }catch(IOException e){
            System.out.println("An error occurred: "+e.getMessage());

        }
       
    }
}

