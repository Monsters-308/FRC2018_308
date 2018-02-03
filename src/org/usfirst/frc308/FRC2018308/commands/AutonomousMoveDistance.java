package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousMoveDistance extends Command {

	public AutonomousMoveDistance() {
		requires(Robot.chassis);
	}
	
	public static double getEncTics(double dist) {
		double encTics = (dist/18.84955592153876)*512;
		return encTics;
	}
	
	public void moveDistance() {
		Robot.chassis.frontLeftMotor1.set(ControlMode.Position, AutonomousDrive.getEncTics(60));
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
