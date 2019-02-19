package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* Ascend.java
* Command that makes the robot ascend to the high ground
*/
public class Descend extends CommandGroup {

    public Descend() {
    	addSequential(new LiftFront(false));
		addParallel(new LiftRear(false));
	}
}
