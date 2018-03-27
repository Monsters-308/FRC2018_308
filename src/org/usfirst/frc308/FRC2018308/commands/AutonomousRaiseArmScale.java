package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousRaiseArmScale extends Command {

	public static double switchHeight = 3500;

	protected void initialize() {
		Robot.arm.setupArm();
		System.out.println("Initializing Auro Raise Arm");
	}

	protected void execute() {
		System.out.println("Executing Raise Arm");
		Robot.arm.autoRaiseArmScale();
	}

	@Override
	protected boolean isFinished() {
//		// TODO Auto-generated method stub
		if (Arm.armMotor.getSelectedSensorPosition(0) >= Arm.maxArmHeight) {
			return true;
		}
		return false;
	}

}
