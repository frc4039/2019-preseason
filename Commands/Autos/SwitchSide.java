import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchSide extends Command
{
    Command left, right;
    boolean finished;

    public SwitchSide(Command left, Command right)
    {
        this.left = left;
        this.right = right;
    }

    protected void initialize()
    {
        finished = false;
    }

    protected void execute()
    {
        char side = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
        switch(side)
        {
            case 'R':
                right.start();
                finished = true;
                break;
            case 'L':
                left.start();
                finished = true;
                break;
        }
    }

    protected boolean isFinished()
    {
        return this.finished;
    }
}