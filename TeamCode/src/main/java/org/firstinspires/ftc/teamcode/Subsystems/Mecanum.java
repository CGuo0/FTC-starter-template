package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class Mecanum {
    private DcMotor leftFront, rightFront, leftBack, rightBack;
    private final double CLIP_MIN = -1.0;
    private final double CLIP_MAX = 1.0;
    private double powerRatio = 1.0;

    public Mecanum(HardwareMap hardwareMap) {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        leftFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        leftFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setPowerRatio(double ratio) {
        powerRatio = Range.clip(ratio, 0.0, 1.0);
    }

    public void moveDriveGears(double x, double y, double z) {
        double leftFrontPower  = Range.clip(x + y + z, CLIP_MIN, CLIP_MAX);
        double rightFrontPower = Range.clip(-x + y - z, CLIP_MIN, CLIP_MAX);
        double leftBackPower   = Range.clip(-x + y + z, CLIP_MIN, CLIP_MAX);
        double rightBackPower  = Range.clip(x + y - z, CLIP_MIN, CLIP_MAX);

        leftFront.setPower(leftFrontPower * powerRatio);
        rightFront.setPower(rightFrontPower * powerRatio);
        leftBack.setPower(leftBackPower * powerRatio);
        rightBack.setPower(rightBackPower * powerRatio);
    }

    public void stop() {
        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);
    }

}
