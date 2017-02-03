package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class ExampleGripper2 extends OpMode {

    final double LEFT_OPEN_POSITION = 0.0;

    Servo leftGripper;
    Servo rightGripper;
    public static double var;

    @Override
    public void init() {
        leftGripper = hardwareMap.servo.get("arm_motor1");
        rightGripper = hardwareMap.servo.get("arm_motor2");
    }

    @Override
    public void loop() {
        // This code will keep the gripper open as long as the button is
        // pressed. When the button is released, the gripper is closed
        if(gamepad1.dpad_up) {
            var += .01;

        } else if (gamepad1.dpad_down) {
            var -= .01;

        }
        //leftGripper.setPosition(var);
        //rightGripper.setPosition(var);
    }
}

