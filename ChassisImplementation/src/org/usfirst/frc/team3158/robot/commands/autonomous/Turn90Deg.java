package org.usfirst.frc.team3158.robot.commands.autonomous;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn90Deg extends Command {
	boolean isRightC;
    public Turn90Deg(boolean isRight) {
    isRightC = isRight; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1.04);
    	if(isRightC) Robot.driveTrain.drive(0, 0.7);
    	if(!isRightC) Robot.driveTrain.drive(0, -0.7);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
