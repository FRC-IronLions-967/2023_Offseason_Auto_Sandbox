package frc.robot.auto.choices;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.auto.AutoState;
import frc.robot.auto.AutoStateTracker;
import frc.robot.auto.AutonomousInterface;
import frc.robot.Constants;
import frc.robot.commands.auto_commands.AutoInitializeManipulatorCommand;
import frc.robot.subsystems.SubsystemsInstance;

public class Auto1 implements AutonomousInterface {

    private AutoStateTracker stateTracker;
    private AutoState[] auto1States = {
        AutoState.START,
        AutoState.INITIALIZING,
        AutoState.IDLE
    };

    private boolean autoInit;

    public Auto1(){
        stateTracker = new AutoStateTracker(auto1States);
    }

    @Override
    public void init() {
        autoInit = true;
    }

    @Override
    public void periodic() {
        switch(stateTracker.getCurrentState()) {
            case START:
                //Do not begin running in periodic until init() has been called
                if(autoInit){
                    CommandScheduler.getInstance().schedule(new AutoInitializeManipulatorCommand(stateTracker, Constants.kAutoInitTimeout));
                    stateTracker.inProgress();
                }
                break;
            case INITIALIZING:
                break;
            case IDLE:
                //No actions should be performed in IDLE
                break;
            default:
                break;
        }
    }
}
