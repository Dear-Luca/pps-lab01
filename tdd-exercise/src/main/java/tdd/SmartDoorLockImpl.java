package tdd;

public class SmartDoorLockImpl implements SmartDoorLock{
    private boolean isLocked = false;
    private boolean isBlocked = false;
    private boolean isPinSet = false;
    private int pin;
    private final int maxAttempts;
    private int failedAttempts = 0;

    public SmartDoorLockImpl(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }



    @Override
    public void setPin(int pin) {
        this.isPinSet = true;
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if (pin == this.pin){
            this.isLocked = false;
        } else if (failedAttempts < maxAttempts - 1){
            this.failedAttempts += 1;
        } else {
            this.isBlocked = true;
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
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }
}
