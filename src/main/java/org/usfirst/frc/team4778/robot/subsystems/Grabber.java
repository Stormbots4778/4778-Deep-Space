package org.usfirst.frc.team4778.robot.subsystems;

import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/*
* Grabber.java
* Subsystem that contains definitions for the disk grabber
*/
public class Grabber extends Subsystem {
  
  public void initDefaultCommand() {}

  public void grab(double speed,boolean grabDisk) {
    if(grabDisk) {
	    RobotMap.m_grabberMotors.set(speed);
	  } else {
    	RobotMap.m_grabberMotors.set(-speed);
	  }
  }

  public void stop() {
    RobotMap.m_grabberMotors.set(0);
  }
}
