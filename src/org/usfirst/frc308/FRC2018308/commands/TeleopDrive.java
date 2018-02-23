
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
		Robot.chassis.gyro();
		// Strafe Forward/Backward Turn Gyro

		double x = 0;
		double y;
		double z;

		if (Math.abs(Robot.oi.driverXbox.getRawAxis(1)) > Robot.chassis.deadzone) {
			y = Robot.oi.driverXbox.getRawAxis(1);
		} else {
			y = 0;
		}

		if (Math.abs(Robot.oi.driverXbox.getRawAxis(4)) > Robot.chassis.deadzone) {
			z = Robot.oi.driverXbox.getRawAxis(4);
		} else {
			z = 0;
		}
		 
		Robot.chassis.mainDrive.driveCartesian(x, -y, z, 0.0);
		if (Robot.oi.driverXbox.getRawAxis(2) > 0) {
			x = -Robot.oi.driverXbox.getRawAxis(2);
			Robot.chassis.mainDrive.driveCartesian(x, -y, 0, 0.0);
		}

		if (Robot.oi.driverXbox.getRawAxis(3) > 0) {
			x = Robot.oi.driverXbox.getRawAxis(3);
			Robot.chassis.mainDrive.driveCartesian(x, -y, 0, 0.0);
		} else {
			Robot.chassis.mainDrive.driveCartesian(x, -y, z, 0.0);
		}

		if (Robot.oi.driverXbox.getRawAxis(2) == 0 && Robot.oi.driverXbox.getRawAxis(3) == 0) {
			x = 0;
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
