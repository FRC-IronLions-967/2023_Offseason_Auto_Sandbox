package frc.robot.auto;

public class AutoStateTracker {
    private AutoState[] states;
    private int currentState;

    AutoStateTracker(AutoState[] states){
        this.states = states;
        currentState = 0;
    }

    public void nextState(){
        currentState++;
        if(currentState == states.length){
            currentState = 0;
        }
    }

    public AutoState getCurrentState(){
        return states[currentState];
    }

    public void setState(AutoState newState){
        for(int i = 0; i < states.length; i++){
            if(states[i].equals(newState)){
                currentState = i;
            }
        }
    }
}
