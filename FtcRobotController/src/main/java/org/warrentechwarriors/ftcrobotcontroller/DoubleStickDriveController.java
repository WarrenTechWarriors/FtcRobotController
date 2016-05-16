package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by tobyjackson on 5/10/16.
 */
public class DoubleStickDriveController extends DriveController {

    @Override
    public void update(Gamepad gamepad) {

        float left = -gamepad.left_stick_y;
        float right = -gamepad.right_stick_y;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

        right = (float)scaleInput(right);
        left =  (float)scaleInput(left);

        this.getRightDriveMotor().setPower(right);
        this.getLeftDriveMotor().setPower(left);
    }
}
