package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* Ascend.java
* Command that makes the robot ascend to the high ground
*/
public class Descend extends CommandGroup {

    public Descend() {
		addSequential(new LiftRear(false));
		addSequential(new AutoTimer(0.4));
		addSequential(new LiftFront(false));
	}
}
