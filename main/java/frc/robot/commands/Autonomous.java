// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class Autonomous extends SequentialCommandGroup {
  
      public Autonomous(FeederSubsystem m_feeder, ShooterSubsystem m_shooter, DriveSubsystem m_drive) {
  
  
          addCommands(

          new ShootSequence(m_feeder, m_shooter),

          new DriveCommand(false, Constants.BACKUP_DISTANCE, -Constants.AUTO_SPEED, m_drive)
      );
    }
}
