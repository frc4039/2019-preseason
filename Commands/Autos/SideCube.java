import org.usfirst.frc.team4039.robot.commands.blues.RunBlues;
import org.usfirst.frc.team4039.robot.commands.conveyor.ConveyorForward;
import org.usfirst.frc.team4039.robot.commands.drive.DriveForward;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideCube extends CommandGroup
{
    public SideCube()
    {
        addSequential(new SwitchSide(new DriveTurn(-40), new DriveTurn(40)));
        addSequential(new DriveForward(3.0));
        addSequential(new RunBlues());
    }
}