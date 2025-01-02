// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap; 

/** Add your docs here. */
public class ClimbArm extends SubsystemBase{
  private Spark motorLeft1 = new Spark(RobotMap.MOTOR_LEFT_1);
  private Spark motorLeft2 = new Spark(RobotMap.MOTOR_LEFT_2);
  private Spark motorRight1 = new Spark(RobotMap.MOTOR_RIGHT_1);
  private Spark motorRight2 = new Spark(RobotMap.MOTOR_RIGHT_2);

  public ClimbArm() {
    motorRight1.setInverted(true);
    motorRight2.setInverted(true);

  }

  public void moveArm(double speed) {
    motorLeft1.set(speed);
    motorLeft2.set(speed);
    motorRight1.set(speed);
    motorRight2.set(speed);

  }

  public void stopArm() {
    motorLeft1.stopMotor();
    motorLeft2.stopMotor();
    motorRight1.stopMotor();
    motorRight2.stopMotor();
  }

  public void extend() {
    moveArm(1.0); //positive speed for extending
  }

  public void retract() {
    moveArm(-1.0); //negative speed for retracting
  }

}
