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
public class DriveByDistance extends Command {
	private PIDProcessor PID;
	double power, dis, feet, target, start_tick;

	public DriveByDistance(double power, double feet) {
		requires(Robot.chassis);
		
		this.power = power;
		dis = feet;
	}
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "DriveByDistance");
//-----------------------------------------------------------------------
		start_tick = Robot.chassis.getEncoderTick();
		feet = 6500/(6 * Math.PI) * (dis * 12)*0.53;
		target = feet + start_tick;
		PID = new PIDProcessor(Robot.kP, Robot.kI, Robot.kD, target);
		PID.setThreshold(0.2, 1111);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
    	System.out.println("Driving Forward");

		double power = PID.outputNormal(Robot.chassis.getEncoderTick());
		if (power > this.power && power > 0) {
			Robot.chassis.Forward(this.power);
		}else if(power < this.power && power < 0) {
			Robot.chassis.Forward(-this.power);
		}else {
			Robot.chassis.Forward(power);
		}
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
		Robot.chassis.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
