import java.util.*;

class LogEntry{

    int timestamp;
    String message;

    LogEntry(int timestamp, String message){
        this.timestamp = timestamp;
        this.message = message;
    }

    @Override
    public String toString(){
        return timestamp + " : " + message;
    }
}

public class MergeKSortedLogs{

    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources){

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> sources.get(a[0]).get(a[1]).timestamp
                        - sources.get(b[0]).get(b[1]).timestamp
        );

        for (int i = 0; i < sources.size(); i++){

            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> result = new ArrayList<>();

        while (!minHeap.isEmpty()){

            int[] top = minHeap.poll();

            int listIndex = top[0];
            int elementIndex = top[1];

            result.add(sources.get(listIndex).get(elementIndex));

            if (elementIndex + 1 < sources.get(listIndex).size()){
                minHeap.offer(new int[]{
                        listIndex,
                        elementIndex + 1
                });
            }
        }

        return result;
    }

    public static void main(String[] args){

        List<List<LogEntry>> logs = new ArrayList<>();

        logs.add(Arrays.asList(
                new LogEntry(1, "A"),
                new LogEntry(4, "B"),
                new LogEntry(7, "C")
        ));

        logs.add(Arrays.asList(
                new LogEntry(2, "D"),
                new LogEntry(5, "E")
        ));

        logs.add(Arrays.asList(
                new LogEntry(3, "F"),
                new LogEntry(6, "G")
        ));

        List<LogEntry> merged = mergeKSortedLogs(logs);

        for (LogEntry entry : merged){
            System.out.println(entry);
        }
    }
}