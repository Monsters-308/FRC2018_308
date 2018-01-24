
package org.usfirst.frc308.FRC2017308.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import org.usfirst.frc308.FRC2017308.OI;
import org.usfirst.frc308.FRC2017308.Robot;
import org.usfirst.frc308.FRC2017308.RobotMap;
import org.usfirst.frc308.FRC2017308.subsystems.Chassis;
/**
 *
 */
public class drive extends Command {

    public drive() {

    	requires(Robot.chassis);

    }

    @Override
    protected void initialize() {
    	Chassis.setupDrive();
    }

   
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
