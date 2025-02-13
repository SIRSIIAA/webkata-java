package sirsiiaa.webkata.java.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("npc")
public class NPCBean implements Creature {
    @Value("${npc.name}")
    private String name;
    @Override
    public String getName() {
        return name;
    }
}
