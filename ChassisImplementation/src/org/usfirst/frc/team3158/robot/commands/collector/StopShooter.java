package org.usfirst.frc.team3158.robot.commands.collector;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopShooter extends Command {

    public StopShooter() {
    	//StopShooter requires Robot.Collector
    	requires(Robot.collector);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.Collector.Stop() is called
    	Robot.collector.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
