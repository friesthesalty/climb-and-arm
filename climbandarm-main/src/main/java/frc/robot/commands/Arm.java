// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class Arm extends Command {
  /** Creates a new Arm. */
  public Arm() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.climbAndArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double rightTrigger = Robot.m_robotContainer.GetRightTriggerAxis();
    double leftTrigger = Robot.m_robotContainer.GetLeftTriggerAxis();

    if (rightTrigger > 0) {
      Robot.climbAndArm.close();
    } else if (leftTrigger > 0) {
      Robot.climbAndArm.open();
    } else {
      Robot.climbAndArm.stop();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
