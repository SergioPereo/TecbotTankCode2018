package org.usfirst.frc.team3158.robot.resources;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PWMTalonSRX;

public class TecbotSpeedController extends PWMSpeedController {
	TalonSRX cant;
	PWMSpeedController t;
	boolean isCan = false;

	public TecbotSpeedController(int port, boolean isCanC) {
		super(port);
		this.isCan = isCanC;
		if (isCanC)
			cant = new TalonSRX(port);
		else
			t = new PWMTalonSRX(port);
	}

	@Override
	public void set(double speed) {
		if (isCan) {
			cant.set(ControlMode.Velocity, speed);
		} else {
			t.set(speed);
		}
	}
}
