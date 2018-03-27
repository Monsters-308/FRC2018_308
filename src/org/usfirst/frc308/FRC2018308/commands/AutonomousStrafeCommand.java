package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousStrafeCommand extends CommandGroup{

	public AutonomousStrafeCommand()  {
//		addParallel(new AutonomousRaiseArmSwitch());
		addSequential(new AutonomousStrafeTest(60, true));
		addSequential(new AutonomousStrafeTest(60, false));
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
