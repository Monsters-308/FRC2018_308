
package org.usfirst.frc308.FRC2018308.commands;
<<<<<<< HEAD
=======
import org.usfirst.frc308.FRC2018308.Robot;
>>>>>>> 29f66d1552bc59a2b19208eee7735ab89415595a

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {

<<<<<<< HEAD
	public AutonomousCommand() {

	}
=======
    public AutonomousCommand() {
    	addSequential(new AutonomousDrive());
    }
>>>>>>> 29f66d1552bc59a2b19208eee7735ab89415595a

	@Override
	protected void initialize() {
	}

<<<<<<< HEAD
	@Override
	protected void execute() {
	}
=======
    @Override
    protected void execute() {
    	
    }
>>>>>>> 29f66d1552bc59a2b19208eee7735ab89415595a

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
