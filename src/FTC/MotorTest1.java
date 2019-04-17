/*
Copyright 2018 FIRST Tech Challenge Team 15828

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp

public class MotorTest1 extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motorTest;
    private DcMotor motorTest2;
    private DcMotor motorTest3;
    private Blinker expansion_Hub_2;
    private Servo servo;
    private Servo servoTest;


    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        motorTest2 = hardwareMap.get(DcMotor.class, "motorTest2");
        motorTest3 = hardwareMap.get(DcMotor.class, "motorTest3");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        servo = hardwareMap.get(Servo.class, "servo");
        servoTest = hardwareMap.get(Servo.class, "servo");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        double tgtPower = 0;
        double tgtPower1 = 0;
        double tgtPower2 = 0;
        double servoPos = 0;
        int rightBumper = 0;
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            tgtPower2 = 0;
            servoTest.setPosition(0);
            if(gamepad1.b){
               tgtPower = (-this.gamepad1.right_stick_y);    //Makes it so the wheel goes the same as the other motor
               tgtPower1 = (-this.gamepad1.left_stick_y * -1); 
            } else{
                tgtPower = (-this.gamepad1.right_stick_y)/2;    //Makes it so the wheel goes the same as the other motor
                tgtPower1 = (-this.gamepad1.left_stick_y * -1)/2;
            }
            if(gamepad1.y == true && gamepad1.a == false){
                tgtPower2 = -1;
            } 
            
            if (gamepad1.a == true && gamepad1.y == false){
                tgtPower2 = 1;
            } 
            servoTest.setPosition(1);
            servoPos = .5;
            if (gamepad1.x == true){
                servoPos = 0;
            } else if(gamepad1.x == false){
                servoPos = .5;
            }
            motorTest.setPower(tgtPower);
            motorTest2.setPower(tgtPower1);
            motorTest3.setPower(tgtPower2);
            servo.setPosition(servoPos);
            telemetry.addData("Motor Power", motorTest.getPower());
            telemetry.addData("Motor Power 2", motorTest2.getPower());
            telemetry.addData("Motor Power 3", motorTest3.getPower());
            telemetry.addData("Servo Position", servo.getPosition());
            telemetry.addData("Servo Postion", servoTest.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
