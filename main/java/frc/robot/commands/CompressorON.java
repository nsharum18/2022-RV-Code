// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class CompressorON extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    
    private final AirSubsystem air;

    public CompressorON(AirSubsystem m_air) {

      air = m_air;
      addRequirements(air);

    }
    
    // Use addRequirements() here to declare subsystem dependencies.


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    air.CompressorON();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    air.CompressorON();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    air.CompressorOFF();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}