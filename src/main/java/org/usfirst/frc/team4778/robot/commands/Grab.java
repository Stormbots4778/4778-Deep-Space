package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/*
* Grab.java
* Command that grabs disk
*/
public class Grab extends Command {
  private double time;
  private double endTime;

  private double speed;
  private boolean grabDisk;
  private boolean isFinished;
  
  public Grab(double speed,boolean grabDisk,double time) {
    this.speed = speed;
    this.grabDisk = grabDisk;
    this.time = time;
    isFinished = false;
  }

  protected void initialize() {
    endTime = Timer.getFPGATimestamp() + time;
  }

  protected void execute() {
    Robot.grabber.grab(speed,grabDisk);
    if (Timer.getFPGATimestamp() >= endTime) {
      isFinished = true;
    }
  }

  protected boolean isFinished() {
    return isFinished;
  }

  protected void end() {
    RobotMap.m_grabberMotor.set(0);
    isFinished = false;
  }

  protected void interrupted() {
    end();
  }
}
