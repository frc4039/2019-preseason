import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class GripOpen extends InstantCommand
{
    public GripOpen()
    {
        requires(Robot.gripper);
        requires(Robot.Plunger);
    }

    //Called just before this Command runs the first time
    protected void initialize()
    {
        Robot.gripper.open();
        Robot.Plunger.open();
    }
}