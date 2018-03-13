
package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAutonomousCommand extends CommandGroup {

	public RightAutonomousCommand() {
		addSequential(new AutonomousExtendArm());
		addSequential(new AutonomousDrive(192, true));
		addSequential(new AutonomousRaiseArmSwitch());
		addSequential(new AutonomousTurnLeft(-90));
		addSequential(new AutonomousDrive(50, true));
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
