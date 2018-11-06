import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoPaths extends Drive
{
//Define paths
    int[] zero = {0, 0};

    //centre position, drive to switch, drop cube on ends
    int[] centreLeftEnd = {6400, -7000};
    int[] cp1 = {0, -7000};
    int[] cp2 = {6400, 0};
    Path path_centreSwitchLeft = new PathCurve(zero, cp1, cp2, centreLeftEnd, 20);
    int[] centreRightEnd = {6400, 6400};
    int[] cp3 = {0, 6400};
    int[] cp4 = {6400, 0};
    Path path_centreSwitchRight = new PathCurve(zero, cp3, cp4, centreRightEnd, CURVE_RES);

    //centre position, drive to switch, drop cube on close face
    int[] centreLeftFace = {9500, -6400};
    int[] cp5 = {3000, 0};
    int[] cp6 = {3500, -6400};
    Path path_centreLeftFace = new PathCurve(zero, cp5, cp6, centreLeftFace, 20);
    //backup left
    int[] backupLeftEnd = {24200, -12600};
    int[] cp7 = {4400, -12700};
    int[] cp8 = {3500, -6400};
    Path path_backupLeftEnd = new PathCurve(centreLeftFace, cp8, cp7, backupLeftEnd, 20);

    int[] centreRightFace = {9500, 4400};
    int[] cp9 = {2000, 0};
    int[] cp10 = {3500, 4400};
    Path path_centreRightFace = new PathCurve(zero, cp9, cp10, centreRightFace, 20);
    //backupRight
    int[] backupRightEnd = {24200, 10000};
    int[] cp11 = {4400, 10000};
    int[] cp12 = {3500, 4400};
    Path path_backupRightEnd = new PathCurve(centreRightFace, cp12, cp11, backupRightEnd, 20);

    //drive to switch and stop
    int[] sideVL = {15200, -2200};
    int[] cp13 = {5500, 0};
    int[] cp14 = {15200, 3500};
    Path path_sideVeerLeft = new PathCurve(zero, cp13, cp14, sideVL, 40);
    int[] sideVR = {15200, 2200};
    int[] cp15 = {5500, 0};
    int[] cp16 = {15200, -3500};
    Path path_sideVeerRight = new PathCurve(zero, cp15, cp16, sideVR, 40);

    int[] sideCLEnd = {9500, -14000};
    int[] cp17 = {4700, 0};
    int[] cp18 = {4700, -14000};
    Path path_sideCrossLeft = new PathCurve(zero, cp17, cp18, sideCLEnd, CURVE_RES);
    int[] sideCREnd = {9500, 14000};
    int[] cp19 = {4700, 0};
    int[] cp20 = {4700, 14000};
    Path path_sideCrossRight = new PathCurve(zero, cp19, cp20, sideCREnd, CURVE_RES);

    //pass auto line
    int[] crossAutoEnd = {13000, 0};
    Path path_crossAutoLine = new PathLine(zero, crossAutoEnd, 2);

    //2 cube
    int[] backupTwoCubeEnd = {4500, -1000};
    int[] cp21 = {5500, 4000};
    int[] cp22 = {6000, -1500};
    int[] cp23 = {6000, 0};
    int[] cp24 = {6500, 3000};
    int[] centreRightScore = {9500, 3500};
    Path path_twoCubeBackupRight = new PathCurve(centreRightFace, cp21, cp22, backupTwoCubeEnd, 10);
    Path path_twoCubeShootRight = new PathCurve(backupTwoCubeEnd, cp23, cp24, centreRightScore, 10);

    int[] cp25 = {6000, -6000};
    int[] cp26 = {6000, -550};
    int[] cp27 = {6500, -5500};
    int[] centreLeftScore = {9500, -6000};
    Path path_twoCubeBackupLeft = new PathCurve(centreLeftFace, cp25, cp26, backupTwoCubeEnd, 40);
    Path path_twoCubeShootLeft = new PathCurve(backupTwoCubeEnd, cp23, cp27, centreLeftScore, 40);

    int[] pickupTwoCubeEnd = {9000, -1000};
    Path path_twoCubePickup = new PathLine(backupTwoCubeEnd, pickupTwoCubeEnd, 4);
    Path path_twoCubeBackupLine = new PathLine(pickupTwoCubeEnd, backupTwoCubeEnd, 2);


}