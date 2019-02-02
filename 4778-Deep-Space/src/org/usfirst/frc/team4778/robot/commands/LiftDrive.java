package org.usfirst.frc.team4778.robot.commands;

import org.usfirst.frc.team4778.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
* LiftDrive.java
* Command that handles the wheels on the bottom of the rear lifter
*/
public class LiftDrive extends Command {

	private double speed;
	private boolean forward;
		
    public LiftDrive(double speed,boolean forward) {
    	this.forward = forward;
    	this.speed = speed;
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.lifter.liftDrive(speed,forward);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
