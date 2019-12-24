package edu.list;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            System.out.println("Введите целое положительное число: количество элементов в списке.");
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
            System.out.println("Введите элементы списка.");
            LinearList mainList = new LinearList();
            for (int i = 0; i < numberOfObject; i++) {
                mainList.add(input.next());
            }
            int numberOfOperation = -1;
            while (numberOfOperation != 0) {
                System.out.println("Введите число: 0 - выход; 1 - добавление элемента;" +
                        " 2 - получение элемента; 3 - удаление элемента по индексу; 4 - удаление элемента; " +
                        "\n5 - проверка вхождения элемента в список; 6 - индекс элемента в списке.");
                numberOfOperation = input.nextInt();
                int indexOfObject;
                Object obj;
                switch (numberOfOperation) {
                    case (0):
                        break;
                    case (1):
                        System.out.println("Введите целое положительное число: индекс нового элемента.");
                        indexOfObject = input.nextInt();
                        System.out.println("Введите элемент.");
                        mainList.add(indexOfObject, input.next());
                        System.out.println(mainList.toString());
                        break;
                    case (2):
                        System.out.println("Введите целое положительное число: индекс элемента.");
                        indexOfObject = input.nextInt();
                        try {
                            obj = mainList.get(indexOfObject);
                            System.out.println(obj.toString());
                        } catch (NoSuchElementException e) {
                            System.out.println("Элемента с таким индексом нет.");
                        }
                        break;
                    case (3):
                        System.out.println("Введите целое положительное число: индекс удаляемого элемента.");
                        indexOfObject = input.nextInt();
                        mainList.remove(indexOfObject);
                        System.out.println(mainList.toString());
                        break;
                    case (4):
                        System.out.println("Введите удаляемый элемент.");
                        obj = input.next();
                        mainList.remove(obj);
                        System.out.println(mainList.toString());
                        break;
                    case (5):
                        System.out.println("Введите проверяемый элемент.");
                        obj = input.next();
                        boolean b = mainList.contains(obj);
                        if (b) {
                            System.out.println("Элемент в списке есть.");
                        } else {
                            System.out.println("Элемента в списке нет.");
                        }
                        break;
                    case (6):
                        System.out.println("Введите элемент.");
                        obj = input.next();
                        indexOfObject = mainList.indexOf(obj);
                        if (indexOfObject == -1) {
                            System.out.println("Элемента в списке нет.");
                        } else {
                            System.out.println("Индекс элемента: " + indexOfObject);
                        }
                        break;
                    default:
                        throw new Exception("Ошибка: неверно введён номер операции.");
                }
            }
            System.out.println(mainList.toString());
        } catch (Exception e) {
            if (e.getMessage() == null) {
                System.out.println("Ошибка.");
            } else {
                System.out.println(e.getMessage());
            }
        }
    }
}
