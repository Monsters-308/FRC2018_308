package org.usfirst.frc308.FRC2018308.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousGetFieldLayout extends Command {
	public static boolean done;
	public static String fieldLayout;

	public AutonomousGetFieldLayout() throws InterruptedException {
		while (done == false) {
			getFMS();
			Thread.sleep(5);
		}
	}

	public static void getFMS() {
		if (fieldLayout != null) {
			fieldLayout = DriverStation.getInstance().getGameSpecificMessage();
			done = true;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (fieldLayout != null) {
			return true;
		} else {
			return false;
		}
	}

}
