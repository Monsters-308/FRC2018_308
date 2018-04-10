
package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DiagonalLeftAutonomousCommand extends CommandGroup {

	public DiagonalLeftAutonomousCommand() {
		addSequential(new AutonomousDrive(50, true));
		addSequential(new AutonomousTurnLeft(-45));
		addSequential(new AutonomousDrive(95, true));
		addSequential(new AutonomousTurnRight(55));
		addSequential(new AutonomousRaiseArmSwitch());
		addSequential(new AutonomousDrive(90, true));
		addSequential(new AutonomousOpenClaw());
		addSequential(new AutonomousDrive(70, false));
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
