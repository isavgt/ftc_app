package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Autonoom{
    public DcMotor motorLeft = null;
    public DcMotor motorRight = null;

    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public Autonoom() {

    }



    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");

        motorLeft.setPower(0);
        motorRight.setPower(0);

        motorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER)(0);
        motorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER)(0);



    }

}





