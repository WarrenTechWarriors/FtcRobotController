package org.warrentechwarriors.ftcrobotcontroller;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by tobyjackson on 5/10/16.
 */
public abstract class DriveController extends HardwareController {

    private DcMotor leftDriveMotor;
    private DcMotor rightDriveMotor;

    public DcMotor getLeftDriveMotor()
    {
        return this.leftDriveMotor;
    }

    public void setLeftDriveMotor(DcMotor motor)
    {
        this.leftDriveMotor = motor;
    }

    public DcMotor getRightDriveMotor()
    {
        return this.rightDriveMotor;
    }

    public void setRightDriveMotor(DcMotor motor)
    {
        this.rightDriveMotor = motor;
    }

//    public abstract void update(Gamepad gamepad);

    /*
	 * This method scales the joystick input so for low joystick values, the
	 * scaled value is less than linear.  This is to make it easier to drive
	 * the robot more precisely at slower speeds.
	 */
    protected double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }
}
