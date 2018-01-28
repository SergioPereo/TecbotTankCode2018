package org.usfirst.frc.team3158.robot.autonomous;

import org.usfirst.frc.team3158.robot.Robot;
import org.usfirst.frc.team3158.robot.commands.autonomous.DriveForwardTimed;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ForwardToNull extends CommandGroup {
	String gameConfiguration;
    
	public ForwardToNull() {
    gameConfiguration = Robot.gameData.getConfiguration();
    	if(gameConfiguration.charAt(0) == 'R'){
    		addSequential(new DriveForwardTimed(3));
    	}
    	if(gameConfiguration.charAt(0) == 'L'){
    		addSequential(new DriveForwardTimed(3));
    	}
    }
}
