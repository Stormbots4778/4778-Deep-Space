package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* Ascend.java
* Command that makes the robot ascend to the high ground
*/
public class Descend extends CommandGroup {

  public Descend() {
		addSequential(new LiftRear(false));
		//addSequential(new AutoTimer(0.4));
		addSequential(new LiftFront(false)); //retract front and rear pistons

		addSequential(new LiftDrive(-0.3,false,1));
		//addParallel(new LiftDrive(-.1,false,1)); //drive backwards until edge of platform

		addSequential(new LiftRear(true)); //extend rear pistons
		addSequential(new AutoTimer(2)); //wait to ensure extension


		addSequential(new LiftDrive(-0.2,false,3)); //drive until front wheels off

		addSequential(new LiftFront(true)); //extend front pistons
		addSequential(new AutoTimer(2)); //wait to ensure extension

		addSequential(new LiftDrive(-0.4,true,1)); //drive away from platform

		addSequential(new LiftFront(false));
		addParallel(new LiftRear(false));
	}
}
