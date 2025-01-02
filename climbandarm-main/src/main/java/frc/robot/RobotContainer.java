// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// used https://first.wpi.edu/wpilib/allwpilib/docs/release/java/edu/wpi/first/wpilibj/XboxController.html

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
  private XboxController driverController = new XboxController(RobotMap.DRIVER_CONTROLLER);

  public double GetDriverRawAxis(int axis){
    return driverController.getRawAxis(axis);
  }

  public double GetRightTriggerAxis() {
    return driverController.getRightTriggerAxis();
  }

  public double GetLeftTriggerAxis() {
    return driverController.getLeftTriggerAxis();
  }

  public Boolean GetLeftBumper() {
    return driverController.getLeftBumper();
  }

  public Boolean GetRightBumper() {
    return driverController.getRightBumper();
  }

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  
}
