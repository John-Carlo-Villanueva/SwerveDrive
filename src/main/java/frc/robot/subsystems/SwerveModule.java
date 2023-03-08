package frc.robot.subsystems;

import com.ctre.phoenixpro.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModule extends SubsystemBase{
    private CANSparkMax turningMotor;
    private CANSparkMax driveMotor;

    private RelativeEncoder turningEnc;
    private RelativeEncoder driveEnc;

    private PIDController turningPID;

    private CANcoder absoluteEnc;
    private boolean absoluteEncReversed;
    private double absoluteEncOffsetRad;

    public SwerveModule(int driveMotorId, int turningMotorId, boolean driveMotorReversed, boolean turningMotorReversed, 
    int absoluteEncId, double absoluteEncOffset, boolean absoluteEncReversed){

        this.absoluteEncOffsetRad = absoluteEncOffset;
        this.absoluteEncReversed = absoluteEncReversed;
        absoluteEnc = new CANcoder(absoluteEncId);

        driveMotor = new CANSparkMax(driveMotorId, MotorType.kBrushless);
        turningMotor = new CANSparkMax(turningMotorId, MotorType.kBrushless);

        driveMotor.setInverted(driveMotorReversed);
        turningMotor.setInverted(turningMotorReversed);

        driveEnc = driveMotor.getEncoder();
        turningEnc = turningMotor.getEncoder();


        turningPID = new PIDController(1, 0, 0);
    }
}
