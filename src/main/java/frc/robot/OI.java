/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.custom.classes.commandXboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick leftStick = new Joystick(RobotMap.leftJoystick);
    public Joystick rightStick = new Joystick(RobotMap.rightJoystick);
    public JoystickButton rightStickShifter = new JoystickButton(rightStick, RobotMap.rightJoystickShifterButton);

    public commandXboxController Xbox360Controller = new commandXboxController(RobotMap.Xbox360Joystick);

    public OI () {
      rightStickShifter.whenPressed(new ToggleShifterState());

      Xbox360Controller.rightBumper.whenPressed(new OpenHatch());
      Xbox360Controller.leftBumper.whenPressed(new CloseHatch());
      Xbox360Controller.B.whenPressed(new ToggleFrontClimb());
      Xbox360Controller.Y.whenPressed(new ToggleRearClimb());
      Xbox360Controller.dpad_up.whenPressed(new ExtendHatch());
      Xbox360Controller.dpad_down.whenPressed(new RetractHatch());
    }
}
