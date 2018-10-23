package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class EjectBlock extends Command {
	private double power;
	private long startTime;
    public EjectBlock(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		SmartDashboard.putString("Running Commend : ", "EjectBlock");
		startTime = System.currentTimeMillis();
//-----------------------------------------------------------------------
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	while(System.currentTimeMillis() - startTime <= 1000) {
    		Robot.shooter.eject(power);
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
