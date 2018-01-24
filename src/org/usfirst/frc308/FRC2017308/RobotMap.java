// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc308.FRC2017308;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix. motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
   // public static WPI_TalonSRX armMotor;
    public static WPI_TalonSRX frontLeftMotor1;
    public static WPI_TalonSRX frontLeftMotor2;
    public static WPI_TalonSRX frontRightMotor1;
    public static WPI_TalonSRX frontRightMotor2;
    public static WPI_TalonSRX rearLeftMotor1;
    public static WPI_TalonSRX rearLeftMotor2;
    public static WPI_TalonSRX rearRightMotor1;
    public static WPI_TalonSRX rearRightMotor2;
    public static Compressor pneumaticsCompressor1;
    public static Solenoid pneumaticspusherSolenoid;
    public static DoubleSolenoid pneumaticsclawSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
   //     armMotor = new WPI_TalonSRX(8);
//        LiveWindow.addActuator("Arm", "CAN Talon 9", armWPI_TalonSRX9);
        
        frontLeftMotor1 = new WPI_TalonSRX(0);
//        LiveWindow.addActuator("Chassis", "CAN Talon 1", frontLeftMotor1);
        
        frontLeftMotor2 = new WPI_TalonSRX(1);
//        LiveWindow.addActuator("Chassis", "CAN Talon 2", frontLeftMotor2);
        
        frontRightMotor1 = new WPI_TalonSRX(2);
//        LiveWindow.addActuator("Chassis", "CAN Talon 3", frontRightMotor1);
        
        frontRightMotor2 = new WPI_TalonSRX(3);
//        LiveWindow.addActuator("Chassis", "CAN Talon 4", frontRightMotor2);
        
        rearLeftMotor1 = new WPI_TalonSRX(4);
//        LiveWindow.addActuator("Chassis", "CAN Talon 5", rearLeftMotor1);
        
        rearLeftMotor2 = new WPI_TalonSRX(5);
//        LiveWindow.addActuator("Chassis", "CAN Talon 6", rearLeftMotor2);
        
        rearRightMotor1 = new WPI_TalonSRX(6);
//        LiveWindow.addActuator("Chassis", "CAN Talon 7", rearRightMotor1);
        
        rearRightMotor2 = new WPI_TalonSRX(7);
//        LiveWindow.addActuator("Chassis", "CAN Talon 8", rearRightMotor2);
        
       // pneumaticsCompressor1 = new Compressor(0);
//        LiveWindow.addActuator("Pneumatics", "Compressor 1", pneumaticsCompressor1);
        
       // pneumaticspusherSolenoid = new Solenoid(1, 0);
//        LiveWindow.addActuator("Pneumatics", "pusherSolenoid", pneumaticspusherSolenoid);
        
//        Warning, the two modules in robot builder are different!
      //  pneumaticsclawSolenoid = new DoubleSolenoid(2, 1, 2);
       // LiveWindow.addActuator("Pneumatics", "clawSolenoid", pneumaticsclawSolenoid);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

	public static void drive(double d, double e) {
		// TODO Auto-generated method stub
		
	}

	
	}

