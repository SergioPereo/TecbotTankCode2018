/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3158.robot;

import org.usfirst.frc.team3158.robot.autonomous.AutolineToExchange;
import org.usfirst.frc.team3158.robot.autonomous.ForwardToNull;
import org.usfirst.frc.team3158.robot.autonomous.Nothing;
import org.usfirst.frc.team3158.robot.autonomous.Scale;
import org.usfirst.frc.team3158.robot.autonomous.ScaleFromTheMiddleToNear;
import org.usfirst.frc.team3158.robot.autonomous.SwitchWithTurnToThePlatformZone;
import org.usfirst.frc.team3158.robot.subsystem.arm.Arm;
import org.usfirst.frc.team3158.robot.subsystem.chassis.DirectionPIDSubsystem;
import org.usfirst.frc.team3158.robot.subsystem.chassis.DistancePIDSubsystem;
import org.usfirst.frc.team3158.robot.subsystem.chassis.DriveTrain;
import org.usfirst.frc.team3158.robot.subsystem.collector.Collector;
import org.usfirst.frc.team3158.robot.subsystem.tecbotgyro.TecbotGyro;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static DriveTrain driveTrain;
	public static OI oi;
	public static Collector collector;
	public static Arm arm;
	public static TecbotGyro tecbotgyro;
	public static DirectionPIDSubsystem directionPid;
	public static DistancePIDSubsystem distancePid;
	public static GameData gameData;
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private Command autonomousCommand;
	private SendableChooser<Command> chooser = new SendableChooser<>();
	public double p=0, i=0, d=0;
	public double pid = 0;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		driveTrain = new DriveTrain();
		oi = new OI();
		collector = new Collector();
		arm = new Arm();
		tecbotgyro = new TecbotGyro();
		directionPid = new DirectionPIDSubsystem();
		gameData = new GameData();
		chooser.addDefault("None Auto", new Nothing());
		chooser.addObject("Autoline To Exchange", new AutolineToExchange());
		chooser.addObject("AutoNull", new ForwardToNull());
		chooser.addObject("Scale From The Middle", new ScaleFromTheMiddleToNear());
		chooser.addObject("Switch", new SwitchWithTurnToThePlatformZone());
		chooser.addObject("AutoScale", new Scale());
		SmartDashboard.putData("Auto choices", chooser);
		SmartDashboard.putNumber("PID", pid);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		if(autonomousCommand != null)
			autonomousCommand.start();
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopInit(){
		if(autonomousCommand != null)
			autonomousCommand.cancel();
		
		
	}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
