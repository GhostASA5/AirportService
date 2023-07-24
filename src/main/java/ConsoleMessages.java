import java.util.ArrayList;
import java.util.List;

public class ConsoleMessages {

    public ConsoleMessages(List<String> messages) {
        this.messages = messages;
    }

    public ConsoleMessages() {
    }

    private List<String> messages = new ArrayList<>();

    public void addMessage(String message){
        messages.add(message);
    }

    public List<String> getAllConsoleMessages(){
        return messages;
    }

}
