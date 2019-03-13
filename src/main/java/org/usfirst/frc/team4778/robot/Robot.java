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

		SmartDashboard.putNumber("Front Left Encoder", RobotMap.m_encoderLeftFront.getDistance());
		SmartDashboard.putNumber("Back Left Encoder", RobotMap.m_encoderLeftRear.getDistance());
		SmartDashboard.putNumber("Front Right Encoder", RobotMap.m_encoderRightFront.getDistance());
		SmartDashboard.putNumber("Back Right Encoder", RobotMap.m_encoderRightRear.getDistance());
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

		SmartDashboard.putNumber("Front Left Encoder", RobotMap.m_encoderLeftFront.getDistance());
		SmartDashboard.putNumber("Back Left Encoder", RobotMap.m_encoderLeftRear.getDistance());
		SmartDashboard.putNumber("Front Right Encoder", RobotMap.m_encoderRightFront.getDistance());
		SmartDashboard.putNumber("Back Right Encoder", RobotMap.m_encoderRightRear.getDistance());
	}
	
	@Override
	public void testPeriodic() {}
}
