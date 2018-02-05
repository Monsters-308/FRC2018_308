
package org.usfirst.frc308.FRC2018308.subsystems;

import org.usfirst.frc308.FRC2018308.RobotMap;
import org.usfirst.frc308.FRC2018308.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;


/**
 *
 */
public class Pneumatics extends Subsystem {

    private final Compressor compressor1 = RobotMap.pneumaticsCompressor1;
    private final Solenoid pusherSolenoid = RobotMap.pneumaticspusherSolenoid;
    private final Solenoid clawSolenoid = RobotMap.clawSolenoid;

    @Override
    public void initDefaultCommand() {
    	
    }

    @Override
    public void periodic() {
 
    }

}

