
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

	// Instantiate main MecanumDrive
	public MecanumDrive mainDrive = new MecanumDrive(RobotMap.frontLeftMotor1, RobotMap.rearLeftMotor1,
			RobotMap.frontRightMotor1, RobotMap.rearRightMotor1);

	// Instantiate gyro
	public static Gyro gyro = null;

	@Override
	// Set default command for a subsystem
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	// Update drive outputs with current joystick values.
	public void periodic() {
		// mainDrive.driveCartesian(RobotConstants.forward, RobotConstants.strafe,
		// RobotConstants.turn, RobotConstants.angle);
		//                       Strafe                      Forward/Backward             Turn                            Gyro
		mainDrive.driveCartesian(Robot.oi.joystick2.getX(), -Robot.oi.joystick1.getY(), Robot.oi.joystick1.getX(), RobotConstants.angle);

		if (Math.abs(Robot.oi.joystick1.getY()) == 0) {
			RobotConstants.fowardError = Math
					.abs((((RobotConstants.frontRightRawValue) + (RobotConstants.rearRightRawValue)) / 2)
							- (((RobotConstants.frontLeftRawValue) + (RobotConstants.rearLeftRawValue)) / 2));
		} else {
			RobotConstants.fowardError = 0;
		}

		if (Math.abs(Robot.oi.joystick2.getX()) == 0) {
			RobotConstants.strafeError = Math
					.abs((((RobotConstants.frontRightRawValue) + (RobotConstants.frontLeftRawValue)) / 2)
							- (((RobotConstants.rearLeftRawValue) + (RobotConstants.rearRightRawValue)) / 2));
		} else {
			RobotConstants.strafeError = 0;
		}
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

		RobotMap.frontLeftEnc.setMaxPeriod(.1);
		RobotMap.frontLeftEnc.setMinRate(10);
		RobotMap.frontLeftEnc.setDistancePerPulse(5);
		RobotMap.frontLeftEnc.setReverseDirection(true);
		RobotMap.frontLeftEnc.setSamplesToAverage(7);

		RobotMap.rearLeftEnc.setMaxPeriod(.1);
		RobotMap.rearLeftEnc.setMinRate(10);
		RobotMap.rearLeftEnc.setDistancePerPulse(5);
		RobotMap.rearLeftEnc.setReverseDirection(true);
		RobotMap.rearLeftEnc.setSamplesToAverage(7);

		RobotMap.frontRightEnc.setMaxPeriod(.1);
		RobotMap.frontRightEnc.setMinRate(10);
		RobotMap.frontRightEnc.setDistancePerPulse(5);
		RobotMap.frontRightEnc.setReverseDirection(true);
		RobotMap.frontRightEnc.setSamplesToAverage(7);

		RobotMap.rearRightEnc.setMaxPeriod(.1);
		RobotMap.rearRightEnc.setMinRate(10);
		RobotMap.rearRightEnc.setDistancePerPulse(5);
		RobotMap.rearRightEnc.setReverseDirection(true);
		RobotMap.rearRightEnc.setSamplesToAverage(7);
	}
}
