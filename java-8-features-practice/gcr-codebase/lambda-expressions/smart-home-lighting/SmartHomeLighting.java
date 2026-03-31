import java.util.*;

public class SmartHomeLighting {
    public static void main(String[] args) {

        Map<String, LightAction> lightBehaviors = new HashMap<>();

        // Lambdas for different triggers
        lightBehaviors.put("MOTION", () ->
            System.out.println("\nMotion detected -> Lights ON at full brightness"));

        lightBehaviors.put("NIGHT", () ->
            System.out.println("Night time -> Lights ON at warm dim mode"));

        lightBehaviors.put("VOICE_ON", () ->
            System.out.println("Voice command -> Lights ON"));

        lightBehaviors.put("VOICE_OFF", () ->
            System.out.println("Voice command -> Lights OFF"));

        // Simulating triggers
        triggerLight("MOTION", lightBehaviors);
        triggerLight("NIGHT", lightBehaviors);
        triggerLight("VOICE_ON", lightBehaviors);
        triggerLight("VOICE_OFF", lightBehaviors);
    }

    static void triggerLight(String trigger, Map<String, LightAction> behaviors) {
        LightAction action = behaviors.get(trigger);

        if(action != null) {
            action.execute();
        } else {
            System.out.println("No action defined for this trigger");
        }
    }
}