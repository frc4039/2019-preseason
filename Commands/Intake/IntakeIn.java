import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeIn extends Command
{
    public IntakeIn()
    {
        requires(Robot.intake);
    }

    //Called jsut before this Command runs the first time
    protected void initialize()
    {
        Robot.intake.runIn();
    }

    //Make this return true when this Command no logner needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    //Called when this Command is finished or interrupted
    protected void end()
    {
        Robot.intake.stop();
    }
}