import java.util.*;
public class CharacterCounthola {
    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'a', 'd', 'a', 'e', 'a', 'b', 'd', 'b'};
        char searchChar = 'b';
        int count = countCharacterOccurrences(charArray, searchChar);
        System.out.println("The character '" + searchChar + "' appears " + count + " times.");
    }
    public static int countCharacterOccurrences(char[] charArray, char searchChar) {
        int count = 0;
        for (char c : charArray) {
            if (c == searchChar) {
                count++;
            }
        }
        return count;
    }
}
    

