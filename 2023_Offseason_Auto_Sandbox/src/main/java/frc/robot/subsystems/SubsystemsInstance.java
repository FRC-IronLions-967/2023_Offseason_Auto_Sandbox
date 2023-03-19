package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class SubsystemsInstance {

    private static SubsystemsInstance inst;

    public DriveSubsystem driveSubsystem;
    public ExampleSubsystem exampleSubsystem; 

    private SubsystemsInstance() {
        driveSubsystem = new DriveSubsystem();
        exampleSubsystem = new ExampleSubsystem();

        CommandScheduler.getInstance().registerSubsystem(driveSubsystem);
        CommandScheduler.getInstance().registerSubsystem(exampleSubsystem);
    }
    public static SubsystemsInstance getInstance () {
        if(inst == null) inst = new SubsystemsInstance();

        return inst;

    }
}