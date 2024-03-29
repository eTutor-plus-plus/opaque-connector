package connector.dto.opaque;

import java.io.Serializable;

/**
 *  class for score object
 */
public class Score implements Serializable {

    String axis;
    int marks;

    public Score() {
    }

    public Score(int marks) {
        this.axis = "";
        this.marks = marks;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public int getMarks() {return marks;}

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
