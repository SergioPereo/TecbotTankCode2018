package org.usfirst.frc.team3158.robot.autonomous;

import org.usfirst.frc.team3158.robot.Robot;
import org.usfirst.frc.team3158.robot.commands.autonomous.DriveForwardTimed;
import org.usfirst.frc.team3158.robot.commands.autonomous.Turn90Deg;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScaleFromTheMiddleToNear extends CommandGroup {
	String gameData;

	public ScaleFromTheMiddleToNear() {
		gameData = Robot.gameData.getConfiguration();
		if (gameData.charAt(1) == 'L') {
			addSequential(new Turn90Deg(false));
			addSequential(new DriveForwardTimed(2));
			addSequential(new Turn90Deg(true));
			addSequential(new DriveForwardTimed(1));
		}
		if (gameData.charAt(1) == 'R') {
			addSequential(new Turn90Deg(true));
			addSequential(new DriveForwardTimed(2));
			addSequential(new Turn90Deg(false));
			addSequential(new DriveForwardTimed(1));
		}

	}
}
