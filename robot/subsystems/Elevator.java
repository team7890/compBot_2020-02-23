/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* FRC Team 7890 SeQuEnCe                                                     */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  CANSparkMax elevatorMotor = new CANSparkMax(Constants.kCANIds.iElevator, MotorType.kBrushless);

  public Elevator() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void up() {
    elevatorMotor.set(1.0);
  }

  public void down() {
    elevatorMotor.set(-1.0);
  }

  public void stop() {
    elevatorMotor.stopMotor();
  }

  public void setSpeed(double speed) {
    elevatorMotor.set(speed);
  }

}