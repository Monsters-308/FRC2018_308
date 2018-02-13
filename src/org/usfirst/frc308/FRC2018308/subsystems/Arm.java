package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotConstants;
import org.usfirst.frc308.FRC2018308.RobotMap;
//import org.usfirst.frc308.FRC2018308.commands.TeleopArm;
import org.usfirst.frc308.FRC2018308.commands.TeleopArm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {

	public static WPI_TalonSRX armMotor = RobotMap.armMotor;
	public static WPI_TalonSRX extendArmMotor = RobotMap.extendArmMotor;
	public static boolean commandPosition = false;
	public static int tmploop = 0;
	public static int targetPosition = 0;
//	public double current = 0;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TeleopArm());
	}
	
	public void setupArm() {
//		armMotor.setInverted(true);
//		armMotor.set(ControlMode.Position, 0);
//		current = 0;
//		
//		armMotor.setSelectedSensorPosition(0, 0, 0);
//	    armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
//		armMotor.setSelectedSensorPosition(0, 0, 100);
//		armMotor.configNominalOutputForward(0, 10);
//		armMotor.configNominalOutputReverse(0, 10);
//		armMotor.configPeakOutputForward(0.7, 10);
//		armMotor.configPeakOutputReverse(-0.7, 10);
//		
//		armMotor.config_kD(0, 0.05, 10);
//		armMotor.config_kI(0, 0.001, 10);
//		armMotor.config_kP(0, 0.01, 10);
//		armMotor.config_kF(0,  1, 10);
//		
//		
//		armMotor.configAllowableClosedloopError(0, 16, 100);
//		armMotor.setSensorPhase(false);
		
	}

	public void moveDistance(double dist) {
		armMotor.configForwardSoftLimitEnable(true, 10);
		armMotor.configForwardSoftLimitThreshold(targetPosition / 2, 10);
		armMotor.configClosedloopRamp(1, 10);
		targetPosition += dist;
		armMotor.set(ControlMode.Position, targetPosition);
				
	}
	
	public void controlArm() {
		armMotor.set(ControlMode.PercentOutput, Robot.oi.joystick1.getY());
		
	}
//	
//	public void moveCurrent() {
//		if(Robot.oi.joystick1.getRawButton(2) == true) {
//			current += 0.01;
//		}
//		
//		armMotor.set(ControlMode.Current, current);
//	}	
//	
//	public void moveSpeed() {
//		armMotor.set(ControlMode.PercentOutput, Robot.oi.joystick1.getY());//+armMotor.getSelectedSensorPosition(0));		
//	}
//	
	public void periodic() {

		Robot.arm.controlArm();
		if(tmploop++ % 50 == 0) {
			tmploop = 1;
			System.out.println(armMotor.getSelectedSensorPosition(0)+" Error "+armMotor.getClosedLoopError(0)+" Target "+armMotor.getClosedLoopTarget(0));
			
			
			SmartDashboard.putNumber("Arm Encoder", armMotor.getSelectedSensorPosition(0));
			
		}
	}


}
