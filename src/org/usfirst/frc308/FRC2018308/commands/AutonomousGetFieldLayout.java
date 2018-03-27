package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousGetFieldLayout{
	public static boolean done;
	public static String fieldLayout;
	

	public AutonomousGetFieldLayout() {
		Thread fms = new Thread() {
			public void run() {
				System.out.println("Thread Started");
				while (done == false) {
					getFMS();
					try{
						Thread.sleep(5);
						
					} catch (InterruptedException e) {
						
					}
				}
				
			}
		};
		
		fms.start();
		System.out.println("Starting Thread");
		
	}

	public static boolean getDone() {
		return done;
	}
	public static void getFMS() {
		if (fieldLayout != null) {
			fieldLayout = DriverStation.getInstance().getGameSpecificMessage();
			
			done = true;
		}
	}
}
