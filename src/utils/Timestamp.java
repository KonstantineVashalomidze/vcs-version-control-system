package utils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Timestamp {

    // This is the format of the time stamp
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    // This is the time when the time stamp is created
    private String timestamp;

    public Timestamp(){
        this.timestamp = new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    /**
     *  compares two timestamps of the form yyyy-MM-dd HH:mm:ss.SSS
     * @param t1 timestamp1 to compare
     * @param t2 timestamp2 to compare
     * @return 0 if they are equal, -1 if the left timestamp is older than the right and 1 if the left timestamp is newer than the right
     */
    public static int compareTo(Timestamp t1, Timestamp t2){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        LocalDateTime leftDateTime = LocalDateTime.parse(t1.getTimestamp(), formatter);
        LocalDateTime rightDateTime = LocalDateTime.parse(t2.getTimestamp(), formatter);


        if (leftDateTime.isEqual(rightDateTime)) {
            return 0;
        } else if (leftDateTime.isBefore(rightDateTime)) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object obj){
        return Timestamp.compareTo(this, (Timestamp) obj) == 0;
    }

    @Override
    public String toString(){
        return this.timestamp;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

}
