package org.usfirst.frc.team6947.robot.subsystems;

import org.usfirst.frc.team6947.robot.commands.DriveByJoystick;
import org.usfirst.frc.team6947.robot.Robot;
import org.usfirst.frc.team6947.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem implements PIDOutput{

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	  private WPI_TalonSRX masterLEFT;
	  private WPI_TalonSRX slaveLEFT;
	    
	  private WPI_TalonSRX masterRIGHT;
	  private WPI_TalonSRX slaveRIGHT;
	    
	  public DifferentialDrive robotDrive;
	  private SpeedControllerGroup m_Right;
	  private SpeedControllerGroup m_Left;

	  public double Kp = 1.0;
	  public double Ki = 1.0;
	  public double Kd = 1.0;
	  public double Kf = 1.0;
	  
	  public Encoder encoderLEFT;
	  
	  PIDController PID;
	  
	public Chassis() {
	    masterLEFT = new WPI_TalonSRX(RobotMap.DRIVE_MASTER_LEFT);
    	slaveLEFT = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_LEFT);
    	m_Left = new SpeedControllerGroup(masterLEFT, slaveLEFT);
    	
    	masterRIGHT = new WPI_TalonSRX(RobotMap.DRIVE_MASTER_RIGHT);
    	slaveRIGHT = new WPI_TalonSRX(RobotMap.DRIVE_SLAVE_RIGHT);
    	m_Right = new SpeedControllerGroup(masterRIGHT, slaveRIGHT);
    	
    	robotDrive = new DifferentialDrive(m_Left, m_Right);
    	
    	encoderLEFT = new Encoder(0,1);
    	
    	masterRIGHT.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	
//  	PID = new PIDController(Robot.chassis.Kp, Robot.chassis.Ki, Robot.chassis.Kd, FeedbackDevice.CTRE_MagEncoder_Relative, );
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveByJoystick());
    	   
    }
    
    public void stop() {
    	robotDrive.curvatureDrive(0, 0, true);
    }
    public void Forward(double power){
    	robotDrive.curvatureDrive(power, -0.03, true);
    }
    public void Backward(double power) {
    	robotDrive.curvatureDrive(-power, 0, true);
    }
    public void DriveLeft(double power){
    	masterLEFT.set(-power);
    	masterRIGHT.set(-power);
    }
    public void DriveRight(double power){
    	masterRIGHT.set(power);
    	masterLEFT.set(power);
    }
    public void driveByJoystick(double yDir,double xDir){
    	SmartDashboard.putString("Drive by joystick?", yDir + "," + xDir);
    	robotDrive.arcadeDrive(-yDir*((-Robot.oi.joystick1.getRawAxis(3)+1)*0.5),xDir*((-Robot.oi.joystick1.getRawAxis(3)+1)*0.5));
    }
    
    public int getEncoderTick() {
    	return masterRIGHT.getSensorCollection().getQuadraturePosition();
    }
    public void encoderReset() {
    	masterRIGHT.getSensorCollection().setQuadraturePosition(0, 100);
    }

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
}

