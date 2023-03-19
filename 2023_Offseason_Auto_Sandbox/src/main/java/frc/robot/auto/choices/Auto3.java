package frc.robot.auto.choices;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.auto.AutoState;
import frc.robot.auto.AutoStateTracker;
import frc.robot.auto.AutonomousInterface;
import frc.robot.subsystems.SubsystemsInstance;

public class Auto3 implements AutonomousInterface {

    private AutoStateTracker stateTracker;
    private AutoState[] auto3States = {
        AutoState.START,
        AutoState.INITIALIZING,
        AutoState.FINISHED
    };

    private boolean autoInit;
    private SubsystemsInstance inst; 

    public Auto3(){
        inst = SubsystemsInstance.getInstance();
        stateTracker = new AutoStateTracker(auto3States);
    }

    @Override
    public void init() {
        autoInit = true;
    }

    @Override
    public void periodic() {
        switch(stateTracker.getCurrentState()) {
            case START:
                //Do not being running in periodic until init() has been called
                if(autoInit){
                    
                }
                break;
            case INITIALIZING:
                break;
            case FINISHED:
                break;
            default:
                break;
        }
    }
}
