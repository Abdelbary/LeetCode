class MyHashMap {
    int[] hashMap;
    public MyHashMap() {
        hashMap = new int[(int)(1e6+1)];
        
        for(int i = 0 ; i < (int)(1e6+1) ; i++)
        {
            hashMap[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        hashMap[key] = value;
    }
    
    public int get(int key) {
        return hashMap[key];
    }
    
    public void remove(int key) {
        hashMap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */