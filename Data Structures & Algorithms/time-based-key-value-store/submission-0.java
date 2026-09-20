class TimeMap {
    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);

        map.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key);

        if (pairs == null || pairs.isEmpty())
            return "";

        int left = 0;
        int right = pairs.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair pair = pairs.get(mid);

            if (pair.timestamp == timestamp)
                return pair.value;

            if (pair.timestamp < timestamp) {
                // Valid candidate, but look for a later timestamp
                result = pair.value;
                left = mid + 1;
            } else {
                // Timestamp is too large
                right = mid - 1;
            }
        }

        return result;
    }
}

class Pair {
    String value;
    int timestamp;

    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}