// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class ShootSequence extends SequentialCommandGroup {
  
      public ShootSequence(FeederSubsystem m_feeder, ShooterSubsystem m_shooter) {
  
  
          addCommands(
        new ParallelDeadlineGroup(
          
          new WaitCommand(4),

          new Shoot(m_shooter),

          sequence(
            new WaitCommand(Constants.FEEDER_DELAY),

            new Feed(m_feeder),

            new WaitCommand(Constants.FEEDER_DELAY),

            new Feed(m_feeder)
          )
        )
      );
    }
}
