package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous extends CommandGroup {
	String gameData =  DriverStation.getInstance().getGameSpecificMessage();
    public Autonomous() {
    	System.out.println("Running Auto");
    	addParallel(new DriveByDistance(0.3, 14));
 //   	addSequential(new ShooterLifterUp());
    	addSequential(new RotateRight(0.4, 325));
    }
}
