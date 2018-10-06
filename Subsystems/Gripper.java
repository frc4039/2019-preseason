import org.usfirst.frc.team4039.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class gripper extends Subsystems
{
    private State state = State.ClosedNoCube;

    private enum State
    {
        Opening,
        Open,
        ClosedNoCube,
        ClosedWithCube;

        public Timer time = new Timer();
        State()
        {
            time.reset();
            time.start();
        }
    }

    public void open()
    {
        switch(this.state)
        {
            case Opening:
            case Open:
                //already opening
                break;
            case ClosedNoCube:
            case ClosedWithCube:
                //start opening
                this.state = State.Opening;
                break;
        }
    }

    public void close()
    {
        switch(this.state)
        {
            case Opening:
            case Open:
                //close immediately
                this.state = State.ClosedNoCube;
                break;
            case ClosedNoCube:
            case ClosedWithCube:
                //already closed
                break;
        }
    }

    Solenoid gripper = new Solenoid(RobotMap.intakeGripper);
    Solenoid plunger = new Solenoid(RobotMap.plunger);
    DigitalInput beamBreak = new DigitalInput(RobotMap.beamBreak);

    @Override
    public void periodic()
    {
        boolean grip = false, plunge = false;

        switch(state)
        {
            case ClosedNoCube:
                grip = true;
                plunge = false;

                //prob won't happen, but jic
                if(beamBreak.get())
                {
                    state = State.ClosedWithCube;
                }
                break;
            case Opening:
                grip = false;
                plunge = false;

                //stay for 1s before continuing
                if(state.time.get() < 1.0)
                {
                    break;
                }
                
                state = State.Open;
            case Open:
                grip = false;
                plunge = true;

                //stay if no cube
                if(!beamBreak.get())
                {
                    break;
                }

                state = State.ClosedWithCube;
            case ClosedWithCube:
                grip = true;
                plunge = false;

                //if we eject cube
                if(!beamBreak.get())
                {
                    state = State.ClosedNoCube;
                }
                break;
        }

        gripper.set(grip);
        plunger.set(plunge);

        SmartDashboard.putBoolean("gripper/HasCube", state = State.ClosedWithCube);
    }

    protected void initDefaultCommand()
    {
        
    }
}