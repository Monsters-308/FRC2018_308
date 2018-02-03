
package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotConstants;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
	public static AnalogInput input = new AnalogInput(0);

	// Instantiate main MecanumDrive
	public MecanumDrive mainDrive = new MecanumDrive(RobotMap.frontLeftMotor1, RobotMap.rearLeftMotor1,
			RobotMap.frontRightMotor1, RobotMap.rearRightMotor1);

	// Instantiate gyro
	public static SPI gyro = new SPI(Port.kOnboardCS0);

	@Override
	// Set default command for a subsystem
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	// Update drive outputs with current joystick values.
	public void periodic() {
		// Strafe Forward/Backward Turn Gyro
		 mainDrive.driveCartesian(Robot.oi.joystick1.getRawAxis(4),
		 -Robot.oi.joystick1.getRawAxis(5), Robot.oi.joystick1.getRawAxis(0),
		 RobotConstants.angle);
//		mainDrive.driveCartesian(Robot.oi.joystick2.getX(), -Robot.oi.joystick1.getY(), Robot.oi.joystick1.getX(),
	//			RobotConstants.angle);

		RobotConstants.frontLeftEncPos = frontLeftMotor1.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber("Front Left Encoder Value 0", RobotConstants.frontLeftEncPos);

		RobotConstants.rearLeftEncPos = rearLeftMotor1.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber("Rear Left Encoder Value 4", RobotConstants.rearLeftEncPos);

		RobotConstants.frontRightEncPos = frontRightMotor1.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber("Front Right Encoder Value 2", RobotConstants.frontRightEncPos);

		RobotConstants.rearRightEncPos = rearRightMotor1.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber("Rear Right Encoder Value 6", RobotConstants.rearRightEncPos);

		double dist = input.getValue();
		
		SmartDashboard.putNumber("Distance:", dist);
		
		SmartDashboard.putNumber("Angle:", RobotConstants.angle);
	}

	// Initialize gyro.
/*	public void gyro() {
		RobotConstants.angle = gyro.getAngle(); // get current heading
		RobotMap.drive(-1.0, -(RobotConstants.angle) * (RobotConstants.ChassisKp)); // drive towards heading 0
		Timer.delay(0.004);
		gyro = new AnalogGyro(1);
	}
*/
	// Setup motor followers and inversions
	public static void setupDrive() {
		frontLeftMotor2.follow(Chassis.frontLeftMotor1);
		frontRightMotor2.follow(Chassis.frontRightMotor1);

		rearLeftMotor2.follow(Chassis.rearLeftMotor1);
		rearRightMotor2.follow(Chassis.rearRightMotor1);

		frontLeftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		frontRightMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		rearLeftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		rearRightMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		frontLeftMotor1.config_kP(0, 0, 0);
		frontLeftMotor1.config_kI(0, 0, 0);
		frontLeftMotor1.config_kD(0, 0, 0);

		frontRightMotor1.config_kP(0, 0, 0);
		frontRightMotor1.config_kI(0, 0, 0);
		frontRightMotor1.config_kD(0, 0, 0);

		rearLeftMotor1.config_kP(0, 0, 0);
		rearLeftMotor1.config_kI(0, 0, 0);
		rearLeftMotor1.config_kD(0, 0, 0);

		rearRightMotor1.config_kP(0, 0, 0);
		rearRightMotor1.config_kI(0, 0, 0);
		rearRightMotor1.config_kD(0, 0, 0);
		
		
	}
}
