
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;





/*
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp

public class TeleOpTest1 extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor motorTest;
    private DcMotor motorTest2;
    private DcMotor motorTest3;
    private Blinker expansion_Hub_2;
    private Servo servo;


    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        motorTest2 = hardwareMap.get(DcMotor.class, "motorTest2");
        motorTest3 = hardwareMap.get(DcMotor.class, "motorTest3");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        servo = hardwareMap.get(Servo.class, "servo");
        //servoTest

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        double tgtPower = 0;
        double tgtPower1 = 0;
        double tgtPower2 = 0;
        //double servoPos = .5
        double servoMarkerRetracted=.5; // limit value
        double servoPos = servoMarkerRetracted;
        double servoMarkerExtended=0.0;  // limit value
        
        int rightBumper = 0;
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            tgtPower2 = 0;
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
            if (gamepad1.x == true){
                servoPos = servoPos -.05;
                if (servoPos < servoMarkerExtended) {
                    servoPos = servoMarkerExtended;
                }
            } else if(gamepad1.x == false){
                servoPos = servoPos +.05;
                if (servoPos > servoMarkerRetracted) {
                    servoPos = servoMarkerRetracted;
                }
            }
            
            motorTest.setPower(tgtPower);
            motorTest2.setPower(tgtPower1);
            motorTest3.setPower(tgtPower2);
            servo.setPosition(servoPos);
            
            telemetry.addData("Motor Power", motorTest.getPower());
            telemetry.addData("Motor Power 2", motorTest2.getPower());
            telemetry.addData("Motor Power 3", motorTest3.getPower());
            //telemetry.addData("ServoPos", servoPos);
            telemetry.addData("Servo Position", servo.getPosition());
            //telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
}
