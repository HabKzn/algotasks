package practicum;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

    /**
     *
     * В задачах, в которых заранее не оговорен состав символов в строках,
     * строки могут содержать русские и английские буквы,
     * а также пробелы, знаки препинания, кавычки и скобки.
     *
     * Не использовать при решении регулярные выражения, методы стандартных библиотек
     * java.util.Collections, java.util.Arrays, java.lang.Math, а также методы
     * replace и replaceAll, reverce, equals, indexOf, toLowerCase, toUpperCase
     * split, substring из java.lang.String.
     * Можете использовать циклы, условные операторы,
     * простые типы данных и их обертки.
     *
     * Как изменится сложность ваших решений, если убрать
     * ограничения по использованию функций Java API?
     */

    /**
     * Вычислите максимальное, минимальное и среднее число для списка чисел
     * Верните их сумму
     * Список гарантированно содежит элементы
     */
     public static double maxMinAvr (List<Integer> numbers) {
         double min = numbers.get(0);
         double sumOfNumbers = 0;
         double max = numbers.get(0);
         for (int a : numbers) {
             if (a <= min) {
                 min = a;
             }
             if (a >= max) {
                 max = a;
             }
             sumOfNumbers += a;
         }
         return max + min + sumOfNumbers / numbers.size();
     }


    /**
     * Найдите второе максимальное значение в массиве,
     * если такого нет, то вернуть первое
     * Массив гарантировано содержит элементы
     */
    public static Integer max2 (List<Integer> list) {
        int max = list.get(0);
        int secondMax = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= max) max = list.get(i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > secondMax && list.get(i) != max) secondMax = list.get(i);
        }
        return secondMax;
    }

    /**
     * Удалите число из массива.
     * Верните массив не содержащий этого элемента,
     * но и не содержащий "пропусков" на месте удаленных элементов
     * Например, если из массива [0, 6, 0 ,5, 0] нужно удалить элемент 0,
     * то возвращаться должен массив содержащий два элемента [6, 5]
     */
    public static int[] removeElementFromArray(int[] numbers, int value) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != value) nums.add(numbers[i]);
        }
        int[] toReturn = new int[nums.size()];
        for (int i = 0; i < toReturn.length; i++) {
            toReturn[i] = nums.get(i);
        }
        return toReturn;
    }


    /**
     * Удалите все гласные из строки.
     * Например, "мАма Мыла раму" -> "мм Мл рм"
     */
    public static String removeVowels(String str) {
        char[] chars = str.toCharArray();
        List<Character> glasniye =
                List.of('А', 'а', 'У', 'у', 'О', 'о', 'Ы', 'ы', 'И', 'и', 'Э', 'э', 'Я', 'я', 'Ю', 'ю', 'Ё', 'ё', 'Е', 'е',
                        'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y');
        String noVowel = "";
        for (int i = 0; i < chars.length; i++) {
            if (!glasniye.contains(chars[i])) {
                noVowel += chars[i];
            }
        }
        return noVowel;
    }


    /**
     * Убрать повторяющиеся подряд символы в строке
     * например "ммммоолллокко" -> "молоко"
     * (*) - в этой задаче нужно учитывать сочетания
     * повторяющихся букв разного регистра,
     * при этом в выходной строке остается первая буква,
     * например, "мМммооЛллокКОоо" -> "моЛокО",
    */
    public static String removeDublicates(String str) {
        if (str.length() < 2) return str;
        char[] chars = str.toCharArray();
        List<Character> charList = new ArrayList<>();
        charList.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!(chars[i - 1] == Character.toLowerCase(chars[i])
                    || chars[i - 1] == Character.toUpperCase(chars[i])
                    || chars[i] == chars[i - 1]))
                charList.add(chars[i]);
        }
        String toReturn = "";
        for (int i = 0; i < charList.size(); i++) {
            toReturn += charList.get(i);
        }
        return toReturn;
    }

    /**
     * Сжать строку, удаляя повторяющиеся символы
     * и указывая количество повторов для каждого символа
     * например "мооолооооккооо" -> "м1о3л1о4к2о2"
     */
    public static String zipStr(String str) {
        if (str.length() < 1) return str;
        char[] chars = str.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            if ((i + 1) == chars.length) {
                charList.add(chars[i]);
                charList.add(Character.forDigit(count, 10));
                break;
            } else if (chars[i] != chars[i + 1]) {
                charList.add(chars[i]);
                charList.add(Character.forDigit(count, 10));
                continue;
            } else {
                do {
                    i++;
                    count++;
                } while ((i + 1) != chars.length && chars[i] == chars[i + 1]);
            }
            charList.add(chars[i]);
            charList.add(Character.forDigit(count, 10));
        }
        String toReturn = "";
        for (
                int i = 0; i < charList.size(); i++) {
            toReturn += charList.get(i);
        }
        return toReturn;
    }


    /**
     * Выяснить является ли строка палиндромом,
     * то есть  одинаково читается в обоих направлениях.
     * Например, слово "топот" - палиндром, а слово "топор" нет.
     * Строка "А роза упала на лапу Азора" тоже палиндром,
     * а строка "А роза уколола лапу Азора" нет.
     * "A man, a plan, a canal-Panama", тоже палиндром
     *
     * (!) Так как запрещены регулярные выражения
     * и методы преобразования регистра символов из java.lang.String
     * обратите внимание таблицу кодов символов UTF-8
     * (лучше убрать эту подсказку и выдать ее в процессе)
     */
    public static boolean isPalindrom(String str) {
        char[] charsArray = str.toCharArray();
        List<Character> charsList = new ArrayList<>();
        for (int i = 0; i < charsArray.length; i++) {
            if (charsArray[i] > 64 && charsArray[i] < 91 ||
                    charsArray[i] > 96 && charsArray[i] < 123 ||
                    charsArray[i] > 1039 && charsArray[i] < 1104 ||
                    charsArray[i] == 1025 || charsArray[i] == 1105)
                charsList.add(charsArray[i]);
        }
        List<Character> charsListReversed = new ArrayList<>();
        for (int i = charsArray.length - 1; i > 0; i--) {
            if (charsArray[i] > 64 && charsArray[i] < 91 ||
                    charsArray[i] > 96 && charsArray[i] < 123 ||
                    charsArray[i] > 1039 && charsArray[i] < 1104 ||
                    charsArray[i] == 1025 || charsArray[i] == 1105)
                charsListReversed.add(charsArray[i]);
        }
        boolean toReturn = true;
        for (int i = 0; i < charsList.size() - 1; i++) {
            if (charsList.get(i) == charsListReversed.get(i)
                    || charsList.get(i) == Character.toUpperCase(charsListReversed.get(i))
                    || charsList.get(i) == Character.toLowerCase(charsListReversed.get(i))) {
                continue;
            } else toReturn = false;
        }
        return toReturn;
    }

    /**
     * Перевернуть все слова в предложении
     * "Кот лакал молоко" -> "тоК лакал околом"
     */
    public static String reverseWordsInSentence(String sentence) {
        char[] chars = sentence.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] > 1039 && chars[i] < 1104 ||
                    chars[i] == 1025 || chars[i] == 1105) || (i == chars.length - 1)) {
                characterList.add(chars[i]);   // если не является буквой, или является последним символом, то добавляется в лист
            } else {  // если является буквой, тогда:
                int first = i;
                int last = i;
                for (int j = i; j < chars.length; j++) { //перебор, начиная с индекса, на котором обнаружена буква и заканчивая последним символом массива символов
                    final boolean b = chars[j] > 1039 && chars[j] < 1104 ||
                            chars[j] == 1025 || chars[j] == 1105;
                    if (j == chars.length - 1) {   // если текущий индекс является последним
                        if (b) last = j;
                        else last = j - 1;
                    } else if (b) {
                        continue;//пока является буквой, то цикл идет дальше
                    } else { // если перестал быть буквой
                        last = j - 1;
                        break;
                    }
                }
                i = last;
                for (int k = last; k >= first; k--) { // запускаем новый цикл в ходе которого добавляем символы в диапазоне от last до first
                    characterList.add(chars[k]);
                }
            }
        }
        String sb = "";
        for (int i = 0; i < characterList.size(); i++) {
            sb += characterList.get(i);
        }
        return sb;
    }

    /**
     * Отсортируйте символы в массиве,
     * не используйте дополнительные структуры данных.
     * При вводе массива символов {'c', 'a', 'b'},
     * возвращаться должен тот же отсортированный массив {'a', 'b', 'c'}
     */
    public static char[] sortSymbols(char[] symbols) {
        char temp = 0;
        for (int i = 0; i < symbols.length; i++) {
            for (int j = i + 1; j < symbols.length; j++) {
                if (symbols[i] > symbols[j]) {
                    temp = symbols[i];
                    symbols[i] = symbols[j];
                    symbols[j] = temp;
                }
            }
        }
        return symbols;
    }


    /**
     * Выясните являются ли две строки анограммами.
     * Строки являются анограммами, если они состоят из одних и тех же букв
     * Например, слова "кот" и "ток" анограммы, а слова "кот" и  "кит" нет.
     */
    public static boolean isAnogramOf(String word, String anogram) {
        char[] wordChar = word.toCharArray();
        char[] anogramChar = anogram.toCharArray();
        if (wordChar.length != anogramChar.length) {
            return false;
        }
        char temp = 0;
        for (int i = 0; i < wordChar.length; i++) {
            for (int j = i + 1; j < wordChar.length; j++) {
                if (wordChar[i] > wordChar[j]) {
                    temp = wordChar[i];
                    wordChar[i] = wordChar[j];
                    wordChar[j] = temp;
                }
            }
        }

        for (int i = 0; i < anogramChar.length; i++) {
            for (int j = i + 1; j < anogramChar.length; j++) {
                if (anogramChar[i] > anogramChar[j]) {
                    temp = anogramChar[i];
                    anogramChar[i] = anogramChar[j];
                    anogramChar[j] = temp;
                }
            }
        }
        int a = 0;
        for (int i = 0; i < wordChar.length; i++) {
            if (wordChar[i] != anogramChar[i]) {
                a++;
            }
        }
        return a == 0;
    }

    /**
     * Выясните, все ли символы в строке встречаются один раз.
     * Если строка содержит повторябщиеся символы,
     * то возвращать false, если не содержит - true
     * Нельзя использовать дополнительные структуры данных.
     * <p>
     * (!) В этой задаче строка может содержать
     * любой символ из таблицы ASCII (127 символов)
     * <p>
     * (!!) Сложность - O(n)
     */

    public static boolean hasUniqueChars(String str) {
        if (str.length() == 1) {
            return str.charAt(0) < 128;
        }
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) || str.charAt(j) > 127 || str.charAt(i) > 127) {
                    a++;
                }
            }
        }
        return a == 0;
    }
}
