package org.usfirst.frc.team6947.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous_Middle extends CommandGroup {
    	String gameData =  DriverStation.getInstance().getGameSpecificMessage();
    public Autonomous_Middle() {
    	if(gameData.charAt(0) == 'R') {
    		SmartDashboard.setDefaultString("Autonomous Status: ", "Aiming for Right Switch");
    		addSequential(new AutoStart());
    		addSequential(new RotateRight(0.6, 325));
    		addParallel(new ShooterLifterUp(2800));
    		addSequential(new DriveByDistance(0.4, 8));
    		addSequential(new wait(800));
    		addSequential(new RotateRight(-0.6, 300));
     		
      		addSequential(new DriveForwardByTime(1000));
    		addSequential(new EjectBlock(1));
    		addSequential(new PincherSafetyControll());
    	}else if(gameData.charAt(0) == 'L') {
    		SmartDashboard.setDefaultString("Autonomous Status: ", "Aiming for Left Switch");
    		addSequential(new AutoStart());
    		addSequential(new RotateRight(-0.6, 450));
     		addParallel(new ShooterLifterUp(2800));
    		addSequential(new DriveByDistance(0.4, 8.5));
    		addSequential(new wait(800));
    		addSequential(new RotateRight(0.6, 250));
      		addSequential(new DriveForwardByTime(1000));
    		addSequential(new EjectBlock(1));
    		addSequential(new PincherSafetyControll());
   	}
    	
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
