/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6947.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6947.robot.PIDProcessor;
import org.usfirst.frc.team6947.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class LeftTurn extends Command {
	private PIDProcessor PID;
	double power, dis, feet, target;

	public LeftTurn(double power, double angle) {
		requires(Robot.chassis);
		
		this.power = power;
		dis = angle;
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "LeftTurn");
//-----------------------------------------------------------------------
		Robot.chassis.encoderReset();
		Timer.delay(0.1);
		feet = 26.789 * dis * 1.8;
		target = feet;
		SmartDashboard.putNumber("Target", target);
		PID = new PIDProcessor(Robot.kP, Robot.kI, Robot.kD, target);
		PID.setThreshold(0.1, 200);
		System.out.println("initialized");
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double power = PID.outputNormal(Robot.chassis.getEncoderTick());
		if (power > this.power || power < this.power) {
			Robot.chassis.DriveLeft(this.power);
		}else {
			Robot.chassis.DriveLeft(power);
		}
		
		System.out.println("runnung");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return PID.checkDone();	
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	//	Robot.drivetrain.EncoderReset();
		System.out.println("End");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
