package frc.robot.auto;

public enum AutoState {
    START,
    INITIALIZING,
    ARM_OUT,
    PLACE,
    DRIVE_BACK,
    DRIVE_TURN_RIGHT,
    DRIVE_TURN_LEFT,
    IDLE, //IDLE is a known safe state where the robot will not move or perform actions
}
