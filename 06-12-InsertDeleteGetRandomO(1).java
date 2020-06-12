class RandomizedSet {
    HashMap<Integer, Integer> set;
    ArrayList<Integer> list;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (set.containsKey(val)) return false;
        set.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!set.containsKey(val)) return false;
        int lelem = list.get(list.size() - 1);
        int id = set.get(val);
        list.set(id, lelem);
        set.put(lelem, id);
        set.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */