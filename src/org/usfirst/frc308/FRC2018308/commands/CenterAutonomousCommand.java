
package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAutonomousCommand extends CommandGroup {

	public CenterAutonomousCommand() {
		System.out.println("Center");
		if (Robot.fieldLayout.equals("RRR") || Robot.fieldLayout.equals("RLR")) {
			System.out.println("Right" + " " + Robot.fieldLayout);
			addSequential(new AutonomousDrive(50, true));
			addSequential(new AutonomousTurnRight(45));
			addSequential(new AutonomousDrive(120, true));
			addSequential(new AutonomousTurnLeft(-35));
			addSequential(new AutonomousRaiseArmSwitch());
			addSequential(new AutonomousDrive(50, true));
			addSequential(new AutonomousOpenClaw());
			addSequential(new AutonomousDrive(70, false));
		}else if(Robot.fieldLayout.equals("LLL") || Robot.fieldLayout.equals("LRL")){
			System.out.println("Left" + " " + Robot.fieldLayout);
			addSequential(new AutonomousDrive(50, true));
			addSequential(new AutonomousTurnLeft(-45));
			addSequential(new AutonomousDrive(85, true));
			addSequential(new AutonomousTurnRight(55));
			addSequential(new AutonomousRaiseArmSwitch());
			addSequential(new AutonomousDrive(80, true));
			addSequential(new AutonomousOpenClaw());
			addSequential(new AutonomousDrive(70, false));
		}
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
