package ss4_class_object.exercise.build_stop_watch;


public class StopWatch {
    private long startTime;
    private long endTime;                           // LocalTime hiển thị thời gian hiện tại

    public StopWatch() {
    }

    public void start() {
        startTime = System.currentTimeMillis();  /// System.currentTimeMillis() hiển thị luôn thời gian mili
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }


    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }
}