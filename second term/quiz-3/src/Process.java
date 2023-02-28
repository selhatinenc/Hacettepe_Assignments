import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Process{
    Queue<String> queue;

    public Process(Queue<String> queue) throws IOException {
        this.queue=queue;
    ReadingFile();

    }

    private void ReadingFile() throws IOException {
        String prt="";
        ArrayList<String> AllLines= (ArrayList<String>) Files.readAllLines(Paths.get("src\\input.txt").toAbsolutePath());
        for (String strr:AllLines){
        String[] str =  strr.split(" ");
            StringBuffer stringBuffer=new StringBuffer(strr);
           String str2= String.valueOf(stringBuffer.charAt(0));
            if(str.length==2&str2.equals("e"))Enque(str[0],str[1]);
            else if(str.length==1&str2.equals("d"))Deque(strr);
            else if (str.length==1) {
             prt+=   FromDecToOctal(Integer.parseInt(str[0]));


            }
        }  write( prt );
    }

    private void Deque(String strr)  {
        char c=findchar(strr);
        switch (c){
            case 'F':queue.dequeueHead();
            case 'M':queue.dequeueMiddle();
            case 'B':queue.dequeueEnd();
        }
    }

    private void Enque(String s, String s1) {
        char c=findchar(s);
        switch (c){
            case 'F':queue.enqueueHead(String.valueOf(Integer.valueOf(s1)));
            case 'M':queue.enqueueMiddle(String.valueOf(Integer.valueOf(s1)));
            case 'B':queue.enqueueEnd(String.valueOf(Integer.valueOf(s1)));
        }


    }
    public  void write(String str){
        try {
            FileWriter fileWriter=new FileWriter("output.txt");
            fileWriter.write(str);


            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String FromDecToOctal(int number){
        NodeList<Integer> octallist=new NodeList<>();
        int remainder=0;
        while (number!=0){
            remainder=number%8;
            number=number/8;
            octallist.push(remainder);

        }
        return new StringBuffer(octallist.toString()).reverse().toString() ;

    }
    public char findchar(String s){
        return new StringBuffer(s).charAt(5);
    }



}
