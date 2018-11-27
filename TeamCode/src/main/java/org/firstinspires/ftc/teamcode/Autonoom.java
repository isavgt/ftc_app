package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Autonoom", group = "")
public class Autonoom extends OpMode {
    public DcMotor motorLeft;
    public DcMotor motorRight;

    @Override
    public void init() {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");
        Moveforward(.5f);
        try {
            Thread.sleep(500);
        } catch (Exception e){

        }
        Moveforward(0);

    }

    @Override
    public void loop() {

    }

    void Moveforward (float speed) {
        motorRight.setPower(speed);
        motorLeft.setPower(-speed);
    }
}
