package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* Ascend.java
* Command that makes the robot ascend to the high ground
*/
public class Ascend extends CommandGroup {

	public Ascend() {
		addSequential(new LiftRear(true));
		addParallel(new LiftFront(true)); //Extend front and rear lifters
		
		addSequential(new AutoTimer(4));
		
		addSequential(new LiftDrive(0.4,true,1)); //Position front of robot on upper level
		
		addSequential(new LiftFront(false)); //Retract front lifter
		addSequential(new AutoTimer(4));
		
		addSequential(new LiftDrive(0.4,true,1)); //Drive forward further onto upper level
		addParallel(new LiftDrive(0.4,false,1));
		
		addSequential(new LiftRear(false)); //Retract rear lifter
		addSequential(new AutoTimer(4));
		
		addSequential(new LiftDrive(0.4,false,1)); //Drive all the way onto upper level

	}
}