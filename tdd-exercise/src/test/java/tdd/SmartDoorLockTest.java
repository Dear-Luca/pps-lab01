package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private SmartDoorLock smartDoorLock;
    private static final int PIN = 1234;

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
        smartDoorLock.setPin(PIN);
    }

    @Test
    public void testLockPinSet(){
        setPin();
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testUnlockCorrectPin(){
        setPin();
        smartDoorLock.lock();
        smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testUnlockWrongPin(){
        setPin();
        smartDoorLock.lock();
        final int pin = 2345;
        smartDoorLock.unlock(pin);
        assertTrue(smartDoorLock.isLocked());
    }



}
