package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class TeleopArm extends Command {

	public TeleopArm() {
		requires(Robot.arm);
	}

	protected void initialize() {
		System.out.println("initialize");
		Robot.arm.setupArm();
	}

	protected void execute() {
	//Robot.arm.basicControl(); //Test Code
	Robot.arm.move();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
