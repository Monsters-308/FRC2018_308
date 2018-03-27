package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousStrafeTest extends Command {

	public static double distance;
	public AutonomousStrafeTest(double dist, boolean direction) { // true is forward, false is backward
		// requires(Robot.chassis);
		if(direction == true) {
			distance  = dist;
		}else if(direction == false) {
			distance  = -dist;
		}
		
	}
	
	protected void initialize() {
		Chassis.frontLeftMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.frontRightMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.rearLeftMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.rearRightMotor1.setSelectedSensorPosition(0, 0, 100);
		Chassis.gyro.reset();
		Chassis.setupDrive();
	}

	protected void execute() {
		Robot.chassis.autoStrafe(distance);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
