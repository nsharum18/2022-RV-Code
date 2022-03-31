// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  //creating shoot motor
  CANSparkMax Shooter = new CANSparkMax(Constants.SHOOTER, MotorType.kBrushless);

  //sets up encoder
  private RelativeEncoder shooterEncoder;

  /** Creates a new ExampleSubsystem. */
  public ShooterSubsystem() {

    //finish setup for encoders
    shooterEncoder = Shooter.getEncoder();

  }

  public double getEncoder() {

   return shooterEncoder.getPosition();

  }

  public void shoot() {

    Shooter.set(-Constants.SHOOTER_SPEED);

  }

  public void stop() {

    Shooter.set(0);

  }

  public void resetEncoder() {

    shooterEncoder.setPosition(0);
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
