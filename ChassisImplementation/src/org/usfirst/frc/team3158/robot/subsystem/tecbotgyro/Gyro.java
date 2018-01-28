package org.usfirst.frc.team3158.robot.subsystem.tecbotgyro;

import org.usfirst.frc.team3158.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Gyro {
	private AnalogGyro gyro;
	private double angle;
	private double rate;
	public Gyro(){
		gyro=new AnalogGyro(RobotMap.analogGyro);
	}
	public void run(){
		angle=gyro.getAngle();
		rate=gyro.getRate();
		SmartDashboard.putNumber("Gyro angle", gyro.getAngle());
		SmartDashboard.putNumber("Gyro rate", gyro.getRate());
	}
	public void reset(){
		gyro.reset();
	}
	public double getAngle(){
		return angle;
	}
	public double getRate(){
		return rate;
	}
	public void initGyro(){
		gyro.initGyro();
	}
	public void setSensitivity(double sensitivity){
		gyro.setSensitivity(sensitivity);
	}
	public void calibrate(){
		gyro.calibrate();
	}
}
