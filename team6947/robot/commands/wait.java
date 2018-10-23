package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class wait extends Command {
	public long startTime, target;
    public wait(long target) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        this.target  = target;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "wait");
//-----------------------------------------------------------------------
    	startTime = System.currentTimeMillis();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(System.currentTimeMillis() - startTime <= target) {
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
