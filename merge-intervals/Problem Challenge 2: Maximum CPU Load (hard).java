import java.util.*;

class Job {
  int start;
  int end;
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {
  public static int findMaxCPULoad(List<Job> jobs) {
    //NOTICE///////////////////////////////////////
    //. This solution works and is pretty optimized, but not most optimized.
    //. I used same idea of "Merge Intervals" but it can more effectively be done
    //. with a priority queue. I.e. I did it the correct way in the review :)
    //NOTICE///////////////////////////////////////
    if(jobs == null) return 0;
    if(jobs.size() == 1) return jobs.get(0).cpuLoad;

    Collections.sort(jobs, (a,b) -> Integer.compare(a.start, b.start));
    List<Job> mergedJobs = new ArrayList<Job>();

    int start = jobs.get(0).start;
    int end = jobs.get(0).end;
    int cpuLoad = jobs.get(0).cpuLoad;

    for(int i = 1; i < jobs.size(); i++) {
      //overlap
      if(end > jobs.get(i).start) {
        end = Math.max(end, jobs.get(i).end);
        cpuLoad += jobs.get(i).cpuLoad;
      }
      //no overlap
      else {
        mergedJobs.add(new Job(start, end, cpuLoad));
        start = jobs.get(i).start;
        end = jobs.get(i).end;
        cpuLoad = jobs.get(i).cpuLoad;
      }
    }
    //add mergedJob
    mergedJobs.add(new Job(start, end, cpuLoad));

    int maxCpuLoad = 0;
    for(Job job : mergedJobs) {
      maxCpuLoad = Math.max(maxCpuLoad, job.cpuLoad);
    }
    return maxCpuLoad;
  }

  public static void main(String[] args) {
    List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
  }
}