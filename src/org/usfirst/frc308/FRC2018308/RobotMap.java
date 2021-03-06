// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc308.FRC2018308;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static WPI_TalonSRX armMotor;
	public static WPI_TalonSRX frontLeftMotor1;
//	public static WPI_TalonSRX frontLeftMotor2;
	public static WPI_TalonSRX frontRightMotor1;
//	public static WPI_TalonSRX frontRightMotor2;
	public static WPI_TalonSRX rearLeftMotor1;
//	public static WPI_TalonSRX rearLeftMotor2;
	public static WPI_TalonSRX rearRightMotor1;
//	public static WPI_TalonSRX rearRightMotor2;
	public static WPI_TalonSRX extendArmMotor;
	public static Compressor pneumaticsCompressor1;
	public static Solenoid pneumaticspusherSolenoid;
	public static Solenoid clawSolenoid;
	public static Solenoid leftReleaseSolenoid;
	public static Solenoid leftLiftSolenoid;
	public static Solenoid rightReleaseSolenoid;
	public static Solenoid rightLiftSolenoid;
	public static DigitalInput armExtensionLimitSwitch;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	@SuppressWarnings("deprecation")
	public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		armExtensionLimitSwitch = new DigitalInput(0);
		
        armMotor = new WPI_TalonSRX(8);
        LiveWindow.addActuator("Arm", "CAN Talon 9", armMotor);
        
        frontLeftMotor1 = new WPI_TalonSRX(0);
        LiveWindow.addActuator("Chassis", "CAN Talon 1", frontLeftMotor1);
        
//        frontLeftMotor2 = new WPI_TalonSRX(1);
//        LiveWindow.addActuator("Chassis", "CAN Talon 2", frontLeftMotor2);
        
        frontRightMotor1 = new WPI_TalonSRX(2);
        LiveWindow.addActuator("Chassis", "CAN Talon 3", frontRightMotor1);
        
//        frontRightMotor2 = new WPI_TalonSRX(3);
//        LiveWindow.addActuator("Chassis", "CAN Talon 4", frontRightMotor2);
        
        rearLeftMotor1 = new WPI_TalonSRX(4);
//        rearLeftMotor1 = new WPI_TalonSRX(5);
        LiveWindow.addActuator("Chassis", "CAN Talon 5", rearLeftMotor1);
        
//        rearLeftMotor2 = new WPI_TalonSRX(5);
//        rearLeftMotor2 = new WPI_TalonSRX(4);
//        LiveWindow.addActuator("Chassis", "CAN Talon 6", rearLeftMotor2);
        
        rearRightMotor1 = new WPI_TalonSRX(6);
        LiveWindow.addActuator("Chassis", "CAN Talon 7", rearRightMotor1);
        
//        rearRightMotor2 = new WPI_TalonSRX(7);
//        LiveWindow.addActuator("Chassis", "CAN Talon 8", rearRightMotor2);
        
        extendArmMotor = new WPI_TalonSRX(9);
        LiveWindow.addActuator("Arm", "CAN Talon 10", extendArmMotor);
        
        pneumaticsCompressor1 = new Compressor(0);
        LiveWindow.addActuator("Pneumatics", "Compressor 1", pneumaticsCompressor1);
            
//      Warning, the two modules in robot builder are different!
        
//        LiveWindow.addActuator("Pneumatics", "clawSolenoid", clawSolenoid);
        
        if(Robot.inGameMode == false) {
        	rearLeftMotor1 = new WPI_TalonSRX(5);
        	clawSolenoid = new Solenoid(2);
        	leftReleaseSolenoid = new Solenoid(4);
            leftLiftSolenoid = new Solenoid(0);
            rightReleaseSolenoid = new Solenoid(3);
            rightLiftSolenoid = new Solenoid(1);
       }
        if(Robot.inGameMode == true){
        	rearLeftMotor1 = new WPI_TalonSRX(4);
        	clawSolenoid = new Solenoid(4);
        	leftReleaseSolenoid = new Solenoid(3);
            leftLiftSolenoid = new Solenoid(2);
            rightReleaseSolenoid = new Solenoid(1);
            rightLiftSolenoid = new Solenoid(0);
        }
       

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
}

	public static void drive(double d, double e) {
		// TODO Auto-generated method stub

	}

}
