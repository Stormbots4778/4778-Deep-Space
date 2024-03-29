package org.usfirst.frc.team4778.robot;

//import org.usfirst.frc.team4778.robot.commands.Ascend;
//import org.usfirst.frc.team4778.robot.commands.LiftDrive;
//import org.usfirst.frc.team4778.robot.commands.LiftFront;
//import org.usfirst.frc.team4778.robot.commands.LiftRear;
import org.usfirst.frc.team4778.robot.commands.Push;
import org.usfirst.frc.team4778.robot.commands.Shoot;
import org.usfirst.frc.team4778.robot.commands.Grab;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
* OI.java
* Contains definitions for operator interfaces
*/

public class OI {
	public static Joystick joystickLeft = new Joystick(0);
	public static Joystick joystickRight = new Joystick(1);

	public static Button shoot = new JoystickButton(joystickLeft, 3);
	public static Button intake = new JoystickButton(joystickRight, 3);

	public static Button pushL = new JoystickButton(joystickLeft, 1);
	public static Button pushR = new JoystickButton(joystickRight, 1);

	public static Button grab_disk = new JoystickButton(joystickLeft, 2);
	public static Button release_disk = new JoystickButton(joystickRight,2); 

	/*
	public static Button lift_front_up = new JoystickButton(joystickRight, 6); //comment out when not testing
	public static Button lift_rear_up = new JoystickButton(joystickLeft, 11); //comment out when not testing
	public static Button lift_front_down = new JoystickButton(joystickRight, 7); //comment out when not testing
	public static Button lift_rear_down = new JoystickButton(joystickLeft, 10); //comment out when not testing
	
	public static Button ascend = new JoystickButton(joystickLeft,2); //change to better button
	*/

	public OI() {
		intake.whileHeld(new Shoot(-0.1));
		shoot.toggleWhenPressed(new Shoot(0.35));

		pushL.whileHeld(new Push());
		pushR.whileHeld(new Push());
		
		grab_disk.whenPressed(new Grab(0.2,true,2));
		release_disk.whenPressed(new Grab(0.8,false,0.06));

		/*
		lift_front_up.whileActive(new LiftFront(true));
		lift_rear_up.whileActive(new LiftRear(true));
		lift_front_down.whileActive(new LiftFront(false));
		lift_rear_down.whileActive(new LiftRear(false));
		ascend.whenPressed(new Ascend());
		*/
	}
}