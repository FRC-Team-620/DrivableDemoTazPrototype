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
    RIGHTREARMOTOR(3, Robot.drivetrain),

    /*^^^^^^^^^^ ELECTRONICS EDITING END HERE ^^^^^^^^^^^^
     *
     * How to use the Pin document:
     *
     * MYPIN(3, Robot.someSubsystem),
     * YOURPIN(4, Robot.otherSubsystem),
     * THEIRPIN(2, Robot.someSubsystem),
     *    ^     ^          ^           ^
     *    ^     ^      Subsystem       ^
     * Pin Name ^                      ^
     *          ^          Comma at the End of a Value
     *   Pin Number on Rio
     *
     *
     */;// <= this isn't a stray semicolon, it's being used for the benefit of electronics


    Pin(int i, Subsystem ss)
    {
        id = i;
        claz = ss.getClass().getName();
    }

    public static int getId(Pin pin) throws IllegalArgumentException
    {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        var caller = stackTrace[2].getClassName();
        for(var p : Pin.values())
        {
            if(pin == p && caller.equals(p.claz)) return p.id;
        }
        throw new IllegalArgumentException();
    }

    private final int id;
    private final String claz;
}