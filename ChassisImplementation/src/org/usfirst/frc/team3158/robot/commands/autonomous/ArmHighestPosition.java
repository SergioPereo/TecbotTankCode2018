package org.usfirst.frc.team3158.robot.commands.autonomous;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmHighestPosition extends Command {
	boolean isInTheRightPosition, isTheCommandFinished = false;

	public ArmHighestPosition() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!isInTheRightPosition) {
			if (Robot.arm.getUpEncoder().get() > Robot.arm.getHighestPosition()
					&& Robot.arm.getDownEncoder().get() > Robot.arm.getDefaultPosition()) {
				Robot.arm.armDOWN();
				isTheCommandFinished = false;
			} else if (Robot.arm.getUpEncoder().get() < Robot.arm.getHighestPosition()
					&& Robot.arm.getDownEncoder().get() < Robot.arm.getHighestPosition()) {
				Robot.arm.armDOWN();
				isTheCommandFinished = false;
			} else if (Robot.arm.getUpEncoder().get() < Robot.arm.getHighestPosition()
					&& Robot.arm.getDownEncoder().get() > Robot.arm.getHighestPosition()) {
				Robot.arm.moveUPupMotor();
				Robot.arm.moveDOWNdownMotor();
				isTheCommandFinished = false;
			} else if (Robot.arm.getUpEncoder().get() > Robot.arm.getHighestPosition()
					&& Robot.arm.getDownEncoder().get() < Robot.arm.getHighestPosition()) {
				Robot.arm.moveUPdownMotor();
				Robot.arm.moveDOWNupMotor();
				isTheCommandFinished = false;
			} else if (Robot.arm.getUpEncoder().get() == Robot.arm.getHighestPosition()
					&& Robot.arm.getDownEncoder().get() == Robot.arm.getHighestPosition()) {
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
