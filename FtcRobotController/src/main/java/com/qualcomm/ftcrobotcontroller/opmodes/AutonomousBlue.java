package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Jin on 12/18/2015.
 */
public class AutonomousBlue extends LinearOpMode {

    DcMotor rightMotor;
    DcMotor leftMotor;

    Servo hvServo;
    Servo trapdoor;
    Servo lclinger;
    Servo climbers;
    Servo BlockGuard;
    Servo StringRelease;
    Servo TapeRelease;

    public static double var;

    @Override
    public void runOpMode() throws InterruptedException {
        rightMotor = hardwareMap.dcMotor.get("left_drive");
        leftMotor = hardwareMap.dcMotor.get("right_drive");

        hvServo = hardwareMap.servo.get("vexmotor");
        trapdoor = hardwareMap.servo.get("armservo");
        lclinger = hardwareMap.servo.get("lservo");
        climbers = hardwareMap.servo.get("climberservo");
        BlockGuard = hardwareMap.servo.get("blockservo");
        StringRelease = hardwareMap.servo.get("stringate");
        TapeRelease = hardwareMap.servo.get("tapeservo");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        hvServo.setPosition(0.5);
        trapdoor.setPosition(0.5);
        lclinger.setPosition(0.5);
        climbers.setPosition(0.0);
        StringRelease.setPosition(0.0);
        TapeRelease.setPosition(0.6);
        BlockGuard.setPosition(1.0);

        telemetry.addData("LeftPosition", leftMotor.getCurrentPosition());
        telemetry.addData("RightPosition", rightMotor.getCurrentPosition());
        telemetry.addData("ServoPosition", climbers.getDirection());

        waitForStart();
        sleep(10000);
        for (double i = 0; i < 1; i++) {
            leftMotor.setPower(0.3);
            rightMotor.setPower(0.3);
            sleep(500);
            leftMotor.setPowerFloat();
            rightMotor.setPowerFloat();
            leftMotor.setPower(-0.3);
            rightMotor.setPower(-0.3);
            sleep(500);
            leftMotor.setPowerFloat();
            rightMotor.setPowerFloat();
            BlockGuard.setPosition(0.25);
            sleep(1000);
            BlockGuard.setPosition(0.25);
            leftMotor.setPower(0.3);
            rightMotor.setPower(0.27);
            sleep(4000);



        }
        leftMotor.setPowerFloat();
        rightMotor.setPowerFloat();
    }
}
