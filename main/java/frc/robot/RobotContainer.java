// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final AirSubsystem m_air = new AirSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final FeederSubsystem m_feeder = new FeederSubsystem();
  private final ShooterSubsystem m_shooter = new ShooterSubsystem();

  //setting controllers
  XboxController Driver1 = new XboxController(XboxConstants.DRIVER1_STICKS);
  XboxController Driver2 = new XboxController(XboxConstants.DRIVER2_STICKS);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_drive.setDefaultCommand( 
      
      new RunCommand(
        () ->
          m_drive.arcadeDrive(-Driver1.getLeftY(), Driver1.getRightX()), m_drive));

      //compressor on
      new CompressorON(m_air);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

   /****************** DRIVER1 CONTROLS ******************/

    //Driver1 lbumper button shoot
    new JoystickButton(Driver1, XboxConstants.XBOX_LBUMPER)
        .whileHeld(new ShootSequence(m_feeder, m_shooter));

    //Driver1 RBumper button intake
    new JoystickButton(Driver1, XboxConstants.XBOX_RBUMPER)
        .whileHeld(new Intake(m_intake, m_feeder));

   /****************** DRIVER2 CONTROLS ******************/

    new JoystickButton(Driver2, XboxConstants.XBOX_LBUMPER)
        .whenPressed(new Feed(m_feeder));
  
    new JoystickButton(Driver2, XboxConstants.XBOX_RBUMPER)
        .whenPressed(new IntakeIN(m_air));

    new JoystickButton(Driver2, XboxConstants.XBOX_A)
        .whenPressed(new IntakeIN(m_air));

    new JoystickButton(Driver2, XboxConstants.XBOX_B)
        .whenPressed(new IntakeOUT(m_air));



  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
    // An ExampleCommand will run in autonomous
    
  }
}
