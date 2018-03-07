
package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopLift extends Command {

	public TeleopLift() {
		requires(Robot.lift);
	}

	@Override
	protected void initialize() {
		Robot.lift.setupLift();
	}

	@Override
	protected void execute() {
		Robot.lift.armWings();
		Robot.lift.periodic();
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
