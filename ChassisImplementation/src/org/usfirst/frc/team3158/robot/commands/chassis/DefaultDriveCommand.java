package org.usfirst.frc.team3158.robot.commands.chassis;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DefaultDriveCommand extends Command {
	boolean btnLatch=false;
    public DefaultDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	btnLatch=false;
    	
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.driveTrain.getTransmissionStatus()){
    		Robot.driveTrain.drive();	
    	} else {
    		Robot.driveTrain.driveT();
    	}
    	if(Robot.driveTrain.driversInvertStatus()){
    		if(Robot.oi.getCopilot().getPOV()==Robot.oi.right||Robot.oi.getPilot().getPOV()==Robot.oi.right){
    	    	if(!btnLatch){
    	    		Robot.driveTrain.invertDrivers();
    	    		btnLatch=true;
    	    	}
        	}else btnLatch=false;
    	}
    	else if(Robot.oi.getPilot().getPOV()==Robot.oi.right){
	    	if(!btnLatch){
	    		Robot.driveTrain.invertDrivers();
	    		btnLatch=true;
	    	}
    	}else btnLatch=false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
