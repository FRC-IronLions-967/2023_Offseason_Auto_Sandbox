package frc.robot.commands.auto_commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.auto.AutoState;
import frc.robot.auto.AutoStateTracker;
import frc.robot.subsystems.SubsystemsInstance;

public class AutoDriveCommand extends WaitCommand {
  
  private SubsystemsInstance inst;
  private AutoStateTracker stateTracker;
  private double xInput;
  private double yInput;
  private boolean hasTimedOut;

  public AutoDriveCommand (AutoStateTracker stateTracker, double xInput, double yInput, double timeout) {
    super(timeout);
    hasTimedOut = false;

    this.xInput = xInput;
    this.yInput = yInput;
    this.stateTracker = stateTracker;

    inst = SubsystemsInstance.getInstance();
    addRequirements(inst.driveSubsystem);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    inst.driveSubsystem.arcadeDrive(xInput, yInput);
  }

  @Override
  public boolean isFinished() {
    if(super.isFinished()){
      hasTimedOut = true;
    }
    return hasTimedOut || inst.driveSubsystem.exampleCondition();
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    inst.driveSubsystem.arcadeDrive(0.0, 0.0);
    if(hasTimedOut){
      stateTracker.setState(AutoState.FINISHED);
    }else{
      stateTracker.nextState();
    }
  }
}