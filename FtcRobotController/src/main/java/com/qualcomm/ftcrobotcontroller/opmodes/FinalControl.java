package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class FinalControl extends OpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor arm_motor;
    DcMotor hvArm;
    DcMotor Slide;
    DcMotor Winch1;
    DcMotor Winch2;

    Servo hvServo;
    Servo trapdoor;
    Servo lclinger;
    Servo climbers;
    Servo BlockGuard;
    Servo StringRelease;
    Servo TapeRelease;
    Servo CylinderFlap;


    @Override
    public void init() {
        //get references to all the stuff from the hardware map
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        arm_motor = hardwareMap.dcMotor.get("arm_motor");
        hvArm = hardwareMap.dcMotor.get ("intakelift");
        Slide = hardwareMap.dcMotor.get ("slidermotor");
        Winch1 = hardwareMap.dcMotor.get("pullmotor1");
        Winch2 = hardwareMap.dcMotor.get("pullmotor2");

        hvServo = hardwareMap.servo.get ("vexmotor");
        trapdoor = hardwareMap.servo.get ("armservo");
        lclinger = hardwareMap.servo.get("lservo");
        climbers = hardwareMap.servo.get ("climberservo");
        BlockGuard = hardwareMap.servo.get("blockservo");
        StringRelease = hardwareMap.servo.get("stringate");
        TapeRelease = hardwareMap.servo.get("tapeservo");


        //Other additional tweaks to any of teh hardware
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        Winch1.setDirection(DcMotor.Direction.REVERSE);
        hvServo.setPosition(0.5);
        trapdoor.setPosition(0.5);
        lclinger.setPosition(0.5);
        climbers.setPosition(0.0);
        StringRelease.setPosition(0.0);
        TapeRelease.setPosition(0.6);
        BlockGuard.setPosition(1.0);
    }

    @Override
    public void loop() {
        /*
        NEVER MIND THIS PART

        double scannerLevel = scannerSensor.getUltrasonicLevel();
        double climberLevel = climberSensor.getUltrasonicLevel();
        telemetry.addData("Scanner:", String.format("%.3f", scannerLevel));
        telemetry.addData("Climber:", String.format("%.3f", climberLevel));
        */

        climbers.setPosition(0.0);
        //get the values from the gamepads
        //note: pushing the stick all the way up returns -1,
        // so we need to reverse the values
        float leftYa = gamepad1.left_stick_y;
        float rightYa = gamepad1.right_stick_y;

        //set the power of the motors with the gamepad values
        leftMotor.setPower(leftYa);
        rightMotor.setPower(rightYa);

        //This bit is for teh harvester arm too go op and don.
        /*float leftYb = 0;
        if (gamepad2.a)
            leftYb = (float) 0.3;
        if (gamepad2.y)
            leftYb = (float) -0.3;
        hvArm.setPower(leftYb); */
        float harv  = gamepad2.right_stick_y;

        hvArm.setPower(harv/4);

        //This bit is for the slide
        float slide = gamepad2.left_stick_y;
        Slide.setPower(slide);
        float sliding = 0;
        if (gamepad2.dpad_down)
            sliding = (float) -0.5;
        if (gamepad2.dpad_up)
            sliding = (float) 0.3;
        Slide.setPower(sliding);

        //This bit is for the arm that's attached to the cylinder
        float rotate = 0;
        if (gamepad2.dpad_left)
            rotate = (float) 0.2;
        if (gamepad2.dpad_right)
            rotate = (float) -0.2;
        arm_motor.setPower(rotate);

        //This bit is for the harvester intake.
        float hvPosition;
        if (gamepad2.x)
            hvPosition = 0.0f;
        else if (gamepad2.b)
            hvPosition = 1.0f;
        else
            hvPosition = 0.5f;
        hvServo.setPosition(hvPosition);

        //This bit is for the trapdoor thing under the cylinder
        float trapdoorpos;
        if (gamepad2.right_bumper)
            trapdoorpos = 0.0f;
        if (gamepad2.right_bumper)
            trapdoorpos = (float) 1.0;
        else
            trapdoorpos = 0.5f;
        trapdoor.setPosition(trapdoorpos);

        //This bit is for the left clinger
        float clingpos1 = 1.0f;

        //if (gamepad1.right_bumper)
            //clingpos1  = (float) 1.0;

        if (gamepad1.right_bumper)
            clingpos1 = 0.0f;
        else
            clingpos1 = 1.0f;
        lclinger.setPosition(clingpos1);

        //This bit is for the climber deploying servo
        float climbdeploy = 0;
        if (gamepad1.x)
            climbdeploy = 1.0f;
        climbers.setPosition(climbdeploy);

        //This bit is for the WINCH
        /*float Winch1dir = 0;
        float Winch2dir = 0;
        if (gamepad1.a)
            Winch1dir = (float) -0.2;
        if (gamepad1.a)
            Winch2dir = (float) -0.2;
        Winch1.setPower(Winch1dir);
        Winch2.setPower(Winch2dir);

        //This bit for the winch to pull FASTA
        float Winch1fast = 0;
        float Winch2fast = 0;
        if (gamepad1.dpad_down)
            Winch1fast = (float) -1.0;
        if (gamepad1.dpad_down)
            Winch2fast = (float) -1.0;
        */


        float Winch1dir = gamepad1.right_trigger;
        float Winch2dir = gamepad1.right_trigger;

        if (gamepad1.right_stick_button)
            Winch1dir = (float) -0.5;
        if (gamepad1.right_stick_button)
            Winch2dir = (float) -0.5;
        Winch1.setPower(Winch1dir);
        Winch2.setPower(Winch2dir);

        //This bit is for the tape and string release
        float StringPos = 0;
        float TapePos = 0.6f;
        if (gamepad1.dpad_up)
            StringPos = 1.0f;
        if (gamepad1.dpad_up)
            TapePos = 0.0f;
        StringRelease.setPosition(StringPos);
        TapeRelease.setPosition(TapePos);

        //This bit is for de robot bumper
        float Guard = 1.0f;
        float HopFlap = 0.0f;
        if (gamepad1.left_bumper)
            Guard = 0.25f;
        else
            Guard = 1.f;

        BlockGuard.setPosition(Guard);



        //This bit is for the hopper plastic flap.
        /* if (gamepad2.a) {
            var+=0.0 ;
        }

        if (gamepad2.y) {
            var+=1.0;
        }
        CylinderFlap.setPosition(var); */

    }
}