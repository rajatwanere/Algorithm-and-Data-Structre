package hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


    class Task implements Comparable<Task> {
        int deadline;
        int minutes;

        public Task(int deadline, int minutes) {
            this.deadline = deadline;
            this.minutes = minutes;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.deadline, other.deadline);
        }
    }

     class TaskSchedule {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of tasks: ");
            int numTasks = scanner.nextInt();

            List<Task> tasks = new ArrayList<>();

            System.out.println("Enter the deadline and minutes for each task:");
            for (int i = 0; i < numTasks; i++) {
                int deadline = scanner.nextInt();
                int minutes = scanner.nextInt();
                tasks.add(new Task(deadline, minutes));
            }

            Collections.sort(tasks);

            int maxOvershoot = 0;

            for (Task task : tasks) {
                int completionTime = task.minutes;


                if (completionTime > task.deadline) {
                    int overshoot = completionTime - task.deadline;
                    maxOvershoot = Math.max(maxOvershoot, overshoot);
                }
            }

            System.out.println("Maximum overshoot value: " + maxOvershoot);

            scanner.close();
        }
    }

