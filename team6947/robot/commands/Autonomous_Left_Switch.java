package org.usfirst.frc.team6947.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous_Left_Switch extends CommandGroup {
    	String gameData =  DriverStation.getInstance().getGameSpecificMessage();
    public Autonomous_Left_Switch() {
		addSequential(new AutoStart());

    	if(gameData.charAt(0) == 'L') {
    		SmartDashboard.setDefaultString("Autonomous Status: ", "Aiming for Left Switch");
    		addParallel(new ShooterLifterUp(2500));
    		addSequential(new DriveByDistance(0.4, 14));
    		addSequential(new RotateRight(0.4, 800));
    		addSequential(new DriveForwardByTime(400));
    		addSequential(new EjectBlock(1));
    		addSequential(new PincherSafetyControll());
    		addSequential(new wait(400));
    	}else {
    		SmartDashboard.setDefaultString("Autonomous Status: ", "Aiming for the Auto-Line");
    		addParallel(new DriveByDistance(0.3, 13));
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
