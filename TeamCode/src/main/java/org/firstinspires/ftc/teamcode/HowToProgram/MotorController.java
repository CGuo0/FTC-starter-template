package org.firstinspires.ftc.teamcode.HowToProgram;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MotorController {

    private DcMotor motor;

    // Constructor initializes the motor from hardware map by its name
    public MotorController(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, "motor");
        // Set default motor direction and mode
        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    /*
     Set motor power from -1.0 (full reverse) to 1.0 (full forward).
     0 stops the motor.
     */
    public void setPower(double power) {
        motor.setPower(power);
    }

    //stop motor
    public void stop() {
        motor.setPower(0);
    }


    /* Reset the encoder to zero */
    public void resetEncoder() {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

}