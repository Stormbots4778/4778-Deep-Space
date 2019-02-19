package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* Ascend.java
* Command that makes the robot ascend to the high ground
*/
public class Ascend extends CommandGroup {

	public Ascend() {
		addSequential(new LiftFront(true)); //Extend front and rear lifters
		addParallel(new LiftRear(true));
		/*
		addSequential(new AutoTimer(3));
		
		addSequential(new LiftDrive(0.25,true,3)); //Position front of robot on upper level
		
		addSequential(new LiftFront(false)); //Retract front lifter
		addSequential(new AutoTimer(3));
		
		addSequential(new LiftDrive(0.25,true,3)); //Drive forward further onto upper level
		//addParallel(new LiftDrive(0.2,false,3));
		
		addSequential(new LiftRear(false)); //Retract rear lifter
		addSequential(new AutoTimer(3));
		
		//addSequential(new LiftDrive(0.2,false,3)); //Drive all the way onto upper level
		*/
	}
}