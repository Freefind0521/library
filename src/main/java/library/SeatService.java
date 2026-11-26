package library;

import java.util.Map;

public class SeatService {
    private final Map<String, Integer> seats;

    public SeatService(Map<String, Integer> seats) {
        this.seats = seats;
    }

    public void reserve(String sid, int hour) {
        if (hour > 4) {
            throw new IllegalArgumentException("单次最多 4 小时");
        }
        seats.put(sid, hour);
    }
}
