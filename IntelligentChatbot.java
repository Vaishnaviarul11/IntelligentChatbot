import java.util.Scanner;

public class IntelligentChatbot {
    public static void main(String[] args) {
        NaiveBayesClassifier classifier = new NaiveBayesClassifier();
        classifier.train(trainingdata.getTrainingExamples());

        var responses = trainingdata.getResponses();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🤖 Intelligent Chatbot ready! Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("bye")) {
                System.out.println("Bot: " + responses.get("goodbye"));
                break;
            }

            String intent = classifier.classify(input);
            System.out.println("Bot: " + responses.getOrDefault(intent, responses.get("unknown")));
        }

        scanner.close();
    }
}
