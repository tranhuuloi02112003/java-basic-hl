package ExerciseHashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetMain {
    public static boolean hasCommonElement(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
        for (Integer number : firstSet) {
            if (secondSet.contains(number)) {
                return true;
            }
        }
        return false;
    }

    public static HashSet<Integer> getIntersection(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
        HashSet<Integer> intersection = new HashSet<>(firstSet);
        intersection.retainAll(secondSet);
        return intersection;
    }

    public static HashSet<Integer> getUnion(HashSet<Integer> firstSet, HashSet<Integer> secondSet) {
        HashSet<Integer> union = new HashSet<>(firstSet);
        union.addAll(secondSet);
        return union;
    }

    public static boolean clearAndCheckEmpty(HashSet<Integer> set) {
        set.clear();
        return set.isEmpty();
    }

    public static void displayHashSetWithIterator(HashSet<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }
    }

    public static void displayArrayFromHashSet(HashSet<Integer> set) {
        Integer [] array = set.toArray(new Integer[0]);
        Arrays.stream(array).forEach(element -> System.out.print(element+"\t"));
    }


    public static void main(String[] args) {
        HashSet<Integer> firstSet = new HashSet<>(List.of(1, 2, 3, 4, 5));
        HashSet<Integer> secondSet = new HashSet<>(List.of(4, 5, 6, 7, 8));

        System.out.print("Check for existence of element in 2 HashSet:");
        System.out.println(hasCommonElement(firstSet, secondSet));

        System.out.print("\nGet intersection of 2 HashSet:");
        HashSet<Integer> intersectionResult = getIntersection(firstSet, secondSet);
        System.out.println(intersectionResult);

        System.out.print("\nGet union of 2 HashSet:");
        HashSet<Integer> unionResult = getUnion(firstSet, secondSet);
        System.out.println(unionResult);

        System.out.print("\nClear HashSet and check if it's empty:");
        boolean isThirdSetEmpty = clearAndCheckEmpty(firstSet);
        System.out.println(isThirdSetEmpty);

        System.out.println("\nDisplay elements of HashSet using Iterator:");
        displayHashSetWithIterator(secondSet);

        System.out.println("\nConvert HashSet to array and print each element:");
        displayArrayFromHashSet(secondSet);
    }

}
