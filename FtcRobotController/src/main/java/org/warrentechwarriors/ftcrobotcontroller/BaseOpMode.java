package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by tobyjackson on 5/10/16.
 */
public abstract class BaseOpMode extends OpMode {

    private OpModeSettings settings = new OpModeSettings();

    @Override
    public void init() {
        configure(settings);
        settings.getDriveController().init();
        settings.getArmController().init();
        settings.getHandController().init();
        settings.getSwivelController().init();
    }

    @Override
    public void loop() {

        // update the drive controller
        settings.getDriveController().update(gamepad1);

        // update the arm controller
        settings.getArmController().update(gamepad2);

        // update the claw controller
        settings.getHandController().update(gamepad2);

        // update the swivel controller
        settings.getSwivelController().update(gamepad2);

        // TODO: Update sensor controller(s)

        // set telemetry
        telemetry.addData("GP1", gamepad1.toString());
        telemetry.addData("GP2", gamepad2.toString());
    }

    @Override
    public void stop()
    {
        settings.getDriveController().stop();

        settings.getArmController().stop();

        settings.getHandController().stop();

        settings.getSwivelController().stop();
    }

    public abstract void configure(OpModeSettings configuration);
}
