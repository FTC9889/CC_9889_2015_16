package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Jin on 2/26/2016.
 */
public class AutoEncoderRedClimber extends OpMode {

    DcMotor rightMotor;
    DcMotor leftMotor;

    Servo climbers;

    @Override
    public void init() {
        rightMotor = hardwareMap.dcMotor.get("left_drive");
        leftMotor = hardwareMap.dcMotor.get("right_drive");
        climbers = hardwareMap.servo.get("climberservo");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);


        leftMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    @Override
    public void start() {
        leftMotor.setTargetPosition(13000);
        rightMotor.setTargetPosition(8000);

        leftMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        rightMotor.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        leftMotor.setPower(0.3);
        rightMotor.setPower(0.3);

        climbers.setPosition(1.0);
    }



    @Override
    public void loop() {
        telemetry.addData("LeftPosition", leftMotor.getCurrentPosition());
        telemetry.addData("RightPosition", rightMotor.getCurrentPosition());
        telemetry.addData("ServoPosition", climbers.getDirection());
    }
}
