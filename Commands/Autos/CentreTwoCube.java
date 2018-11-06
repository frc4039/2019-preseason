import javax.lang.model.util.ElementScanner6;
import org.usfirst.frc.team4039.robot.commands.blues.RunBlues;
import org.usfirst.frc.team4039.robot.commands.conveyor.ConveyorForward;
import org.usfirst.frc.team4039.robot.commands.drive.DriveForward;
import edu.wpi.first.wpilibj.command.CommandGroup;
import ShiftLib;

public class CentreTwoCube extends Autos
{
    if(plateColour = 'L')
    {
        addSequential(new AutoPaths(path_centreLeftFace));
        addSequential(new RunBlues(2.0));
        addSequential(new AutoPaths(path_twoCubeBackupLeft));
        addSequential(new AutoPaths(path_twoCubePickup));
        addSequential(new GripOpen(2.0));
        addParallel(new IntakeIn(2.0));
        addSequential(new AutoPaths(path_twoCubeBackupLine));
        addSequential(new AutoPaths(path_twoCubeShootLeft));
    }
    else if(plateColour = 'R')
    {
        addSequential(new AutoPaths(path_centreRightFace));
        addSequential(new RunBlues(2.0));
        addSequential(new AutoPaths(path_twoCubeBackupRight));
        addSequential(new AutoPaths(path_twoCubePickup));
        addSequential(new GripOpen(2.0));
        addParallel(new IntakeIn(2.0));
        addSequential(new AutoPaths(path_twoCubeBackupLine));
        addSequential(new AutoPaths(path_twoCubeShootRight));
    }
}