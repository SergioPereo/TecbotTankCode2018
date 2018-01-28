package org.usfirst.frc.team3158.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class GameData {
	public GameData(){
		
	}
	public String getConfiguration() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}

	public boolean isFMSAttached() {
		return DriverStation.getInstance().isFMSAttached();
	}

	public boolean isAutonomous() {
		return DriverStation.getInstance().isAutonomous();
	}
}
