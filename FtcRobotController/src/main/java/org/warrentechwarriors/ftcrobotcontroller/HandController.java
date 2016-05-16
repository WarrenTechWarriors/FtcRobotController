package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by tobyjackson on 5/10/16.
 */
public class HandController extends HardwareController {
    private Servo leftHand;
    private Servo rightHand;

    // position of the hand servos
    private double handPosition;

    // amount to change the hand servo position by
    private double handDelta = 0.05;

    public void setLeftHandServo(Servo servo)
    {
        this.leftHand = servo;
    }

    public void setRightHandServo(Servo servo) { this.rightHand = servo; }

    public void setHandDelta(double delta)
    {
        this.handDelta = delta;
    }

    public double getHandDelta()
    {
        return this.handDelta;
    }

    public void setHandPosition(double position)
    {
        this.handPosition = Range.clip(position, Servo.MIN_POSITION, Servo.MAX_POSITION);
        this.leftHand.setPosition(this.handPosition);
        this.rightHand.setPosition(1.0 - this.handPosition);
    }

    @Override
    public void update(Gamepad gamepad)
    {
        if (gamepad.x)
        {
            setHandPosition(this.handPosition + this.handDelta);
        }

        if (gamepad.b)
        {
            setHandPosition(this.handPosition - this.handDelta);
        }

        addTelemetryMessage("HandPosition", this.handPosition);
        addTelemetryMessage("LeftHandServo", this.leftHand.getPosition());
        addTelemetryMessage("RightHandServo", this.rightHand.getPosition());
    }
}
