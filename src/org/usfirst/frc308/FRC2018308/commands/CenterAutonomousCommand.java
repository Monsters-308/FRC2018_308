
package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAutonomousCommand extends CommandGroup {

	public CenterAutonomousCommand() {
		addSequential(new AutonomousExtendArm());
		addParallel(new AutonomousRaiseArmSwitch());
		addSequential(new AutonomousDrive(140, true));
		addSequential(new AutonomousOpenClaw());
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
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
