package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.ModuleConstants;

public class SwerveModule extends SubsystemBase{
    private CANSparkMax turningMotor;
    private CANSparkMax driveMotor;

    private RelativeEncoder turningEnc;
    private RelativeEncoder driveEnc;

    private PIDController turningPID;

    private AnalogInput absoluteEnc;
    private boolean absoluteEncReversed;
    private double absoluteEncOffsetRad;

    public SwerveModule(int driveMotorId, int turningMotorId, boolean driveMotorReversed, boolean turningMotorReversed, 
    int absoluteEncId, double absoluteEncOffset, boolean absoluteEncReversed){

        this.absoluteEncOffsetRad = absoluteEncOffset;
        this.absoluteEncReversed = absoluteEncReversed;
        absoluteEnc = new AnalogInput(absoluteEncId);

        driveMotor = new CANSparkMax(driveMotorId, MotorType.kBrushless);
        turningMotor = new CANSparkMax(turningMotorId, MotorType.kBrushless);

        driveMotor.setInverted(driveMotorReversed);
        turningMotor.setInverted(turningMotorReversed);

        driveEnc = driveMotor.getEncoder();
        turningEnc = turningMotor.getEncoder();

        driveEnc.setPositionConversionFactor(ModuleConstants.kDriveEncRot2Meter);
        driveEnc.setVelocityConversionFactor(ModuleConstants.kDriveEncRPM2MeterPerSec);
        turningEnc.setPositionConversionFactor(ModuleConstants.kTurningEncRot2Rad);
        turningEnc.setVelocityConversionFactor(ModuleConstants.kTurningEncRPM2RadPerSec);

        turningPID = new PIDController(ModuleConstants.kPTurning, 0, 0);
        turningPID.enableContinuousInput(-Math.PI, Math.PI);

        resetEncs();
    }

    public double getDrivePosition(){
        return driveEnc.getPosition();
    }

    public double getTurningPosition(){
        return turningEnc.getPosition();
    }

    public double getDriveVelocity(){
        return driveEnc.getVelocity();
    }

    public double getTurningVelocity(){
        return turningEnc.getVelocity();
    }

    public double getAbsoluteEncRad(){
        double angle = absoluteEnc.getVoltage() / RobotController.getVoltage5V();
        angle *= 2.0 * Math.PI;
        angle -= absoluteEncOffsetRad;
        return angle * (absoluteEncReversed ? -1.0:1.0);
    }

    public void resetEncs(){
        driveEnc.setPosition(0);
        turningEnc.setPosition(getAbsoluteEncRad());
    }

    public SwerveModuleState getState(){
        return new SwerveModuleState(getDriveVelocity(), new Rotation2d(getTurningPosition()));
    }

    public void setDesiredState(SwerveModuleState state){
        if (Math.abs(state.speedMetersPerSecond) < 0.001){
            stop();
            return;
        }
        state = SwerveModuleState.optimize(state, getState().angle);
        driveMotor.set(state.speedMetersPerSecond / DriveConstants.kPhysicalMaxSpeedMetersPerSecond);
        turningMotor.set(turningPID.calculate(getTurningPosition(), state.angle.getRadians()));
        SmartDashboard.putString("Swerve[" + absoluteEnc.getChannel() + "] state", state.toString());
    }

    public void stop() {
        driveMotor.set(0);
        turningMotor.set(0);
    }
}
