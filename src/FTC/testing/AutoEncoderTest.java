/*


*/
package org.firstinspires.ftc.teamcode.testing;

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

public class AutoEncoderTest extends LinearOpMode {
    private DcMotor motorLeftDrive;
    private DcMotor motorRightDrive;
    private DcMotor motorLifter;
    private Servo servoMarker;
    private Blinker expansion_Hub_2; 
    @Override
    public void runOpMode() throws InterruptedException {
        double servoMarkerRetracted=.5; // limit value
        double servoPos = servoMarkerRetracted;
        double servoMarkerExtended=0.0;  // limit value
        motorRightDrive = hardwareMap.get(DcMotor.class, "motorTest");
        motorLeftDrive = hardwareMap.get(DcMotor.class, "motorTest2");
        motorLifter = hardwareMap.get(DcMotor.class, "motorTest3");
        servoMarker = hardwareMap.get(Servo.class, "servo");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        
        // we want power 1.0 to move bot forward on both wheels,
        // and the left drive moter is mounted backwards relative to the right
        // so we reverse it here
        motorLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        
        // if we set RUN_USING_ENCODER motor will be controlled by speed basically
        // rather than power (see http://ftc-tricks.com/dc-motors/)
        // this should help with keeping left and right motors going at same rate
        motorLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // for the lifter moter we don't care about speed so run without encoder
        // note that even with "run without encoder" we can still set a target
        // encoder value for rotation
        // NOTE: running the STOP_AND_RESET_ENCODER without an encoder cable 
        // seems to cause the motor to not respond to power instructions
        //motorLifter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //motorLifter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        servoMarker.setPosition(servoMarkerRetracted);

        telemetry.addData("Status", "Initialized2");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // lower from hook
            // would be best to make this do a certain number of
            // rotations but we need a tetrix to rev encoder cable
            telemetry.addData("Status", "Lowering from hook");
            telemetry.update();
            
            motorLifter.setPower(1);
            sleep(1250);
            motorLifter.setPower(0);
            telemetry.addData("Status", "Lowered");
            telemetry.update();

            sleep(1000);

            motorLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            // Rev motor 1440 per rotation
            // Tetrix motor 1120 per rotation
            motorLeftDrive.setTargetPosition(1440 * 2);
            motorRightDrive.setTargetPosition(1440 * 2);
            // since we are RUN_USING_ENCODER this will be speed not power:
            motorLeftDrive.setPower(0.5);
            motorRightDrive.setPower(0.5);
            
            //servo.setPosition(servoMarkerRetracted);
            while (motorLeftDrive.isBusy() || motorRightDrive.isBusy()) {
                telemetry.addData("busy  leftDrive pos", motorLeftDrive.getCurrentPosition());
                telemetry.addData("busy rightDrive pos", motorRightDrive.getCurrentPosition());
                telemetry.update();
            }
            
            servoMarker.setPosition(servoMarkerExtended);
            Thread.sleep(1000);
            servoMarker.setPosition(servoMarkerRetracted);
            Thread.sleep(50000);
            /*
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(1);
            Thread.sleep(500);  //Sleeps for 3 seconds
            motorTest.setPower(0);
            motorTest2.setPower(0);
            motorTest3.setPower(-1);
            Thread.sleep(1000);
            motorTest.setPower(.5);
            motorTest2.setPower(-.5);
            motorTest3.setPower(0);
            servo.setPosition(45);
            Thread.sleep(1200);
            
            telemetry.addData("Motor Power", motorTest.getPower());
            telemetry.addData("Motor Power 2", motorTest2.getPower());
            telemetry.addData("Motor Power 3", motorTest3.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();
            */
        }
    }
}
