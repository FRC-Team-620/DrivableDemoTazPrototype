/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drivetrain;

import java.time.LocalDateTime;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveDistanceByVelocity extends Command {
  public DriveDistanceByVelocity(double distanceInMeters, double velocityInMetersPerSecond) 
  {
    requires(Robot.drivetrain);
    distance = distanceInMeters;
    velocity = velocityInMetersPerSecond;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    startTime = LocalDateTime.now();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() 
  {
    Robot.drivetrain.arcadeDrive(velocity, 0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() 
  {
    return startTime.plusSeconds((long) (distance/velocity)).isBefore(LocalDateTime.now());
  }

  // Called once after isFinished returns true
  @Override
  protected void end() 
  {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() 
  {
  }

  private LocalDateTime startTime;
  private double distance; 
  private double velocity;
}
