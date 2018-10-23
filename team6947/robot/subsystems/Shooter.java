package org.usfirst.frc.team6947.robot.subsystems;

import org.usfirst.frc.team6947.robot.Robot;
import org.usfirst.frc.team6947.robot.RobotMap;
import org.usfirst.frc.team6947.robot.commands.MoveShooterObject;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {

    private Victor shooterRIGHT, shooterLEFT, hand;
    public Solenoid leftPincher, rightPincher;
    DifferentialDrive shooterMotor, liftMotor;
    
    private long startTime;
    
    public Shooter() {
    	shooterRIGHT = new Victor(RobotMap.SHOOTER_RIGHT);	
    	shooterLEFT = new Victor(RobotMap.SHOOTER_LEFT);
    	
    	leftPincher = new Solenoid(5, RobotMap.LEFT_PINCHER);
    	rightPincher = new Solenoid(5, RobotMap.RIGHT_PINCHER);
    	
    	shooterMotor = new DifferentialDrive(shooterRIGHT, shooterLEFT);
    	


    }
    public void initDefaultCommand() {
    }
    
    public void collect (double power, long targetTime) {
    	
    	startTime = System.currentTimeMillis();
    	if(leftPincher.get()) {
    		while(System.currentTimeMillis() - startTime <=  1000) {
    			shooterMotor.curvatureDrive(power, 0, false);
    		}
    		shooterMotor.curvatureDrive(power, 0, false);
    	}else {
    		while(System.currentTimeMillis() - startTime <=  targetTime) {
    			System.out.println("Accelerating Shooter.....");
    			shooterMotor.curvatureDrive(power, 0, false);
    		}
    	}
		shooterMotor.curvatureDrive(power, 0, false);
    	leftPincher.set(true);
    	rightPincher.set(true);
    }
    public void eject(double power) {
    	shooterMotor.curvatureDrive(-power, 0, false);
    }
    
    public void pinch() {
    	leftPincher.set(true);
    	rightPincher.set(true);
    }
    public void release() {
    	leftPincher.set(false);
    	rightPincher.set(false);
    }
    public void stop() {
    	
    	shooterMotor.curvatureDrive(0, 0, true);;
    }
    public void stickDown() {
    	hand.set(1);
    }
    public void stickUp() {
    	hand.set(-1);
    }
    public void stickStop() {
    	hand.set(0.0);
    }
	public void pincherSafety() {
		if(leftPincher.get() == true && rightPincher.get() == true) {
			leftPincher.set(false);
	    	rightPincher.set(false);
		}else if(leftPincher.get() == false && rightPincher.get() == false) {
			leftPincher.set(true);
	    	rightPincher.set(true);
		}
			
	}
}

