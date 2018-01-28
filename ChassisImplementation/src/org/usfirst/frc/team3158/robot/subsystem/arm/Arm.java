package org.usfirst.frc.team3158.robot.subsystem.arm;

import org.usfirst.frc.team3158.robot.RobotMap;
import org.usfirst.frc.team3158.robot.resources.TecbotSpeedController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

	TecbotSpeedController upArmMotor, downArmMotor;
	Encoder upArmEncoder, downArmEncoder;
	int lowPosition = 0;
	int defaultPosition = 100;
	int highPosition = 200;
	int highestPosition = 250;

	public Arm() {

		switch (RobotMap.arm_typeOfMotor) {
		case CAN:
			upArmMotor = new TecbotSpeedController(RobotMap.upArmMotor, true);
			downArmMotor = new TecbotSpeedController(RobotMap.downArmMotor, true);
		case TALON:
			upArmMotor = new TecbotSpeedController(RobotMap.upArmMotor, false);
			downArmMotor = new TecbotSpeedController(RobotMap.downArmMotor, false);
		}
		upArmEncoder = new Encoder(RobotMap.upMotorEncoder[0], RobotMap.upMotorEncoder[1]);
		downArmEncoder = new Encoder(RobotMap.downMotorEncoder[0], RobotMap.downMotorEncoder[1]);
		upArmEncoder.reset();
		downArmEncoder.reset();
	}

	public void armUP() {
		upArmMotor.set(0.5);
		downArmMotor.set(0.5);
	}

	public void armDOWN() {
		upArmMotor.set(-0.5);
		downArmMotor.set(-0.5);
	}

	public void armSTOP() {
		upArmMotor.set(0);
		downArmMotor.set(0);
	}

	public void moveUPupMotor() {
		upArmMotor.set(0.5);
	}

	public void moveDOWNupMotor() {
		upArmMotor.set(-0.5);
	}

	public void moveUPdownMotor() {
		downArmMotor.set(0.5);
	}

	public void moveDOWNdownMotor() {
		downArmMotor.set(-0.5);
	}

	public int getDefaultPosition() {
		return defaultPosition;
	}

	public int getHighPosition() {
		return highPosition;
	}

	public int getHighestPosition() {
		return highestPosition;
	}

	public int getLowestPosition() {
		return lowPosition;
	}

	public int upArticulationPosition() {
		return upArmEncoder.get();
	}

	public int downArticulationPosition() {
		return downArmEncoder.get();
	}

	public Encoder getUpEncoder() {
		return upArmEncoder;
	}

	public Encoder getDownEncoder() {
		return downArmEncoder;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
