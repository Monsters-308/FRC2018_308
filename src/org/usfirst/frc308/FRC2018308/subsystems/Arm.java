package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.RobotConstants;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.TeleopArm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{

	public static final WPI_TalonSRX armMotor = RobotMap.armMotor;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TeleopArm());
	}

	public void periodic() {
		armMotor.set(RobotConstants.joyArm);
	}

}
