/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.drivetrain.DriveWithJoysticks;

public class Drivetrain extends Subsystem {

  @Override
  public void initDefaultCommand() //TODO: potentially flip motor groups
  {
    setDefaultCommand(new DriveWithJoysticks());
    var leftSide = new SpeedControllerGroup(new Spark(Pin.getId(Pin.LEFTFRONTMOTOR)), new Spark(Pin.getId(Pin.LEFTREARMOTOR)));
    var rightSide = new SpeedControllerGroup(new Spark(Pin.getId(Pin.RIGHTFRONTMOTOR)), new Spark(Pin.getId(Pin.RIGHTREARMOTOR)));
    dDrive = new DifferentialDrive(leftSide, rightSide);
  }

  public void arcadeDrive(double move, double rotate)
  {
    dDrive.arcadeDrive(move, rotate);
  }

  private DifferentialDrive dDrive;
}
