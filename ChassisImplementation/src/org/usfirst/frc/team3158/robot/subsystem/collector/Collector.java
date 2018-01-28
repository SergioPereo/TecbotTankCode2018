package org.usfirst.frc.team3158.robot.subsystem.collector;

import org.usfirst.frc.team3158.robot.RobotMap;
import org.usfirst.frc.team3158.robot.resources.TecbotSpeedController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Collector extends Subsystem{

	//The two motors and limit switch required for this subsystem are declared
	TecbotSpeedController collectorLeft,collectorRight;
	DigitalInput limitSwitch;
	DoubleSolenoid trigger;
	
	/*the two motors and limit switch are set to their port when this constructor is called 
	*in Robot.java
	*/
	
	public Collector() {
		switch(RobotMap.chassis_typeOfMotor)
		{
		case CAN:{
		collectorLeft=new TecbotSpeedController(RobotMap.motorCollectorLeft, true);
		collectorRight=new TecbotSpeedController(RobotMap.motorCollectorRight, true);
		break;}
		case TALON:{
			collectorLeft=new TecbotSpeedController(RobotMap.motorCollectorLeft, false);
			collectorRight=new TecbotSpeedController(RobotMap.motorCollectorRight, false);
			break;}
		}
		limitSwitch= new DigitalInput(RobotMap.collectorLimitSwitch);
		trigger = new DoubleSolenoid(RobotMap.triggerPiston[0],RobotMap.triggerPiston[1]);
	}
	
	/*When GetBox is called the state of the limit switch determines the next step, if the 
	 * limit switch returns true both motors are set to (0), if the limit switch returns false 
	 * both motors are set to (-.7)
	 */
	public void getBox() {
		boolean limit=limitSwitch.get();
		if (limit) {
			collectorLeft.set(0);
			collectorRight.set(0);
		}else {
			collectorLeft.set(-.7);
			collectorRight.set(-.7);			
		}
	}
	
	//when ShootBox is called both motors are set to (.7)
	
	public void shootBox() {
		collectorLeft.set(.7);
		collectorRight.set(.7);
	}
	//The trigger of the shooter
	
	public void triggerON(){
		trigger.set(Value.kForward);
	}
	public void triggerOFF(){
		trigger.set(Value.kOff);
	}
	public void triggerReverse(){
		trigger.set(Value.kReverse);
	}
	
	//when Stop is called both motors are set to (0)
	
	public void stop() {
		collectorLeft.set(0);
		collectorRight.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public boolean LimitBoolean () {
		return limitSwitch.get();
	}


}

