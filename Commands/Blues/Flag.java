import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Flag extends Command
{
    public Flag()
    {
        requires(Robot.Flag);
    }

    //Called before this Command runs the first time
    protected void initialize()
    {
        Robot.Flag.run(true);
    }

    //Make this true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    //Called when Command is finished or interrupted
    protected void end()
    {
        Robot.Flag.run(false);
    }
}