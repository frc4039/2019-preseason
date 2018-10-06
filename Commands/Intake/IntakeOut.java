import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command
{
    public IntakeOut()
    {
        requires(Robot.intake);
    }

    //Called just before this Command runs the first time
    protected void initialize()
    {
        Robot.intake.runOut();
    }

    //Make this true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    //Called when this Command is finsihed or interrupted
    protected void end()
    {
        Robot.intake.stop();
    }
}