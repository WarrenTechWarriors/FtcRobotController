package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by tobyjackson on 5/10/16.
 */
public class SingleStickDriveController extends DriveController {

    @Override
    public void update(Gamepad gamepad) {

        float throttle =  -gamepad.left_stick_x;
        float direction = gamepad.left_stick_y;
        float right = throttle - direction;
        float left = throttle + direction;
        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

        right = (float)scaleInput(right);
        left = (float)scaleInput(left);

        this.getRightDriveMotor().setPower(right);
        this.getLeftDriveMotor().setPower(left);

        addTelemetryMessage("Throttle", throttle);
        addTelemetryMessage("Direction", direction);
        addTelemetryMessage("Left", left);
        addTelemetryMessage("Right", right);
    }
}

