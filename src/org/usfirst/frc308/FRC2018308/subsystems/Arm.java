package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.TeleopArm;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {

	public static final WPI_TalonSRX armMotor = RobotMap.armMotor;
	public static final WPI_TalonSRX extendArmMotor = RobotMap.extendArmMotor;
	public static int tmploop = 0;

	public static int _lastPosition = 0;
	public static int _lastPositionRate = 0;
	public static double _lastDemandSpeed = 0.0;

	public static int _maxArmTravelUp = 1950; // per arm set a max Travel positive

	public void initDefaultCommand() {
		setDefaultCommand(new TeleopArm());
	}

	public void setupArm() {
		armMotor.setInverted(true); //inverts direction
		armMotor.setSensorPhase(false);//true does not work

		armMotor.set(ControlMode.PercentOutput, 0);

		armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);

		armMotor.setSelectedSensorPosition(0, 0, 100);

		armMotor.configNominalOutputForward(0, 10);
		armMotor.configNominalOutputReverse(0, 10);
		armMotor.configPeakOutputForward(1.0, 10);
		armMotor.configPeakOutputReverse(-1.0, 10);

		_lastPosition = armMotor.getSelectedSensorPosition(0);
		_lastPositionRate = 0;
		_lastDemandSpeed = 0.0;

	}
	
	public void basicControl() {
		armMotor.set(Robot.oi.codriver.getY());
	}

	public void move() {
		if(armMotor.getSelectedSensorPosition(0) <= 0) {
			armMotor.setSelectedSensorPosition(0, 0, 100);
		}
//		System.out.println(armMotor.getSelectedSensorPosition(0));
		
//		_lastPositionRate = armMotor.getSelectedSensorPosition(0) - _lastPosition; // instanious change from previous
		_lastPositionRate = 0; // instanious change from previous
		
		
		// position
		if (-1*Robot.oi.codriver.getY() > 0.1 //FIX NEGATIVE VALUE
				&& (armMotor.getSelectedSensorPosition(0) + _lastPositionRate) < _maxArmTravelUp) 
		{ // if we continue at
				System.out.println("in move up");																					// the same rate
																									// then keep on
																									// moving
			// let us detune the last 10% of travel to slow the motion
			if ((armMotor.getSelectedSensorPosition(0) * 100) / _maxArmTravelUp >= 90) {
				armMotor.set(ControlMode.PercentOutput, Robot.oi.codriver.getY() / 2.0); // go at 1/2 Speed
				_lastDemandSpeed = (Robot.oi.codriver.getY()) / 2.0;
				System.out.println("motor should go up slow");	
			} else {
				armMotor.set(ControlMode.PercentOutput, Robot.oi.codriver.getY());
				_lastDemandSpeed = Robot.oi.codriver.getY();
				System.out.println("motor should go up normal");	
			}
		} else if (-1*Robot.oi.codriver.getY() <= -0.1
				&& (armMotor.getSelectedSensorPosition(0) - _lastPositionRate) > 0) { // if we continue down at the same
																						// rate then keep on moving
			if ((armMotor.getSelectedSensorPosition(0) * 100) / _maxArmTravelUp <= 10) {
				armMotor.set(ControlMode.PercentOutput, Robot.oi.codriver.getY() / 2.0); // go at 1/2 Speed
				_lastDemandSpeed = (Robot.oi.codriver.getY()) / 2.0;
			} else {
				armMotor.set(ControlMode.PercentOutput, Robot.oi.codriver.getY());
				_lastDemandSpeed = Robot.oi.codriver.getY();
			}

		} else { // this is in the deadband state so try to hold the position
			armMotor.setNeutralMode(NeutralMode.Brake);
			armMotor.set(ControlMode.PercentOutput, 0.0);
			_lastDemandSpeed = 0;
			
		}

		_lastPosition = armMotor.getSelectedSensorPosition(0);
	}

	public void periodic() {
//
//		if (tmploop++ % 50 == 0) { // printout every second
//			tmploop = 1;
//			System.out.println("Enc " + armMotor.getSelectedSensorPosition(0) + " Speed " + armMotor.get() + " Demand "
//					+ _lastDemandSpeed + " Rate " + _lastPositionRate + " Last Enc " + _lastPosition);
//
		SmartDashboard.putNumber("Arm Encoder", armMotor.getSelectedSensorPosition(0));
//
//		}
		SmartDashboard.putNumber("Last Position", _lastPosition);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
