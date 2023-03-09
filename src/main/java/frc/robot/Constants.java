package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {

  public static class ModuleConstants {
    public static final double kWheelDiameterMeters = Units.inchesToMeters(1);
    public static final double kDriveMotorGearRatio = 1 / 4;
    public static final double kTurningMotorGearRatio = 1 / 4;
    public static final double kDriveEncRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
    public static final double kTurningEncRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
    public static final double kDriveEncRPM2MeterPerSec = kDriveEncRot2Meter / 10;
    public static final double kTurningEncRPM2RadPerSec = kTurningEncRot2Rad / 10;
    public static final double kPTurning = 0.5;
  }

  public static final class DriveConstants {

    public static final double kTrackWidth = Units.inchesToMeters(1);
    // Distance between right and left wheels
    public static final double kWheelBase = Units.inchesToMeters(1);
    // Distance between front and back wheels
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2));

    public static final int kFrontLeftDriveMotorPort = 1;
    public static final int kBackLeftDriveMotorPort = 2;
    public static final int kFrontRightDriveMotorPort = 3;
    public static final int kBackRightDriveMotorPort = 4;

    public static final int kFrontLeftTurningMotorPort = 5;
    public static final int kBackLeftTurningMotorPort = 6;
    public static final int kFrontRightTurningMotorPort = 7;
    public static final int kBackRightTurningMotorPort = 8;

    public static final boolean kFrontLeftTurningEncoderReversed = false;
    public static final boolean kBackLeftTurningEncoderReversed = false;
    public static final boolean kFrontRightTurningEncoderReversed = false;
    public static final boolean kBackRightTurningEncoderReversed = false;

    public static final boolean kFrontLeftDriveEncoderReversed = false;
    public static final boolean kBackLeftDriveEncoderReversed = false;
    public static final boolean kFrontRightDriveEncoderReversed = false;
    public static final boolean kBackRightDriveEncoderReversed = false;

    public static final int kFrontLeftDriveAbsoluteEncoderPort = 9;
    public static final int kBackLeftDriveAbsoluteEncoderPort = 10;
    public static final int kFrontRightDriveAbsoluteEncoderPort = 11;
    public static final int kBackRightDriveAbsoluteEncoderPort = 12;

    public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = false;
    public static final boolean kBackLeftDriveAbsoluteEncoderReversed = false;
    public static final boolean kFrontRightDriveAbsoluteEncoderReversed = false;
    public static final boolean kBackRightDriveAbsoluteEncoderReversed = false;

    public static final double kFrontLeftDriveAbsoluteEncoderOffsetRad = 1;
    public static final double kBackLeftDriveAbsoluteEncoderOffsetRad = 1;
    public static final double kFrontRightDriveAbsoluteEncoderOffsetRad = 1;
    public static final double kBackRightDriveAbsoluteEncoderOffsetRad = 1;

    public static final double kPhysicalMaxSpeedMetersPerSecond = 1;
    public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

    public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 4;
    public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
    public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3;
    public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;
  }
}