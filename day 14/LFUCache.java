class DLLNode {
    int key;
    int val;
    int frequency;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DoublyLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;

    public DoublyLinkedList() {
        this.listSize = 0;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // add new node into head of list and increase list size by 1
    public void addNode(DLLNode curNode) {
        DLLNode nextNode = head.next;
        curNode.next = nextNode;
        curNode.prev = head;
        head.next = curNode;
        nextNode.prev = curNode;
        listSize++;
    }

    // remove input node and decrease list size by 1
    public void removeNode(DLLNode curNode) {
        DLLNode prevNode = curNode.prev;
        DLLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}

class LFUCache {
    final int cap;
    int currSize;
    int minFreq;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.currSize = 0;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if (currNode == null) {
            return -1;
        }
        updateNode(currNode);
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if (cap == 0) return;
        
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        }
        else {
            currSize++;
            if (currSize > cap) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }
            minFreq = 1;
            DLLNode newNode = new DLLNode(key, value);
            
            DoublyLinkedList curList = freqMap.getOrDefault(1, new DoublyLinkedList());
            curList.addNode(newNode);
            freqMap.put(1, curList);
            cache.put(key, newNode);
        }
    }
    
    public void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoublyLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(curNode);
        
        if (curFreq == minFreq && curList.listSize == 0) {
            minFreq++;
        }
        
        curNode.frequency++;
        DoublyLinkedList newList = freqMap.getOrDefault(curNode.frequency, new DoublyLinkedList());
        newList.addNode(curNode);
        freqMap.put(curNode.frequency, newList);
    }
}