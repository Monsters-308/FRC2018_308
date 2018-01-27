package org.usfirst.frc308.FRC2018308;

public class RobotConstants {

//OI Constants
	public static double forward = -Robot.oi.joystick2.getX();
	public static double strafe = Robot.oi.joystick1.getY();
	public static double turn = Robot.oi.joystick1.getX();

	//Arm Constants
	public static double joyArm = Robot.oi.joystick2.getZ();
	
//Chassis Constants
	public static final double ChassisKp = 0.3;
	public static double ChassisKd;
	public static double ChassisKi;
	public static double angle;
	
//Arm Constants
	public static double ArmKp;
	public static double ArmKd;
	public static double ArmKi;
}
