
package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.subsystems.Chassis;

/**
 *
 */
public class TeleopDrive extends Command {

	// Set subsystem requirement
	public TeleopDrive() {
		requires(Robot.chassis);
	}

	@Override
	// Initialize drivetrain setup
	protected void initialize() {
		Chassis.setupDrive();
	}

	// Run perodic loop
	protected void execute() {
		// Robot.chassis.gyro();
		Robot.chassis.periodic();
		if(Math.abs(Robot.oi.driverXbox.getRawAxis(1)) <= 0.2 && Math.abs(Robot.oi.driverXbox.getRawAxis(0)) <= 0.2 && Math.abs(Robot.oi.driverXbox.getRawAxis(4)) <= 0.2 ) {
			RobotMap.frontLeftMotor1.set(0);
			RobotMap.frontRightMotor1.set(0);
			RobotMap.rearLeftMotor1.set(0);
			RobotMap.rearRightMotor1.set(0);
			RobotMap.frontLeftMotor2.set(0);
			RobotMap.frontRightMotor2.set(0);
			RobotMap.rearLeftMotor2.set(0);
			RobotMap.rearRightMotor2.set(0);
		}

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// Egit test
	}

	@Override
	protected void interrupted() {
	}
}
