import org.usfirst.frc.team4039.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem
{
    private double speed = 0.0;
    private boolean Plunge = false;

    public void runIn()
    {
        this.speed = -1.0;
    }

    public void runOut()
    {
        this.speed = 1.0;
    }

    public void stop()
    {
        this.speed = 0.0;
    }

    public void setPlunge(boolean Plunge)
    {
        this.Plunge = Plunge;
    }

    private DoubleSolenoid Plunger = new DoubleSolenoid(RobotMap.plunger);

    TalonSRX rollerLeft = new TalonSRX(RobotMap.rollerLeft);
    TalonSRX rollerRight = new TalonSRX(RobotMap.rollerRight);

    public void periodic()
    {
        rollerLeft.set(ContolMode.PercentOutput, speed);
        rollerRight.setInverted(true);
        rollerRight.follow(rollerLeft);
        Plunger.set(Plunge ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    protected void initDefaultCommand()
    {

    }
}