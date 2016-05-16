package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

/**
 * Created by tobyjackson on 5/11/16.
 */
public class RobotOpModeRegister implements OpModeRegister {

    @Override
    public void register(OpModeManager manager) {
        manager.register("SampleOpMode", SampleOpMode.class);
    }
}
