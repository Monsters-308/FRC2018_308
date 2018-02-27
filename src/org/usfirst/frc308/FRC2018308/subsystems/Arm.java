package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.Robot;
import org.usfirst.frc308.FRC2018308.RobotMap;
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

	public static final WPI_TalonSRX armMotor = RobotMap.armMotor;
	public static final WPI_TalonSRX extendArmMotor = RobotMap.extendArmMotor;
	public static DigitalInput armInnerLimitSwitch = new DigitalInput(1);
	public static int tmploop = 0;

	public static double armExtension = 0;
	public static int _lastPosition = 0;
	public static int _lastPositionRate = 0;
	public static double _lastDemandSpeed = 0.0;
	public static double codriverJoystickValue;
	public static String armDirection;
	public static double maxArmHeight; // Game Value
	public static double maxArmExtension;
	public static double armUDPackageZoneMidPoint = 1075;
	public static double armUDPackageZoneLowerLimit = 156;
	public static double armUDPackageZoneUpperLimit = 2000;

	// public static double maxValue = 10000;
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopArm());
	}

	public void setupArm() {
		armMotor.setInverted(true); // inverts direction
		armMotor.setSensorPhase(true);

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
			maxArmExtension = 48056;
			maxArmHeight = 4700;
			armUDPackageZoneMidPoint = 1075;
			armUDPackageZoneLowerLimit = 156;
			armUDPackageZoneUpperLimit = 2000;
		} else if (Robot.inGameMode == true) {
			maxArmExtension = 45315;
			maxArmHeight = 9500;
			armUDPackageZoneMidPoint = 1075;
			armUDPackageZoneLowerLimit = 156;
			armUDPackageZoneUpperLimit = 2000;
		}
	}
	
	public void ketteringArmExtension() {
		if(Robot.oi.codriver.getRawButton(6) == true && extendArmMotor.getSelectedSensorPosition(0) < maxArmExtension ) {
			extendArmMotor.set(1.0);
		}else if(Robot.oi.codriver.getRawButton(4) == true) {
			extendArmMotor.set(-1.0);
		}
	}

	public void extendArm() {
		armExtension = extendArmMotor.getSelectedSensorPosition(0);
		
//		if(extendArmMotor.getSelectedSensorPosition(0) < 0) {
//			extendArmMotor.setSelectedSensorPosition(0, 0, 100);
//		}
		//If In/Out Joystick is not neutral
		if (Robot.oi.codriver.getRawButton(2) == true && armExtension >= maxArmExtension) {
			extendArmMotor.set(-0.5);
			System.out.println("Retracting Arm" + extendArmMotor.getSelectedSensorPosition(0));
		}else if(Robot.oi.codriver.getZ() == 0) {
			extendArmMotor.set(0);
			System.out.println("Neutral" + extendArmMotor.getSelectedSensorPosition(0));
		}else {
			extendArmMotor.set(0);
		}

		//Zero encoder if negative
		if (armExtension < 0) {
			extendArmMotor.setSelectedSensorPosition(0, 0, 10);
		}
	}

	public void move() {
		codriverJoystickValue = Robot.oi.codriver.getY();

		// When encoder value reads negative, reset to zero
		if (armMotor.getSelectedSensorPosition(0) <= 0) {
			armMotor.setSelectedSensorPosition(0, 0, 100);
		}
		// System.out.println(armMotor.getSelectedSensorPosition(0));

		// Arm Down
		if (codriverJoystickValue <= -0.1 ) {
				//&& armMotor.getSelectedSensorPosition(0) > 0) {
			armMotor.setNeutralMode(NeutralMode.Coast);
			armMotor.set(ControlMode.PercentOutput, codriverJoystickValue);
			armDirection = "Arm Down";
			System.out.println("Arm Down");

			// Move Arm Up if not already at the bottom
		} else if (codriverJoystickValue >= 0.1 && (armMotor.getSelectedSensorPosition(0) < maxArmHeight)) {
			// START HERE Sending the motor a positive percentage does not drive motor down
			// (i.e. does nothing)

			armMotor.setNeutralMode(NeutralMode.Coast);
			armMotor.set(ControlMode.PercentOutput, codriverJoystickValue); // go at 1/2 Speed
			armDirection = "Arm Up";
			System.out.println("Arm Up");

		} else { // this is in the deadband state so try to hold the position
			armMotor.setNeutralMode(NeutralMode.Brake);
			// System.out.println("Hold Position");
			armMotor.set(ControlMode.PercentOutput, 0.0);

		}

	}

	public void periodic() {
		//
		// if (tmploop++ % 50 == 0) { // printout every second
		// tmploop = 1;
		// System.out.println("Enc " + armMotor.getSelectedSensorPosition(0) + " Speed "
		// + armMotor.get() + " Demand "
		// + _lastDemandSpeed + " Rate " + _lastPositionRate + " Last Enc " +
		// _lastPosition);
		// }

		// SmartDashboard.putNumber("Arm Up/Down Encoder",
		// armMotor.getSelectedSensorPosition(0));
		System.out.println("Arm Up/Down Encoder" + armMotor.getSelectedSensorPosition(0) + "Arm In/Out Encoder"
				+ extendArmMotor.getSelectedSensorPosition(0));

		SmartDashboard.putNumber("Last Arm Up/Down Position", _lastPosition);
		SmartDashboard.putNumber("Joystick Value", codriverJoystickValue);
		SmartDashboard.putNumber("Arm Up/Down Encoder Value", armMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Arm In/Out Encoder Value:", extendArmMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Arm Output Current", armMotor.getOutputCurrent());
		SmartDashboard.putNumber("Arm Up/Down Speed", armMotor.get());
		SmartDashboard.putBoolean("In Game Mode", Robot.inGameMode);

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
