package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousRaiseArmSwitch extends Command {

	public static double switchHeight = 3500;

	protected void initialize() {
		Robot.arm.setupArm();
		
	}

	protected void execute() {
		Robot.arm.autoRaiseArmSwitch();
	}

	@Override
	protected boolean isFinished() {
//		// TODO Auto-generated method stub
		if (Arm.armMotor.getSelectedSensorPosition(0) > switchHeight) {
			return true;
		}
		return false;
	}

}
