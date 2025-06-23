package org.firstinspires.ftc.teamcode.HowToProgram;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoController {

    private CRServo continuousServo;  // Continuous rotation servo
    private Servo positionServo;       // Position servo

    private double currentPosition = 0.5;

    public ServoController(HardwareMap hardwareMap) {
        continuousServo = hardwareMap.get(CRServo.class, "continuousServo");
        positionServo = hardwareMap.get(Servo.class, "positionServo");
    }

    // Run continuous servo with power -1 to 1
    // You can change the parameter type to boolean, but make sure gamepad controls align with chosen type
    // Ex. Buttons are boolean, joysticks/dpads are double
    public void runContinuousServo(double power) {
        continuousServo.setPower(power);

        /* if you choose to use boolean code snippet example
            if(a==true){
                continuousServo.setPower(1);
            }
            else if(b==true){
                continuousServo.setPower(-1);
            }
         */

        //Boolean is less versatile than using doubles!
    }

    // Set position servo angle 0 to 1
    public void setPositionServo(double position) {
        currentPosition = clamp(position, 0.0, 1.0);
        positionServo.setPosition(currentPosition);
    }

    private double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }
}