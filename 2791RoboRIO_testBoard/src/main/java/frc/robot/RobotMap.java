package frc.robot;


import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogInput;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalOutput;



/*
this file is for constructing and mapping actuators and sensors
*/




public class RobotMap{

public static PowerDistributionPanel PDP;

public TalonSRX leftTalonSRX;
public TalonSRX rightTalonSRX;

public Talon leftTalon;
public Talon rightTalon;

public CANSparkMax leftSparkMAX;
public CANSparkMax rightSparkMAX;

public AnalogInput pot1;

public DigitalOutput DO0;
public DigitalOutput DO1;


public void RobotMapInit(){
/*construct anything here*/

PDP = new PowerDistributionPanel(0);//constructs the power distribution panel
 
leftTalon = new Talon(2); //constructs a PWM talon 
rightTalon = new Talon(3);

rightTalonSRX = new TalonSRX( 2);//constructs a CAN talonSRX
leftTalonSRX  = new TalonSRX( 3);

rightSparkMAX = new CANSparkMax(4,MotorType.kBrushless);//constructs a CAN sparkMax for brushless motors
leftSparkMAX = new CANSparkMax(5,MotorType.kBrushless);

pot1 = new AnalogInput(0);// constructs an analog input

DO0 = new DigitalOutput(0);
DO1 = new DigitalOutput(1);

}//this function initializes robotmap, constructing anything connected to the robot and assigning them to ports





}//end of file--------------------------------------------
