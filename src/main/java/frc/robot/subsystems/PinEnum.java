/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

enum Pin
{
    //vvvvvvvvv ELECTRONICS EDITING START HERE vvvvvvvvvvv
    
    LEFTFRONTMOTOR(0, Robot.drivetrain),
    RIGHTFRONTMOTOR(1, Robot.drivetrain),
    LEFTREARMOTOR(2, Robot.drivetrain),
    RIGHTREARMOTOR(3, Robot.drivetrain);
    
    //^^^^^^^^^^ ELECTRONICS EDITING END HERE ^^^^^^^^^^^^

    Pin(int i, Subsystem ss)
    {
        id = i;
        claz = ss.getClass();
    }

    public static int getId(Pin pin, Subsystem ss) throws IllegalArgumentException
    {
        for(var p : Pin.values())
        {
            if(pin == p && ss.getClass().equals(p.claz)) return p.id;
        }
        throw new IllegalArgumentException();
    }

    private final int id;
    private final Class<?> claz;
}