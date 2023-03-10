package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

  private SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
  private XboxController xController = new XboxController(0);

  public RobotContainer() {
    swerveSubsystem.setDefaultCommand(new SwerveJoystickCmd(swerveSubsystem,
    () -> -xController.getLeftX(),
    () -> xController.getLeftY(),
    () -> xController.getRightX()));
    configureBindings();
  }
  private void configureBindings() {
    
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
