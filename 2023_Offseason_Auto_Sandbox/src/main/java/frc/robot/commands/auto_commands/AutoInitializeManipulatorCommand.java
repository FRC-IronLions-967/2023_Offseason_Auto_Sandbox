package frc.robot.commands.auto_commands;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.auto.AutoStateTracker;
import frc.robot.subsystems.SubsystemsInstance;

public class AutoInitializeManipulatorCommand extends WaitCommand {
  
  private SubsystemsInstance inst;
  private AutoStateTracker stateTracker;
  private boolean hasTimedOut;

  public AutoInitializeManipulatorCommand (AutoStateTracker stateTracker, double timeout) {
    super(timeout);
    hasTimedOut = false;

    this.stateTracker = stateTracker;

    inst = SubsystemsInstance.getInstance();
    addRequirements(inst.driveSubsystem);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    inst.exampleSubsystem.initializeSystem();
  }

  @Override
  public boolean isFinished() {
    if(super.isFinished()){
      hasTimedOut = true;
    }
    return hasTimedOut || inst.exampleSubsystem.exampleCondition();
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    
    //only allow more commands if this one did not time out
    if(!hasTimedOut){
      stateTracker.nextState();
    }
  }
}