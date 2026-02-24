package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach(){
        this.smartDoorLock = new SmartDoorLockImpl();
    }

    @Test
    public void testInitialState(){
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testLockPinNotSet(){
        assertThrows(IllegalStateException.class, () -> smartDoorLock.lock());
    }

    private void setPin(){
        final int pin = 1234;
        smartDoorLock.setPin(pin);
    }

    @Test
    public void testLockPinSet(){
        setPin();
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }



}
