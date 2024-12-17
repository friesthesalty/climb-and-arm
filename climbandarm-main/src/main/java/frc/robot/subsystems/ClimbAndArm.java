// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ClimbAndArm extends SubsystemBase {

  private Spark armMotorLeft = new Spark(RobotMap.ARM_MOTOR_LEFT);
  private Spark armMotorRight = new Spark(RobotMap.ARM_MOTOR_RIGHT);

  public void close() {
    armMotorLeft.set(1); // just some constant speed
    armMotorRight.set(0);
  }

  public void open() {
    armMotorRight.set(1);
    armMotorLeft.set(0);
  }


  public void stop() {
    armMotorLeft.set(0);
    armMotorLeft.set(0);
  }

  /** Creates a new climbAndArm. */
  public ClimbAndArm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
