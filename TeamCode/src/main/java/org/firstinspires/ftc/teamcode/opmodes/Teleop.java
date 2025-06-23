package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Mecanum;

@TeleOp(name = "TeleOp Main Linear", group = "Starter")
public class Teleop extends LinearOpMode {

    @Override
    public void runOpMode() {
        Mecanum drive = new Mecanum(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();






        waitForStart();

        while (opModeIsActive()) {
            //Mecanum Drive Subsystem
            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y; // Invert for forward
            double z = gamepad1.right_stick_x;
            drive.moveDriveGears(x,y,z);
            telemetry.addData("Drive", "x: %.2f y: %.2f z: %.2f", x, y, z);
            telemetry.update();
        }

        // Stop all motors when the opmode ends
        drive.stop();
    }
}