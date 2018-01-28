
<<<<<<< HEAD:src/org/usfirst/frc308/FRC2017308/subsystems/Arm.java
<<<<<<< HEAD:src/org/usfirst/frc308/FRC2017308/subsystems/Arm.java
package org.usfirst.frc308.FRC2017308.subsystems;
=======
package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.commands.*;
>>>>>>> parent of ede964c... Revert "Name Refactoring":src/org/usfirst/frc308/FRC2018308/subsystems/Arm.java

import edu.wpi.first.wpilibj.command.Subsystem;

=======
package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.RobotConstants;
import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
>>>>>>> parent of fa466f2... Revert "Revert "Revert "Basic Arm Code""":src/org/usfirst/frc308/FRC2018308/subsystems/Arm.java

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

	public static WPI_TalonSRX armMotor = RobotMap.armMotor;
	
    @Override
    public void initDefaultCommand() {
    	setDefaultCommand(new TeleopArm());
    }
    
    @Override
    public void periodic() {
       armMotor.set(RobotConstants.joyArm);
    }

}

