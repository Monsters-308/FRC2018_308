
package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotConstants;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class Chassis extends Subsystem {

	// Local motor instantiation from RobotMap
	public static final WPI_TalonSRX frontLeftMotor1 = RobotMap.frontLeftMotor1;
	public static final WPI_TalonSRX frontLeftMotor2 = RobotMap.frontLeftMotor2;
	public static final WPI_TalonSRX frontRightMotor1 = RobotMap.frontRightMotor1;
	public static final WPI_TalonSRX frontRightMotor2 = RobotMap.frontRightMotor2;
	public static final WPI_TalonSRX rearLeftMotor1 = RobotMap.rearLeftMotor1;
	public static final WPI_TalonSRX rearLeftMotor2 = RobotMap.rearLeftMotor2;
	public static final WPI_TalonSRX rearRightMotor1 = RobotMap.rearRightMotor1;
	public static final WPI_TalonSRX rearRightMotor2 = RobotMap.rearRightMotor2;
	
	//Instantiate main MecanumDrive
	public MecanumDrive mainDrive = new MecanumDrive(RobotMap.frontLeftMotor1, RobotMap.rearLeftMotor1,
			RobotMap.frontRightMotor1, RobotMap.rearRightMotor1);
	
	//Instantiate gyro
	public static Gyro gyro = null;

	@Override
	// Set default command for a subsystem
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	// Update drive outputs with current joystick values.
	public void periodic() {
//		mainDrive.driveCartesian(RobotConstants.forward, RobotConstants.strafe, RobotConstants.turn, RobotConstants.angle);
									//Strafe				Forward/Backward			Turn						Gyro
		mainDrive.driveCartesian(Robot.oi.joystick2.getX(), -Robot.oi.joystick1.getY(), Robot.oi.joystick1.getX(), RobotConstants.angle);
	}

	// Initialize gyro.
	public void gyro() {
		RobotConstants.angle = gyro.getAngle(); // get current heading
		RobotMap.drive(-1.0, -(RobotConstants.angle) * (RobotConstants.ChassisKp)); // drive towards heading 0
		Timer.delay(0.004);
		gyro = new AnalogGyro(1);
	}

	// Setup motor followers and inversions
	public static void setupDrive() {
		frontLeftMotor2.follow(Chassis.frontLeftMotor1);
		frontRightMotor2.follow(Chassis.frontRightMotor1);
		
		rearLeftMotor2.follow(Chassis.rearLeftMotor1);
		rearRightMotor2.follow(Chassis.rearRightMotor1);
		
	}
}
