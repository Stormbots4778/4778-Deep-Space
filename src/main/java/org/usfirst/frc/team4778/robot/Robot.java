package org.usfirst.frc.team4778.robot;

import org.usfirst.frc.team4778.robot.commands.AutoCrossLine;
import org.usfirst.frc.team4778.robot.commands.AutoDisk;
import org.usfirst.frc.team4778.robot.commands.AutoSphere;
import org.usfirst.frc.team4778.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4778.robot.subsystems.Grabber;
import org.usfirst.frc.team4778.robot.subsystems.Lifter;
import org.usfirst.frc.team4778.robot.subsystems.SphereManipulator;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.TimedRobot;

/*
* Robot.java
* Main robot class
*/
public class Robot extends TimedRobot {
	
	// Subsystems
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Grabber grabber = new Grabber();
	public static final Lifter lifter = new Lifter();
	public static final MecanumDrive m_drive = new MecanumDrive(RobotMap.m_leftFront, RobotMap.m_leftRear, RobotMap.m_rightFront, RobotMap.m_rightRear);
	public static final SphereManipulator spheremanipulator = new SphereManipulator();

	public static OI oi = new OI();
	
	public static final int PULSES_PER_REVOLUTION = 256; //PPR
	public static final int WHEEL_DIAMETER = 6; //inches
	public static final double DISTANCE_BETWEEN_WHEELS = 21.9; //inches
	
	//Cleanup this mess
	public static double LF; 
	public static double LR;
	public static double RF;
	public static double RR;
	public static double x;
	public static double y;
	public static double angle;

	//Command m_autonomousCommand;
	//SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	@Override
	public void robotInit() {
		RobotMap.m_encoderLeftFront.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
		RobotMap.m_encoderLeftRear.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
		RobotMap.m_encoderRightFront.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);
		RobotMap.m_encoderRightRear.setDistancePerPulse((WHEEL_DIAMETER * Math.PI) / PULSES_PER_REVOLUTION);

		CameraServer.getInstance().addAxisCamera("10.47.78.2");
		CameraServer.getInstance().startAutomaticCapture();

		// Auto Chooser
		//SmartDashboard.putData("Auto mode", m_chooser);
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
						
//		m_autonomousCommand = m_chooser.getSelected();
//				
//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.start();
//		}
	}

	@Override
	public void autonomousPeriodic() {
		CameraServer.getInstance().getVideo();
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {	
		RobotMap.m_encoderLeftFront.reset();
		RobotMap.m_encoderLeftRear.reset();
		RobotMap.m_encoderRightFront.reset();
		RobotMap.m_encoderRightRear.reset();

//		if (m_autonomousCommand != null) {
//			m_autonomousCommand.cancel();
//		}
	}

	@Override
	public void teleopPeriodic() {
		CameraServer.getInstance().getVideo();
		Scheduler.getInstance().run();

		//Create separate command
		LF = RobotMap.m_encoderLeftFront.getDistance();
		LR = RobotMap.m_encoderLeftRear.getDistance();
		RF = RobotMap.m_encoderRightFront.getDistance();
		RR = RobotMap.m_encoderRightRear.getDistance();
		x = ((LF + RF) - (LR + RR)) / 4;
		y = ((LF + LR) - (RF + RR)) / 4;
		angle = ((((LF + LR) + (RF + RR)) / (4 * DISTANCE_BETWEEN_WHEELS)) * (180 / Math.PI)) % 360;

		SmartDashboard.putNumber("Front Left Encoder", LF);
		SmartDashboard.putNumber("Back Left Encoder", LR);
		SmartDashboard.putNumber("Front Right Encoder", RF);
		SmartDashboard.putNumber("Back Right Encoder", RR);
		SmartDashboard.putNumber("x", x);
		SmartDashboard.putNumber("y", y);
		SmartDashboard.putNumber("angle", angle);
	}
	
	@Override
	public void testPeriodic() {}
}
