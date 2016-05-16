package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.ServoController;

/**
 * Created by tobyjackson on 5/10/16.
 */
public class SampleOpMode extends BaseOpMode {

    ArmController armController;
    HandController handController;
    DriveController driveController;
    SwivelController swivelController;

    @Override
    public void configure(OpModeSettings settings) {
        armController = new ArmController();
        armController.setMotor(hardwareMap.dcMotor.get("arm"));
        armController.setTelemetry(telemetry);
        settings.setArmController(armController);

        handController = new HandController();
        handController.setLeftHandServo(hardwareMap.servo.get("left_hand"));
        handController.setRightHandServo(hardwareMap.servo.get("right_hand"));
        handController.setTelemetry(telemetry);
        settings.setHandController(handController);

        swivelController = new SwivelController();
        swivelController.setServo(hardwareMap.servo.get("swivel"));
        swivelController.setTelemetry(telemetry);
        settings.setSwivelController(swivelController);

        driveController = new SingleStickDriveController();
        driveController.setLeftDriveMotor(hardwareMap.dcMotor.get("left_drive"));
        driveController.setRightDriveMotor(hardwareMap.dcMotor.get("right_drive"));
        driveController.setTelemetry(telemetry);
        settings.setDriveController(driveController);

        telemetry.addData("00", "Configuration:");
        telemetry.addData("arm", hardwareMap.dcMotor.get("arm") != null ? "mapped" : "not mapped");
        telemetry.addData("left_drive", hardwareMap.dcMotor.get("left_drive") != null ? "mapped" : "not mapped");
        telemetry.addData("right_drive", hardwareMap.dcMotor.get("right_drive") != null ? "mapped" : "not mapped");
        telemetry.addData("left_hand", hardwareMap.servo.get("left_hand") != null ? "mapped" : "not mapped");
        telemetry.addData("right_hand", hardwareMap.servo.get("right_hand") != null ? "mapped" : "not mapped");
        telemetry.addData("swivel", hardwareMap.servo.get("swivel" != null ? "mapped" : "not mapped"));
    }
}
