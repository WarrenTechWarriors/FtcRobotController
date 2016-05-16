package org.warrentechwarriors.ftcrobotcontroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tobyjackson on 5/10/16.
 */
public class OpModeSettings {

    private DriveController driveController;
    private HandController handController;
    private ArmController armController;
    private SwivelController swivelController;

    public void setArmController(ArmController controller)
    {
        this.armController = controller;
    }

    public ArmController getArmController()
    {
        return this.armController;
    }

    public void setHandController(HandController controller)
    {
        this.handController = controller;
    }

    public HandController getHandController()
    {
        return this.handController;
    }

    public void setDriveController(DriveController controller)
    {
        this.driveController = controller;
    }

    public DriveController getDriveController()
    {
        return this.driveController;
    }

    public void setSwivelController(SwivelController controller)
    {
        this.swivelController = controller;
    }

    public SwivelController getSwivelController()
    {
        return this.swivelController;
    }

}
