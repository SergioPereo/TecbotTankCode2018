package org.usfirst.frc.team3158.robot.subsystem.chassis;

import org.usfirst.frc.team3158.robot.Robot;
import org.usfirst.frc.team3158.robot.RobotMap;
import org.usfirst.frc.team3158.robot.commands.chassis.DefaultDriveCommand;
import org.usfirst.frc.team3158.robot.resources.RobotDrive;
import org.usfirst.frc.team3158.robot.resources.TecbotSpeedController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

	TecbotSpeedController frontRightWheel, frontLeftWheel, rearRightWheel, rearLeftWheel, middleLeftWheel,
			middleRightWheel, transmissionWheel;
	RobotDrive drive;
	DoubleSolenoid transmission;
	boolean encoders, reverse, driversLatch = false;
	boolean transmissionState = false;
	Encoder leftEncoder, rightEncoder;
	Command defaultCommand;
	boolean transmissionStatus = false;

	// The constructor is to set all the motor types and ports, create the
	// RobotDrive,
	// Set the solenoid ports if transmission exists and the encoders if exists
	// Requires the RobotMapTecbot

	public DriveTrain() {
		if (!RobotMap.class.getSuperclass().getName().equals("RobotMap"))
			throw new NullPointerException("RobotMap is not extending from RobotMapTecbot");
		switch (RobotMap.chassis_typeOfConfiguration) {
		case MOTORS_2:
			switch (RobotMap.chassis_typeOfMotor) {
			case CAN:
				rearRightWheel = new TecbotSpeedController(RobotMap.chassis_rearRightMotor, true);
				rearLeftWheel = new TecbotSpeedController(RobotMap.chassis_rearLeftMotor, true);
				break;
			case TALON:
				rearRightWheel = new TecbotSpeedController(RobotMap.chassis_rearRightMotor, false);
				rearLeftWheel = new TecbotSpeedController(RobotMap.chassis_rearLeftMotor, false);
				break;
			}
			drive = new RobotDrive(rearLeftWheel, rearRightWheel);
			break;
		case MOTORS_4:
			switch (RobotMap.chassis_typeOfMotor) {
			case CAN:
				frontRightWheel = new TecbotSpeedController(RobotMap.chassis_frontRightMotor, true);
				frontLeftWheel = new TecbotSpeedController(RobotMap.chassis_frontLeftMotor, true);
				rearRightWheel = new TecbotSpeedController(RobotMap.chassis_rearRightMotor, true);
				rearLeftWheel = new TecbotSpeedController(RobotMap.chassis_rearLeftMotor, true);
				break;
			case TALON:
				frontRightWheel = new TecbotSpeedController(RobotMap.chassis_frontRightMotor, false);
				frontLeftWheel = new TecbotSpeedController(RobotMap.chassis_frontLeftMotor, false);
				rearRightWheel = new TecbotSpeedController(RobotMap.chassis_rearRightMotor, false);
				rearLeftWheel = new TecbotSpeedController(RobotMap.chassis_rearLeftMotor, false);
				break;
			}
			drive = new RobotDrive(frontLeftWheel, rearLeftWheel, frontRightWheel, rearRightWheel);
			break;
		case MOTORS_6:
			switch (RobotMap.chassis_typeOfMotor) {
			case CAN:
				frontRightWheel = new TecbotSpeedController(RobotMap.chassis_frontRightMotor, true);
				frontLeftWheel = new TecbotSpeedController(RobotMap.chassis_frontLeftMotor, true);
				rearRightWheel = new TecbotSpeedController(RobotMap.chassis_rearRightMotor, true);
				rearLeftWheel = new TecbotSpeedController(RobotMap.chassis_rearLeftMotor, true);
				middleLeftWheel = new TecbotSpeedController(RobotMap.chassis_middleLeftMotor, true);
				middleRightWheel = new TecbotSpeedController(RobotMap.chassis_middleRightMotor, true);
				break;
			case TALON:
				frontRightWheel = new TecbotSpeedController(RobotMap.chassis_frontRightMotor, false);
				frontLeftWheel = new TecbotSpeedController(RobotMap.chassis_frontLeftMotor, false);
				rearRightWheel = new TecbotSpeedController(RobotMap.chassis_rearRightMotor, false);
				rearLeftWheel = new TecbotSpeedController(RobotMap.chassis_rearLeftMotor, false);
				middleLeftWheel = new TecbotSpeedController(RobotMap.chassis_middleLeftMotor, false);
				middleRightWheel = new TecbotSpeedController(RobotMap.chassis_middleRightMotor, false);
				break;
			}
			drive = new RobotDrive(frontLeftWheel, rearLeftWheel, frontRightWheel, rearRightWheel, middleLeftWheel,
					middleRightWheel);
			break;
		}

		if (RobotMap.chassis_transmission) {
			transmission = new DoubleSolenoid(RobotMap.chassis_transmissionForward,
					RobotMap.chassis_transmissionReverse);
		}
		if (RobotMap.chassis_encoders) {
			leftEncoder = new Encoder(RobotMap.chassis_encoder1[0], RobotMap.chassis_encoder1[1]);
			rightEncoder = new Encoder(RobotMap.chassis_encoder2[0], RobotMap.chassis_encoder2[1]);
			leftEncoder.setDistancePerPulse(RobotMap.chassis_encoder_ratio);
			rightEncoder.setDistancePerPulse(RobotMap.chassis_encoder_ratio);
		}
		transmissionWheel = new TecbotSpeedController(RobotMap.middlechassisWheel, true);
		defaultCommand = new DefaultDriveCommand();
	}

	// Returns encoders

	public Encoder getLeftEncoder() {
		return leftEncoder;
	}

	public Encoder getRightEncoder() {
		return rightEncoder;
	}

	// Transmission of the wheel
	public boolean getTransmissionStatus() {
		return transmissionStatus;
	}

	public void driveT() {
		if (driversLatch)
			transmissionWheel.set(Robot.oi.getPilot().getY());
		else
			transmissionWheel.set(Robot.oi.getCopilot().getX());
	}

	public void retractTransmissionWheel() {
		transmissionStatus = false;
		transmission.set(Value.kReverse);
	}

	public void activeTransmissionWheel() {
		transmissionStatus = true;
		transmission.set(Value.kForward);
	}

	// Invert the front orientation from the chassis

	public void changeOrientation() {
		reverse = !reverse;
	}

	// Change the axis orientation of the robot
	// @Param reverse is to change a desired state true or false

	public void setOrientation(boolean reverse) {
		this.reverse = reverse;
	}

	// Returns if the robot orientation is inverted

	public boolean getOrientation() {
		return reverse;
	}

	// Set a speed and rotation angle for the robot

	public void drive(double axis, double rotationAngle) {
		if (reverse)
			drive.arcadeDrive(-axis, rotationAngle);
		else
			drive.arcadeDrive(axis, rotationAngle);
	}

	// Uses the joystick to move the robot

	public void drive() {
		if (driversLatch)
			drive(Robot.oi.getPilot().getY(), Robot.oi.getPilot().getX());
		else
			drive(Robot.oi.getPilot().getY(), Robot.oi.getPilot().getX());
	}

	// Switch drivers controls

	public void invertDrivers() {
		driversLatch = !driversLatch;
	}

	// Set the main driver;

	public void setInvertDrivers(boolean invert) {
		driversLatch = invert;
	}

	// Returns if the controls are switched

	public boolean driversInvertStatus() {
		return driversLatch;
	}

	// Stop DriveTrain

	public void stop() {
		drive.arcadeDrive(0, 0);
	}

	// Turn transmission on

	public void transmissionOn() {
		transmission.set(DoubleSolenoid.Value.kForward);
		transmissionState = true;
	}

	// Turn transmission off

	public void transmissionOff() {
		transmission.set(DoubleSolenoid.Value.kReverse);
		transmissionState = false;
	}

	// Set transmission to a desired state
	// @Param state is for enabling the transmission on a desired state

	public void setTransmission() {
		if (transmissionState)
			transmissionOn();
		else
			transmissionOff();
	}

	// Switch transmission state

	public void transmissionLatch() {
		if (transmissionState)
			transmissionOff();
		else
			transmissionOn();
	}

	// Returns the motors

	public TecbotSpeedController getFrontRightWheel() {
		return frontRightWheel;
	}

	public TecbotSpeedController getFrontLeftWheel() {
		return frontLeftWheel;
	}

	public TecbotSpeedController getRearRightWheel() {
		return rearRightWheel;
	}

	public TecbotSpeedController getRearLeftWheel() {
		return rearLeftWheel;
	}

	public TecbotSpeedController getMiddleRightWheel() {
		return middleRightWheel;
	}

	public TecbotSpeedController getMiddleLeftWheel() {
		return middleLeftWheel;
	}

	// Set the default command for the driveTrain if this subsystem is not on
	// use

	protected void initDefaultCommand() {
		if (defaultCommand != null)
			setDefaultCommand(defaultCommand);
	}
}
