package org.usfirst.frc.team4778.robot;

// Note: WPI_TalonSRX must be used to support the updated RobotDrive
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/*
* RobotMap
* Contains mapping for all of the robot's motor controllers
*/
public class RobotMap {
	
	// Left Front drivetrain motor controllers
	public static WPI_TalonSRX m_leftFront = new WPI_TalonSRX(1);
	
	// Left Rear drivetrain motor controllers
	public static WPI_TalonSRX m_leftRear  = new WPI_TalonSRX(3);
	
	// Right Front drivetrain motor controllers
	public static WPI_TalonSRX m_rightFront = new WPI_TalonSRX(2);
	
	// Right Rear drivetrain motor controllers
	public static WPI_TalonSRX m_rightRear = new WPI_TalonSRX(0);

	// Front solenoids
	//public static DoubleSolenoid m_leftFrontSolenoid   = new DoubleSolenoid(0,1);
	//public static DoubleSolenoid m_rightFrontSolenoid = new DoubleSolenoid(2,3);
	
	// Rear solenoids
	//public static DoubleSolenoid m_leftRearSolenoid = new DoubleSolenoid(4,5);
	//public static DoubleSolenoid m_rightRearSolenoid = new DoubleSolenoid(6,7);
	
	//public static Compressor m_compressor = new Compressor();
}