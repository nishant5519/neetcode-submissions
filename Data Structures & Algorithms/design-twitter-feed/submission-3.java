class Twitter {

    private Map<Integer , List<int[]>> userTweets ;
    private Map<Integer, Set<Integer>> userFollowers ;
    private int time = 0;


    public Twitter() {
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> list = new ArrayList<>();
        if(userTweets.containsKey(userId)) {
             list = userTweets.get(userId);
        }  
            list.add(new int[]{tweetId , time++});
            userTweets.put(userId , list);
    }
    
    public List<Integer> getNewsFeed(int userId) {

    // Create a new list so we don't modify the followers list
    List<Integer> users = new ArrayList<>();

    if (userFollowers.containsKey(userId)) {
        users.addAll(userFollowers.get(userId));
    }

    // Include the user's own tweets
    users.add(userId);

    // Create a fresh max heap every time
    PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) -> b[1] - a[1]);

    // Add all tweets of the user and followees
    for (Integer user : users) {
        List<int[]> tweetAndTimestamps = userTweets.get(user);

        if (tweetAndTimestamps == null) {
            continue;
        }

        for (int[] tweetAndTimestamp : tweetAndTimestamps) {
            maxHeap.offer(tweetAndTimestamp);
        }
    }

    List<Integer> result = new ArrayList<>();

    // Return only the latest 10 tweets
    while (!maxHeap.isEmpty() && result.size() < 10) {
        result.add(maxHeap.poll()[0]);
    }

    return result;
}
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = new HashSet<>();
        if(followerId!=followeeId) {
            if(userFollowers.containsKey(followerId)) {
                set = userFollowers.get(followerId);
            }
            set.add(followeeId);
            userFollowers.put(followerId , set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userFollowers.containsKey(followerId)){
            Set<Integer> set = userFollowers.get(followerId);
            set.remove((Integer)followeeId);
        }
    }
}
