package org.usfirst.frc308.FRC2018308.commands;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.subsystems.Claw;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousOpenClaw extends Command{
	public AutonomousOpenClaw() {
		
	}
	
	protected void initialize() {
		Claw.clawSolenoid.set(false);
	}
	
	protected void execute() {
		Robot.claw.autoOpenClaw();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(Claw.clawSolenoid.get() == true) {
			return true;
		}else {
		return false;
	}
	}

}
