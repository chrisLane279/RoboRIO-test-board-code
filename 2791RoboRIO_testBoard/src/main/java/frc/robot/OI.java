
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/*

This is the operator interface file

*/


public class OI{


public static Joystick operator0;//creates a joystick called operator0 on port 0

public double arcade_trigger;
public double arcade_turnAxis;
public boolean operatorA;
public boolean operatorB;


public void OIinit(){//initialize joysticks here. this runs once.

operator0 = new Joystick(0);


}


public void OIrun(){


arcade_trigger = operator0.getRawAxis(3) - operator0.getRawAxis(2);
arcade_turnAxis = operator0.getRawAxis(0);

operatorA = operator0.getRawButton(1);
operatorB = operator0.getRawButton(2);
}







}//end of file-----------------------------------------
