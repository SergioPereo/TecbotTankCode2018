package org.usfirst.frc.team3158.robot;

import org.usfirst.frc.team3158.robot.commands.arm.ArmDOWN;
import org.usfirst.frc.team3158.robot.commands.arm.ArmSTOP;
import org.usfirst.frc.team3158.robot.commands.arm.ArmUP;
import org.usfirst.frc.team3158.robot.commands.chassis.ChangeDirection;
import org.usfirst.frc.team3158.robot.commands.chassis.ChangeTransmission;
import org.usfirst.frc.team3158.robot.commands.collector.GetBox;
import org.usfirst.frc.team3158.robot.commands.collector.ShootBox;
import org.usfirst.frc.team3158.robot.commands.collector.TriggerOFF;
import org.usfirst.frc.team3158.robot.commands.collector.TriggerON;
import org.usfirst.frc.team3158.robot.commands.collector.TriggerReverse;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Joystick pilot,copilot;
	Button a, a1;
	Button b, b1;
	Button x, x1;
	Button y, y1;
	Button Lb, Lb1;
	Button Rb, Rb1;
	Button LStickButton, LStickButton1;
	Button RStickButton, RStickButton1;
	Button select, select1;
	Button start, start1;
	public final int right = 90, left = 270, upper = 180, downward=0;
	public OI(){
		pilot = new Joystick(0);
		copilot = new Joystick(1);
		a = new JoystickButton(pilot,1);
		b = new JoystickButton(pilot,2);
		x=new JoystickButton(pilot,3);
		y=new JoystickButton(pilot,4);
		select = new JoystickButton(pilot, 7);
		start = new JoystickButton(pilot, 8);
		Lb=new JoystickButton(pilot,5);
		Rb=new JoystickButton(pilot,6);
		LStickButton = new JoystickButton(pilot, 9);
		RStickButton = new JoystickButton(pilot, 10);
	  
		a1 = new JoystickButton(copilot,1);
		b1 = new JoystickButton(copilot,2);
		x1=new JoystickButton(copilot,3);
	  	y1=new JoystickButton(copilot,4);
	  	Lb1=new JoystickButton(copilot,5);
	  	Rb1=new JoystickButton(copilot,6);
	  	LStickButton1 = new JoystickButton(copilot, 9);
	  	RStickButton1 = new JoystickButton(copilot, 10);
	  	select1 = new JoystickButton(copilot, 7);
	  	start1 = new JoystickButton(copilot, 8);
	  	
	  	//Pilot This functions are only for test, this functions won't be the final functions for buttons
	  	
	  	x.whenPressed(new ChangeTransmission());
	  	start.whenPressed(new ArmUP());
	  	start.whenReleased(new ArmSTOP());
	  	select.whenPressed(new ArmDOWN());
	  	select.whenPressed(new ArmSTOP());
	  	RStickButton.whenPressed(new ChangeDirection());
	  	Rb.whenPressed(new ShootBox());
	  	Lb.whenPressed(new GetBox());
	  	a.whenPressed(new TriggerON());
	  	a.whenReleased(new TriggerOFF());
	  	b.whenPressed(new TriggerReverse());
	  	b.whenReleased(new TriggerOFF());
	  	
	  	
		
	}
	public Joystick getPilot(){
		return pilot;
	}
	public Joystick getCopilot(){
		return copilot;
	}

}
