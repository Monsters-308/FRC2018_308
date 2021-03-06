
package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitchAutonomousCommand extends CommandGroup {

	public RightSwitchAutonomousCommand() {
		addSequential(new AutonomousDrive(160, true));
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
