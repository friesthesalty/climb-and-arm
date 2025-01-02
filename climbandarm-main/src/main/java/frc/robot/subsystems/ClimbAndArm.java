// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ClimbAndArm extends SubsystemBase {

  private Spark clawMotorLeft = new Spark(RobotMap.CLAW_MOTOR_LEFT);
  private Spark clawMotorRight = new Spark(RobotMap.CLAW_MOTOR_RIGHT);
  private Spark stageMotorLeft = new Spark(RobotMap.STAGE_MOTOR_LEFT);
  private Spark stageMotorRight = new Spark(RobotMap.STAGE_MOTOR_RIGHT);

  public void close() {
    clawMotorLeft.set(0.1); // just some constant speed
    clawMotorRight.set(0);
  }

  public void open() {
    clawMotorRight.set(0.1);
    clawMotorLeft.set(0);
  }


  public void clawStop() {
    clawMotorLeft.set(0);
    clawMotorLeft.set(0);
  }

  public void moveUp() {
    stageMotorLeft.set(0.1);
    stageMotorRight.set(0);
  }

  public void moveDown() {
    stageMotorRight.set(0.1);
    stageMotorLeft.set(0);
  }

  public void stageStop() {
    stageMotorLeft.set(0);
    stageMotorLeft.set(0);
  }

  /** Creates a new climbAndArm. */
  public ClimbAndArm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
