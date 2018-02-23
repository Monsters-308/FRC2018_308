package org.usfirst.frc308.FRC2018308.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.*;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;

public class Claw extends Subsystem {

	public static Solenoid clawSolenoid = RobotMap.clawSolenoid;

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TeleopClaw());
	}

	@Override
	public void periodic() {
		Robot.claw.openClaw();
	}
	
	public void openClaw() {
		if(Robot.oi.codriver.getRawButton(3) == true) {
			Claw.clawSolenoid.set(false);
		}
		if(Robot.oi.codriver.getRawButton(1) == true) {
			Claw.clawSolenoid.set(true);
		}
	}
	

}
