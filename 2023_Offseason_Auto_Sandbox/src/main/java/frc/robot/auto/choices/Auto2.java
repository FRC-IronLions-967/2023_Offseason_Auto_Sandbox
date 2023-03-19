package frc.robot.auto.choices;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants;
import frc.robot.auto.AutoState;
import frc.robot.auto.AutoStateTracker;
import frc.robot.auto.AutonomousInterface;
import frc.robot.commands.auto_commands.AutoInitializeManipulatorCommand;

public class Auto2 implements AutonomousInterface {

    private AutoStateTracker stateTracker;
    private AutoState[] auto2States = {
        AutoState.START,
        AutoState.INITIALIZING,
        AutoState.ARM_OUT,
        AutoState.PLACE,
        AutoState.IDLE
    };

    private boolean autoInit;

    public Auto2(){
        stateTracker = new AutoStateTracker(auto2States);
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
            case ARM_OUT:
                break;
            case PLACE:
                break;
            case IDLE:
                //No actions should be performed in IDLE
                break;
            default:
                break;
        }
    }
}
