import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class QueueOperations {
    private Node first, last;
    private StackOperations stack;
    private int infoCount = 0, warnCount = 0, errorCount = 0, memoryWarnings = 0;

    private class Node{
        String item;
        Node next;
    }

    public QueueOperations(){
        stack = new StackOperations();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue (String item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
    }

    public String dequeue(){
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return item;
    }

    public void readFile(String filePath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = reader.readLine()) != null){
                enqueue(line);
            }
        }
         catch (IOException e){
                e.printStackTrace();
            }
        }


    public void dequeueEntries (){
        while (!isEmpty()){
            String entry = dequeue();
            analyzeLogEntry(entry);
        }
    }

    private void analyzeLogEntry (String entry){
        if (entry.contains("ERROR")){
            stack.push(entry);
            errorCount++;
        } else if (entry.contains("INFO")) {
            infoCount++;
        } else if (entry.contains("WARN")) {
            warnCount++;
        } if (entry.contains("Memory")){
            memoryWarnings++;
        }
    }

    public int getInfoCount(){
        return infoCount;
    }

    public int getWarnCount(){
        return warnCount;
    }
    public int getErrorCount(){
        return errorCount;
    }

    public int getMemoryWarnings(){
        return memoryWarnings;
    }

    public StackOperations getStackOperations(){
        return stack;
    }

}
