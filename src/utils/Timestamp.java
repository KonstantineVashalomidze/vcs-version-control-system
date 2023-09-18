package utils;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Timestamp implements Comparable{

    // This is the format of the time stamp
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    // This is the time when the time stamp is created
    private String timestamp;

    public Timestamp(){
        this.timestamp = new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return this.compareTo(obj) == 0;
    }

    @Override
    public String toString(){
        return this.timestamp;
    }

    /**
     *
     * @return returns timestamp value
     */
    public String getTimestamp() {
        return this.timestamp;
    }

    /**
     *  compares two timestamps of the form yyyy-MM-dd HH:mm:ss.SSS
     * @param o timestamp2 to compare 'this' timestamp
     * @return 0 if they are equal, -1 if the left timestamp is older than the right and 1 if the left timestamp is newer than the right
     */
    @Override
    public int compareTo(Object o) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        LocalDateTime leftDateTime = LocalDateTime.parse(this.getTimestamp(), formatter);
        LocalDateTime rightDateTime = LocalDateTime.parse(((Timestamp) o).getTimestamp(), formatter);


        if (leftDateTime.isEqual(rightDateTime)) {
            return 0;
        } else if (leftDateTime.isBefore(rightDateTime)) {
            return -1;
        } else {
            return 1;
        }
    }
}
