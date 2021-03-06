import sim.field.continuous.Continuous2D;
import sim.util.Double2D;
import sim.util.MutableDouble;
import sim.util.MutableDouble2D;
import sim.engine.*;
import sim.field.continuous.*;
import sim.util.*;

public class Student implements Steppable
    {
    public void step(SimState state)
        {
        Students students = (Students) state;
        Continuous2D yard = students.yard;

        Double2D me = students.yard.getObjectLocation(this);

        MutableDouble2D sumForces = new MutableDouble2D();

        // add in a vector to the "teacher" -- the centre of the yard, so we don't go too far away
        sumForces.addIn(new Double2D((yard.width * 0.5 - me.x) * students.forceToSchoolMultiplier,
                (yard.height *0.5 - me.y) * students.forceToSchoolMultiplier));

        // add a bit of randomness
        sumForces.addIn(new Double2D(students.randomMultiplier * (students.random.nextDouble() * 1.0 - 0.5),
                students.randomMultiplier * (students.random.nextDouble() * 1.0 - 0.5)));

        sumForces.addIn(me);

        students.yard.setObjectLocation(this, new Double2D(sumForces));
        }
    }
