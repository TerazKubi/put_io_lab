package put.io.patterns.implement;

public class SystemInfoObserver implements SystemStateObserver{
    @Override
    public void update(SystemMonitor monitor) {

        // Print information to the console
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", monitor.lastSystemState.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", monitor.lastSystemState.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", monitor.lastSystemState.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", monitor.lastSystemState.getUsbDevices()));

    }
}
