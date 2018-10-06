import org.usfirst.frc.team4039.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Conveyor extends Subsystems
{
    private double speed = 0.0;

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public TalonSRX conveyorMotor = new TalonSRX(RobotMap.conveyorMotor);
    private TalonSRX stretchSpin = new TalonSRX(RobotMap.stretchSpin);

    public void periodic()
    {
        conveyorMotor.set(ControlMode.PercentOutput, speed);
        //stretchSpin.follow(conveyorMotor);
    }

    public void initDefaultCommand()
    {
        
    }
}