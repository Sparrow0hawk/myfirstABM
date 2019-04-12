import sim.engine.*;
import sim.display.*;

public class StudentsWithUI extends GUIState
    {
        public static void main(String[] args)
            {
            StudentsWithUI vid = new StudentsWithUI();
            Console c = new Console(vid);
            c.setVisible(true);
            }
        public StudentsWithUI() { super(new Students((System.currentTimeMillis())));}
        public StudentsWithUI(SimState state) { super(state); }
        public static String getName() { return "Student Schoolyard Cliques";}
}
