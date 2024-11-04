package lab_9;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PointsByDistance {

    public static void main(String[] args) {
        PriorityQueue<B8_04> pointsQueue = new PriorityQueue<>(new Comparator<B8_04>() {
            @Override
            public int compare(B8_04 p1, B8_04 p2) {
                return Double.compare(p1.distanceToOrigin(), p2.distanceToOrigin());
            }
        });

        pointsQueue.add(new B8_04(3, 4));
        pointsQueue.add(new B8_04(1, 1));
        pointsQueue.add(new B8_04(0, 2));
        pointsQueue.add(new B8_04(5, 6));
        pointsQueue.add(new B8_04(1, 0));

        System.out.println("точечки в порядке возрастания их спавна(координат):");
        while (!pointsQueue.isEmpty()) {
            System.out.println(pointsQueue.poll());
        }
    }
}
