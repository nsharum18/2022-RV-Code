// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

//motor ID values
public static final int LEFT_MASTER = 1;
public static final int LEFT_FOLLOWER = 2;
public static final int RIGHT_MASTER = 3;
public static final int RIGHT_FOLLOWER = 4;
public static final int TOP_INTAKE = 5;
public static final int BOT_INTAKE = 6;
public static final int CHAIR = 7;
public static final int SHOOTER = 8;

//robot values
public static final double DRIVE_SPEED = .6;
public static final double TURN_SPEED = .6;
public static final double SHOOTER_SPEED = .6;
public static final double INTAKE_SPEED = .3;
public static final double FEED_SPEED = .5;
public static final double FEED_VALUE = -20;
public static final double AUTO_SPEED = .6;
public static final double FEEDER_DELAY = 1;
public static final double BACKUP_DISTANCE = -10;
}
