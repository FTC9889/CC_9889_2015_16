package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Jin on 2/25/2016.
 */
public class AutoEncoderBlueClimber  extends OpMode {

    DcMotor rightMotor;
    DcMotor leftMotor;

    Servo hvServo;
    Servo trapdoor;
    Servo lclinger;
    Servo climbers;
    Servo BlockGuard;
    Servo StringRelease;
    Servo TapeRelease;

    @Override
    public void init() {
        rightMotor = hardwareMap.dcMotor.get("left_drive");
        leftMotor = hardwareMap.dcMotor.get("right_drive");

        hvServo = hardwareMap.servo.get ("vexmotor");
        trapdoor = hardwareMap.servo.get ("armservo");
        lclinger = hardwareMap.servo.get("lservo");
        climbers = hardwareMap.servo.get ("climberservo");
        BlockGuard = hardwareMap.servo.get("blockservo");
        StringRelease = hardwareMap.servo.get("stringate");
        TapeRelease = hardwareMap.servo.get("tapeservo");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        hvServo.setPosition(0.5);
        trapdoor.setPosition(0.5);
        lclinger.setPosition(0.5);
        climbers.setPosition(0.0);
        StringRelease.setPosition(0.0);
        TapeRelease.setPosition(0.6);
        BlockGuard.setPosition(1.0);


        leftMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        rightMotor.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
    }

    @Override
    public void start() {
        leftMotor.setTargetPosition(10000);
        rightMotor.setTargetPosition(9000);

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

