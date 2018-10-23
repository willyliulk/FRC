/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6947.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6947.robot.commands.AutoStart;
import org.usfirst.frc.team6947.robot.commands.Autonomous_BluePrint;
import org.usfirst.frc.team6947.robot.commands.Autonomous_Left_Scale;
import org.usfirst.frc.team6947.robot.commands.Autonomous_Left_Switch;
import org.usfirst.frc.team6947.robot.commands.Autonomous_Middle;
import org.usfirst.frc.team6947.robot.commands.Autonomous_Righht_Scale;
import org.usfirst.frc.team6947.robot.commands.Autonomous_Right_Switch;
import org.usfirst.frc.team6947.robot.subsystems.Chassis;
import org.usfirst.frc.team6947.robot.subsystems.Climber;
import org.usfirst.frc.team6947.robot.subsystems.Lifters;
import org.usfirst.frc.team6947.robot.subsystems.Shooter;

public class Robot extends TimedRobot {
	//Initiating Subsystems
	public static  Chassis chassis;
	public static UsbCamera camera;
	public static Shooter shooter;
	public static Climber climber;
	public static Lifters lifter;
	public static PIDProcessor PID;
	public static OI oi;
	
	//Camera Interface Size Setting
	public static final int IMG_WIDTH = 160;
	public static final int IMG_HIGHT = 120;
	
	//PID Setting
	public static double kP = 0.00006;
	public static double kI = 0;
	public static double kD = 0.0001;
	public static double target;
	
	//Other Initializations
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>(); 
	
	
	@Override
	public void robotInit() {
		//Instantiating Subsystems
		chassis = new Chassis();
		shooter = new Shooter();
		climber = new Climber(); 
		lifter = new Lifters();
		
		
		oi = new OI();
		
		//Initialize Camera
		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(IMG_WIDTH, IMG_HIGHT);
		camera.setExposureManual(10);
		CameraServer.getInstance().startAutomaticCapture();
		
		chooser.addDefault("Autonomous_Left_Scale", new Autonomous_Left_Scale());
		chooser.addObject("Autonomous_Middle", new Autonomous_Middle());
		chooser.addObject("Autonomous_Righht_Scale", new Autonomous_Righht_Scale());
		SmartDashboard.putData("AutoMode:", chooser);
	}
	@Override
	public void disabledInit() {
		/*chooser = new SendableChooser<>();
		chooser.addDefault("Middle", new Autonomous_Middle());
		chooser.addObject("Left Scale", new Autonomous_Left_Scale());
		chooser.addObject("Left Switch", new Autonomous_Left_Switch());
		chooser.addObject("Right Scale", new Autonomous_Righht_Scale());
		chooser.addObject("Right Switch", new Autonomous_Right_Switch());

		SmartDashboard.putData("Auto mode", chooser);*/
	}
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("PincherMod", shooter.leftPincher.get());
	}
	@Override
	public void autonomousInit() {
		//autonomousCommand =  (Command) chooser.getSelected();
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
//	
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		chassis.encoderReset();
	}
	@Override
	public void teleopPeriodic() {	
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Encoder:" , chassis.getEncoderTick());
		SmartDashboard.putBoolean("PincherMod", shooter.leftPincher.get());
	}
	@Override
	public void testPeriodic() {
		
	}
}
