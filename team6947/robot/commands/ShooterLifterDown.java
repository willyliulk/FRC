package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterLifterDown extends Command {
	long Time;
    public ShooterLifterDown(long Time) {
        requires(Robot.lifter);
        this.Time = Time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "ShooterLifterDown");
//-----------------------------------------------------------------------
    	this.Time = this.Time + System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("ShooterLifterDown");
    	Robot.lifter.shooterLifterDown();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (this.Time <= System.currentTimeMillis()) || (!Robot.lifter.limitSwitchDown.get());
    }
    protected void end() {
    	Robot.lifter.shooterLifter.set(0);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
