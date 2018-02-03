
package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc308.FRC2018308.Robot;
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
		Robot.chassis.periodic();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
