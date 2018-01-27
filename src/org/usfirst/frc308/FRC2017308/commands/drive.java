
package org.usfirst.frc308.FRC2017308.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc308.FRC2017308.Robot;
import org.usfirst.frc308.FRC2017308.subsystems.Chassis;
/**
 *
 */
public class drive extends Command {

	//Set subsystem requirement
    public drive() {
    	requires(Robot.chassis);
    }

    @Override
    //Initialize drivetrain setup
    protected void initialize() {
    	Chassis.setupDrive();
    }

   //Run perodic loop
	protected void execute() {
		Robot.chassis.periodic();
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
