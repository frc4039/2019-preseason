import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class TiltUp extends InstantCommand
{
    public TiltUp()
    {
        requires(Robot.tilt);
    }

    //Called just before this Command runs the first time
    protected void initialize()
    {
        Robot.tilt.Tilting(true);
    }

    //Make this return true when this Command no longer neeeds to run execute()
    protected boolean isFinished()
    {
        return true;
    }
}