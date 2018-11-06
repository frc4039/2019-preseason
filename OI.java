import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI
{
    Joystick driver = new Joystick(0);
	XboxController operator = new XboxController(1);
	
	//driver controls
	Button driveShift = new JoystickButton(driver, 1);
	Button flag = new JoystickButton(driver, 11);
	Button dConveyorShot = new JoystickButton(driver, 10);
	Button dIntakeOut = new JoystickButton(driver, 9);

	//operator controls
	Button gripOpen = new JoystickButton(operator, 2); //B
	Button gripClose = new JoystickButton(operator, 2); //B
	Button intakeIn = new JoystickButton(operator, GetRawAxis(3)); //Right bumper
	Button intakeOut = new JoystickButton(operator, GetRawAxis(2)); //left bumper
	Button tiltUp = new JoystickButton(operator, GetPOV(0)); //D-up
	Button tiltDown = new JoystickButton(operator, GetPOV(4)); //D-down
	Button conveyorForward = new JoystickButton(operator, GetRawAxis(-1)); //left js up
	Button conveyorBackward = new JoystickButton(operator, GetRawAxis(1)); //left js down
	Button runBlues = new JoystickButton(operator, 1); //A
    //Button startButton = new JoystickButton(operator, 8);
    
    public OI()
    {
		//driver
		driveShift.whileHeld(new Shift());
		flag.whileHeld(new Flag());
		dConveyorShot.whileHeld(new runBlues());
		dIntakeOut.whileHeld(new intakeOut());
		
		//op
		gripOpen.whileHeld(new gripOpen());
		gripClose.whenReleased(new gripClose());
		intakeIn.whileHeld(new intakeIn());
		intakeOut.whileHeld(new intakeOut());
		tiltUp.whenPressed(new tiltUp());
		tiltDown.whenPressed(new tiltDown());
		conveyorForward.whileHeld(new conveyorForward());
		conveyorBackward.whileHeld(new conveyorBackward());
		runBlues.whileHeld(new runBlues());
		//startButton.whenPressed(new StretchLift());
    }
    public void periodic()
    {
		// Drive in teleop
		Robot.drive.user(driver.getY(), driver.getX());
	}
}