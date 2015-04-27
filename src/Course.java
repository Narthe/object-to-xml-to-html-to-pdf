import java.util.Date;
import java.util.Locale;

/**
 * Created by narthe on 11/01/2015.
 */
public class Course {
    private int id;
    private int start;
    private int end;
    private int distance;

    public Course() {}

    public Course(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.distance = end-start;
    }

    public Course(int start, int end) {
        this.start = start;
        this.end = end;
        this.distance = end-start;
    }

    public int getId() { return id; }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }


    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    @Override
    public String toString() {
        return "Run{" +
                "start=" + start +
                ", end=" + end +
                ", distance=" + distance +
                '}';
    }
}
