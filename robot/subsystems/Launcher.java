/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* FRC Team 7890 SeQuEnCe                                                     */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kCANIds;

public class Launcher extends SubsystemBase {

  CANSparkMax objNeo9 = new CANSparkMax(kCANIds.iLauncherOne, MotorType.kBrushless);
  CANSparkMax objNeo16 = new CANSparkMax(kCANIds.iLauncherTwo, MotorType.kBrushless);
  CANSparkMax objFeedNeo550 = new CANSparkMax(kCANIds.iFeed, MotorType.kBrushless);
  VictorSPX objIndexerVictor = new VictorSPX(kCANIds.iIndexer);

  public Launcher() {
    // CANPIDController objPIDControllerOne = motorOne.getPIDController();
    // // CANEncoder m_encoderOne = motorOne.getEncoder();

    // // TODO: Figure out the values below through testing later !!!
    // final double kP = 0.0003;
    // final double kI = 0.0;
    // final double kD = 0.0006;
    // final double kIz = 0;
    // final double kFF = 0;
    // final double kMaxOutput = 1;
    // final double kMinOutput = -1;
    // final double maxRPM = 5700;
    // final double kSP = 3000;

    // objPIDControllerOne.setP(kP);
    // objPIDControllerOne.setI(kI);
    // objPIDControllerOne.setD(kD);
    // objPIDControllerOne.setIZone(kIz);
    // objPIDControllerOne.setFF(kFF);
    // objPIDControllerOne.setOutputRange(kMinOutput, kMaxOutput);

    // CANPIDController objPIDControllerTwo = motorTwo.getPIDController();
    // // CANEncoder m_encoderTwo = motorTwo.getEncoder();

    // // TODO: Figure out the values below through testing later !!!
    // objPIDControllerTwo.setP(kP);
    // objPIDControllerTwo.setI(kI);
    // objPIDControllerTwo.setD(kD);
    // objPIDControllerTwo.setIZone(kIz);
    // objPIDControllerTwo.setFF(kFF);
    // objPIDControllerTwo.setOutputRange(kMinOutput, kMaxOutput);


  }
  
  public void setSpeed(double dSpeed) {
    objNeo9.set(-dSpeed);
    objNeo16.set(dSpeed);
  }

  public void setFeedSpeed(double dSpeed) {
    objFeedNeo550.set(dSpeed);
  }

  public void setIndexerSpeed(double dSpeed) {
    objIndexerVictor.set(ControlMode.PercentOutput, dSpeed);
  }

  public void stop() {
    objNeo9.stopMotor();
    objNeo16.stopMotor();
    objFeedNeo550.stopMotor();
    objIndexerVictor.set(ControlMode.PercentOutput, 0.0);
  }

  public void togglePID(boolean on) {
    // TODO: So maybe try out a backup system if the PID decides to not work... !!!
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
