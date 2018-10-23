package org.usfirst.frc.team6947.robot.subsystems;

import org.usfirst.frc.team6947.robot.Robot;
import org.usfirst.frc.team6947.robot.RobotMap;
import org.usfirst.frc.team6947.robot.commands.MoveShooterObject;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifters extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 public Spark shooterLifter;
	 public DigitalInput limitSwitchUp;
	 public DigitalInput limitSwitchDown;
	 
	 public Lifters() {
	    	shooterLifter = new Spark(RobotMap.SHOOTER_LIFTER);

	    	limitSwitchUp = new DigitalInput(8);
	    	limitSwitchDown = new DigitalInput(7);

	 }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveShooterObject());

    }
  //---------------------Lifter------------------------------------------
  	public void driveByJoystickLift() {
  	    if(!limitSwitchUp.get() && Robot.oi.joystick2.getRawAxis(5) < 0) {
  	    	shooterLifter.set(0.0);
  		}else if(!limitSwitchDown.get() && Robot.oi.joystick2.getRawAxis(5) > 0) {
  			shooterLifter.set(0.0);
  		}else {
  			shooterLifter.set(Robot.oi.joystick2.getRawAxis(5));
  		}
  	}
  	public void shooterLifterUp() {
  	 	shooterLifter.set(-1);
  	}
  	public void shooterLifterDown() {
  		    shooterLifter.set(1);
  	}
}

