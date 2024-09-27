
public class DataLog {
    private String timestamp;
    private String loglevel;
    private String message;

    public DataLog(String timestamp, String loglevel, String message){
        this.timestamp = timestamp;
        this.loglevel = loglevel;
        this.message = message;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public String getLoglevel(){
        return loglevel;
    }

    public String getMessage(){
        return message;
    }

    public String toString(){
        return String.format("[%s] %s %s", timestamp, loglevel,message);
    }
}
