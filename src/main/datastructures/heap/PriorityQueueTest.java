package heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {


    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(3);
        pq.add(67);
        pq.add(5);
        pq.add(3);

        System.out.println(pq.peek());

        pq.poll();

        Iterator iterator = pq.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }


    }

}
