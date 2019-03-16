package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * AutoEncoderDrive.java
 * Used for accurate driving in autonomous
 */
public class AutoEncoderDrive extends Command {
	
	private double speed;
	private double distance;
	
	private double time;
	private double endTime;
	
	private PIDController masterPID
  private PIDController slavePID
	
	private boolean isFinished;
  
	public AutoEncoderDrive(double speed, double distance, double time) {
		this.speed = speed;
		this.distance = distance;
		this.time = time;
	}

	protected void initialize() {
		RobotMap.m_encoderLeftFront.reset();
		RobotMap.m_encoderLeftRear.reset();
		RobotMap.m_encoderRightFront.reset();
		RobotMap.m_encoderRightRear.reset();
		
		endTime = 0;
		isFinished = false;
	
		masterPIDleft = new PIDController(0.25, 0, 0, distance);
		masterPIDleft.setTolerence(3);
		masterPIDleft.setOutputLimits(-speed, speed);

		slavePIDright = new PIDController(0.75, 0, 0, 0);
		slavePIDright.setTolerence(1);
		slavePIDright.setOutputLimits(-0.6, 0.6);

		masterPIDright = new PIDController(0.25, 0, 0, distance);
		masterPIDright.setTolerence(3);
		masterPIDright.setOutputLimits(-speed, speed);

		slavePIDleft = new PIDController(0.75, 0, 0, 0);
		slavePIDleft.setTolerence(1);
		slavePIDleft.setOutputLimits(-0.6, 0.6);

		endTime = Timer.getFPGATimestamp() + time;
	}
			
	protected void execute() {
		slavePIDleft.setSetpoint(RobotMap.m_encoderRightFront.getDistance());
		slavePIDright.setSetpoint(RobotMap.m_encoderLeftFront.getDistance());
		
		double leftFrontPID = masterPIDleft.computePID(RobotMap.m_encoderLeftFront.getDistance());
		double leftRearPID = slavePIDleft.computePID(RobotMap.m_encoderLeftRear.getDistance());
		double rightFrontPID = masterPIDright.computePID(RobotMap.m_encoderRightFront.getDistance());
		double rightRearPID = slavePIDright.computePID(RobotMap.m_encoderRightRear.getDistance());

		Robotmap.leftFront.set(leftFrontPID)
		Robotmap.leftRear.set(leftRearPID);
		Robotmap.rightFront.set(rightFrontPID);
		Robotmap.rightRear.set(rightRearPID);

		isFinished = Timer.getFPGATimestamp() > endTime;
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		Robotmap.leftFront.set(0)
		Robotmap.leftRear.set(0);
		Robotmap.rightFront.set(0);
		Robotmap.rightRear.set(0);
		
		isFinshed = false;
	}

	protected void interrupted() {
		end();
	}
}
