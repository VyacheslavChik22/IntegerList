import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyIntegersListTest {

    private MyIntegersList myIntegersList; // создаем переменную типа тестируемого класса
    private final Integer TEST_NUM = 10; // создаем константную переменную для использования в тестах
    private final Integer[] TEST_lIST = {TEST_NUM};

    @BeforeEach
    void setUp() {
        myIntegersList = new MyIntegersList(); //инизиализируем переменную  для использования в каждом тесте
    }


    @org.junit.jupiter.api.Test
    void shouldAddItemWhenAdd() {
        Integer result = myIntegersList.add(TEST_NUM);// добавляем в пустой массив значение
        assertEquals(result, TEST_NUM);               // проверяем
        assertEquals(myIntegersList.size(), 1); // проверяем, что в массиве 1 элемент
    }

    @org.junit.jupiter.api.Test
    void shouldAddItemWhenAddByIndex() {
        Integer result = myIntegersList.add(0, TEST_NUM);
        assertEquals(result, TEST_NUM);
        assertEquals(myIntegersList.size(), 1);

    }

    @org.junit.jupiter.api.Test
    void shouldAddItemOnPositionWhenSet() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем элемент
        Integer result = myIntegersList.set(0,TEST_NUM); //добавляем элемент на место предыдущего
        assertEquals(result, TEST_NUM);
        assertEquals(myIntegersList.size(), 1);

    }

    @org.junit.jupiter.api.Test
    void shouldFindItemByIndex() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем элемент
        int result = myIntegersList.indexOf(TEST_NUM);
        assertEquals(result, 0);
    }

    @org.junit.jupiter.api.Test
    void shouldExceptionIfItemIsNot() {
    //проверка выброса искючения(класс исключения, по методу  с аргументом)
        assertThrows(Exception.class, () -> myIntegersList.remove(TEST_NUM));
    }

    @org.junit.jupiter.api.Test
    void shouldRemoveItemByIndex() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем элемент1
        Integer result = myIntegersList.remove(0); //удаляем элемент получая null
        assertEquals(result, null);
        assertEquals(myIntegersList.size(), 0); // в массиве нет элементов

    }

    @org.junit.jupiter.api.Test
    void shouldReturnTrueOrTrue() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем элемент
        boolean result = myIntegersList.contains(TEST_NUM);
        assertTrue(result);                                   //элемент есть-true
        assertEquals(myIntegersList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnTrueOrFalse() {
        boolean result = myIntegersList.contains(TEST_NUM);
        assertFalse(result);                                //элемента нет-false
    }


    @org.junit.jupiter.api.Test
    void shouldReturnItemByLastIndexCheckingIndex() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем элемент
        int result = myIntegersList.lastIndexOf(TEST_NUM);
        assertEquals(result, 0);//возвращается индекс элемента - 0
    }


    @org.junit.jupiter.api.Test
    void shouldReturnItemByIndex() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем элемент
        Integer result = myIntegersList.get(0);
        assertEquals(result,TEST_NUM);
        assertEquals(myIntegersList.size(), 1);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnItemByLastIndexCheckingAbsence() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем элемент
        int result = myIntegersList.lastIndexOf(52);
        assertEquals(result, -1);//возвращается индекс элемента - 1
    }

    @org.junit.jupiter.api.Test
    void shouldReturnExceptionIfIndexOutOfSize() {
        Integer resultAdding = myIntegersList.add(0, TEST_NUM);//добавляем 1элемент
        Integer resultAdding2 = myIntegersList.add(0, TEST_NUM);//добавляем еще 1элемент
        assertThrows(Exception.class,()-> myIntegersList.get(2));//выбрасываем исключение если индекс элемента выходит за длину массива.

    }

    @Test
    void shouldTestEqualsBeValid() {
        Integer resultAdding = myIntegersList.add(TEST_NUM);//добавляем 1элемент
       MyIntegersList expectedList = new MyIntegersList();        //объявляем проверочный массив
        expectedList.add(TEST_NUM);                        //добавляем в него тот же элемент
        boolean result = myIntegersList.equals(expectedList); // кладем в переменную нужный метод с проверяемый массивом
        assertTrue(result);   //Проверяется равенство массивов

    }
    @org.junit.jupiter.api.Test
    void shouldTestEqualsBeNotValid() {
        Integer resultAdding = myIntegersList.add(TEST_NUM);//добавляем 1элемент
        MyIntegersList expectedList = new MyIntegersList();        //объявляем проверочный массив без элементов
        boolean result = myIntegersList.equals(expectedList); // кладем в переменную нужный метод с проверяемый массивом
        assertFalse(result);   //Проверяется неравенство массивов

    }
    @org.junit.jupiter.api.Test
    void shouldReturnSize() {
        Integer resultAdding = myIntegersList.add(TEST_NUM);//добавляем 1элемент
        int result = myIntegersList.size();
        assertEquals(result,1);
    }

    @org.junit.jupiter.api.Test
    void shouldReturnTrue() {
        boolean result = myIntegersList.isEmpty();
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void shouldReturnFalse() {
        Integer resultAdding = myIntegersList.add(TEST_NUM);//добавляем 1элемент
        boolean result = myIntegersList.isEmpty();
        assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void shouldClearItemsFromArray() {
        Integer resultAdding = myIntegersList.add(TEST_NUM);//добавляем 1элемент
        myIntegersList.clear();       //очищаем массив от элементов
        int result = myIntegersList.size();
        assertEquals(result,0);

    }

    @org.junit.jupiter.api.Test
    void shouldEqualsNewArrayAndOld() {
        Integer resultAdding = myIntegersList.add(TEST_NUM);//добавляем 1элемент
        Integer[] result = myIntegersList.toArray();
        assertArrayEquals(result,TEST_lIST);  //Сравниваем массивы
    }

    @org.junit.jupiter.api.Test
    void shouldGrowArray() {
        Integer resultAdding = myIntegersList.add(TEST_NUM);//добавляем 1элемент
        Integer resultAdding2 = myIntegersList.add(TEST_NUM);//добавляем 2элемент
        int result = myIntegersList.arrLength();   //Сравниваем длинну увеличившегося массива.
        assertEquals(result,3);

    }

}