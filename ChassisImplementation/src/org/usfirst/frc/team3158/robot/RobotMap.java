package org.usfirst.frc.team3158.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public enum MotorConfiguration {
		CAN, TALON
	}

	public enum ChassisConfiguration {
		MOTORS_2, MOTORS_4, MOTORS_6;
	}
	/////////////// Arm Subsystem

	public static MotorConfiguration arm_typeOfMotor = MotorConfiguration.CAN;
	public static int upArmMotor = 0;
	public static int downArmMotor = 0;

	// Encoders

	public static int upMotorEncoder[] = { 0, 1 };
	public static int downMotorEncoder[] = { 0, 1 };

	/////////////// Collector Subsystem

	public static MotorConfiguration collector_typeOfMotor = MotorConfiguration.CAN;
	public static int motorCollectorLeft = 0;
	public static int motorCollectorRight = 0;
	public static int collectorLimitSwitch = 0;
	public static int triggerPiston[] ={0,0};

	/////////////// Climber Subsystem

	public static int climberMotorLeft = 0;
	public static int climberMotorRight = 0;

	/////////////// Chassis Subsystem

	public static MotorConfiguration chassis_typeOfMotor = MotorConfiguration.CAN;
	public static ChassisConfiguration chassis_typeOfConfiguration = ChassisConfiguration.MOTORS_4;

	public static int chassis_frontRightMotor = 2;
	public static int chassis_frontLeftMotor = 4;
	public static int chassis_rearRightMotor = 1;
	public static int chassis_rearLeftMotor = 10;
	public static int chassis_middleLeftMotor = 0;
	public static int chassis_middleRightMotor = 0;

	// Middle Chassis Wheel configuration
	public static int middlechassisWheel = 0;

	// Swerve

	public static MotorConfiguration swerve_typeOfMotor = MotorConfiguration.CAN;

	public static int swerve_steerLeftMotor = 0;
	public static int swerve_steerRightMotor = 0;

	public static boolean swerve_encoders = false;

	public static int swerve_encoderLeft[] = { 0, 0 };
	public static int swerve_encoderRight[] = { 0, 0 };

	public static int swerve_encoder_ratio = 0;

	// Transmission
	public static boolean chassis_transmission = true;

	public static int chassis_transmissionForward = 6;
	public static int chassis_transmissionReverse = 7;

	// Encoders

	public static boolean chassis_encoders = false;

	public static double chassis_encoder_ratio = 3;

	public static int chassis_encoder1[] = { 4, 5 };
	public static int chassis_encoder2[] = { 0, 1 };

	/////////////// Shooter Subsystem

	public static MotorConfiguration shooter_typeOfConfiguration = MotorConfiguration.CAN;

	// Encoders

	public static boolean shooter_hasEncoders = false;

	// Gyro

	public static boolean isNavx = true; // true for Navx, false for analog gyro

	public static int chassis_gyroscope = 0;
	public static double pGyro = .2;
	public static double iGyro = 0;
	public static double dGyro = 0;
	public static int analogGyro = 0;

}