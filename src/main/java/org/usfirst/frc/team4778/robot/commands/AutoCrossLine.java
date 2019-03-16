package org.usfirst.frc.team4778.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/*
* AutoCrossLine.java
* Autonomous for only crossing the line
*/
public class AutoCrossLine extends CommandGroup {
  
  public AutoCrossLine() {
    //addSequential(new Descend());
    addSequential( new AutoEncoderDrive(0.6,162,5);
  }
}