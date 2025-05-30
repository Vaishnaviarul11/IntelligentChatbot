import java.util.*;

public class trainingdata {
    
    public static Map<String, List<String>> getTrainingExamples() {
        Map<String, List<String>> data = new HashMap<>();
        data.put("greeting", Arrays.asList(
            "hello", "hi", "hey", "good morning", "good evening"));
        data.put("goodbye", Arrays.asList(
            "bye", "goodbye", "see you", "take care"));
        data.put("thanks", Arrays.asList(
            "thank you", "thanks", "thank you very much"));
        data.put("ask_name", Arrays.asList(
            "what is your name", "who are you", "your name please"));
        data.put("ask_weather", Arrays.asList(
            "what's the weather", "tell me the weather", "weather today"));
        return data;
    }

    public static Map<String, String> getResponses() {
        Map<String, String> responses = new HashMap<>();
        responses.put("greeting", "Hello! How can I assist you today?");
        responses.put("goodbye", "Goodbye! Have a nice day!");
        responses.put("thanks", "You're welcome!");
        responses.put("ask_name", "I am ChatBot AI, your virtual assistant.");
        responses.put("ask_weather", "Sorry, I don't have weather data now.");
        responses.put("unknown", "Sorry, I don't understand. Can you rephrase?");
        return responses;
    }
}
