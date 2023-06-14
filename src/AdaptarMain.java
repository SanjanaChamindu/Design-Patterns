public class AdaptarMain {
    public static void main(String[] args) {
        Pen p = new PenAdapter();
        AssignmentWork assignmentWork = new AssignmentWork();
        assignmentWork.setPen(p);
        assignmentWork.writeAssignment("I'm tired in writing assignments");
    }
}

interface Pen{
    void write(String str);
}
class AssignmentWork{
    private Pen pen;
    public void writeAssignment(String str){
        pen.write(str);
    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }
}

class PilotPen{
    public void mark(String str){
        System.out.println(str);
    }
}

class PenAdapter implements Pen{
    PilotPen pilotPen = new PilotPen();
    @Override
    public void write(String str) {
        pilotPen.mark(str);
    }
}
