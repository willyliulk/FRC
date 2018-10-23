package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStart extends CommandGroup {

    public AutoStart() {
    	requires(Robot.chassis);
    	requires(Robot.shooter);
    	 
    	addSequential(new ShooterPinch());
    	addSequential(new wait(1000));
    	addParallel(new PincherSafetyControll());
    	addSequential(new ShooterLifterUp(1200));
    	addSequential(new DriveByDistance(0.4, 4));
    	addSequential(new DriveBackwardByTime(800));
    	addSequential(new ShooterLifterDown(800));
//    	addParallel(new DriveByDistance(0.4, 4));
    	addSequential(new PincherSafetyControll());
    	addSequential(new CollectBlock(1));

    	//228, 467
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
