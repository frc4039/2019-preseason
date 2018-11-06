package robotcode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4039.robot.commands.ExampleCommand;
import org.usfirst.frc.team4039.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import acm.*;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.usfirst.frc.team4039.robot.subsystems.Blues;
import org.usfirst.frc.team4039.robot.subsystems.Conveyor;
import org.usfirst.frc.team4039.robot.subsystems.Drive;
import org.usfirst.frc.team4039.robot.subsystems.Flag;
import org.usfirst.frc.team4039.robot.subsystems.Gripper;
import org.usfirst.frc.team4039.robot.subsystems.Intake;
//import org.usfirst.frc.team4039.robot.subsystems.Stretch;
import org.usfirst.frc.team4039.robot.subsystems.Tilt;
import org.usfirst.frc.team4039.robot.commands.Autos;
import org.usfirst.frc.team4039.robot.commands.Blues;
import org.usfirst.frc.team4039.robot.commands.Conveyor;
import org.usfirst.frc.team4039.robot.commands.Drive;
import org.usfirst.frc.team4039.robot.commands.Gripper;
import org.usfirst.frc.team4039.robot.commands.Intake;
//import org.usfirst.frc.team4039.robot.commands.Stretch;
import org.usfirst.frc.team4039.robot.commands.Tilt;

public class Robot extends TimedRobot
{
    Command autonomousCommand;
    SendableChooser<String> chooser;

    public GameState gameState;

    public static Blues blues = new Blues();
    public static Conveyor conveyor = new Conveyor();
    public static Drive drive = new Drive();
    public static Gripper gripper = new Gripper();
    public static Intake intake = new Intake();
    public static Tilt tilt = new Tilt();
    //public static Stretch stretch = = new Stretch();
    public static OI oi;

    //run when the robot is first enabled and should be used for any initialization code
    public void robotInit()
    {
        oi = new OI();
        this.Drive.setPositionToZero();

        chooser = new SendableChooser<String>();
        chooser.addDefault("Drive Forward", new DriveForward());
        chooser.addObject("Drive Forward Cube", new DriveForwardCube());

        SmartDashboard.putData("Auto Mode", chooser);
    }

        //called once every time the robot is disabled, used to reset any subsystems
        public void disabledInit()
        {
            Scheduler.getInstance().removeAll();
        }    

    public void disabledPeriodic()
    {
        oi.periodic();
        Scheduler.getInstance().run();

        if(Joystick.GetRawButton(12))
        {
            nav.Reset();
            leftEncoder.Reset();
            rightEncoder.Reset();
            Robot.Reset();
        }

        autoDelay = -5*(Joystick.GetRawAxis(3) - 1);
        Robot.updatePos(leftEncoder.Get(), rightEncoder.Get(), nav.GetYaw());

        plateColour = DriverStation.GetInstance().GetGameSpecificMessage();

        printDelay++;
        if(printDelay > 25)
        {
            printDelay = 0;
            if(beamBreak.get())
                System.out.Println("BEAM SENSOR TRUE\n");
            System.out.println("robot position x: %d\ty:%d\n", Robot.getXPos(), Robot.getYPos());
        }
    }

    //shows how to select different auto modes using SmartDash
    public void autonomousInit()
    {
        String selectedAuto = (String) chooser.getSelected();
        System.out.println(selectedAuto);
        switch(selectedAuto)
        {
            case "DriveForward":
                autonomousCommand = new DriveForward();
                break;
            case "SideCube":
                autonomousCommand = new SideCube();
                break;
        }

        if(autonomousCommand != null)
        {
            autonomousCommand.start();
        }
    }

    //this is called periodically during autonomous
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    //Makes sure autonomous stops ruuning when tele-op starts
    public void teleopInit()
    {
        Scheduler.getInstance().removeAll();
    }

    //this is called periodically during operator control
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void testInit()
    {
        Schedular.getInstance().removeAll();
    }
    //this is called periodically during test mode
    public void testPeriodic()
    {

    }
}