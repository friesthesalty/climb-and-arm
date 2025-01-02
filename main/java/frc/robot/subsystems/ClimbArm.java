// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap; 

/** Add your docs here. */
// Motor Controllers for climbing mechanism
public class ClimbArm extends SubsystemBase{
  private Spark motorLeft1 = new Spark(RobotMap.MOTOR_LEFT_1);
  private Spark motorLeft2 = new Spark(RobotMap.MOTOR_LEFT_2);
  private Spark motorRight1 = new Spark(RobotMap.MOTOR_RIGHT_1);
  private Spark motorRight2 = new Spark(RobotMap.MOTOR_RIGHT_2);

  public ClimbArm() {
    // Invert right motors to match the left motors direction for synchronized movement.
    motorRight1.setInverted(true);
    motorRight2.setInverted(true);

  }

   // Method to control the arm's movement by setting the speed of all motors
  // A positive or negative value passed to speed will move the arm accordingly
  public void moveArm(double speed) {
    motorLeft1.set(speed);
    motorLeft2.set(speed);
    motorRight1.set(speed);
    motorRight2.set(speed);

  }

   // Method to stop the arm by turning off all motors
  public void stopArm() {
    motorLeft1.stopMotor();
    motorLeft2.stopMotor();
    motorRight1.stopMotor();
    motorRight2.stopMotor();
  }

  // Method to extend the arm by setting all motors to a positive speed (1.0)
  public void extend() {
    moveArm(1.0); //positive speed for extending (constant)
  }

  // Method to retract the arm by setting all motors to a negative speed (-1.0)
  public void retract() {
    moveArm(-1.0); //negative speed for retracting (constant)
  }

}
