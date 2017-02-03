package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class ExampleGripper extends OpMode {

    Servo arm_motor1;
    //Servo arm_motor2;
    public static double var;

    @Override
    public void init() {
        arm_motor1 = hardwareMap.servo.get("armservo");
        //arm_motor2 = hardwareMap.servo.get("arm_motor2");
    }

    @Override
    public void loop()
    {
        // This code will open and close the gripper with two buttons
        // using 1 button to open and another to close the gripper

        if (gamepad2.dpad_up) {
            var +=0.0 ;
        }
        if (gamepad2.dpad_down) {
            var += 1.0;
        }
        arm_motor1.setPosition(var);
        //arm_motor2.setPosition(var);
    }
}

