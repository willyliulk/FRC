package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterLifterUp extends Command {
	
	long Time;
	long endTime;
    public ShooterLifterUp(long Time) {
        requires(Robot.lifter);
        this.Time = Time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "ShooterLifterUp");
//-----------------------------------------------------------------------
    	this.endTime = this.Time + System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Lifting");
    	Robot.lifter.shooterLifterUp();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (this.endTime <= System.currentTimeMillis()) || (!Robot.lifter.limitSwitchUp.get());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lifter.shooterLifter.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
