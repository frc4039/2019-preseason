import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ConveyorBackward extends Command()
{
    public ConveyorBackward()
    {
        requires(Robot.conveyor);
    }

    //Called just before this Command runs the first time
    protected void initialize()
    {
        Robot.conveyor.setSpeed(-1.0);
    }

    //Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    //Called when this command is finished or interrupted
    protected void end()
    {
        Robot.conveyor.setSpeed(0.0);
    }
}