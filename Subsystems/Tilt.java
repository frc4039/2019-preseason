import org.usfirst.frc.team4039.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Tilt extends Subsystem
{
    private boolean tilt = false;

    public void setTilt(boolean tilt)
    {
        this.tilt = tilt;
    }

    private DoubleSolenoid tilter = new DoubleSolenoid(RobotMap.tiltUp, RobotMap.tiltDown);

    public void periodic()
    {
        tilter.set(tilt ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand()
    {

    }
}