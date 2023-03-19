package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    public DriveSubsystem() {

    }

    public void move(double r, double l) {

    }

    public void arcadeDrive(double x, double y){

    }

    /**
    * An example method querying a boolean state of the subsystem (for example, a digital sensor).
    *
    * @return value of some boolean subsystem state, such as a digital sensor.
    */
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    @Override 
    public void periodic(){
        // This method will be called once per scheduler run
    }

}