package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class SwerveSubsystem extends SubsystemBase{
    private SwerveModule frontLeft;
    private SwerveModule frontRight;
    private SwerveModule backLeft;
    private SwerveModule backRight;
    private AHRS gyro = new AHRS(SPI.Port.kMXP);

    public SwerveSubsystem(){
        
        frontLeft = new SwerveModule(DriveConstants.kFrontLeftDriveMotorPort, DriveConstants.kFrontLeftTurningMotorPort, DriveConstants.kFrontLeftDriveEncoderReversed, DriveConstants.kFrontLeftTurningEncoderReversed,
         DriveConstants.kFrontLeftDriveAbsoluteEncoderPort, DriveConstants.kFrontLeftDriveAbsoluteEncoderOffsetRad, DriveConstants.kFrontLeftDriveAbsoluteEncoderReversed);

        frontRight = new SwerveModule(DriveConstants.kFrontRightDriveMotorPort, DriveConstants.kFrontRightTurningMotorPort, DriveConstants.kFrontRightDriveEncoderReversed,
         DriveConstants.kFrontRightTurningEncoderReversed, DriveConstants.kFrontRightDriveAbsoluteEncoderPort, DriveConstants.kFrontRightDriveAbsoluteEncoderOffsetRad, DriveConstants.kFrontRightDriveAbsoluteEncoderReversed);

        backLeft = new SwerveModule(DriveConstants.kBackLeftDriveMotorPort, DriveConstants.kBackLeftTurningMotorPort, DriveConstants.kBackLeftDriveEncoderReversed,
         DriveConstants.kBackLeftTurningEncoderReversed, DriveConstants.kBackLeftDriveAbsoluteEncoderPort, DriveConstants.kBackLeftDriveAbsoluteEncoderOffsetRad, DriveConstants.kBackLeftDriveAbsoluteEncoderReversed);

        backRight = new SwerveModule(DriveConstants.kBackRightDriveMotorPort, DriveConstants.kBackRightTurningMotorPort, DriveConstants.kBackRightDriveEncoderReversed, DriveConstants.kBackRightTurningEncoderReversed,
         DriveConstants.kBackRightDriveAbsoluteEncoderPort, DriveConstants.kBackRightDriveAbsoluteEncoderOffsetRad, DriveConstants.kBackRightDriveAbsoluteEncoderReversed);
    }
}
