package org.firstinspires.ftc.teamcode.opmodesteleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.ExampleRobot;
import org.firstinspires.ftc.teamcode.mechanisms.basicmechanisms.DeadzonedController;

import static org.firstinspires.ftc.teamcode.util.Constants.*;

@TeleOp
public class ExampleTeleOpMode extends OpMode {
    //Tells the code that an ExampleRobot named robot actually exists
    private ExampleRobot robot = new ExampleRobot();

    //Remember to set the example servo to its "closed" position before running this OpMode to make sure this line is valid
    private boolean exampleServoOpen = false;

    //Initializes the driver controller for general usage, with "User 1" being gamepad1 and "User 2" being gamepad2.
    DeadzonedController DriverController = new DeadzonedController(gamepad1, CONTROLLER_1_DEADZONE);
    DeadzonedController OperatorController = new DeadzonedController(gamepad2, CONTROLLER_2_DEADZONE);

    // Code to run when the driver hits INIT
    //Here, it tells the code to initialize the robot on the hardwareMap. And yes, the real local OpMode reference to the HardwareMap is called "hardwareMap".
    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    public void loop() {

        //Sets a bunch of booleans to false every cycle; you'll see why on the A pressed loop.
        boolean aPressed = false;
        boolean bPressed = false;
        boolean xPressed = false;
        boolean yPressed = false;

        boolean leftPressed = false;
        boolean rightPressed = false;

        //Sets the motor under the name for the ExampleMotor class to the magnitude of the left joystick's Y axis
        //Note the fact that there's empty parintheses to indicate a method call
        robot.setExampleMotorSpeed(DriverController.getLeftYAxis());

        //This opens the exampleServo if the A button is held down. If you want it to be on a toggle,
        //you'll need some more logic to check it across code cycles to make sure it doesn't spam
        //open/closed while you're holding it down. I wonder why I initialized those booleans for each button's previous state...? (Check Randy's Wisdom for further example code.)
        if (gamepad1.a) {
            robot.openExampleServo();
        } else {
            robot.closeExampleServo();
        }

        //Quick note: all the buttons are a, b, x and y, but the bumpers' coded labels are left_bumper and right_bumper respectively.
    }
}
