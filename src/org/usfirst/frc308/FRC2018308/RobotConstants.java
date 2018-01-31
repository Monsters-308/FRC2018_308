package org.usfirst.frc308.FRC2018308;

public class RobotConstants {
	
//Chassis Constants
	public static final double ChassisKp = 0.3;
	public static final double ChassisKd = 0;
	public static final double ChassisKi = 0;
	
	public static double angle;
	
	public static double frontRightSpeed = RobotMap.frontRightEnc.getRate();
	public static double rearRightSpeed = RobotMap.rearRightEnc.getRate();
	public static double frontLeftSpeed = RobotMap.frontLeftEnc.getRate();
	public static double rearLeftSpeed = RobotMap.rearLeftEnc.getRate();
	
	public static double frontRightDist = RobotMap.frontRightEnc.getDistance();
	public static double rearRightDist = RobotMap.rearRightEnc.getDistance();
	public static double frontLeftDist = RobotMap.frontLeftEnc.getDistance();
	public static double rearLeftDist = RobotMap.rearLeftEnc.getDistance();
	
	public static double frontRightRawValue = RobotMap.frontRightEnc.get();
	public static double rearRightRawValue = RobotMap.rearRightEnc.get();
	public static double frontLeftRawValue = RobotMap.frontLeftEnc.get();
	public static double rearLeftRawValue = RobotMap.rearLeftEnc.get();
	
	public static double fowardError;
	public static double strafeError;
	public static double turnError;
//Arm Constants
	public static final double ArmKp = 0;
	public static final double ArmKd = 0;
	public static final double ArmKi = 0;
}
