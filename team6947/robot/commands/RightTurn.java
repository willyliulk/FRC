/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6947.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6947.robot.PIDProcessor;
import org.usfirst.frc.team6947.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class RightTurn extends Command {
	private PIDProcessor PID;
	double power, dis, feet, target;

	public RightTurn(double power, double angle) {
		requires(Robot.chassis);
		
		this.power = power;
		dis = angle;
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "RightTurn");
//-----------------------------------------------------------------------
		Robot.chassis.encoderReset();
		feet = 26.7888889 * dis *0.1;
		target = feet;
		PID = new PIDProcessor(Robot.kP, Robot.kI, Robot.kD, target);
		PID.setThreshold(200, 200);
		System.out.println("initialized");
		
	}
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double power = PID.outputNormal(-Robot.chassis.getEncoderTick());
		if (power > this.power || power < this.power) {
			Robot.chassis.DriveRight(this.power);
		}else {
			Robot.chassis.DriveRight(power);
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
