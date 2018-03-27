package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousLowerArm extends Command {


	protected void initialize() {
		Robot.arm.setupArm();
		System.out.println("Initializing Auto Lower Arm");
	}

	protected void execute() {
		System.out.println("Executing Lower Arm");
		Robot.arm.autoLowerArm();
	}

	@Override
	protected boolean isFinished() {
//		// TODO Auto-generated method stub
		if (Arm.armMotor.getSelectedSensorPosition(0) <= 5410) {
			return true;
		}
		return false;
	}

}
