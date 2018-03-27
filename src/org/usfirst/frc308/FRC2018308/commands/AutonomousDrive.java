package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.subsystems.Chassis;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDrive extends Command {
	public double distance;
	public boolean dir;
	public double distanceTrav;

	public static double highSpeed;
	public static double lowSpeed;

	public static double heading;

	public AutonomousDrive(double inches, boolean direction) { // true is forward, false is backward
		// requires(Robot.chassis);
		highSpeed = 0.5;
		lowSpeed = 0.3;
		double dist = inches - 40;
		if (Robot.inGameMode == false) {
			distance = dist * (7.2 * Math.PI);
		} else if (Robot.inGameMode == true) {
			distance = (dist * (7.2 * Math.PI)) * 2;
		}
		dir = direction;
	}

	protected void initialize() {
		Chassis.frontLeftMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.frontRightMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.rearLeftMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.rearRightMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.gyro.reset();
		heading = Chassis.gyro.getAngle();
		Chassis.setupDrive();
	}

	public void getEnc() { // averages front two encoders if going forward, back two if going backward
		if (dir) {
			distanceTrav = (Chassis.rearLeftMotor1.getSelectedSensorPosition(0)
					+ Chassis.rearRightMotor1.getSelectedSensorPosition(0)) / 2;

		} else {
			distanceTrav = (Chassis.rearLeftMotor1.getSelectedSensorPosition(0)
					+ Chassis.rearRightMotor1.getSelectedSensorPosition(0) / 2) * -1;
		}

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		getEnc();
		if (distanceTrav < distance) { // go faster if in greater than 10% of the move but less than 90%
			if (distanceTrav * 100 / distance > 10 || distanceTrav * 100 / distance < 90) {
				if (dir == true) {
					Robot.chassis.moveDistance(highSpeed, 0);
				} else {
					Robot.chassis.moveDistance(-highSpeed, 0);
				}
				getEnc();
			} else if (distanceTrav * 100 / distance > 90 || distanceTrav * 100 / distance > 10) { // go slower in first
																									// and last 10% of
																									// the move
				if (dir == true) {
					Robot.chassis.moveDistance(lowSpeed, 0);
				} else {
					Robot.chassis.moveDistance(-lowSpeed, 0);
				}
				getEnc();
			}
		} else { // stop moving
			Robot.chassis.moveDistance(0.0, 0.0);
		}
	}

	protected boolean isFinished() { // checks to see if target has been met
		// TODO Auto-generated method stub
		getEnc();
		if (distanceTrav >= distance) {
			return true;
		}
		return false;
	}
}
