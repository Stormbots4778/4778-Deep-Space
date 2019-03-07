package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* AutoDisk.java
* Autonomous for scoring a disk
*/
public class AutoDisk extends CommandGroup {

  public AutoDisk() {
    addSequential(new Descend());
  }
}
