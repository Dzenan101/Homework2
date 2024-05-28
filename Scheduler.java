package Homework2;
import java.util.ArrayList;

public class Scheduler {
    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue processQueue = new ProcessQueue();

        int currentTime = 0;

        while (!processQueue.isEmpty() || anyProcessesRemaining(processes)) {
            for (Process process : processes) {
                if (process.getArrivalTime() == currentTime) {
                    processQueue.addProcess(process);
                }
            }

            Process currentProcess = processQueue.peekNextProcess();

            if (currentProcess != null) {
                currentProcess.setBurstTime(currentProcess.getBurstTime() - 1);

                if (currentProcess.getBurstTime() > 0) {
                    if (currentTime < 10)
                        System.out.println("t: " + currentTime + "   | " + currentProcess.getProcessName());
                    else System.out.println("t: " + currentTime + "  | " + currentProcess.getProcessName());
                } else {
                    if (currentTime < 10)
                        System.out.println("t: " + currentTime + "   | " + currentProcess.getProcessName());
                    else System.out.println("t: " + currentTime + "  | " + currentProcess.getProcessName());
                    processQueue.runNextProcess();
                }
            } else {
                if (currentTime < 10) System.out.println("t: " + currentTime + "   | no process");
                else System.out.println("t: " + currentTime + "  | no process");
            }

            currentTime++;
        }

        System.out.println("Total time: " + currentTime);
    }

    public static boolean anyProcessesRemaining(ArrayList<Process> processes) {
        for (Process process : processes) {
            if (process.getBurstTime() > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();

        processes.add(new Process("P1", 1, 4, 0));
        processes.add(new Process("P2", 2, 3, 0));
        processes.add(new Process("P3", 1, 7, 6));
        processes.add(new Process("P4", 3, 4, 11));
        processes.add(new Process("P5", 2, 2, 12));

        scheduleAndRun(processes);

    }
}