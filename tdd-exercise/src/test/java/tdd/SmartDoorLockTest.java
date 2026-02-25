package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private SmartDoorLock smartDoorLock;
    private static final int PIN = 1234;
    private static final int WRONG_PIN = 2345;
    private static final int MAX_ATTEMPTS = 5;

    @BeforeEach
    void beforeEach(){
        this.smartDoorLock = new SmartDoorLockImpl(MAX_ATTEMPTS);
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

    private void setPinAndLock(){
        setPin();
        smartDoorLock.lock();
    }

    @Test
    public void testLockPinSet(){
        setPinAndLock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testUnlockCorrectPin(){
        setPinAndLock();
        smartDoorLock.unlock(PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testUnlockWrongPin(){
        setPinAndLock();
        smartDoorLock.unlock(WRONG_PIN);
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testIsBlocked(){
        setPinAndLock();
        for (int i = 0; i < smartDoorLock.getMaxAttempts(); i++) {
            smartDoorLock.unlock(WRONG_PIN);
        }
        assertThrows(IllegalStateException.class, () -> smartDoorLock.unlock(PIN));
    }

}

