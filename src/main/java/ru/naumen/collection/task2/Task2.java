package ru.naumen.collection.task2;

import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно реализовать метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task2
{

    /**
     * Возвращает дубликаты пользователей, которые есть в обеих коллекциях
     */
    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        Set<User> usersSetCollA = new HashSet<>(collA);
        // проходим по элементам collA и добавляем в usersSetCollA
        // добавление элемента в HashSet выполняется за O(1)
        // алгоритмическая сложность равна O(N), N - количество пользователей в collA
        List<User> result = new LinkedList<>();
        for (User user : collB){
            if (usersSetCollA.contains(user)){
                result.add(user);
            }
        }
        // Перебираем каждый элемент в collB, делаем проверку contains, которая выполняется за O(1)
        // затем добавляем элемент в LinkedList, что тоже займет O(1)
        // алгоритмическая сложность равна O(2M), где M - количество пользователей в collB
        return result;
        // O(N + 2M), общая алгоритмическая сложность
    }
}
