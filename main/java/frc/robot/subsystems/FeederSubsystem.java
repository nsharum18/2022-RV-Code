// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederSubsystem extends SubsystemBase {

  //creating intake motors
  CANSparkMax Chair = new CANSparkMax(Constants.CHAIR, MotorType.kBrushless);


  //sets up encoder
  private RelativeEncoder chairEncoder;

  /** Creates a new ExampleSubsystem. */
  public FeederSubsystem() {

    //finish setup for encoders
    chairEncoder = Chair.getEncoder();

  }

  public double getEncoder() {

    return chairEncoder.getPosition();
    
  }
  

  public void Feed() {

    Chair.set(-Constants.FEED_SPEED);

  }

  public void stop() {

    Chair.set(0);

  }

  public void resetEncoder() {

    chairEncoder.setPosition(0);
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
