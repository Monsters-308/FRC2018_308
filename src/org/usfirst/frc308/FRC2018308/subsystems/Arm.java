package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.AutonomousRaiseArmSwitch;
import org.usfirst.frc308.FRC2018308.commands.TeleopArm;
import org.usfirst.frc308.FRC2018308.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {

	public static DigitalInput limitSwitch = RobotMap.armExtensionLimitSwitch;
	public static final WPI_TalonSRX armMotor = RobotMap.armMotor;
	public static final WPI_TalonSRX extendArmMotor = RobotMap.extendArmMotor;
	public static int tmploop = 0;

	public static double armExtension = 0;
	public static int _lastPosition = 0;
	public static int _lastPositionRate = 0;
	public static double _lastDemandSpeed = 0.0;
	public static double codriverJoystickValue;
	public static String armDirection;
	public static double maxArmHeight; // Game Value
	public static double maxArmExtension;

	public static double _armDegreesAtStartOfPackage; // guess need to verify
	public static double _armEncoderAt180; // guess need to verify

	public static int _lowExtension; // guess full extension in low degrees
	public static int _lowMidExtension; // guess full extension in low to mid degrees
	public static int _midExtension; // guess full extension in mid degrees
	public static int _midHighExtension; // guess full extension in mid to high degrees
	public static int _highExtension; // guess full extension in high degrees
	public static int armAngle;
	// State of the arm limit switch that stops arm from extending beyond package.
	// Arm Limit Switch: False - Limit not Reached and Arm Not Fully Extended. True
	// - Limit Reached and Arm Fully Extended
	public static boolean limitSwitchState;

	// public static double maxValue = 10000;
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopArm());
	}

	public void setupArm() {
		armMotor.setInverted(true); // inverts direction
		armMotor.setSensorPhase(true);
		
		extendArmMotor.setNeutralMode(NeutralMode.Brake);

		armMotor.set(ControlMode.PercentOutput, 0);

		// Arm Up/Down Configurations
		armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		armMotor.setSelectedSensorPosition(0, 0, 100);

		armMotor.configNominalOutputForward(0, 10);
		armMotor.configNominalOutputReverse(0, 10);
		armMotor.configPeakOutputForward(1.0, 10);
		armMotor.configPeakOutputReverse(-1.0, 10);

		// Arm In/Out Configuration
		extendArmMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		extendArmMotor.setSelectedSensorPosition(0, 0, 10);
		extendArmMotor.setSensorPhase(false);

		_lastPosition = armMotor.getSelectedSensorPosition(0);
		armExtension = extendArmMotor.getSelectedSensorPosition(0);
		_lastPositionRate = 0;
		_lastDemandSpeed = 0.0;
		

		// WARNING: inGameMode MUST be set to True in code prior to deployment to be
		// correct during Game Matches
		if (Robot.inGameMode == false) {
			// Used in the Arm In/Out logic
			maxArmHeight = 7900;
			_armDegreesAtStartOfPackage = 45; // Was 52 guess need to verify
			_armEncoderAt180 = 4700; // guess need to verify

			_lowExtension = 101633; // guess full extension in low degrees
			_lowMidExtension = 60589; // guess full extension in low to mid degrees
			_midExtension = 60589; // guess full extension in mid degrees
			_midHighExtension = 101633; // guess full extension in mid to high degrees
			_highExtension = 101633; // guess full extension in high degrees

		} else if (Robot.inGameMode == true) {
			maxArmHeight = 9500; // guess need to verify
			_armEncoderAt180 = 9500; // guess need to verify
			_armDegreesAtStartOfPackage = 45;
			_lowExtension = 101633; // guess full extension in low degrees
			_lowMidExtension = 60589; // guess full extension in low to mid degrees
			_midExtension = 60589; // guess full extension in mid degrees
			_midHighExtension = 101633; // guess full extension in mid to high degrees
			_highExtension = 101633; // guess full extension in high degrees

		}
	}

	public void extendArmManual() {

		// Tom: Added this to the Manual functional as it was only being called from
		// Auto. Put in a central place
		armExtension = extendArmMotor.getSelectedSensorPosition(0);
		limitSwitchState = limitSwitch.get();

		// If CoDriver Joystick Bottom Button then Retract Arm
		if (Robot.oi.codriver.getRawButton(4) == true) {
			extendArmMotor.set(-0.5);
			// Else If CoDriver Joystick Top Button then Extent Arm
		} else if (Robot.oi.codriver.getRawButton(6) == true && limitSwitchState == true) {
			extendArmMotor.set(0.5);
			// Else Netural
		} else {
			extendArmMotor.set(0);
		}

	}

	public void extendArmAutomaticCase() {
		// Arm Limit Switch: False - Limit not Reached and Arm Not Fully Extended. True
		// - Limit Reached and Arm Fully Extended
		limitSwitchState = limitSwitch.get();
		
		if(Lift.leftWingDown == true || Lift.rightWingDown == true) {
			Arm.extendArmMotor.set(0);
		}
		
		if(extendArmMotor.getSelectedSensorPosition(0) >= 101663) {
			extendArmMotor.set(0);
		}
		
//		IF(EXTENDARMMOTOR.GETSELECTEDSENSORPOSITION(0) <= 12021) {
//			EXTENDARMMOTOR.SET(0);
//		}

		if(armMotor.getSelectedSensorPosition(0) < 0) {
			armMotor.setSelectedSensorPosition(0, 0, 100);
		}
		// Sets arm extension encoder to pre-determined max value when limitswitch is
		// pressed
		if (limitSwitchState == false) {
			extendArmMotor.setSelectedSensorPosition(101663, 0, 100);
		}
//		if(extendArmMotor.getSelectedSensorPosition(0) <= 100) {
//			armMotor.set(0.2);
//		}

		// If the Arm Up or Down buttons on the CoDriver Joystick are not selected
		// OR CoDriver Button 11 Override is not held down

		// System.out.println("In Auto");
		if (Robot.oi.codriver.getRawButton(4) == false && Robot.oi.codriver.getRawButton(6) == false
				&& Robot.oi.codriver.getRawButton(11) == false) {
			// System.out.println("In Function");
			armExtension = extendArmMotor.getSelectedSensorPosition(0);
			
			// if we want to stay in package then we get the arm angle and then modify
			// the maximum extend before the joystick moves it.
			// break up the angle in groups of 10 example 90 degrees = 9, 180 degrees = 18
			if(Lift.leftWingDown == false || Lift.rightWingDown == false) {
			switch ((int) (armAngle / 10.0)) {

			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				// allow arm to do low extension
				if (limitSwitchState == true) {
					extendArmMotor.set(0.5);
//					System.out.println("Neutral" + extendArmMotor.getSelectedSensorPosition(0));
				}
				break;
			case 8:
			case 9:
			case 10:
			case 11:
				if (armExtension > _lowMidExtension) {
					extendArmMotor.set(-1.0);
//					System.out.println("Neutral" + extendArmMotor.getSelectedSensorPosition(0));
				}
				break;

//Move 12 - 19 up for inspection
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
			case 18:
			case 19:
				if (limitSwitchState == true) {
					extendArmMotor.set(1.0);
					System.out.println("Neutral" + extendArmMotor.getSelectedSensorPosition(0));
				}
				break;
				// allow arm to do low to mid extension
				
				// allow arm to do mid extension
				

			default:
				
				;
				// we don't want to limit if out of control to allow the extension to be
				// retracted
			} // end of case

		}
		}// end of If Joystick is in control

	} // end of function

	public double getArmAngle() {
		double retval = 0.0;
		// define the arm angle in reference to encoder value of the arm
		// we want the angle to represent when the extension should be at the lowest
		// maximum extension
		// 90.0 = the lowest possible maximum extension
		// 180.0 = the greatest possible maximum extension
		// assumption that the arm encoder value of 0 = _armDegreesAtStartOfPackage
		// assumption that the arm encoder value of _armEncoderAt180 = 180 degrees
		// now determine the range of encoder over a range of degrees
		// ratio degree/encoder = (180 - _armDegreesAtStartOfPackage) / _armEncoderAt180
		int armPosition = armMotor.getSelectedSensorPosition(0);
		if (armPosition <= 0) {
			armPosition = 0;
		}
		retval = (double) (armPosition * ((180.0 - _armDegreesAtStartOfPackage) / _armEncoderAt180))
				+ _armDegreesAtStartOfPackage;

		armAngle = (int) retval;
		// System.out.println("Arm Angle: " + armAngle);
		return retval;
	}

	// Despite the reallllly generic name of "Move", this code Moves the Arm Up and
	// Down
	public void move() {
		codriverJoystickValue = Robot.oi.codriver.getY();

		// When encoder value reads negative, reset to zero
		if (armMotor.getSelectedSensorPosition(0) <= 0) {
			armMotor.setSelectedSensorPosition(0, 0, 100);
		}
		// System.out.println(armMotor.getSelectedSensorPosition(0));

		// Arm Down
		if (codriverJoystickValue <= -0.1) {
			// && armMotor.getSelectedSensorPosition(0) > 0) {
			armMotor.setNeutralMode(NeutralMode.Coast);
			armMotor.set(ControlMode.PercentOutput, codriverJoystickValue);
			armDirection = "Arm Down";
			// System.out.println("Arm Down");

			// Move Arm Up if not already at the bottom
		} else if (codriverJoystickValue >= 0.1 && (armMotor.getSelectedSensorPosition(0) < maxArmHeight)) {
			// START HERE Sending the motor a positive percentage does not drive motor down
			// (i.e. does nothing)

			armMotor.setNeutralMode(NeutralMode.Coast);
			armMotor.set(ControlMode.PercentOutput, codriverJoystickValue); // go at 1/2 Speed
			armDirection = "Arm Up";
			// System.out.println("Arm Up");

		} else { // this is in the deadband state so try to hold the position
			armMotor.setNeutralMode(NeutralMode.Brake);
			// System.out.println("Hold Position");
			armMotor.set(ControlMode.PercentOutput, 0.0);

		}

	}

	public void periodic() {
		SmartDashboard.putNumber("Arm Up/Down Encoder", armMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Arm In/Out Encoder", extendArmMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Arm Angle", Arm.armAngle);
		SmartDashboard.putBoolean("Arm Limit Switch State" , Arm.limitSwitchState);
		
		System.out.println(
				"armExtension = " + armExtension + "arm up/down encoder" + armMotor.getSelectedSensorPosition(0) +" Actual Arm Extension: " + extendArmMotor.getSelectedSensorPosition(0));

	}

	public void autoRaiseArmSwitch() {
//		Arm.armMotor.set(ControlMode.Current, 0.75);
		if(armMotor.getSelectedSensorPosition(0) < AutonomousRaiseArmSwitch.switchHeight) {
			armMotor.set(0.5);
			System.out.println("In AutoRaiseArm");
		}else {
			System.out.println("Arm isn't raising");
		}
	}
	public void autoRaiseArmScale() {
//		Arm.armMotor.set(ControlMode.Current, 0.75);
		if(armMotor.getSelectedSensorPosition(0) < Arm.maxArmHeight) {
			armMotor.set(1.0);
			System.out.println("In AutoRaiseArm");
		}else {
			System.out.println("Arm isn't raising");
		}
	}
	
	public void autoExtendArm() {
	if(limitSwitchState == true) {
		extendArmMotor.set(1.0);
	}
	}
	public void autoLowerArm() {
		if(armMotor.getSelectedSensorPosition(0) >= 5410) {
			armMotor.set(-0.5);
		}
		}

	protected boolean isFinished() {
		// TODO Auto-generated method stub

			return false;
	}
}



