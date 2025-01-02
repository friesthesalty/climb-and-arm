// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// used https://docs.wpilib.org/en/stable/docs/software/hardware-apis/sensors/ultrasonics-software.html

package frc.robot.commands;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Arm extends Command {
  /** Creates a new Arm. */
  public Arm() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.climbAndArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // returns true if sensor is within distance threshold
  public Boolean sensorAccepted(int triggerPin, int echoPin) {
    final int limitMM = 25; // 25 millimeters for limit


    Ultrasonic ultrasonicMeasure = new Ultrasonic(triggerPin, echoPin);
    double measurementMM = ultrasonicMeasure.getRangeMM();

    return measurementMM > limitMM;
  }  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // sensors
    Boolean stageSensorTop = sensorAccepted(RobotMap.TRIGGER_PIN_STAGE_1, RobotMap.ECHO_PIN_STAGE_1);
    Boolean stageSensorBottom = sensorAccepted(RobotMap.TRIGGER_PIN_STAGE_2, RobotMap.ECHO_PIN_STAGE_2);

    // checks whether something is being held in the claw
    Boolean clawSensor = sensorAccepted(RobotMap.TRIGGER_PIN_GRIPPER, RobotMap.ECHO_PIN_GRIPPER);
 
    // gripper
    double rightTrigger = Robot.m_robotContainer.GetRightTriggerAxis();
    double leftTrigger = Robot.m_robotContainer.GetLeftTriggerAxis();

    if (rightTrigger * leftTrigger == 0) { // false when both triggers are pressed
      if (rightTrigger > 0) {
        Robot.climbAndArm.close();
      } else if (leftTrigger > 0) {
        Robot.climbAndArm.open();
      } else {
        Robot.climbAndArm.clawStop();
      }
    }
    //
    

    // belt drive
    // right bumper = up, left bumper = down
    Boolean leftBumper = Robot.m_robotContainer.GetLeftBumper();
    Boolean rightBumper = Robot.m_robotContainer.GetRightBumper();

    if (!(rightBumper && leftBumper)) { // false when both bumpers are pressed
      if (rightBumper && stageSensorTop) {
        Robot.climbAndArm.moveUp();
      } else if (leftBumper && stageSensorBottom) {
        Robot.climbAndArm.moveDown();
      } else {
        Robot.climbAndArm.stageStop();
      }
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
