
<<<<<<< HEAD:src/org/usfirst/frc308/FRC2017308/commands/armControl.java
<<<<<<< HEAD:src/org/usfirst/frc308/FRC2017308/commands/armControl.java
package org.usfirst.frc308.FRC2017308.commands;
=======
package org.usfirst.frc308.FRC2018308.commands;
import org.usfirst.frc308.FRC2018308.Robot;

>>>>>>> parent of fa466f2... Revert "Revert "Revert "Basic Arm Code""":src/org/usfirst/frc308/FRC2018308/commands/TeleopArm.java
=======
package org.usfirst.frc308.FRC2018308.commands;
>>>>>>> parent of ede964c... Revert "Name Refactoring":src/org/usfirst/frc308/FRC2018308/commands/TeleopArm.java
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopArm extends Command {

<<<<<<< HEAD:src/org/usfirst/frc308/FRC2017308/commands/armControl.java
<<<<<<< HEAD:src/org/usfirst/frc308/FRC2017308/commands/armControl.java
    public armControl() {
=======
    public TeleopArm() {
>>>>>>> parent of ede964c... Revert "Name Refactoring":src/org/usfirst/frc308/FRC2018308/commands/TeleopArm.java

=======
    public TeleopArm() {
    	requires(Robot.arm);
>>>>>>> parent of fa466f2... Revert "Revert "Revert "Basic Arm Code""":src/org/usfirst/frc308/FRC2018308/commands/TeleopArm.java
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	Robot.arm.periodic();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
