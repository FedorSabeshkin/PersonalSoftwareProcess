import java.util.*;
import java.util.stream.Stream;

public class Mastermind {

    public static void main(String args[]) {
        System.out.println();
    }

    /**
     *  Count colors non same positions
     * @param patternColors - загаданная последовательность
     * @param inColors - последовательность отгадывающего игрока
     * @return amount colors non same positions
     */
    public static int countNonSamePositionsColors(String[] patternColors, String[] inColors) {
        int amountSameColor = countSameColors(patternColors, inColors);
        int amountColorInSamePosition = countSamePositionColors(patternColors, inColors);
        return amountSameColor-amountColorInSamePosition;
    }

    /**
     * Return answer after one game move
     * @param patternColors - загаданная последовательность
     * @param inColors - последовательность отгадывающего игрока
     * @return array with length 2
     * in first elem contains amount Color In Same Position
     * in second elem contains amount Non Same Positions Colors
     */
    public static int[] gameMove(String[] patternColors, String[] inColors) {
        int amountColorInSamePosition = countSamePositionColors(patternColors, inColors);
        int amountNonSamePositionsColors = countNonSamePositionsColors(patternColors, inColors);
        return new int[] {amountColorInSamePosition, amountNonSamePositionsColors};
    }

    /**
     * Подсчитывает кол-во цветов, содержащихся в обоих последовательностях
     * независимо от их расположения
     * @param patternColors - загаданная последовательность
     * @param inColors  - последовательность отгадывающего игрока
     * @return Кол-во цветов содержащихся в обоих последовательностях
     */
    public static int countSameColors(String[] patternColors, String[] inColors) {
        Stream<String> colorsInBothArrs = Arrays.stream(inColors).filter(color->checkColorExist(color, patternColors) );
        return (int) colorsInBothArrs.count();
    }

    /**
     * Проверяем, что цвет содержится в массиве
     * @param inColor - цвет
     * @param patternColors - массив цветов
     * @return ответ на вопрос, содержится ли цвет в последовательности
     */
    public static boolean checkColorExist(String inColor, String[] patternColors){
        // пробежаться по массиву и найти первое соответствие
        Optional<String> sameColor = Arrays.stream(patternColors).filter(color->color.equals(inColor)).findFirst();
        return sameColor.isPresent();
    }

    /**
     * Подсчитывает кол-во совпадающих цветов в одинаковых позициях в массивах
     * @param patternColors  - загаданная последовательность
     * @param inColors  - последовательность отгадывающего игрока
     * @return кол-во совпадающих цветов в одинаковых позициях в массивах
     */
    public static int countSamePositionColors(String[] patternColors, String[] inColors) {
        // в цикле по основному массиву проверяем совпадает ли элемент
        // с находящемся во входящем массиве в той же позиции
        // и в случае успеха итерируем переменную
        int amountInSamePosition = 0;
        for(int i=0; i<patternColors.length; i++){
            if(patternColors[i].equals(inColors[i])){
                amountInSamePosition++;
            }
        }
        return amountInSamePosition;
    }
}
