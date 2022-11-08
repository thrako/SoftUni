package lesson01_stacks_and_queues.exercise;

import java.util.*;

public class N10Robotics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Robot> robots = readRobots(scanner);
        Time time = readTime(scanner);
        Queue<String> items = readItems(scanner);
        processItems(robots, time, items);
    }

    private static void processItems(List<Robot> robots, Time time, Queue<String> items) {
        while (!items.isEmpty()) {
            time.addSecond();
            robots.forEach(Robot::updateTime);
            String item = items.poll();

            boolean itemTaken = false;
            for (Robot robot : robots) {
                if (!robot.isBusy()) {
                    robot.getTask();
                    log(robot.getName(), item, time);
                    itemTaken = true;
                    break;
                }
            }

            if (!itemTaken) items.offer(item);
        }
    }

    private static List<Robot> readRobots(Scanner scanner) {
        List<Robot> robots = new ArrayList<>();
        String[] roboStrings = scanner.nextLine().split(";");
        for (String dataString : roboStrings) {
            String[] roboData = dataString.split("-");
            String name = roboData[0];
            int processingTime = Integer.parseInt(roboData[1]);
            robots.add(new Robot(name, processingTime));
        }
        return robots;
    }

    private static Time readTime(Scanner scanner) {
        String[] timeString = scanner.nextLine().split(":");
        int hours = Integer.parseInt(timeString[0]);
        int minutes = Integer.parseInt(timeString[1]);
        int seconds = Integer.parseInt(timeString[2]);
        return new Time(hours, minutes, seconds);
    }

    private static Queue<String> readItems(Scanner scanner) {
        Queue<String> items = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            items.offer(input);
            input = scanner.nextLine();
        }
        return items;
    }

    private static void log(String name, String item, Time time) {
        System.out.printf("%s - %s [%s]%n", name, item, time.toString());
    }

    private static class Robot {
        private String name;
        private int processTime;
        private int busyTime;

        public Robot(String name, int timePerTask) {
            this.setName(name);
            this.setProcessTime(timePerTask);
            this.busyTime = 0;
        }

        public void setProcessTime(int processTime) {
            this.processTime = processTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void getTask() {
            this.busyTime += processTime;
        }

        public void updateTime() {
            if (this.busyTime > 0) this.busyTime -= 1;
        }

        public boolean isBusy() {
            return this.busyTime > 0;
        }
    }

    private static class Time {
        private int hours;
        private int minutes;
        private int seconds;

        public Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public void addSecond() {
            this.seconds += 1;
            if (this.seconds > 59) {
                this.seconds -= 60;
                this.minutes += 1;
            }
            if (this.minutes > 59) {
                this.minutes -= 60;
                this.hours += 1;
            }
            if (this.hours > 23) this.hours -= 24;
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
        }
    }
}
