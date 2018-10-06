import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;

import org.usfirst.frc.team4039.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command
{
    private double distance;

    public DriveForward(double distance)
    {
        requires(Robot.drive);
        this.distance = distance;
    }

    //Called just before this Command runs the first time
    protected void initialize()
    {
        Robot.drive.driveForwardTargetDistance(distance);
    }

    //Called repeatedly when this command is scheduled to run
    protected void execute()
    {

    }

    //Make this return true when this command no longer needs to run execute()
    protected boolean isFinished()
    {
        return Robot.drive.driveForwardIsFinsished();
    }

    //Called once after isFinished returns true
    protected void end()
    {
        
    }
}