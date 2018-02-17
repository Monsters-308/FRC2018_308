
package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopClaw extends Command {

	public static boolean clawOpen = false;

	public TeleopClaw() {
		requires(Robot.claw);

	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.claw.periodic();
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
