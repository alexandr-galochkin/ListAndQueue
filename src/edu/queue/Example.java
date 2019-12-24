package edu.queue;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            System.out.println("Введите целое положительное число: количество элементов в очереди.");
            int numberOfObject;
            Scanner input = new Scanner(System.in);
            try {
                numberOfObject = input.nextInt();
                if (numberOfObject < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                throw new Exception("Ошибка: количество элементов должно быть целым положительным числом.");
            }
            System.out.println("Введите элементы очереди.");
            LinkedQueue mainQueue = new LinkedQueue();
            for (int i = 0; i < numberOfObject; i++) {
                mainQueue.add(input.next());
            }
            int numberOfOperation = -1;
            while (numberOfOperation != 0) {
                System.out.println("Введите число: 0 - выход; 1 - добавление элемента;" +
                        " 2 - получение элемента с удалением из очереди; 3 - получение элемента без удаления из очереди; 4 - удаление элемента; " +
                        "\n5 - проверка вхождения элемента в очередь.");
                numberOfOperation = input.nextInt();
                int indexOfObject;
                Object obj;
                switch (numberOfOperation) {
                    case (0):
                        break;
                    case (1):
                        System.out.println("Введите элемент.");
                        mainQueue.add(input.next());
                        System.out.println(mainQueue.toString());
                        break;
                    case (2):
                        obj = mainQueue.poll();
                        System.out.println(obj != null ? obj.toString() : "Очередь пуста.");
                        System.out.println(mainQueue.toString());
                        break;
                    case (3):
                        obj = mainQueue.peek();
                        System.out.println(obj != null ? obj.toString() : "Очередь пуста.");
                        System.out.println(mainQueue.toString());
                        break;
                    case (4):
                        System.out.println("Введите удаляемый элемент.");
                        obj = input.next();
                        mainQueue.remove(obj);
                        System.out.println(mainQueue.toString());
                        break;
                    case (5):
                        System.out.println("Введите проверяемый элемент.");
                        obj = input.next();
                        boolean b = mainQueue.contains(obj);
                        if (b) {
                            System.out.println("Элемент в очереди есть.");
                        } else {
                            System.out.println("Элемента в очереди нет.");
                        }
                        break;
                    default:
                        throw new Exception("Ошибка: неверно введён номер операции.");
                }
            }
            System.out.println(mainQueue.toString());
        } catch (Exception e) {
            if (e.getMessage() == null) {
                System.out.println("Ошибка.");
            } else {
                System.out.println(e.getMessage());
            }
        }
    }
}