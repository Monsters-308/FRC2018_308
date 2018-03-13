package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnRight extends Command {
	public double degrees;
	public double degreesTrav;
	
	public AutonomousTurnRight(double deg)
	{
//		requires(Robot.chassis);
		degrees = deg-3;
	}
	
	protected void initialize()  //resets gyro
	{
		Chassis.setupDrive();
		System.out.println("in auto turn right");

	}
	
	public void currentHeading() // gets current heading from gyro 
	{
		degreesTrav = (Chassis.gyro.getAngle());
		System.out.println("current angle " + Chassis.gyro.getAngle());
	}
	protected void execute()
	{
		currentHeading();
		if(degreesTrav < degrees)
		{
			if(degreesTrav * 100 / degrees > 10 && degreesTrav * 100/degrees < 80) // go faster if greater than 10% of move but less than 90%
			{
					Robot.chassis.turn(0.4);
					currentHeading();
			}
			else if(degreesTrav * 100 / degrees < 10 || degreesTrav * 100 / degrees > 80)// slow down if in first 10% or last 10% of the move
			{
				Robot.chassis.turn(0.4); //go clockwise
				currentHeading();
			}
		}
		else // stop moving 
		{
			Robot.chassis.turn(0.0);
		}
	}
	
	@Override
	protected boolean isFinished() { // checks to see if the target has been met
		if(degreesTrav >= degrees)
		{
			return true;
		}
		return false;
	}
	
}