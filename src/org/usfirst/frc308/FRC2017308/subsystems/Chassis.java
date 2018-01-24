
package org.usfirst.frc308.FRC2017308.subsystems;

import org.usfirst.frc308.FRC2017308.RobotMap;
import org.usfirst.frc308.FRC2017308.commands.*;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import org.usfirst.frc308.FRC2017308.OI;
import org.usfirst.frc308.FRC2017308.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/**
 *
 */
public class Chassis extends Subsystem {

	//Local motor instantiation from RobotMap 
    public static final WPI_TalonSRX frontLeftMotor1 = RobotMap.frontLeftMotor1;
    public static final WPI_TalonSRX frontLeftMotor2 = RobotMap.frontLeftMotor2;
    public static final WPI_TalonSRX frontRightMotor1 = RobotMap.frontRightMotor1;
    public static final WPI_TalonSRX frontRightMotor2 = RobotMap.frontRightMotor2;
    public static final WPI_TalonSRX rearLeftMotor1 = RobotMap.rearLeftMotor1;
    public static final WPI_TalonSRX rearLeftMotor2 = RobotMap.rearLeftMotor2;
    public static final WPI_TalonSRX rearRightMotor1 = RobotMap.rearRightMotor1;
    public static final WPI_TalonSRX rearRightMotor2 = RobotMap.rearRightMotor2;
    public MecanumDrive mainDrive = new MecanumDrive(RobotMap.frontLeftMotor1, RobotMap.rearLeftMotor1,
			RobotMap.frontRightMotor1, RobotMap.rearRightMotor1);

    @Override
    public void initDefaultCommand() {
   
        // Set default command for a subsystem
        setDefaultCommand(new drive());
        
    }
   
    
	public void periodic() {
		//Update drive outputs with current joystick values.
		mainDrive.driveCartesian(-(Robot.oi.joystick2.getX()), Robot.oi.joystick1.getY(), Robot.oi.joystick1.getX(), 0.0);
    }
	//Initialize gyro.
	public void gyro() {
   	 Gyro gyro = null;
 
   		 double Kp = 0.03;

            double angle = gyro.getAngle(); // get current heading
            RobotMap.drive(-1.0, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
   	 gyro = new AnalogGyro(1);
   }

    public static void setupDrive() {
		//Setup motor followers and inverisons
    	frontLeftMotor2.follow(Chassis.frontLeftMotor1);
    	frontRightMotor2.follow(Chassis.frontRightMotor1);
    	rearLeftMotor2.follow(Chassis.rearLeftMotor1);
    	rearRightMotor2.follow(Chassis.frontLeftMotor1);
    	rearRightMotor2.setInverted(true);
    	
    	
    }

}

