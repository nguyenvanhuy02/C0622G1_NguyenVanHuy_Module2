package ss4_class_object.exercise.build_stop_watch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();  // thời gian bắt đầu
        int a = 1;
        for (int i = 0; i < 100000; i++) {   //Thời gian chạy
            if(a < 99999) {
                a = i;
            }
        }
        stopWatch.stop();  // thười gian kết thúc
        System.out.println("Thời gian bắt đầu(s): " + stopWatch.getStartTime());
        System.out.println("Thời gian kết thúc(s):" + stopWatch.getEndTime());
        System.out.println( "Khoảng cách:" + stopWatch.getElapsedTime());
    }
}
