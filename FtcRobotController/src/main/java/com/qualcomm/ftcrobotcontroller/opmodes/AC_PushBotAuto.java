package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by alexander chen on 3/5/16.
 */
public class AC_PushBotAuto extends PushBotTelemetry {
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
    public AC_PushBotAuto()

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

                // Reset the encoders to ensure they are at a known good value.
                reset_drive_encoders();

                // Transition to the next state when this method is called again.
                v_state++;

                break;

            case 1:

                run_using_encoders();

                // All motors move forward
                set_drive_power(-1.0f, -1.0f);

                if (have_drive_encoders_reached(6900, 6900)) {

                    // Reset the drive encoders (stop keeping track of the number of times the motors have turned)
                    reset_drive_encoders();

                    // Stop the motors.
                    set_drive_power(0.0f, 0.0f);

                    v_state++;
                }

                break;

            case 2:

                if (have_drive_encoders_reset()) {
                    v_state++;
                }
                break;

            case 3:

                // Reset the encoders
                run_using_encoders();

                // Start motors in opposite directions
                set_drive_power(1.0f, -1.0f);

                if (have_drive_encoders_reached(3750, 3750)) {
                    reset_drive_encoders();

                    set_drive_power(0.0f, 0.0f);

                    v_state++;

                }
                break;

            case 4:

                if (have_drive_encoders_reset()) {
                    v_state++;
                }
                break;

            case 5:
                run_using_left_drive_encoder();

                set_drive_power(-1.0f, 0.0f);

                if (has_left_drive_encoder_reached(3750)) {
                    reset_left_drive_encoder();

                    set_drive_power(0.0f, 0.0f);

                    v_state++;
                }
                break;

            case 6:

                if (have_drive_encoders_reset()) {
                    v_state++;
                }
                break;

            case 7:

                run_using_encoders();

                set_drive_power(-1.0f, -1.0f);

                if (have_drive_encoders_reached(6900, 6900)) {
                    reset_drive_encoders();

                    set_drive_power(0.0f, 0.0f);
                    v_state++;
                }
                break;

            case 8:
                if (have_drive_encoders_reset()) {

                    // done!
                }

        }
    }
}
                  
                  
                    
                    
                    