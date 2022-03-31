// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class AirSubsystem extends SubsystemBase {

  Compressor compressor = new Compressor(21, PneumaticsModuleType.CTREPCM);

  Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

  /** Creates a new ExampleSubsystem. */
  public AirSubsystem() {


  }

  public void IntakeOut() {

    intakeSolenoid.set(true);
    
  }

  public void IntakeIn() {

    intakeSolenoid.set(false);

    
  }

  public void CompressorON() {

    compressor.enabled();

  }

  public void CompressorOFF() {

    compressor.disable();

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
