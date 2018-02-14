package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.DriverStation;

public class AutonomousGetFieldLayout {
	public static String fieldLayout;

public static void getFieldLayout(){
	fieldLayout = DriverStation.getInstance().getGameSpecificMessage();
}
}
