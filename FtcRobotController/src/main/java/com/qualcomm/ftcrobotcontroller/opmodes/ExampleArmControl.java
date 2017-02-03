package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class ExampleArmControl extends OpMode {

    DcMotor arm;

    @Override
    public void init() {
        //get references to the arm motor from the hardware map
        arm = hardwareMap.dcMotor.get("arm");
    }

    @Override
    public void loop() {
        // This code will control the up and down movement of
        // the arm using the y and b gamepad buttons.
        float leftY = gamepad2.left_stick_y;
        float rightY = gamepad2.right_stick_y;

        //set the power of the motors with the gamepad values
        arm.setPower(leftY);

    }

}

