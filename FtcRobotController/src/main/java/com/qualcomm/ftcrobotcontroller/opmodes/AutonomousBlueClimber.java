package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Jin on 12/18/2015.
 */
public class AutonomousBlueClimber extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo climbers;
    Servo trapdoor;
    Servo lclinger;
    Servo hvServo;

    //final static int ENCODER_CPR = 1440;     //Encoder Counts per Revolution
    //final static double GEAR_RATIO = 1;      //Gear Ratio
    //final static int WHEEL_DIAMETER = 4;     //Diameter of the wheel in inches
    //final static int DISTANCE = 24;          //Distance in inches to drive

    //final static double CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
    //final static double ROTATIONS = DISTANCE / CIRCUMFERENCE;
    //final static double COUNTS = ENCODER_CPR * ROTATIONS * GEAR_RATIO;


    @Override
    public void runOpMode () throws InterruptedException {
        //get de references from dat hardwareMap
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        climbers = hardwareMap.servo.get("climberservo");
        hvServo = hardwareMap.servo.get ("vexmotor");
        trapdoor = hardwareMap.servo.get ("armservo");
        lclinger = hardwareMap.servo.get("lservo");

        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        lclinger.setPosition(0.5);
        climbers.setPosition(0.0);

        waitForStart();
        sleep(500);
        for(int i =0; i<1; i++) {
            climbers.setPosition(0.0);
            leftMotor.setPower(0.2);
            rightMotor.setPower(0.2);
            sleep(8500);
            leftMotor.setPowerFloat();
            rightMotor.setPowerFloat();
            leftMotor.setPower(0.2);
            sleep(200);
            leftMotor.setPowerFloat();
            climbers.setPosition(1.0);
            sleep(400);

        }

        leftMotor.setPowerFloat();
        rightMotor.setPowerFloat();

    }
}
