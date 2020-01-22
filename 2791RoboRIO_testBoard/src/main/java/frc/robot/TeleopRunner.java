   

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.cameraserver.CameraServer;


/* 
*
*
*This file contains tasks to iterate in the code loop
*
*
*/

public class TeleopRunner{

public double kforward; //constant direcrtional value, returns +1
public double kreverse;//constant direcrtional value, returns -1

public DifferentialDrive robotdrive;

void teleoprunnerinit(){

  robotdrive = new DifferentialDrive(Robot.robotmap.leftTalon, Robot.robotmap.rightTalon);
  robotdrive.setSafetyEnabled(false);
}

public void initCameras(){

  CameraServer server = CameraServer.getInstance();
 
  server.startAutomaticCapture(0);

}

public void swapcameras(){

Robot.robotmap.DO0.set(Robot.oi.operatorA);
Robot.robotmap.DO1.set(Robot.oi.operatorB);


/************************
*cam switch truth table *
*-----------------------*
*DO0 | DO1| channel No. *
* (A)| (B)|(port)       *
*0   |0   |0 (1)        *
*0   |1   |1 (2)        *
*1   |0   |2 (3)        *
*1   |1   |3 (4)        *
************************/

}


public void runAllMotors(double speed){
    /*
    This should be called to run all the motors on the board at the speed entered
    in the function as the double value "speed"
    */

 Robot.robotmap.leftSparkMAX.set(speed);
 Robot.robotmap.rightSparkMAX.set(speed);

 Robot.robotmap.rightTalonSRX.set(ControlMode.PercentOutput,speed);
 Robot.robotmap.leftTalonSRX.set(ControlMode.PercentOutput,speed);



}


public void runDifferentialMotors(double speed, double direction){

    /*
    This should be called to run all the motors on the board at the speed entered
    in the function as the double value "speed" and differential direction as the double value 
    "direction", use constants kforward and kreverse for directional input
    */

    Robot.robotmap.leftSparkMAX.set(speed * direction);
    Robot.robotmap.rightSparkMAX.set(speed * -direction);
    
    Robot.robotmap.rightTalonSRX.set(ControlMode.PercentOutput,speed * direction);
    Robot.robotmap.leftTalonSRX.set(ControlMode.PercentOutput,speed * -direction);
    

}

public void arcadedrive(){

    /*
    This should be called to run an arcade drive robot drivetrain in differential mode
    */

 robotdrive.setSafetyEnabled(false);
 robotdrive.arcadeDrive(Robot.oi.arcade_trigger, Robot.oi.arcade_turnAxis);

}



public double getAnalog(){
  /*
  This should be called to read values from analog sensors on the RIO gpi/o
  */

  double potval = Robot.robotmap.pot1.getVoltage();

  return potval;

}

public void idle(){

   //nothing should run here exept motors being set to neutral

  runAllMotors(0.00);
 


}


double kforward(){

 return +1;

}

double kreverse(){

 return -1;

}






}//end of file------------------------------------------------------------------------