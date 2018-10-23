/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6947.robot;


import org.usfirst.frc.team6947.robot.commands.AutoStart;
import org.usfirst.frc.team6947.robot.commands.Autonomous_Right_Switch;
import org.usfirst.frc.team6947.robot.commands.CollectBlock;
import org.usfirst.frc.team6947.robot.commands.DriveBackwardByTime;
import org.usfirst.frc.team6947.robot.commands.DriveByDistance;
import org.usfirst.frc.team6947.robot.commands.DriveForwardByTime;
import org.usfirst.frc.team6947.robot.commands.EjectBlock;
import org.usfirst.frc.team6947.robot.commands.LeftTurn;
import org.usfirst.frc.team6947.robot.commands.PincherSafetyControll;
import org.usfirst.frc.team6947.robot.commands.RightTurn;
import org.usfirst.frc.team6947.robot.commands.Rotate;
import org.usfirst.frc.team6947.robot.commands.RotateLeft;
import org.usfirst.frc.team6947.robot.commands.RotateRight;
import org.usfirst.frc.team6947.robot.commands.ShooterLifterUp;
import org.usfirst.frc.team6947.robot.commands.ShooterPinch;
import org.usfirst.frc.team6947.robot.commands.ShooterRelease;
import org.usfirst.frc.team6947.robot.commands.StopCollecting;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	
	
	//JOYSTICK 1
	public Joystick joystick1=new Joystick(RobotMap.JOYSTICK1_PORT);
	Button Abutton1=new JoystickButton(joystick1, 1);
	Button Abutton2=new JoystickButton(joystick1, 2);
	Button Abutton3=new JoystickButton(joystick1, 3);
	Button Abutton4=new JoystickButton(joystick1, 4);
	Button Abutton5=new JoystickButton(joystick1, 5);
	Button Abutton7=new JoystickButton(joystick1, 7);
	Button Abutton8=new JoystickButton(joystick1, 8);
	Button Abutton9=new JoystickButton(joystick1, 9);
	Button Abutton10=new JoystickButton(joystick1, 10);


	//JOYSTICK 2
	public Joystick joystick2 = new Joystick(RobotMap.JOYSTICK2_PORT);
	Button Bbutton1=new JoystickButton(joystick2, 1);
	Button Bbutton2=new JoystickButton(joystick2, 2);
	Button Bbutton3=new JoystickButton(joystick2, 3);
	Button Bbutton4=new JoystickButton(joystick2, 4);
	Button Bbutton5=new JoystickButton(joystick2, 5);
	Button Bbutton6=new JoystickButton(joystick2, 6);
	Button Bbutton7=new JoystickButton(joystick2, 7);
	Button Bbutton8=new JoystickButton(joystick2, 8);
	Button Bbutton9=new JoystickButton(joystick2, 9);
	Button Bbutton10=new JoystickButton(joystick2, 10);
	Button Bbutton11=new JoystickButton(joystick2, 11);
	
	
	public OI(){
		
		//SHOOTER
		Abutton1.whileHeld(new EjectBlock(1));

		Abutton2.whileHeld(new CollectBlock(1));
		Abutton2.whenReleased(new StopCollecting());
		Abutton3.whenPressed(new PincherSafetyControll());
		
	/*	Abutton7.whenPressed(new ShooterLifterUp(8000));
		Abutton8.whenPressed(new RotateLeft(0.4, 750));
		Abutton9.whenPressed(new DriveByDistance(0.6, 24));*/
		
		Bbutton3.whenPressed(new PincherSafetyControll());
		Bbutton4.whileHeld(new CollectBlock(1));
		Bbutton4.whenReleased(new StopCollecting());

		Bbutton6.whileHeld(new EjectBlock(1));
		
		
	}
	public double getDrivingJoyStickY(){
		return joystick1.getY();
	}
	public double getDrivingJoyStickX(){
		return joystick1.getX();
	}
	public boolean getButton13(){
		return joystick1.getRawButton(13);
	}
	public boolean getButtonButton(int ID) {
		return joystick1.getRawButton(ID);
	}
	
}
