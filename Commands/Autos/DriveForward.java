import org.usfirst.frc.team4039.robot.commands.drive.DriveForward;
import edu.wpi.first.wpilibj.command.CommandGroup;
import ShiftLib;

public class DriveForward extends Autos
{
    public DriveForwardAuto()
    {
        addSequential(new AutoPaths(path_crossAutoLine));
    }
}