import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RunBlues extends Command
{
    public RunBlues()
    {
        requires(Robot.blues);
        requires(Robot.conveyor);
    }

    //Called before this Command runs the first time
    protected void initialize()
    {
        Robot.blues.run(true);
        if(blues.run = true)
        {
            Robot.conveyor.run(true);
        }
        else
        {
            Robot.conveyor.run(false);
        }

    }

    //Make this true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    //Called when Command is finished or interrupted
    protected void end()
    {
        Robot.blues.run(false);
        Robot.conveyor.run(false);
    }
}