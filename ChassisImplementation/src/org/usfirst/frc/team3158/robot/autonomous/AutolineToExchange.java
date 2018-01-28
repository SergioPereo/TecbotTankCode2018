package org.usfirst.frc.team3158.robot.autonomous;

import org.usfirst.frc.team3158.robot.Robot;
import org.usfirst.frc.team3158.robot.commands.autonomous.DriveForwardTimed;
import org.usfirst.frc.team3158.robot.commands.autonomous.Turn180Deg;
import org.usfirst.frc.team3158.robot.commands.autonomous.Turn90Deg;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutolineToExchange extends CommandGroup {
	String gameData;
    public AutolineToExchange() {
    	gameData = Robot.gameData.getConfiguration();
    	if(gameData.charAt(0) == 'R'){
    		addSequential(new DriveForwardTimed(3));
    		addSequential(new Turn180Deg());
    		addSequential(new DriveForwardTimed(2));
    		addSequential(new Turn90Deg(true));
    		addSequential(new DriveForwardTimed(2));
    		addSequential(new Turn90Deg(false));
    	}
    	if(gameData.charAt(0) == 'L'){
    		addSequential(new DriveForwardTimed(3));
    		addSequential(new Turn180Deg());
    		addSequential(new DriveForwardTimed(2));
    		addSequential(new Turn90Deg(false));
    		addSequential(new DriveForwardTimed(2));
    		addSequential(new Turn90Deg(true));
    	}
    }
}
