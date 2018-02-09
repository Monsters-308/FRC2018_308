package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class TeleopArm extends Command {

	static boolean moving = false;
	public TeleopArm() {
		requires(Robot.arm);
	}

	protected void initialize() {
		Robot.arm.setupArm();
	}

	protected void execute() {
		if(Robot.oi.joystick1.getRawButton(1) == true) {
			if(moving == false) {
				Robot.arm.moveDistance(500);
				moving = true;
			}			
		}else {
			moving = false;
		}	
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
