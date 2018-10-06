import org.usfirst.frc.team4039.robot.commands.drive.DriveForward;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForward extends CommandGroup{
    public DriveForwardAuto()
    {
        addSequential(new DriveForward(3.0));
        addSequential(new RunBlues());
    }
}