package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousExtendArm extends Command{

	public void initialize() {
		Robot.arm.setupArm();
	}
	public void execute() {
		Robot.arm.autoExtendArm();
	}
	@Override
	protected boolean isFinished() {
		if(Arm.limitSwitchState == false) {
			return true;
		}else {
		// TODO Auto-generated method stub
		return false;
		}
	}

}
