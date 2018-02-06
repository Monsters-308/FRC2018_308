
package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopClaw extends Command {

	public TeleopClaw() {

	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if (Robot.oi.joystick2.getRawButton(2) == true) {
			Robot.claw.openClaw();
		} else {
			Robot.claw.closeClaw();
		}
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
