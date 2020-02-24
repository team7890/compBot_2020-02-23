/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* FRC Team 7890 SeQuEnCe                                                     */
/*----------------------------------------------------------------------------*/

package frc.robot;

// controller imports
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;

// subsystem imports
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
// import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Tilter;
import frc.robot.subsystems.Traveler;
import frc.robot.subsystems.Winch;

// commands imports
import frc.robot.commands.DriveRobot;
import frc.robot.commands.ElevatorSpeed;
import frc.robot.commands.LauncherSpeed;
import frc.robot.commands.LowerIntake;
import frc.robot.commands.MoveTraveler;
import frc.robot.commands.RaiseIntake;
import frc.robot.commands.RollIn;
import frc.robot.commands.RollOut;
import frc.robot.commands.ShiftDriveSpeed;
// import frc.robot.commands.SpinIndexer;
import frc.robot.commands.TiltLauncher;
import frc.robot.commands.WinchUp;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  XboxController objXboxDriverStick = new XboxController(0);    // TO Do: Add this to Constants!!!
  XboxController objXboxCoPilotStick = new XboxController(1);
  Joystick objButtonBox = new Joystick(2);

  // The robot's subsystems and commands are defined here...
  private final DriveTrain objDriveTrain = new DriveTrain();
  private final Pneumatics objPneumatics = new Pneumatics();
  private final Intake objIntake = new Intake();
  private final Launcher objLauncher = new Launcher();
  // private final Indexer objIndexer = new Indexer();
  private final Elevator objElevator = new Elevator();
  private final Winch objWinch = new Winch();
  private final Traveler objTraveler = new Traveler();
  private final Tilter objTilter = new Tilter();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    objDriveTrain.setDefaultCommand(new DriveRobot(() -> objXboxDriverStick.getRawAxis(1) * -0.5, () -> objXboxDriverStick.getRawAxis(4) * 0.5, objDriveTrain));
    objElevator.setDefaultCommand(new ElevatorSpeed(objElevator, () -> objXboxCoPilotStick.getRawAxis(5)));
    objLauncher.setDefaultCommand(new LauncherSpeed(objLauncher, () -> objXboxDriverStick.getRawAxis(3)));
    objWinch.setDefaultCommand(new WinchUp(objWinch, () -> objXboxDriverStick.getRawButton(7),  () -> objXboxDriverStick.getRawButton(8)));
    objTraveler.setDefaultCommand(new MoveTraveler(objTraveler, () -> objXboxCoPilotStick.getRawAxis(0)));
    objTilter.setDefaultCommand(new TiltLauncher (objTilter, () -> objXboxCoPilotStick.getRawAxis(1)));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton buttonB = new JoystickButton(objXboxCoPilotStick, 2);
    final JoystickButton buttonBox5 = new JoystickButton(objButtonBox, 5);
    final JoystickButton bumperL = new JoystickButton(objXboxCoPilotStick, 5); // Left bumper shifts into high gear!!!
    final JoystickButton bumperR = new JoystickButton(objXboxDriverStick, 6); // Right bumper shifts into low gear!!!
    final JoystickButton buttonY = new JoystickButton(objXboxDriverStick, 4);
    final JoystickButton buttonBack = new JoystickButton(objXboxCoPilotStick, 7);
    final JoystickButton buttonStart = new JoystickButton(objXboxCoPilotStick, 8);
    // objXboxDriverStick.getRawButton(5); // Left bumper shifts into high gear!!!
    // objXboxDriverStick.getRawButton(6); // Right bumper shifts into low gear!!!
    // buttonB.whileHeld(new SpinIndexer(objIndexer));
    buttonBox5.whileHeld(new RollOut(objIntake));
    bumperL.whenPressed(new ShiftDriveSpeed(objDriveTrain, true));    // shift into high gear on rising edge
    bumperR.whenPressed(new ShiftDriveSpeed(objDriveTrain, false));   // shift into low gear on rising edge
    buttonY.whileHeld(new RollIn(objIntake));
    buttonBack.whenPressed(new RaiseIntake(objIntake));
    buttonStart.whenPressed(new LowerIntake(objIntake));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   // return m_autoCommand;
  // }
}
