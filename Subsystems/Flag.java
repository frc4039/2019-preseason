import org.usfirst.frc.team4039.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flag extends Subsystems
{
    private boolean isRunning = false;

    public void run(boolean isRunning)
    {
        this.isRunning = isRunning;
    }

    private TalonSRX bluesLeftMotor = new TalonSRX(RobotMap.bluesLeft);

    public void periodic()
    {
        bluesLeftMotor.set(ControlMode.PercentOutput, isRunning ? 1.0 : 0.0); //1 and 0 is between forward 100% and stopped, blues do not go backward (to -1)
    }

    public void initDefaultCommand()
    {

    }
}