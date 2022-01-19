import java.util.*;
import java.util.Arrays;
public class Mastermind {


    private String[] paternColors;

    public Mastermind startGame(String[] paternColors){
        return new Mastermind(paternColors);
    }

    private Mastermind(String[] paternColors){
        this.paternColors = paternColors;
    }

    public static void main(String args[]) {
        System.out.println();
    }

    // проверяем, что цвет содержится в массиве
    public static boolean checkColorExist(String inColor, String[] patternColors){
        // пробежаться по массиву и найти первое соответствие, можно сделать через Stream
        Optional<String> sameColor = Arrays.stream(patternColors).filter(color->color.equals(inColor)).findFirst();
        return sameColor.isPresent();
    }

    // подсчитывает кол-во совпадающих цветов в одинаковых позициях в массивах
    public static int countSamePositionColors(String[] patternColors, String[] inColors) {
        // просто в цикле по основному массиву проверяем совпадает ли элемент
        // с находящемся во входящем массиве в той же позиции
        // и в случае успеха итерируем переменную
        int amountInSamePosition = 0;
        for(int i=0; i<patternColors.length; i++){
            //if equals colors
            if(patternColors[i].equals(inColors[i])){
                amountInSamePosition++;
            }
        }
        return amountInSamePosition;
    }
}
