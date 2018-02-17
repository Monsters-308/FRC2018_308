package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.TeleopDrive;
import org.usfirst.frc308.FRC2018308.commands.TeleopLift;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
	public static boolean leftWingDown;
	public static boolean rightWingDown;

	public void initDefaultCommand() {
		setDefaultCommand(new TeleopLift());
	}

	public void setupLift() {
		leftWingDown = false;
		rightWingDown = false;
	}

	public void dropWingLeft() {
		if (Robot.oi.codriver.getRawButton(7) == true) {
			RobotMap.leftReleaseSolenoid.set(true);
			leftWingDown = true;
		}
	}

	public void dropWingRight() {
		if (Robot.oi.codriver.getRawButton(8) == true) {
			RobotMap.rightReleaseSolenoid.set(true);
			rightWingDown = true;
		}
	}

	public void raiseWingLeft() {
		if (Robot.oi.codriver.getRawButton(9) == true && leftWingDown == true) {
			RobotMap.leftLiftSolenoid1.set(true);
			RobotMap.leftLiftSolenoid2.set(true);
		}
	}

	public void raiseWingRight() {
		if (Robot.oi.codriver.getRawButton(10) == true && rightWingDown == true) {
			RobotMap.rightLiftSolenoid1.set(false);
			RobotMap.rightLiftSolenoid2.set(false);
		}
	}
	
	public void periodic() {
		Robot.lift.dropWingLeft();
		Robot.lift.dropWingRight();
		Robot.lift.raiseWingLeft();
		Robot.lift.raiseWingRight();
	}

}
