package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;
import org.usfirst.frc.team4778.robot.pid.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * AutoEncoderStrafe.java
 * Used for accurate strafing in autonomous
 */
public class AutoEncoderStrafe extends Command {
	
	private double speed;
	private double distance;
	
	private double time;
	private double endTime;
	
	private PIDController leftFrontPID;
  private PIDController leftRearPID;
  private PIDController rightFrontPID;
  private PIDController rightRearPID;
	
	private boolean isFinished;
  
  public static double LF; 
	public static double LR;
	public static double RF;
	public static double RR;
	public static double x = 0;
	public static double y = 0;
  public static double angle = 0;
  
    public AutoEncoderStrafe(double speed, double distance, double time) {
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
    		
    		leftFrontPID = new PIDController(0.25, 0, 0, distance);
    		leftFrontPID.setTolerence(3);
    		leftFrontPID.setOutputLimits(-speed, speed);
    		
    		leftRearPID = new PIDController(0.75, 0, 0, 0);
    		leftRearPID.setTolerence(1);
        leftRearPID.setOutputLimits(-0.5, 0.5);
        
        rightFrontPID = new PIDController(0.25, 0, 0, -distance);
    		rightFrontPID.setTolerence(3);
    		rightFrontPID.setOutputLimits(-speed, speed);
    		
    		rightRearPID = new PIDController(0.75, 0, 0, 0);
    		rightRearPID.setTolerence(1);
    		rightRearPID.setOutputLimits(-0.5, 0.5);
    		
    		endTime = Timer.getFPGATimestamp() + time;
    }
        
    protected void execute() {
      LF = RobotMap.m_encoderLeftFront.getDistance();
	    LR = RobotMap.m_encoderLeftRear.getDistance();
    	RF = RobotMap.m_encoderRightFront.getDistance();
	    RR = RobotMap.m_encoderRightRear.getDistance();
	    angle = ((LF + LR) + (RF + RR)) / (4 * Robot.DISTANCE_BETWEEN_WHEELS);
    	x = (((LF + RF) - (LR + RR)) / 4); // * Math.sin(angle);
    	y = (((LF + LR) - (RF + RR)) / 4); // * Math.cos(angle);
  
      leftRearPID.setSetpoint(RobotMap.m_encoderLeftRear.getDistance());
      rightRearPID.setSetpoint(RobotMap.m_encoderRightRear.getDistance());
    	//RobotMap.m_encoderLeftRear.getDistance()
    	double LFPID = leftFrontPID.computePID(RobotMap.m_encoderLeftRear.getDistance());
      double LRPID = leftRearPID.computePID(RobotMap.m_encoderLeftRear.getDistance());
      double RFPID = rightFrontPID.computePID(RobotMap.m_encoderLeftRear.getDistance());
	    double RRPID = rightRearPID.computePID(RobotMap.m_encoderLeftRear.getDistance());

		  Robot.m_drive.driveCartesian();
		  isFinished = Timer.getFPGATimestamp() > endTime;
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
    	Robot.m_drive.driveCartesian(0,0,0);
    }

    protected void interrupted() {
    	end();
    }
}
