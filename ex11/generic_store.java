import java.util.*;

class GenericStore<T extends Comparable<T>> {
    private ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    void sortAndDisplay() {
        Collections.sort(list);
        System.out.println("Sorted Data: " + list);
    }
}

public class GenericMain {
    public static void main(String[] args) {
        GenericStore<Integer> intStore = new GenericStore<>();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("ENTRE THE NO OF ELEMENTS TO ADD:");
        int n = sc1.nextInt();
        for (int i=0;i<n;i++)
        {
            intStore.add(sc1.nextInt());
        }
        intStore.sortAndDisplay();

        GenericStore<String> strStore = new GenericStore<>();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("ENTRE THE NO OF ELEMENTS TO ADD:");
        int s = sc2.nextInt();
        for (int i=0;i<s;i++)
        {
            strStore.add(sc2.next());
        }
        strStore.sortAndDisplay();
    }
}
