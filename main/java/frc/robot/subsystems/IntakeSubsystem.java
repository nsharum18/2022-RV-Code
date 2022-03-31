// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

  //creating intake motors
  CANSparkMax TopIntake = new CANSparkMax(Constants.TOP_INTAKE, MotorType.kBrushless);
  CANSparkMax BotIntake = new CANSparkMax(Constants.BOT_INTAKE, MotorType.kBrushless);


  //sets up encoder
  private RelativeEncoder intakeEncoder;

  /** Creates a new ExampleSubsystem. */
  public IntakeSubsystem() {

    //finish setup for encoders
    intakeEncoder = TopIntake.getEncoder();

  }

  public double getEncoder() {

   return intakeEncoder.getPosition();
    
  }

  public void Intake() {

    TopIntake.set(Constants.INTAKE_SPEED);
    BotIntake.set(Constants.INTAKE_SPEED * -1);

  }

  public void stop() {

    TopIntake.set(0);
    BotIntake.set(0);

  }

  public void resetEncoder() {

    intakeEncoder.setPosition(0);
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
