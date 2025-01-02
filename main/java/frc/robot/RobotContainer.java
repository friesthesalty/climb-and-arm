// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
//JoystickButton handles button inputs from a joystick or controller
import edu.wpi.first.wpilibj2.command.button.JoystickButton; 
import frc.robot.subsystems.ClimbArm;

public class RobotContainer {
  // Subsystems
  private final ClimbArm climbArm = new ClimbArm();

  // Controllers
  private final XboxController driverController = new XboxController(RobotMap.DRIVER_CONTROLLER);

  // Get raw axis value from driver controller
  public double GetDriverRawAxis(int axis){
    return driverController.getRawAxis(axis);
  }

  public double GetRightTriggerAxis() {
    return driverController.getRightTriggerAxis();
  }

  public double GetLeftTriggerAxis() {
    return driverController.getLeftTriggerAxis();

  }

  public RobotContainer() {
    configureBindings();
  }

  
  // Set up button bindings for controlling the climb arm
  private void configureBindings() {
    // Assuming buttons 1 and 2 control the climb arm actions
  
    // Button 1 extends the arm
    new JoystickButton(driverController, 1).onTrue(Commands.runOnce(() -> {
      // Check if button 2 is NOT pressed, using the '!'. If button 2 is pressed, it goes to the else statement, stopping the arm
      if (!driverController.getRawButton(2)) { 
        climbArm.extend();
        } else {
            climbArm.stopArm(); // Stop if both buttons are pressed
        }
    }));
  
    // Button 2 retracts the arm
    new JoystickButton(driverController, 2).onTrue(Commands.runOnce(() -> {
        // Check if button 1 is NOT pressed, using the '!'. If button 1 is pressed, it goes to the else statement, stopping the arm
        if (!driverController.getRawButton(1)) { 
          climbArm.retract();
          } else {
              climbArm.stopArm(); // Stop if both buttons are pressed
          }
      }));
  
    // Stop the arm if neither button 1 nor button 2 is pressed
    new JoystickButton(driverController, 1).onFalse(Commands.runOnce(() -> climbArm.stopArm()));
    new JoystickButton(driverController, 2).onFalse(Commands.runOnce(() -> climbArm.stopArm()));
  }
  

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }


}


