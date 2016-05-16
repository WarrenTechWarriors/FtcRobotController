package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.robocol.Telemetry;

/**
 * Created by tobyjackson on 5/10/16.
 */
public abstract class HardwareController {

    private Telemetry telemetry;

    public void setTelemetry(Telemetry telemetry)
    {
        this.telemetry = telemetry;
    }

    public Telemetry getTelemetry()
    {
        return this.telemetry;
    }

    public void addTelemetryMessage(String key, String msg)
    {
        if (hasTelemetry())
        {
            telemetry.addData(key, msg);
        }
    }

    public void addTelemetryMessage(String key, Object msg)
    {
        if (hasTelemetry())
        {
            telemetry.addData(key, msg.toString());
        }
    }

    public void addTelemetryMessage(String key, float msg)
    {
        if (hasTelemetry())
        {
            telemetry.addData(key, Float.valueOf(msg));
        }
    }

    public void addTelemetryMessage(String key, double msg)
    {
        if (hasTelemetry())
        {
            telemetry.addData(key, Float.valueOf((float)msg));
        }
    }

    public void init()
    {}

    public abstract void update(Gamepad gamepad);

    public void stop()
    {}

    private boolean hasTelemetry()
    {
        return telemetry != null;
    }
}
