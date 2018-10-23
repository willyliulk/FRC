package org.usfirst.frc.team6947.robot.commands;

import org.usfirst.frc.team6947.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous_BluePrint extends CommandGroup {
	/*String gameData =  DriverStation.getInstance().getGameSpecificMessage();*/
    public Autonomous_BluePrint() {
    	//addSequential(new Autonomous_Left_Scale());
    	//addSequential(new Autonomous_Left_Switch());
    	addSequential(new Autonomous_Middle());
    	//addSequential(new Autonomous_Righht_Scale());
    	//addSequential(new Autonomous_Right_Switch());
    	/*System.out.println("Running Auto");
    	if (SmartDashboard.getBoolean("Other teams can own switch: ", true)) {
    		if (SmartDashboard.getString("Which Side: ", "left") == "left") {
    			if (gameData.charAt(1) == 'L') {
    				SmartDashboard.putString("Autonomous Status", "Aiming for Left Scale");
    			}else {
    				if (gameData.charAt(0) == 'L') {
    					SmartDashboard.putString("Autonomous Status", "Aiming for Left Switch");
    				}else {
        				SmartDashboard.putString("Autonomous Status", "Aiming for Cross the AutoLine");

    				}
    			}
    		}else if(SmartDashboard.getString("Which Side: ", "right") == "right") {
    			if (gameData.charAt(1) == 'R') {
    				SmartDashboard.putString("Autonomous Status", "Aiming for Right Scale");
    			}else {
    				if (gameData.charAt(0) == 'R') {
    					SmartDashboard.putString("Autonomous Status", "Aiming for Right Switch");
    				}else {
        				SmartDashboard.putString("Autonomous Status", "Aiming for Cross the AutoLine");
    				}
    			}
    		}else {
    			if (gameData.charAt(0) == 'L') {
					SmartDashboard.putString("Autonomous Status", "Aiming for Left Switch");
				}else if (gameData.charAt(0) == 'R'){
    				SmartDashboard.putString("Autonomous Status", "Aiming for Right Switch");

				}
    		}
    	}else{
    		if (SmartDashboard.getString("Which Side: ", "left") == "left") {
    			if (gameData.charAt(1) == 'L') {
    				SmartDashboard.putString("Autonomous Status", "Aiming for Left Scale");
    			}else {
    				if (gameData.charAt(0) == 'L') {
    					SmartDashboard.putString("Autonomous Status", "Aiming for Left Switch");
    				}else {
        				SmartDashboard.putString("Autonomous Status", "Aiming for Cross the AutoLine");

    				}
    			}
    		}else if(SmartDashboard.getString("Which Side: ", "right") == "right") {
    			if (gameData.charAt(1) == 'R') {
    				SmartDashboard.putString("Autonomous Status", "Aiming for Right Scale");
    			}else {
    				if (gameData.charAt(0) == 'R') {
    					SmartDashboard.putString("Autonomous Status", "Aiming for Right Switch");
    				}else {
        				SmartDashboard.putString("Autonomous Status", "Aiming for Cross the AutoLine");
    				}
    			}
    		}else {
    			if (gameData.charAt(0) == 'L') {
					SmartDashboard.putString("Autonomous Status", "Aiming for Left Switch");
				}else if (gameData.charAt(0) == 'R'){
    				SmartDashboard.putString("Autonomous Status", "Aiming for Right Switch");

				}
    		}
    	}
/*    	addParallel(new DriveByDistance(0.3, 14));
    	addSequential(new ShooterLifterUp(5500));
    	addSequential(new RotateRight(0.4, 325));*/
    	
    }
}
