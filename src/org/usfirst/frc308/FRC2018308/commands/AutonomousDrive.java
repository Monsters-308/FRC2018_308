package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Chassis;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDrive extends Command {

	public static double dist = 16;
	
	public AutonomousDrive() {
		requires(Robot.chassis);
	}

	protected void initialize() {
		Chassis.setupDrive();
	}

	// Run perodic loop
	protected void execute() {

	}

	public static double getEncTics() {
		double encTics = (dist / 18.84955592153876) * 512;
		System.out.println(encTics);
		return encTics;
	}

//	public void moveDistance() {
//		if (Chassis.rearLeftMotor1.getSelectedSensorPosition(0) < AutonomousDrive.getEncTics()) {
//			Chassis.autoDriveFoward(dist, true);
//		}
//	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(Chassis.frontLeftMotor1.getSelectedSensorPosition(0) < AutonomousDrive.getEncTics() && Chassis.frontRightMotor1.getSelectedSensorPosition(0)< AutonomousDrive.getEncTics()) {
			Chassis.autoDriveFoward(dist, true);
			return false;
		}else {
			return true;
		}
		
	}
}
