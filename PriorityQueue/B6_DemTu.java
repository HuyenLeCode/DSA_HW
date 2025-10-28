import java.util.*;

class WordCount {
    String word;
    int count;

    WordCount(String w) {
        this.word = w;
        this.count = 1;
    }
}

public class B6_DemTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<WordCount> list = new ArrayList<>();

        while (sc.hasNext()) {
            String word = sc.next().toLowerCase().replaceAll("[^a-z0-9]", "");
            if (word.isEmpty()) continue;

            boolean found = false;
            for (WordCount wc : list) {
                if (wc.word.equals(word)) {
                    wc.count++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                list.add(new WordCount(word));
            }
        }

        Collections.sort(list, new Comparator<WordCount>() {
            @Override
            public int compare(WordCount a, WordCount b) {
                return a.word.compareTo(b.word);
            }
        });

        for (WordCount wc : list) {
            System.out.println(wc.word + " : " + wc.count);
        }
    }
}