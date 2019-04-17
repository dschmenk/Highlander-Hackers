/*
Copyright 2019 FIRST Tech Challenge Team 15828

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
package org.firstinspires.ftc.teamcode.competition;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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
@Autonomous

public class FTC_2019_Autonomous extends LinearOpMode {
    private DcMotor motorTest;
    private DcMotor motorTest2;
    private DcMotor motorTest3;
    private Servo servo;
    private Blinker expansion_Hub_2; 
    @Override
    public void runOpMode() throws InterruptedException {
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        motorTest2 = hardwareMap.get(DcMotor.class, "motorTest2");
        motorTest3 = hardwareMap.get(DcMotor.class, "motorTest3");
        servo = hardwareMap.get(Servo.class, "servo");
        
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(0);
            //servo.setPosition(0.0);
            Thread.sleep(500);
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(-.5);
            Thread.sleep(1800);
            motorTest.setPower(-.25);
            motorTest2.setPower(.75);
            Thread.sleep(1200);
            motorTest.setPower(-.25);
            motorTest2.setPower(-.75);
            motorTest3.setPower(0);
            Thread.sleep(1500);
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(0);
            Thread.sleep(1500);
            motorTest.setPower(-.5);
            motorTest2.setPower(.5);
            motorTest3.setPower(0);
            Thread.sleep(600);
            motorTest.setPower(.75);
            motorTest2.setPower(.25);
            motorTest3.setPower(0);
            Thread.sleep(450);
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(0);
            Thread.sleep(1200);
            motorTest.setPower(1);
            motorTest2.setPower(-1);
            Thread.sleep(925);
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(0);
            servo.setPosition(0.0);
            Thread.sleep(900);
            motorTest.setPower(-.5);
            motorTest2.setPower(.25);
            motorTest3.setPower(0);
            Thread.sleep(1200);
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(0);
            servo.setPosition(0.5);
            sleep(3000000);
            
            Thread.sleep(300000);
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(0);
            telemetry.addData("Motor Power", motorTest.getPower());
            telemetry.addData("Motor Power 2", motorTest2.getPower());
            telemetry.addData("Motor Power 3", motorTest3.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
