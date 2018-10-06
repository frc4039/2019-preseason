import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team4039.robot.subsystems.Plunger;

public class GripClose extends InstantCommand
{
    public GripClose()
    {
        requires(Robot.gripper);
        requires(Robot.Plunger);
    }

    //Called just before this Command runs the first time
    protected void initialize()
    {
        Robot.gripper.close();
        Robot.Plunger.close();
    }
}