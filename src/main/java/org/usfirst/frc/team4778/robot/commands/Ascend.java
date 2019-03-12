package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* Ascend.java
* Command that makes the robot ascend to the high ground
*/
public class Ascend extends CommandGroup {

	public Ascend() {
		addSequential(new LiftFront(true));
		addSequential(new AutoTimer(0.4)); //Delay between lifting front and rear
		addSequential(new LiftRear(true)); //Extend front and rear lifters
		
		addSequential(new AutoTimer(2));
		
		addSequential(new LiftDrive(0.4,true,2)); //Position front of robot on upper level
		
		addSequential(new LiftFront(false)); //Retract front lifter
		addSequential(new AutoTimer(2));
		
		addSequential(new LiftDrive(0.4,true,1)); //Drive forward further onto upper level
		addParallel(new LiftDrive(0.4,false,1));
		
		addSequential(new LiftRear(false)); //Retract rear lifter
		addSequential(new AutoTimer(2));
		
		addSequential(new LiftDrive(0.4,false,1)); //Drive all the way onto upper level
	}
}