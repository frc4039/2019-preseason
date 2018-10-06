import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command
{
    public Shift()
    {
        requires(Robot.drive);
    }

    //Called just before this Command runs the first time
    protected void initialize()
    {
        Robot.drive.setShift(true);
    }
}