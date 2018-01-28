package org.usfirst.frc.team3158.robot.subsystem.chassis;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DirectionPIDSubsystem extends PIDSubsystem {

	
	public static boolean isZero = false;
	public DirectionPIDSubsystem() {
		
		super(0, 0, 0);
		// TODO Auto-generated constructor stub
	}

	public DirectionPIDSubsystem(String name, double p, double i, double d) {
		super(name, p, i, d);
		// TODO Auto-generated constructor stub
	}

	public DirectionPIDSubsystem(double p, double i, double d, double period) {
		super(p, i, d, period);
		// TODO Auto-generated constructor stub
	}

	public DirectionPIDSubsystem(String name, double p, double i, double d, double f) {
		super(name, p, i, d, f);
		// TODO Auto-generated constructor stub
	}

	public DirectionPIDSubsystem(double p, double i, double d, double period, double f) {
		super(p, i, d, period, f);
		// TODO Auto-generated constructor stub
	}

	public DirectionPIDSubsystem(String name, double p, double i, double d, double f, double period) {
		super(name, p, i, d, f, period);
		// TODO Auto-generated constructor stub
	}

	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		
		//return Robot.drivetrain.encoder1.getDistance();
		return Robot.tecbotgyro.getAngle(); //Ignoren el comentario 
	}
	
	public void turnToFalse(){
		
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		

		//Robot.driveTrain.drive(0,output);
		if(!isZero){
			Robot.driveTrain.frontLeftWheel.set(DistancePIDSubsystem.ratio*Math.sin(-output+Math.PI/4));
			 Robot.driveTrain.rearLeftWheel.set(DistancePIDSubsystem.ratio*Math.sin(-output+Math.PI/4));
			 Robot.driveTrain.frontRightWheel.set(DistancePIDSubsystem.ratio*-Math.cos(-output+Math.PI/4));
			 Robot.driveTrain.rearRightWheel.set(DistancePIDSubsystem.ratio*-Math.cos(-output+Math.PI/4));

		}
		else{
			Robot.driveTrain.frontLeftWheel.set(.7*Math.sin(-output+Math.PI/4));
			 Robot.driveTrain.rearLeftWheel.set(0.7*Math.sin(-output+Math.PI/4));
			 Robot.driveTrain.frontRightWheel.set(-0.7*-Math.cos(-output+Math.PI/4));
			 Robot.driveTrain.rearRightWheel.set(-0.7*-Math.cos(-output+Math.PI/4));

		}
	
	 
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
