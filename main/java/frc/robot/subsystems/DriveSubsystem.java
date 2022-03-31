// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  //creating drive motors
  CANSparkMax LMaster = new CANSparkMax(Constants.LEFT_MASTER, MotorType.kBrushless);
  CANSparkMax LFollower = new CANSparkMax(Constants.LEFT_FOLLOWER, MotorType.kBrushless);
  CANSparkMax RMaster = new CANSparkMax(Constants.RIGHT_MASTER, MotorType.kBrushless);
  CANSparkMax RFollower = new CANSparkMax(Constants.RIGHT_FOLLOWER, MotorType.kBrushless);

  //sets up drivetrain
  private final DifferentialDrive m_drive = new DifferentialDrive(LMaster,RMaster);

  //sets up encoders
  private RelativeEncoder leftEncoder;
  private RelativeEncoder rightEncoder;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {

    //followers following masters
    LFollower.follow(LMaster);
    RFollower.follow(RMaster);

    //finish setup for encoders
    leftEncoder = LMaster.getEncoder();
    rightEncoder = RMaster.getEncoder();

    RMaster.setInverted(true);

  }

  public double getLMasterEncoder() {

  return leftEncoder.getPosition();
  }

  public double getRMasterEncoder() {

  return rightEncoder.getPosition();
    
  }

  public void arcadeDrive(double fwd, double rot) {

    m_drive.arcadeDrive(fwd * Constants.DRIVE_SPEED, rot * Constants.TURN_SPEED);
  }

  public void stop() {

    m_drive.arcadeDrive(0,0);

  }

  public void resetEncoders() {

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
