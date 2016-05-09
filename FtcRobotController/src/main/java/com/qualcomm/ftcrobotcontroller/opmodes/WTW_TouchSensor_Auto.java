package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by toby jackson 3/14/16.
 */
public class WTW_TouchSensor_Auto extends PushBotTelemetrySensors {
    //--------------------------------------------------------------------------
    //
    // PushBotAuto
    //


    //--------------------------------------------------------------------------
    //
    // v_state
    //
    /**
     * This class member remembers which state is currently active.  When the
     * start method is called, the state will be initialized (0).  When the loop
     * starts, the state will change from initialize to state_1.  When state_1
     * actions are complete, the state will change to state_2.  This implements
     * a state machine for the loop method.
     */
    private int v_state = 0;

    /**
     * Construct the class.
     * <p/>
     * The system calls this member when the class is instantiated.
     */
    public WTW_TouchSensor_Auto()

    {
        //
        // Initialize base classes.
        //
        // All via self-construction.

        //
        // Initialize class members.
        //
        // All via self-construction.

    } // PushBotAuto

    //--------------------------------------------------------------------------
    //
    // start
    //

    /**
     * Perform any actions that are necessary when the OpMode is enabled.
     * <p/>
     * The system calls this member once when the OpMode is enabled.
     */
    @Override
    public void start()

    {
        //
        // Call the PushBotHardware (super/base class) start method.
        //
        super.start();

        //
        // Reset the motor encoders on the drive wheels.
        //
        reset_drive_encoders();

    } // start

    //--------------------------------------------------------------------------
    //
    // loop
    //

    /**
     * Implement a state machine that controls the robot during auto-operation.
     * The state machine uses a class member and encoder input to transition
     * between states.
     * <p/>
     * The system calls this member repeatedly while the OpMode is running.
     */
    @Override
    public void loop()

    {
        //----------------------------------------------------------------------
        //
        // State: Initialize (i.e. state_0).
        //
        switch (v_state) {

            // Step 1. Synchronize the hardware.
            case 0:

                // reset the drive encoders (counters) to 0
                reset_drive_encoders();

                // move to the next state
                v_state++;

                break;

            case 1:
                // run using the encoders (counters)
                run_using_encoders();

                // set the drive power for the left & right motors at half power
                set_drive_power(-0.5f, -0.5f);

                // check to see if the touch sensor is pressed
                if (is_touch_sensor_pressed()) {

                    // request the drive encoders (counters) to be reset to 0
                    reset_drive_encoders();

                    // stop the motors
                    set_drive_power(0.0f, 0.0f);

                    // move to the next state
                    v_state++;
                }
                break;

            case 2:
                // wait until the drive encoders have been reset
                if (have_drive_encoders_reset()) {
                    // move to the next state
                    v_state ++;
                }
                break;

            case 3:
                // run using the encoders (counters)
                run_using_encoders();

                // set the drive power to reverse for both the left & right motors
                // at full power
                set_drive_power(1.0f, 1.0f);

                // check to see if the drive encoders for each motor to reach 1000
                if (have_drive_encoders_reached(1000, 1000)) {

                    // reset the drive encoders
                    reset_drive_encoders();

                    // stop the motors
                    set_drive_power(0.0f, 0.0f);

                    // move to the next state
                    v_state++;
                }
                break;

            case 4:
                // wait until the drive encoders have been reset
                if (have_drive_encoders_reset()) {
                    // move to the next state
                    v_state++;
                }
                break;

            case 5:
                // run using the encoders (counters)
                run_using_encoders();

                // All motors move forward
                set_drive_power(1.0f, -1.0f);

                // check to see if the drive encoders for each motor to reach 3500 revolutions
                if (have_drive_encoders_reached(3500, 3500)) {

                    // Reset the drive encoders (stop keeping track of the number of times the motors have turned)
                    reset_drive_encoders();

                    // Stop the motors.
                    set_drive_power(0.0f, 0.0f);

                    // move to the next state
                    v_state++;
                }

                break;

            case 6:
                // wait for the drive encoders to reset
                if (have_drive_encoders_reset()) {
                    // move back to the first state
                    v_state = 1;
                }
                break;
        }
    }
}
                  
                  
                    
                    
                    