/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* FRC Team 7890 SeQuEnCe                                                     */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.kCANIds;

public class Tilter extends SubsystemBase {
  private final CANSparkMax TilterMotor; 
  private final CANEncoder tilterEncoder;
  
  /**
   * Creates a new Tilter.
   */
  public Tilter() {
    TilterMotor = new CANSparkMax(kCANIds.iLaunchAngle, MotorType.kBrushless);
    tilterEncoder = new CANEncoder(TilterMotor);
    tilterEncoder.setPosition(0.0);
  }

  public void set(DoubleSupplier dSpeed) {
    TilterMotor.set(0.2 * dSpeed.getAsDouble());
  }

  @Override
  public void periodic() {
  }
}
