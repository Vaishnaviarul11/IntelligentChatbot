import java.util.*;

public class NaiveBayesClassifier {
    private Map<String, Map<String, Integer>> wordCounts = new HashMap<>();
    private Map<String, Integer> intentCounts = new HashMap<>();
    private Set<String> vocabulary = new HashSet<>();
    private int totalSamples = 0;

    public void train(Map<String, List<String>> trainingData) {
        for (String intent : trainingData.keySet()) {
            List<String> examples = trainingData.get(intent);
            intentCounts.put(intent, examples.size());
            totalSamples += examples.size();

            Map<String, Integer> counts = wordCounts.computeIfAbsent(intent, k -> new HashMap<>());
            for (String example : examples) {
                String[] words = example.toLowerCase().split("\\s+");
                for (String w : words) {
                    vocabulary.add(w);
                    counts.put(w, counts.getOrDefault(w, 0) + 1);
                }
            }
        }
    }

    public String classify(String input) {
        String[] words = input.toLowerCase().split("\\s+");
        double maxProb = Double.NEGATIVE_INFINITY;
        String bestIntent = "unknown";

        for (String intent : intentCounts.keySet()) {
            double logProb = Math.log((double) intentCounts.get(intent) / totalSamples);

            Map<String, Integer> counts = wordCounts.get(intent);
            int totalWordsInIntent = counts.values().stream().mapToInt(Integer::intValue).sum();

            for (String word : words) {
                int count = counts.getOrDefault(word, 0) + 1; // Laplace smoothing
                double wordProb = (double) count / (totalWordsInIntent + vocabulary.size());
                logProb += Math.log(wordProb);
            }

            if (logProb > maxProb) {
                maxProb = logProb;
                bestIntent = intent;
            }
        }
        return bestIntent;
    }
}
