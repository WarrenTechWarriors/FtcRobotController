package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by tjackson on 4/25/16.
 */
public class CS_TestAutonomousMode extends PushBotTelemetry {

    public CS_TestAutonomousMode()

    {//
        // Initialize base classes.
        //
        // All via self-construction.

        //
        // Initialize class members.
        //
        // All via self-construction.
    }

    @Override
    public void loop()

    {//----------------------------------------------------------------------
        //
        // DC Motors
        //
        // Obtain the current values of the joystick controllers.
        //
        // Note that x and y equal -1 when the joystick is pushed all of the way
        // forward (i.e. away from the human holder's body).
        //
        // The clip method guarantees the value never exceeds the range +-1.
        //
        // The DC motors are scaled to make it easier to control them at slower
        // speeds.
        //
        // The setPower methods write the motor power values to the DcMotor
        // class, but the power levels aren't applied until this method ends.
        //

        //
        // Manage the drive wheel motors.
        //
        // todo: mr. j 1 stick
        float l_left_drive_power = scale_motor_power(gamepad1.left_stick_y);
        float l_right_drive_power = scale_motor_power(gamepad1.right_stick_y);

        set_drive_power(l_left_drive_power, l_right_drive_power);
        //
        // Manage the arm motor.
        //
        float l_left_arm_power = scale_motor_power(-gamepad2.right_stick_y);
        m_left_arm_power(l_left_arm_power);

        //----------------------------------------------------------------------
        //
        // Servo Motors
        //
        // Obtain the current values of the gamepad 'x' and 'b' buttons.
        //
        // Note that x and b buttons have boolean values of true and false.
        //
        // The clip method guarantees the value never exceeds the allowable range of
        // [0,1].
        //
        // The setPosition methods write the motor power values to the Servo
        // class, but the positions aren't applied until this method ends.
        //
        if (gamepad2.x) {
            m_hand_position(a_hand_position() + 0.05);
        } else if (gamepad2.b) {
            m_hand_position(a_hand_position() - 0.05);
        }

        // Use the left stick for rotating the swivel
        // Use left_stick_button to reset the swivel
        if (gamepad2.left_stick_button) {
            m_swivel_position(0.5);
        } else if (gamepad2.left_stick_x > 0) {
            m_swivel_position(a_swivel_position() - 0.010);
        } else if (gamepad2.left_stick_x < 0) {
            m_swivel_position(a_swivel_position() + 0.010);
        }
    }
}
