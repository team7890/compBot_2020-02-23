/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* FRC Team 7890 SeQuEnCe                                                     */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class kCANIds {
        public static final int iLeftPrimary = 1;
        public static final int iLeftFollower = 2;
        public static final int iRightPrimary = 3;
        public static final int iRightFollower = 4;
        public static final int iClimbLeft = 5;
        public static final int iClimbRight = 6;
        public static final int iTraveler = 7;
        public static final int iFeed = 8;
        public static final int iLauncherOne = 9;
        public static final int iIndexer = 10;
        public static final int iIntake = 11;
        public static final int iLaunchAngle = 12;
        public static final int iColorWheel = 13;
        public static final int iElevator = 14;
        public static final int iLauncherTwo = 16;
    }

    public static final class kRobotDims {
        public static final double dTrackWidth = Units.inchesToMeters(24.75);           // track width in meters
        public static final double dWheelDia = Units.inchesToMeters(6.0);               // wheel diameter in meters
        public static final double dGearBoxRatioHigh = 5.133;
        public static final double dGearBoxRatioLow = 15.0;
        public static final double dFalconCountsPerRev = 2048.0;                         // TODO: NEED TO CHECK!!!
        public static final double dFalconEncoderToVelocity = 10.0 / dFalconCountsPerRev * Math.PI * Units.inchesToMeters(dWheelDia);
        public static final double dFalconConversionHigh = dFalconEncoderToVelocity / dGearBoxRatioHigh;
        public static final double dFalconConversionLow = dFalconEncoderToVelocity / dGearBoxRatioLow;
    }

    public static final class kPneumatics {
        public static final int iShifter = 0;
        public static final int iIntake = 1;
        public static final int iIndexer = 2;
        public static final int iAgitater = 3;
        public static final int iColorWheel = 4; 
    }

    public static final class kSpeeds {
        public static final double dIntake = 0.4;
    }
}
