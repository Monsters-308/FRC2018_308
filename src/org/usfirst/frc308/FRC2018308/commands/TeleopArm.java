
package org.usfirst.frc308.FRC2018308.commands;
import org.usfirst.frc308.FRC2018308.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopArm extends Command {

    public TeleopArm() {
    	requires(Robot.arm);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	Robot.arm.periodic();
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
