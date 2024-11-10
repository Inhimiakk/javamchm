package lab_10;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class B9_03 {

    public static AtomicInteger totalContainersUnloaded = new AtomicInteger(0);

    public static void main(String[] args) {
        int N = 3; 
        double T1 = 5.0;
        double T2 = 10.0;
        long T3 = 1000;
        int K1 = 5;
        int K2 = 10;
        int M = 10;
        int K3 = 50;

        Semaphore docks = new Semaphore(N, true);
        Thread[] ships = new Thread[M];

        System.out.println("Началинаем хитрую симуляцию порта");

        for (int i = 0; i < M; i++) {
            long arrivalTime = (long) ((Math.random() * (T2 - T1) + T1) * 1000);
            int containersToUnload = (int) (Math.random() * (K2 - K1 + 1) + K1);
            int shipId = i;

            ships[i] = new Thread(() -> ship(arrivalTime, T3, containersToUnload, shipId, docks, K3));
            ships[i].start();
        }

        try {
            for (int i = 0; i < M; i++) {
                ships[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Симуляция прервана(ужас)");
        }

        System.out.println("Печальный конец симуляции порта");
    }

    public static void ship(long arrivalTime, long unloadTime, int containers, int shipId, Semaphore docks,
            int targetContainers) {
        try {
            Thread.sleep(arrivalTime);
            System.out.printf("Кораблик %d прибыл с %d контейнерами.\n", shipId, containers);

            docks.acquire();
            System.out.printf("Кораблик %d начинает разгрузку.\n", shipId);

            for (int i = 0; i < containers; i++) {
                Thread.sleep(unloadTime);
                int currentTotal = totalContainersUnloaded.incrementAndGet();
                System.out.printf("Кораблик %d выгрузил контейнер %d. Всего выгружено контейнеров: %d\n", shipId, i + 1,
                        currentTotal);

                if (currentTotal >= targetContainers) {
                    System.out.printf("Цель достигнута: выгружено %d контейнеров.\n", targetContainers);
                }
            }

            System.out.printf("Кораблик %d завершил разгрузку и покидает причал.\n", shipId);
            docks.release();
        } catch (InterruptedException e) {
            System.out.printf("Кораблик %d был прерван.\n", shipId);
        }
    }
}
