
package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotConstants;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class Chassis extends Subsystem {

	public static double deadzone = 0.1;
	// Local motor instantiation from RobotMap
	public static final WPI_TalonSRX frontLeftMotor1 = RobotMap.frontLeftMotor1;
	// public static final WPI_TalonSRX frontLeftMotor2 = RobotMap.frontLeftMotor2;
	public static final WPI_TalonSRX frontRightMotor1 = RobotMap.frontRightMotor1;
	// public static final WPI_TalonSRX frontRightMotor2 =
	// RobotMap.frontRightMotor2;
	public static final WPI_TalonSRX rearLeftMotor1 = RobotMap.rearLeftMotor1;
	// public static final WPI_TalonSRX rearLeftMotor2 = RobotMap.rearLeftMotor2;
	public static final WPI_TalonSRX rearRightMotor1 = RobotMap.rearRightMotor1;
	// public static final WPI_TalonSRX rearRightMotor2 = RobotMap.rearRightMotor2;

	// Instantiate main MecanumDrive
	public MecanumDrive mainDrive = new MecanumDrive(RobotMap.frontLeftMotor1, RobotMap.rearLeftMotor1,
			RobotMap.frontRightMotor1, RobotMap.rearRightMotor1);

	// Instantiate gyro
	public static Gyro gyro = new ADXRS450_Gyro();

	@Override
	// Set default command for a subsystem
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	// Update drive outputs with current joystick values.
	public void periodic() {
		RobotConstants.frontLeftEncPos = frontLeftMotor1.getSelectedSensorPosition(0);
		SmartDashboard.putNumber("Front Left Encoder Position", frontLeftMotor1.getSelectedSensorPosition(0));
		RobotConstants.rearLeftEncPos = rearLeftMotor1.getSelectedSensorPosition(0);
		SmartDashboard.putNumber("reart Left Encoder Position", rearLeftMotor1.getSelectedSensorPosition(0));
		RobotConstants.frontRightEncPos = frontRightMotor1.getSelectedSensorPosition(0);
		SmartDashboard.putNumber("Front Right Encoder Position", frontRightMotor1.getSelectedSensorPosition(0));
		RobotConstants.rearRightEncPos = rearRightMotor1.getSelectedSensorPosition(0);
		SmartDashboard.putNumber("Rear Right Encoder Position", rearRightMotor1.getSelectedSensorPosition(0));
		
		SmartDashboard.putNumber("Chassis Angle", gyro.getAngle());
		
		SmartDashboard.putNumber("Front Left Motor Speed", frontLeftMotor1.get());
		SmartDashboard.putNumber("Rear Left Motor Speed", rearLeftMotor1.get());
		SmartDashboard.putNumber("Front Right Motor Speed", frontRightMotor1.get());
		SmartDashboard.putNumber("Rear Right Motor Speed", rearRightMotor1.get());
		
	}

	// Initialize gyro.
	public void gyro() {
		RobotConstants.angle = (int)gyro.getAngle(); // get current heading
		// RobotMap.drive(-1.0, -(RobotConstants.angle) * (RobotConstants.ChassisKp));
		// // drive towards heading 0
		// Timer.delay(0.004);
	}

	// Setup motor followers and inversions
	public static void setupDrive() {
		frontLeftMotor1.setNeutralMode(NeutralMode.Brake);
		frontLeftMotor1.setNeutralMode(NeutralMode.Brake);
		frontLeftMotor1.setNeutralMode(NeutralMode.Brake);
		frontLeftMotor1.setNeutralMode(NeutralMode.Brake);
		
		gyro.reset();
		
		frontLeftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		frontRightMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		rearLeftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		rearRightMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

		frontLeftMotor1.setSelectedSensorPosition(0, 0, 100);
		rearLeftMotor1.setSelectedSensorPosition(0, 0, 100);
		frontRightMotor1.setSelectedSensorPosition(0, 0, 100);
		rearRightMotor1.setSelectedSensorPosition(0, 0, 100);

		rearLeftMotor1.setSensorPhase(true);
		frontLeftMotor1.setSensorPhase(false);

		if(Robot.inGameMode == true) {
			frontRightMotor1.setSensorPhase(true);
			rearRightMotor1.setSensorPhase(false);
		}else {
			frontRightMotor1.setSensorPhase(false);
			rearRightMotor1.setSensorPhase(true);
		}

	}

	public void moveDistance(double percent, double heading) {
		mainDrive.driveCartesian(0.0, percent, 0.0, 0.0);
		}
	
	public void autoStrafe(double percent) {
		mainDrive.driveCartesian(percent, 0.0, 0.0, 0.0);
		}
	
	
	public void turn(double d) {
		mainDrive.driveCartesian(0, 0, d);
	}
	}

