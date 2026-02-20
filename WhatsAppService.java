/**
 * WhatsAppService is a notification medium that simulates sending messages
 * through WhatsApp.
 *
 * It implements NotificationMedium so it can be swapped into AlertSystem
 * without changing AlertSystem.java.
 *
 * @author Erika Coreth
 */
public class WhatsAppService implements NotificationMedium {

    /**
     * Sends a message via WhatsApp (simulated with console output).
     *
     * @param message the message to send
     */
    @Override
    public void send(String message) {
        System.out.println("[WhatsApp] Sending message: " + message);
    }
}

