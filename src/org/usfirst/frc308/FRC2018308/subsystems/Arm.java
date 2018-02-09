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

	public static final WPI_TalonSRX armMotor = RobotMap.armMotor;
	public static final WPI_TalonSRX extendArmMotor = RobotMap.extendArmMotor;
	public static boolean commandPosition = false;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TeleopArm());
	}
	
	public void setupArm() {
		armMotor.setInverted(true);
		armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		armMotor.setSelectedSensorPosition(0, 0, 100);
		armMotor.configNominalOutputForward(0, 0);
		armMotor.configNominalOutputReverse(0, 0);
		armMotor.configPeakOutputForward(0.7, 0);
		armMotor.configPeakOutputReverse(-0.7, 0);
		
		armMotor.config_kD(0, 0, 0);
		armMotor.config_kI(0, 0, 0);
		armMotor.config_kP(0, 0, 0);
		armMotor.config_kF(0,  1, 0);
		
//		armMotor.configForwardSoftLimitEnable(true, 0);
		
		armMotor.configAllowableClosedloopError(0, 0, 100);
		 
		armMotor.setSensorPhase(false);
		
//		armMotor.configClosedloopRamp(1, 10);
	}

	public void moveDistance(int distance) {
		armMotor.set(ControlMode.Position, distance);//+armMotor.getSelectedSensorPosition(0));		
	}
	public void periodic() {
//		armMotor.set(Robot.oi.joystick1.getRawAxis(1)/3);
//		extendArmMotor.set(Robot.oi.joystick2.getRawAxis(5)/3);
//		if(Robot.oi.joystick1.getRawButton(4) == true) {
//			if(commandPosition == false) {
//				armMotor.set(ControlMode.Position, armMotor.getSelectedSensorPosition(0)+500);
//				commandPosition = true;
//			}			
//		}else {
//			commandPosition = false;
//		}
		
		System.out.println(armMotor.getSelectedSensorPosition(0));
		
		SmartDashboard.putNumber("Arm Encoder", armMotor.getSelectedSensorPosition(0));
	}


}
