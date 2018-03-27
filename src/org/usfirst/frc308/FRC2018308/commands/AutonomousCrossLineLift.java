package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossLineLift extends CommandGroup{

	public AutonomousCrossLineLift()  {
		addParallel(new AutonomousRaiseArmSwitch());
		addSequential(new AutonomousDrive(140, true));
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
