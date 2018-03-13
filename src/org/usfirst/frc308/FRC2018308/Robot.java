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

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc308.FRC2018308.commands.*;
import org.usfirst.frc308.FRC2018308.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Arm arm;
	public static Chassis chassis;
	public static Pneumatics pneumatics;
	public static Claw claw;
	public static Lift lift;

	// Variable to determine configuration settings for Practice vs Game Bot
	// inGameMode = False is Practice Bot. inGameMode= True is Game Bot.
	public static boolean inGameMode = false;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		if (chooser.getSelected() == new CenterRightAutonomousCommand()) {
			if (AutonomousGetFieldLayout.fieldLayout == "RRR") {
				autonomousCommand = new CenterRightAutonomousCommand();
			} else if (AutonomousGetFieldLayout.fieldLayout == "RLR") {
				autonomousCommand = new CenterRightAutonomousCommand();
			} else {
				autonomousCommand = new AutonomousCrossLine();
			}
		} else if (chooser.getSelected() == new LeftAutonomousCommand()) {
			if (AutonomousGetFieldLayout.fieldLayout == "LLL") {
				autonomousCommand = new LeftAutonomousCommand();
			} else if (AutonomousGetFieldLayout.fieldLayout == "LRL") {
				autonomousCommand = new LeftAutonomousCommand();
			} else {
				autonomousCommand = new AutonomousCrossLine();
			}
		} else if (chooser.getSelected() == new RightAutonomousCommand()) {
			if (AutonomousGetFieldLayout.fieldLayout == "RRR") {
				autonomousCommand = new RightAutonomousCommand();
			} else if (AutonomousGetFieldLayout.fieldLayout == "RLR") {
				autonomousCommand = new RightAutonomousCommand();
			} else {
				autonomousCommand = new AutonomousCrossLine();
			}
		} else if (chooser.getSelected() == new CenterLeftAutonomousCommand()) {
			if (AutonomousGetFieldLayout.fieldLayout == "LLL") {
				autonomousCommand = new CenterRightAutonomousCommand();
			} else if (AutonomousGetFieldLayout.fieldLayout == "LRL") {
				autonomousCommand = new CenterRightAutonomousCommand();
			} else {
				autonomousCommand = new AutonomousCrossLine();
			}
		} else {
			autonomousCommand = new AutonomousCrossLine();
			RobotMap.init();
			// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
			arm = new Arm();
			chassis = new Chassis();
			pneumatics = new Pneumatics();
			claw = new Claw();
			// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
			// OI must be constructed after subsystems. If the OI creates Commands
			// (which it very likely will), subsystems are not guaranteed to be
			// constructed yet. Thus, their requires() statements may grab null
			// pointers. Bad news. Don't move it.
			oi = new OI();
			lift = new Lift();
			CameraServer.getInstance().startAutomaticCapture();

			// Add commands to Autonomous Sendable Chooser
			// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

			chooser.addObject("Center Right", new CenterRightAutonomousCommand());
			chooser.addObject("Center Left", new CenterLeftAutonomousCommand());
			chooser.addObject("Right", new RightAutonomousCommand());
			chooser.addObject("Left", new LeftAutonomousCommand());

			SmartDashboard.putData("Auto mode chooser", chooser);
		}
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
	}

	/**
	 * This function is called when the disabled button is hit. You can use it to
	 * reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// autonomousCommand = chooser.getSelected();
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {

		Scheduler.getInstance().run();

	}
}
