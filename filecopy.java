import java.io.*;
import java.io.IOException;
public class filecopy{
    public static void main(String a[]){
        String sourcefile="C:\\Users\\tusha\\Downloads\\input.bin";
        String destfile="C:\\Users\\tusha\\Downloads\\output (1).bin";
        try(
            FileInputStream fis=new FileInputStream(sourcefile);
            FileOutputStream fos=new FileOutputStream(destfile);           
        )
         {
            byte[] buffer=new byte[1024];
            int bytesRead;
            while((bytesRead=fis.read(buffer))!=-1){
                fos.write(buffer,0,bytesRead);
            }
            System.out.println("File copied successfully.");
         }
        catch(IOException e){
            System.out.println("An error occurred: "+e.getMessage());
            }
    }
}

