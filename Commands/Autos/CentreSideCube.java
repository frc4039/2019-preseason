import javax.lang.model.util.ElementScanner6;
import org.usfirst.frc.team4039.robot.commands.blues.RunBlues;
import org.usfirst.frc.team4039.robot.commands.conveyor.ConveyorForward;
import org.usfirst.frc.team4039.robot.commands.drive.DriveForward;
import edu.wpi.first.wpilibj.command.CommandGroup;
import ShiftLib;

public class CentreSideCube extends Autos
{
    public SideCube()
    {
        if(plateColour = 'L')
        {
            addSequential(new AutoPaths(path_centreLeftFace));
            addSequential(new RunBlues(2.0));
            addSequential(new AutoPaths(path_backupLeftEnd));
        }
        else if(plateColour = 'R')
        {
            addSequential(new AutoPaths(path_centreRightFace));
            addSequential(new RunBlues(2.0));
            addSequentail(new AutoPaths(path_backupRightEnd));
        }
    }
}