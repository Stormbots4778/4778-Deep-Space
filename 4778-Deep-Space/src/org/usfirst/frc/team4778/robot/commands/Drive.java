package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.OI;
import org.usfirst.frc.team4778.robot.Robot;
import org.usfirst.frc.team4778.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/*
* Drive.java
* Command that handles driving the robot
*/
public class Drive extends Command {
	public Drive() {
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		//Robot.m_drive.driveCartesian(-OI.joystickLeft.getX()/2, OI.joystickLeft.getY()/2, -OI.joystickRight.getX()/2);
		if(OI.joystickLeft.getTrigger())
		{
			RobotMap.m_leftFront.set(.1);
			RobotMap.m_rightFront.set(.1);
			RobotMap.m_leftRear.set(.1);
			RobotMap.m_rightRear.set(.1);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
	
}