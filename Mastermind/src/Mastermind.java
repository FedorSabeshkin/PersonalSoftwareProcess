import java.util.*;
import java.util.Arrays;
public class Mastermind {


    public static void main(String args[]) {
        System.out.println();
    }

    public static boolean checkColorExist(String inColor, String[] paternColors){
        // пробежаться по массиву и найти первое соответствие, можно сделать через Stream
        Optional<String> sameColor = Arrays.stream(paternColors).filter(color->color.equals(inColor)).findFirst();
        return sameColor.isPresent();
    }
}
