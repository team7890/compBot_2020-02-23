/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* FRC Team 7890 SeQuEnCe                                                     */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LauncherSpeed extends CommandBase {

  Launcher objLauncher;
  DoubleSupplier dsSpeed;

  public LauncherSpeed(Launcher objLauncherIn, DoubleSupplier dsSpeedIn) {
    objLauncher = objLauncherIn;
    dsSpeed = dsSpeedIn;
    addRequirements(objLauncher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    objLauncher.setSpeed(0.2 * dsSpeed.getAsDouble());
    objLauncher.setFeedSpeed(dsSpeed.getAsDouble());
    objLauncher.setIndexerSpeed(0.5 * dsSpeed.getAsDouble());
    SmartDashboard.putNumber("Launcher Speed", dsSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    objLauncher.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
