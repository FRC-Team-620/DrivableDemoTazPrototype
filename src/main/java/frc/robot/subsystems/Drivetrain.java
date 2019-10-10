/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.drivetrain.DriveWithJoysticks;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() 
  {
    setDefaultCommand(new DriveWithJoysticks());
    var leftSide = new SpeedControllerGroup(new Spark(Pin.getId(Pin.LEFTFRONTMOTOR, this)), new Spark(Pin.getId(Pin.LEFTREARMOTOR, this)));
    var rightSide = new SpeedControllerGroup(new Spark(Pin.getId(Pin.RIGHTFRONTMOTOR, this)), new Spark(Pin.getId(Pin.RIGHTREARMOTOR, this)));
    dDrive = new DifferentialDrive(leftSide, rightSide);
  }

  public void arcadeDrive(double move, double rotate)
  {
    dDrive.arcadeDrive(move, rotate);
  }

  private DifferentialDrive dDrive;
}
