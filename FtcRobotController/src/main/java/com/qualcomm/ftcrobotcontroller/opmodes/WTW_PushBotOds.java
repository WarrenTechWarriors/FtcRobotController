package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by tjackson on 3/21/16.
 */
public class WTW_PushBotOds extends PushBotTelemetrySensors {

    @Override public void loop() {

        // if we detect light, stop moving
        if (a_ods_light_detected() > 0.0) {

            set_drive_power(0.0, 0.0);

        } else {

            // if we don't detect light, move forward
            set_drive_power(-1.0, -1.0);
        }

        update_telemetry();
    }
}
