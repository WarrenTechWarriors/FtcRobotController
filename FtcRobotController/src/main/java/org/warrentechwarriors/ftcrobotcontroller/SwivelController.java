package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by tobyjackson on 5/12/16.
 */
public class SwivelController extends HardwareController {
    private Servo servo;
    private double position;
    private double delta = 0.5;

    public void setServo(Servo servo)
    {
        this.servo = servo;
    }

    public void setDelta(double delta)
    {
        this.delta = delta;
    }

    public double getDelta()
    {
        return this.delta;
    }

    public void setPosition(double position)
    {
        this.position = Range.clip(position, Servo.MIN_POSITION, Servo.MAX_POSITION);
    }

    @Override
    public void update(Gamepad gamepad) {
        // move right
        if (gamepad.right_bumper)
        {
            setPosition(this.position + this.delta);
        }

        // move left
        if (gamepad.left_bumper)
        {
            setPosition(this.position - this.delta);
        }

        addTelemetryMessage("SwivelPosition", this.position);
        addTelemetryMessage("SwivelServo", this.servo.getPosition());
    }
}
