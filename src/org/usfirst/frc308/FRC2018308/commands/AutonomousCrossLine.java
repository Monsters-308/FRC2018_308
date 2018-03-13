package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossLine extends CommandGroup{

	public AutonomousCrossLine() {
		addSequential(new AutonomousDrive(140, true));
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
