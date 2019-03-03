package Job_Intervie_1.Concurrency_Lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class Concurrency_Classes {
    public static void main(String[] args) {
        // Мютекс - это единичный симофор имеющий да положения = открытий или закрытый доступ к ресурсу.

        // Монитор - некая внутренняя сущность, которая связана с каждым объектом и
        // которая называется внутренней блокировкой, или блокировкой монитора
        // (иногда просто используется слово "монитор").

        // Concurrent Collections — набор коллекций, более эффективно работающие в многопоточной среде нежели
        // стандартные универсальные коллекции из java.util пакета. Вместо базового враппера Collections.synchronizedList
        // с блокированием доступа ко всей коллекции используются блокировки по сегментам данных или же оптимизируется
        // работа для параллельного чтения данных по wait-free алгоритмам.

        ArrayList<String> strings = new ArrayList<>();

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.addAllAbsent(strings);
        copyOnWriteArrayList.addIfAbsent("");

        CopyOnWriteArraySet<String> stringCopyOnWriteArraySet = new CopyOnWriteArraySet<>();

        // — Интерфейс, расширяющий Map несколькими дополнительными атомарными операциями.
        ConcurrentMap<String, Integer> map = new ConcurrentMap<String, Integer>() {
            @Override
            public Integer putIfAbsent(String key, Integer value) {
                return null;
            }

            @Override
            public boolean remove(Object key, Object value) {
                return false;
            }

            @Override
            public boolean replace(String key, Integer oldValue, Integer newValue) {
                return false;
            }

            @Override
            public Integer replace(String key, Integer value) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Integer get(Object key) {
                return null;
            }

            @Override
            public Integer put(String key, Integer value) {
                return null;
            }

            @Override
            public Integer remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends Integer> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Integer> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Integer>> entrySet() {
                return null;
            }
        };

        // В отличие от Hashtable и блоков synhronized на HashMap, данные представлены в виде сегментов,
        // разбитых по hash'ам ключей. В результате, для доступ к данным лочится по сегментам, а не по одному объекту.
        // В дополнение, итераторы представляют данные на определенный срез времени и не
        // кидают ConcurrentModificationException.
        ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();

        // — Расширяет интерфейс NavigableMap и вынуждает использовать ConcurrentNavigableMap объекты в качестве
        // возвращаемых значений. Все итераторы декларируются как безопасные к использованию и не
        // кидают ConcurrentModificationException.
        ConcurrentNavigableMap<String, Integer> navigableMap; // Interface

        // — Является аналогом TreeMap с поддержкой многопоточности. Данные также сортируются по ключу и гарантируется
        // усредненная производительность log(N) для containsKey, get, put, remove и других похожих операций.
        // Алгоритм работы SkipList описан на Wiki и хабре.
        ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();

        // — Имплементация Set интерфейса, выполненная на основе ConcurrentSkipListMap.
        ConcurrentSkipListSet<String> skipListSet = new ConcurrentSkipListSet<>();

        // Queues — неблокирующие и блокирующие очереди с поддержкой многопоточности. Неблокирующие очереди заточены
        // на скорость и работу без блокирования потоков. Блокирующие очереди используются, когда нужно «притормозить»
        // потоки «Producer» или «Consumer», если не выполнены какие-либо условия, например, очередь пуста или перепонена,
        // или же нет свободного «Consumer»'a.

        // Non-Blocking Queues
        // Потокобезопасные и неблокирующие имплементации Queue на связанных нодах (linked nodes).

        ConcurrentLinkedQueue<String> stringConcurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        // — В имплементации используется wait-free алгоритм от Michael & Scott, адаптированный для работы с
        // garbage collector'ом. Этот алгоритм довольно эффективен и, что самое важное, очень быстр,
        // т.к. построен на CAS. Метод size() может работать долго, т.ч. лучше постоянно его не дергать.

        ConcurrentLinkedDeque<String> stringConcurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        // — Deque расшифровывается как Double ended queue и читается как «Deck». Это означает, что данные можно
        // добавлять и вытаскивать с обоих сторон. Соответственно, класс поддерживает оба режима работы:
        // FIFO (First In First Out)(Очередь) и LIFO (Last In First Out)(Стек). На практике, ConcurrentLinkedDeque
        // стоит использовать только, если обязательно нужно LIFO, т.к. за счет двунаправленности нод данный класс
        // проигрывает по производительности на 40% по сравнению с ConcurrentLinkedQueue.

        // Blocking Queues

        BlockingQueue<String> blockingQueue;
        // — При обработке больших потоков данных через очереди становится явно недостаточно использования
        // ConcurrentLinkedQueue. Если потоки, разгребающие очередь перестанут справляться с наплывом данных,
        // то можно довольно быстро схлопотать out of memory или перегрузить IO/Net настолько, что производительность
        // упадет в разы пока не настанет отказ системы по таймаутам или из за отсутствия свободных дескрипторов
        // в системе. Для таких случаев нужна queue с возможностью задать размер очереди или с блокировками по условиям.
        // Тут то и появляется интерфейс BlockingQueue, открывающий дорогу к целому набору полезных классов.
        // Помимо возможности задавать размер queue, добавились новые методы, которые реагируют по-разному на
        // незаполнение или переполнение queue. Так, например, при добавлении элемента в переполненную queue,
        // один метод кинет IllegalStateException, другой вернет false, третий заблокирует поток,
        // пока не появится место, четвертый же заблокирует поток с таймаутом и вернет false, если место так
        // и не появится. Также стоит отметить, что блокирующие очереди не поддерживают null значения,
        // т.к. это значение используется в методе poll как индикатор таймаута.

        ArrayBlockingQueue<String> arrayBlockingQueue;
        // — Класс блокирующей очереди, построенный на классическом кольцевом буфере. Помимо размера очереди, доступна
        // возможность управлять «честностью» блокировок. Если fair=false (по умолчанию), то очередность работы потоков
        // не гарантируется. Более подробно о «честности» можно посмотреть в описании ReentrantLock'a.

        //DelayQueue<> delayQueue;
        // — Довольно специфичный класс, который позволяет вытаскивать элементы из очереди только по прошествии
        // некоторой задержки, определенной в каждом элементе через метод getDelay интерфейса Delayed.

        LinkedBlockingQueue<String> stringLinkedBlockingQueue;
        // — Блокирующая очередь на связанных нодах, реализованная на «two lock queue» алгоритме:
        // один лок на добавление, другой на вытаскивание элемента. За счет двух локов, по сравнению с
        // ArrayBlockingQueue, данный класс показывает более высокую производительность, но и расход памяти у него выше.
        // Размер очереди задается через конструктор и по умолчанию равен Integer.MAX_VALUE.

        PriorityBlockingQueue<String> stringPriorityBlockingQueue;
        // — Является многопоточной оберткой над PriorityQueue. При вставлении элемента в очередь, его порядок
        // определяется в соответствии с логикой Comparator'а или имплементации Comparable интерфейса у элементов.
        // Первым из очереди выходит самый наименьший элемент.

        SynchronousQueue<String> stringSynchronousQueue;
        // — Эта очередь работает по принципу один вошел, один вышел. Каждая операция вставки блокирует «Producer»
        // поток до тех пор, пока «Consumer» поток не вытащит элемент из очереди и наоборот, «Consumer» будет ждать
        // пока «Producer» не вставит элемент.

        BlockingDeque<String> stringBlockingDeque;
        // — Интерфейс, описывающий дополнительные методы для двунаправленной блокирующей очереди. Данные можно
        // вставлять и вытаскивать с двух сторон очереди.

        LinkedBlockingDeque<String> stringLinkedBlockingDeque;
        // — Двунаправленная блокирующая очередь на связанных нодах, реализованная как простой двунаправленный список
        // с одним локом. Размер очереди задается через конструктор и по умолчанию равен Integer.MAX_VALUE.

        TransferQueue<String> stringTransferQueue;
        // — Данный интерфейс может быть интересен тем, что при добавлении элемента в очередь существует возможность
        // заблокировать вставляющий «Producer» поток до тех пор, пока другой поток «Consumer» не вытащит элемент
        // из очереди. Блокировка может быть как с таймаутом, так и вовсе может быть заменена проверкой на наличие
        // ожидающих «Consumer»ов. Тем самым появляется возможность реализации механизма передачи сообщений с
        // поддержкой как синхронных, так и асинхронных сообщений.

        LinkedTransferQueue<String> stringLinkedTransferQueue;
        //— Реализация TransferQueue на основе алгоритма Dual Queues with Slack. Активно использует CAS и
        // парковку потоков, когда они находятся в режиме ожидания.

        

        // Synchronizers — вспомогательные утилиты для синхронизации потоков. Представляют собой мощное оружие
        // в «параллельных» вычислениях.

        // Executors — содержит в себе отличные фрейморки для создания пулов потоков, планирования работы
        // асинхронных задач с получением результатов.

        // Locks — представляет собой альтернативные и более гибкие механизмы синхронизации потоков по сравнению
        // с базовыми synchronized, wait, notify, notifyAll.

        // Atomics — классы с поддержкой атомарных операций над примитивами и ссылками.
    }
}
