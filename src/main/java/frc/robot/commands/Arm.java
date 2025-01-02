// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ClimbArm;

/** Add your docs here. */
public class Arm extends Command{
    private static final ClimbArm climbArm = null;

    // Creates a new arm
    public Arm(){
         // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.climbArm);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        double rightTrigger =  Robot.m_robotContainer.GetRightTriggerAxis(); 
        double leftTrigger =  Robot.m_robotContainer.GetLeftTriggerAxis();  
    

        // Control logic for the climb arm:
        // If the right trigger is pressed beyond a small threshold (e.g., 0.1), extend the arm.
        // If the left trigger is pressed beyond the threshold, retract the arm.
        // If neither trigger is pressed, stop the arm's movement.
        
        if (rightTrigger > 0.1) { // Threshold to prevent accidental small movements
            climbArm.extend(); // Extend the arm
        } else if (leftTrigger > 0.1) {
            climbArm.retract(); // Retract the arm
        } else {
            climbArm.stopArm(); // Stop the arm if no input
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
