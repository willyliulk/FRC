/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6947.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//JOYSTICKS
	public static final int JOYSTICK1_PORT=0;
	public static final int JOYSTICK2_PORT=1;
	//CANBUS
	public static final int DRIVE_MASTER_LEFT=1;
	public static final int DRIVE_SLAVE_LEFT=2;
	public static final int DRIVE_MASTER_RIGHT=3;
	public static final int DRIVE_SLAVE_RIGHT=4;
	
	//PWM
	public static final int CLIMBER_LEFT = 0;
	public static final int CLIMBER_RIGHT = 2;
	public static final int SHOOTER_LIFTER = 3;
	public static final int CLIMBER_ANGLE_ADJUSTER = 4;
	public static final int SHOOTER_RIGHT = 5;
	public static final int SHOOTER_LEFT = 6;
	//PCM
	public static final int LEFT_PINCHER = 0;
	public static final int RIGHT_PINCHER = 1;
	//DIGITAL OUTPUT
	public static final int SSR_RELAY = 7;
}
