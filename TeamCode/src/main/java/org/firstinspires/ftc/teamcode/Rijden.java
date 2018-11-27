package org.firstinspires.ftc.teamcode;

//libraries
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//class
@TeleOp(name = "Rijden", group = "")
public class Rijden extends OpMode {
    private DcMotor MotorLeft;
    private DcMotor MotorRight;
    double driveDirectionSpeed = 1;
    boolean isInverted;

    //Declare Motors
    @Override
    public void init() {
        MotorLeft = hardwareMap.dcMotor.get("MotorLeft");
        MotorRight = hardwareMap.dcMotor.get("MotorRight");
        driveDirectionSpeed = 1;
    }

    //checking loop
    @Override
    public void loop() {
        DriveChecks();
    }

    //Drivecheck function
    void DriveChecks() {
        double Left = -0.5 * driveDirectionSpeed * -gamepad1.left_stick_y;
        double Right = 0.5 * driveDirectionSpeed * -gamepad1.right_stick_y;
        if (isInverted){
            Left = -Left;
            Right = -Right;
        }
        //  logUtils.Log(logUtils.logtype.normal, Left + ',' + Right, 1);

        //slower if one motor backwards (stability)
        if (-gamepad1.left_stick_y < 0 ^ -gamepad1.right_stick_y < 0) {
            MotorLeft.setPower(Left * 0.5);
            MotorRight.setPower(Right * 0.5);
        } else {
            MotorLeft.setPower(Left);
            MotorRight.setPower(Right);
            if (gamepad1.right_trigger > 0.5 && driveDirectionSpeed < 5) {
                driveDirectionSpeed += 0.0025f;
            } else if (gamepad1.left_trigger > 0.5 && driveDirectionSpeed > 0.003) {
                driveDirectionSpeed -= 0.0025f;
            }
            telemetry.addData("DriveDirectionSpeed", driveDirectionSpeed);
        }

        if (gamepad1.b){
            if (isInverted){
                isInverted = false;
            }else {
                isInverted = true;
            }
        }
    }
}
