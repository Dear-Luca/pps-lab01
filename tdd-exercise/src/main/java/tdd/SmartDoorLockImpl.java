package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{
    private boolean isLocked;
    private boolean isPinSet = false;
    private int pin;

    @Override
    public void setPin(int pin) {
        this.isPinSet = true;
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if (pin == this.pin){
            this.isLocked = false;
        }
    }

    @Override
    public void lock(){
        if (!isPinSet){
            throw new IllegalStateException();
        }
        this.isLocked = true;
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
