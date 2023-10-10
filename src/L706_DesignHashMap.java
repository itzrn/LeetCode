package src;



public class L706_DesignHashMap {
    private static class Node{
        Node next;
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    Node head;
    public L706_DesignHashMap() {

    }

    public void put(int key, int value) {
        if(head == null){
            head = new Node(key, value);
            return;
        }
        Node curr = head;
        while(curr.next != null){
            if(curr.key == key){
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        if(curr.key == key){
            curr.value = value;
            return;
        }

        curr.next = new Node(key, value);

    }

    public int get(int key) {
        Node curr = head;
        while(curr != null){
            if(curr.key == key){
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        if( head == null){
            return;
        }
        if(head.key == key){
            head = head.next;
            return;
        }

        Node curr = head;
        while(curr.next != null){
            if(curr.next.key == key){
                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }

    }
}
