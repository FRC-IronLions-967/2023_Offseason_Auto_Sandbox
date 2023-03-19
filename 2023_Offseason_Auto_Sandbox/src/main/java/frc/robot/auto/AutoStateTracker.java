package frc.robot.auto;

/**
 * Handles state machine handoffs and blocking during state execution
 */
public class AutoStateTracker {
    private AutoState[] states;
    private int currentState;
    private boolean commandInProgress;

    /**
     * Handles state machine handoffs and blocking during state execution
     * @param states array of states for this autonomous mode
     */
    public AutoStateTracker(AutoState[] states){
        this.states = states;
        currentState = 0;
        commandInProgress = false;
    }

    /**
     * Transitions to the next state for the current auto routine
     */
    public void nextState(){
        currentState++;
        if(currentState == states.length){
            currentState = 0;
        }
        commandInProgress = false;
    }

    /**
     * Returns the currently active autonomous state, 
     * will return IDLE if a command is currently running
     */
    public AutoState getCurrentState(){
        if(commandInProgress){
            return AutoState.IDLE;
        }else{
            return states[currentState];
        }
    }

    /**
     * Jump to the specified state
     * @param newState to jump to
     */
    public void setState(AutoState newState){
        for(int i = 0; i < states.length; i++){
            if(states[i].equals(newState)){
                currentState = i;
            }
        }
        commandInProgress = false;
    }

    /**
     * Notify the tracker that a command is currently running.
     */
    public void inProgress(){
        commandInProgress = true;
    }
}
