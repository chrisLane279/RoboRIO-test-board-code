/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;// no commands
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.TeleopRunner;
import frc.robot.OI;

/*

This simple Timed robot runs iterative code, with no commands. we dont need them here 

*/
public class Robot extends TimedRobot {

 public static final TeleopRunner teleoprunner = new TeleopRunner();//makes teleoprunner
 public static final RobotMap robotmap = new RobotMap();// makes robotmap
 public static final  OI oi = new OI();// makes operator interface


  @Override
  public void robotInit() {
    SmartDashboard.putString("RobotStateInfo","Robot is initializing");

    robotmap.RobotMapInit();//runs robotmap init function

    oi.OIinit();//runs oi init function
     teleoprunner.teleoprunnerinit();
    teleoprunner.initCameras();//runs camera init function in teleoprunner

  }//RobotInit runs once when the robot is powered on and initializes anything that needs initializing




  @Override
  public void robotPeriodic() {

    oi.OIrun();//runs iterative function in oi



  }//robotPereodic runs constantly after robotinit no matter what



  @Override
  public void autonomousInit() {
    SmartDashboard.putString("RobotStateInfo","Auto Initializing");
    System.out.println("Robot is alive; status Autonoma");
   teleoprunner.idle();//runs idle function in teleoprunner

  }//runs once before autonomus, after robotinit 


  @Override
  public void autonomousPeriodic() {
    SmartDashboard.putString("RobotStateInfo","Auto Periodic");

   teleoprunner.idle();

  }//runs constantly when the bot is enabled and in autonomus mode

  @Override
  public void teleopInit() {
    SmartDashboard.putString("RobotStateInfo","Teleop Initializing");
    System.out.println("Robot is alive; status Machina");
   teleoprunner.idle();

  }//runs once before teleoperated, after robotinit



  @Override
  public void teleopPeriodic() {
    SmartDashboard.putString("RobotStateInfo","Teleop Periodic");
    
   
   //teleoprunner.runAllMotors(teleoprunner.getAnalog());//runs runallmotors function in teleoprunner

   //SmartDashboard.putNumber("Potval", teleoprunner.getAnalog());//puts potval on sdashboard
   
   teleoprunner.swapcameras();//runs swapcameras function in teleoprunner
   
  }//runs constantly when the bot is enabled and in teleoperated mode



 
  @Override
  public void testPeriodic() {
   SmartDashboard.putString("RobotStateInfo","Test Periodic");
   System.out.println("Robot is alive");
   //teleoprunner.arcadedrive();//runs an arcade drive
  }//runs constantly when the bot is enabled and in testing mode

@Override
public void disabledInit(){
  SmartDashboard.putString("RobotStateInfo","disabling");
  System.out.println("Robot disabled");
}

@Override
public void disabledPeriodic(){
  SmartDashboard.putString("RobotStateInfo","Robot disabled");



}

}//end of file------------------------------------------------------------------------------
