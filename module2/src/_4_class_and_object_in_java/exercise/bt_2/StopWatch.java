package _4_class_and_object_in_java.exercise.bt_2;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch s = new StopWatch();
        s.start();
        int a = 0;
        for (int x = 0; x < 10000000; x++) {
            for (int y = 0; y < 1000000; y++) {
                a += 1;
            }

        }
        s.stop();
        System.out.println(s.getStartTime());
        System.out.println(s.getEndTime());
        System.out.println(s.getElapsedTime());
    }
}
