package Homework2;
public class Process implements Comparable<Process> {
    private String processName;
    private int priority;
    private int burstTime;
    private int arrivalTime;

    public Process(String processName, int priority, int burstTime, int arrivalTime) {
        this.processName = processName;
        this.priority = priority;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    public String getProcessName() {
        return this.processName;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getBurstTime() {
        return this.burstTime;
    }
    public void setBurstTime(int newTime) {
        this.burstTime = newTime;

    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    @Override
    public String toString() {
        return this.processName + " - " + this.priority + " - " + this.arrivalTime + " - " + this.burstTime;
    }

    @Override
    public int compareTo(Process other) {
        if(this.priority > other.priority) {
            return -1;
        } else if(this.priority < other.priority) {
            return 1;
        } else {
            if(this.arrivalTime > other.arrivalTime) {
                return -1;
            } else if(this.arrivalTime < other.arrivalTime) {
                return 1;
            }
        }
        return 0;
    }
}