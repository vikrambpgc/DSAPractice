package com.australia.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        List<Pair> times = new ArrayList<>();

        for (int i=0; i < intervals.length; i++) {
            int[] timeInterval = intervals[i];
            times.add(new Pair(TimeEvent.OPEN, timeInterval[0]));
            times.add(new Pair(TimeEvent.CLOSE, timeInterval[1]));
        }

        Collections.sort(times, (a, b) -> {
            if (a.time != b.time) {
                return a.time - b.time;
            } else {
                if (a.t == TimeEvent.CLOSE) return -1;
                else return +1;
            }
        });

        int meetingRooms = 0, maxMeetingRooms = 0;
        for(Pair p: times) {
            if (p.t == TimeEvent.OPEN) {
                meetingRooms++;
                maxMeetingRooms = Math.max(maxMeetingRooms, meetingRooms);
            } else {
                meetingRooms--;
            }
        }

        return maxMeetingRooms;
    }
}

class Pair {
    TimeEvent t;
    int time;

    public Pair(TimeEvent t, int time) {
        this.t= t;
        this.time = time;
    }


}

enum TimeEvent {
    OPEN,
    CLOSE
}
