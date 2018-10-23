package org.usfirst.frc.team6947.robot.subsystems;

import org.usfirst.frc.team6947.robot.Robot;
import org.usfirst.frc.team6947.robot.RobotMap;
import org.usfirst.frc.team6947.robot.commands.ClimberMove;
import org.usfirst.frc.team6947.robot.commands.MoveShooterObject;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 *
 */
public class Climber extends Subsystem {

    private static Victor climberRIGHT, climberLEFT, AngleAdjuster;	
    private DifferentialDrive climberMotors;
    
   
   
    
    public Climber(){
    	climberRIGHT = new Victor(RobotMap.CLIMBER_RIGHT);
    	climberLEFT = new Victor(RobotMap.CLIMBER_LEFT);
    	climberMotors = new DifferentialDrive(climberRIGHT, climberLEFT);
    	
    	
    }
    
    public void ClimberMove(double power, double rotation) {
    	climberMotors.curvatureDrive(power, rotation, true);;
    }
    public void ClimberStop(){
    	climberMotors.stopMotor();
    }
    public void AddDegree(double power) {
    	AngleAdjuster.set(power);
    }
    public void SubtractDegree(double power) {
    	AngleAdjuster.set(-power);
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberMove());
    }
    public void driveByJoystick(){
    	climberMotors.curvatureDrive(-Robot.oi.joystick2.getRawAxis(1), Robot.oi.joystick2.getRawAxis(1), true);
    }
    public void stop() {
    	AngleAdjuster.set(0.0);;
    }

}

