package org.usfirst.frc.team3158.robot.commands.autonomous;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmFirstPosition extends Command {
	boolean isInTheRightPosition, isTheCommandFinished = false;

	public ArmFirstPosition() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!isInTheRightPosition) {
			if (Robot.arm.getUpEncoder().get() > Robot.arm.getLowestPosition()
					&& Robot.arm.getDownEncoder().get() > Robot.arm.getLowestPosition()) {
				Robot.arm.armDOWN();
				isTheCommandFinished = false;
			} else if (Robot.arm.getUpEncoder().get() == Robot.arm.getLowestPosition()
					&& Robot.arm.getDownEncoder().get() == Robot.arm.getLowestPosition()) {
				Robot.arm.armSTOP();
				isTheCommandFinished = true;
			}
		}
		if (isInTheRightPosition) {
			isTheCommandFinished = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTheCommandFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
