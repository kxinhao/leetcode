/**
 * LeetCode 981 Time Based Key-Value Store (Medium)
 * custom data class, hashmap to store key and data list, binary search in data list on get
 * alt soln use TreeMap
 * TC: O(log N) binary search on get
 */
// 3rd impl

class Data {
    String val;
    int time; 
    public Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }

    public void set(String key, String value, int time) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<Data>());
        map.get(key).add(new Data(value, time));
    }

    public String get(String key, int time) {
        if(!map.containsKey(key)) return "";
        return binarySearch(map.get(key), time);
    }

    private String binarySearch(List<Data> list, int time) {
        int lo = 0, hi = list.size()-1;
        while(lo<hi) {
            int mid = (lo+hi)/2;
            if(list.get(mid).time == time) return list.get(mid).val;
            if(list.get(mid).time < time) {
                if(list.get(mid+1).time > time) return list.get(mid).val;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return list.get(lo).time <= time ? list.get(lo).val : "";
    }
}
