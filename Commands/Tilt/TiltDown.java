import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class TiltDown extends InstantCommand
{
    public TiltDown()
    {
        requires(Robot.tilt);
    }

    //Called juts befre this Command runs the first time
    protected void initialize()
    {
        Robot.tilt.Tilting(false);
    }
}