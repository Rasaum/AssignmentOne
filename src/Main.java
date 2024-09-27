import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    QueueOperations queueOps = new QueueOperations();

    String filePath = "src/log-data (2).csv";

    queueOps.readFile(filePath);

    queueOps.dequeueEntries();

    System.out.println("Log Level Analysis:");
    System.out.println("INFO: " + queueOps.getInfoCount());
    System.out.println("WARN: " + queueOps.getWarnCount());
    System.out.println("ERROR: " + queueOps.getErrorCount());
    System.out.println("Memory Warnings: " + queueOps.getMemoryWarnings());

    StackOperations stackops = queueOps.getStackOperations();
    System.out.println("Recent Errors:");
    int errorLimit = 100;
    int count = 0;

    while (!stackops.isEmpty() && count < errorLimit){
    System.out.println(stackops.pop());
    count++;
        }
    }
}