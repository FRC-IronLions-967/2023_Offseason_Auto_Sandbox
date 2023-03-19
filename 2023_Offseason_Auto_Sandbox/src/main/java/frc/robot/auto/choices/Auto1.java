package frc.robot.auto.choices;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.auto.AutoState;
import frc.robot.auto.AutoStateTracker;
import frc.robot.auto.AutonomousInterface;
import frc.robot.subsystems.SubsystemsInstance;

public class Auto1 implements AutonomousInterface {

    private AutoStateTracker stateTracker;
    private AutoState[] auto1States = {
        AutoState.START,
        AutoState.INITIALIZING,
        AutoState.FINISHED
    };

    private boolean autoInit;
    private SubsystemsInstance inst; 

    public Auto1(){
        inst = SubsystemsInstance.getInstance();
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
