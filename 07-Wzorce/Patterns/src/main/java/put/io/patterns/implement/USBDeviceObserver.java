package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{
    private SystemState lastState = null;
    @Override
    public void update(SystemMonitor monitor) {

        if (lastState == null) return;

        int newUsbDevCount = monitor.lastSystemState.getUsbDevices();
        int lastUsbDevCount = lastState.getUsbDevices();

        if ( newUsbDevCount > lastUsbDevCount || newUsbDevCount < lastUsbDevCount ){

            System.out.println("New nubmer of USB Devices: " + Integer.toString(newUsbDevCount));

        }
    }
}
