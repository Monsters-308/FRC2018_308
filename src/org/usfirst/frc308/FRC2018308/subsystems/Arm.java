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
	public static double codriverJoystickValue;
	public static String armDirection;
	public static double maxValue = 3500; // Game Value
//	public static double maxValue = 10000;
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopArm());
	}

	public void setupArm() {
	    armMotor.setInverted(true); //inverts direction
		armMotor.setSensorPhase(true);

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
	
	public void extendArm() {
		extendArmMotor.set(ControlMode.PercentOutput, Robot.oi.codriver.getRawAxis(2) * -1);
	}

	public void move() {
		codriverJoystickValue = Robot.oi.codriver.getY();
	
		//When encoder value reads negative, reset to zero
		if(armMotor.getSelectedSensorPosition(0) <= 0) {
			armMotor.setSelectedSensorPosition(0, 0, 100);
		}
//		System.out.println(armMotor.getSelectedSensorPosition(0));

		// Arm Down
		if (codriverJoystickValue <= -0.1  && armMotor.getSelectedSensorPosition(0) > 0) {
				armMotor.setNeutralMode(NeutralMode.Coast);
				armMotor.set(ControlMode.PercentOutput, codriverJoystickValue); 
				armDirection = "Arm Down";	
				System.out.println("Arm Down");	
	
		// Move Arm Up if not already at the bottom
		} else if (codriverJoystickValue >= 0.1 && (armMotor.getSelectedSensorPosition(0) < maxValue)) { 
			//START HERE  Sending the motor a positive percentage does not drive motor down (i.e. does nothing)
			
				armMotor.setNeutralMode(NeutralMode.Coast);
				armMotor.set(ControlMode.PercentOutput, codriverJoystickValue); // go at 1/2 Speed
				armDirection = "Arm Up";
				System.out.println("Arm Up");
			
		} else { // this is in the deadband state so try to hold the position
			armMotor.setNeutralMode(NeutralMode.Brake);
//			System.out.println("Hold Position");
			armMotor.set(ControlMode.PercentOutput, 0.0);
			
		}

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
		SmartDashboard.putNumber("Joystick Value", codriverJoystickValue);
		SmartDashboard.putString("Arm Direction", "Tom");
		SmartDashboard.putNumber("Arm Output Current", armMotor.getOutputCurrent());
		SmartDashboard.putNumber("Arm Speed", armMotor.get());
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
