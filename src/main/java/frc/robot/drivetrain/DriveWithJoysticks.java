/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveWithJoysticks extends Command 
{
  public DriveWithJoysticks() 
  {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() 
  {
  }

  @Override
  protected void execute() 
  {
    Robot.drivetrain.arcadeDrive(Robot.oi.driverStick.getY(), Robot.oi.driverStick.getX());
  }

  @Override
  protected boolean isFinished()
  {
    return false;
  }

  @Override
  protected void end() 
  {
  }

  @Override
  protected void interrupted()
  { 
  }
}
