package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Jin on 12/18/2015.
 */
public class AutonomousRed_NoEncoders extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo climbers;
    Servo lclinger;
    Servo trapdoor;

    @Override
    public void runOpMode () throws InterruptedException {
        //get de references from dat hardwareMap
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        climbers = hardwareMap.servo.get("climberservo");
        lclinger = hardwareMap.servo.get("lservo");
        trapdoor = hardwareMap.servo.get("armservo");
        //additional tweaks
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        climbers.setPosition(0.0);
        lclinger.setPosition(0.5);

        waitForStart();
        sleep(1000);
        for(int i=0; i<1; i++) {
            leftMotor.setPower(0.3);
            rightMotor.setPower(0.25);
            sleep(6000);
            leftMotor.setPowerFloat();
            rightMotor.setPowerFloat();
            //TURN
            leftMotor.setPower(-0.2);
            rightMotor.setPower(0.3);
            sleep(1500);
            leftMotor.setPowerFloat();
            rightMotor.setPowerFloat();
            leftMotor.setPower(0.2);
            rightMotor.setPower(0.2);
            sleep(1250);
            leftMotor.setPowerFloat();
            rightMotor.setPowerFloat();
            //-----------------------------------------------CLIMBERS DEPLOY
            climbers.setPosition(1.0);
            sleep(1000);
            climbers.setPosition(0.0);

        }

        leftMotor.setPowerFloat();
        rightMotor.setPowerFloat();
    }

}
