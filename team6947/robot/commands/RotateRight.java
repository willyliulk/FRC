package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.PIDProcessor;
import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateRight extends Command {
	double power;
	double T_Time;
	double Time;
	
    public RotateRight(double power, double Time) {
    	
        requires(Robot.chassis);
        this.power = power;
        this.Time = Time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "RotateRight");
//-----------------------------------------------------------------------
    	this.T_Time = System.currentTimeMillis() + this.Time;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.DriveRight(this.power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() >= this.T_Time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
