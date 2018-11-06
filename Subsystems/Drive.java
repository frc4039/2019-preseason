import org.usfirst.frc.team4039.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS.SerialDataType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Subsystems
{
    private double forward = 0.0;
    private double turn = 0.0;
    private double distanceToDrive = 0.0; //

    public void isHighGear(boolean shift)
    {
        this.shift = true;
    }
    
    public void driveForwardTargetDistance(double distance)
    {
        this.distance = distanceToDrive;
    }

    public void user(double forward, double turn)
    {
        this.forward = forward;
        this.turn = turn;
    }

    public boolean driveForwardIsFinished()
    {
        //PID stuff
    }

    public void setShift(boolean shift)
    {
        this.shift = shift;
    }

    TalonSRX driveLeftFront = new TalonSRX(RobotMap.driveLeftFront);
    TalonSRX driveLeftBack = new TalonSRX(RobotMap.driveLeftBack);
    TalonSRX driveRightFront = new TalonSRX(RobotMap.driveRightFront);
    TalonSRX driveRightBack = new TalonSRX(RobotMap.driveRightBack);
    AHRS gyro = new AHRS(SerialPort.Port.kMXP, SerialDataType.kPProcessedData, (byte) 50);
    DoubleSolenoid driveShift = new DoubleSolenoid(RobotMap.driveShiftForward, RobotMap.driveShiftReverse);

    public void periodic()
    {
        driveLeftFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,0);
        driveRightFront.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,0);
        
        if(Driverstation.getInstance().isOperatorControl())
        {
            //Tele-op
            driveRightFront.set(ControlMode.PercentOutput, forward + turn);
            driveRightFront.set(ControlMode.PercentOutput, forward - turn);
        }
        else if(DriverStation.getInstance().isAutonomous())
        {
            autonomousPeriodic();
        }
        else
        {
            driveLeftFront.set(ControlMode.PercentOutput, 0.0);
            driveRightFront.set(ControlMode.PercentOutput, 0.0);
        }
        
        driveLeftBack.follow(driveLeftFront);
        driveRightBack.follow(driverightFront);

        driveShift.set(shift ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);

        SmartDashboard.putNumber("Drive/LeftEncoder", driveLeftFront.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("Drive/RightEncoder", driveRightFront.getSelectedSensorPosition(0));
        SmartDashboard.putNumber("High gear", shift);
    }

    protected void initDefaultCommand()
    {

    }
}
