
package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightScaleAutonomousCommand extends CommandGroup {

	public RightScaleAutonomousCommand() {
//		addSequential(new AutonomousExtendArm());
		addSequential(new AutonomousDrive(382, true));
		addSequential(new AutonomousTurnRight(85));
		addSequential(new AutonomousDrive(50, true));
		addSequential(new AutonomousRaiseArmScale());
//		addSequential(new AutonomousDrive(50, true));
		addSequential(new AutonomousOpenClaw());
		addSequential(new AutonomousLowerArm());
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
