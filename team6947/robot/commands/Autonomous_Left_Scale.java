package org.usfirst.frc.team6947.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous_Left_Scale extends CommandGroup {
    	String gameData =  DriverStation.getInstance().getGameSpecificMessage();
    public Autonomous_Left_Scale() {
    	
    	if(gameData.charAt(1) == 'L') {
    		SmartDashboard.setDefaultString("Autonomous Status: ", "Aiming for Left Scale");
    		addSequential(new AutoStart());
    		addParallel(new ShooterLifterUp(8000));
    		addSequential(new DriveByDistance(0.45, 25));
    		addSequential(new wait(1000));
    		addSequential(new RotateRight(0.4, 500));
    		addSequential(new EjectBlock(1));
    	}else{
    		addSequential(new Autonomous_Left_Switch());
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
