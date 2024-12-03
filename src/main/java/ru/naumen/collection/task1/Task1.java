package ru.naumen.collection.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Дано:
 * <pre>
 * public class Ticket {
 *     private long id;
 *     private String client;
 *     …
 * }</pre>
 * <p>Разработать программу для бармена в холле огромного концертного зала.
 * Зрители в кассе покупают билет (класс Ticket), на котором указан идентификатор билета (id) и имя зрителя.
 * При этом, есть возможность докупить наборы разных товаров (комбо-обед): нет товаров, напитки, еда и напитки.
 * Доп. услуги оформляются через интернет и привязываются к билету, но хранятся отдельно от билета
 * (нельзя добавить товары в класс Ticket).</p>
 * <p>Бармен сканирует билет и получает объект Ticket. По этому объекту нужно уметь
 * находить необходимые товары по номеру билета. И делать это нужно очень быстро,
 * ведь нужно как можно быстрее всех накормить.</p>
 * <p>
 * См. {@link Ticket}
 *
 * @author vpyzhyanov
 * @since 19.10.2023
 */
public class Task1
{
    private Map<Long, Goods> ticketsStorage = new HashMap<>();
    public enum Goods {
        /**
         * нет товаров
         */
        EMPTY,
        /**
         * напитки
         */
        DRINKS,
        /**
         * еда и напитки
         */
        FOOD_AND_DRINKS
    }

    /**
     * Положить в HashMap id пользователя и товар
     */
    public void setGoods(Ticket ticket, Goods goods){
        ticketsStorage.put(ticket.getId(), goods);
    }

    /**
     * Получить товары по билету
     */
    public Goods getGoods(Ticket ticket) {
        return ticketsStorage.get(ticket.getId());
        //В качестве ключей храним id пользователей, получение
        // значения по ключу в HashMap выполняется за O(1)
    }
}
