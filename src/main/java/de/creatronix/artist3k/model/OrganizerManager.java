package de.creatronix.artist3k.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class OrganizerManager {

    HashSet<Organizer> organizers = new HashSet<Organizer>();

    public OrganizerManager() {
        Organizer organizer1 = new Organizer();
        organizer1.setName("Megazin Media");
        organizers.add(organizer1);
        Organizer organizer2 = new Organizer();
        organizer2.setName("Bitbuger");
        organizers.add(organizer2);
    }

    public Collection<Organizer> getAllOrganizers() {
        return organizers;
    }

    public Organizer loadOrganizerByName(String organizerName) {
        Organizer organizer1 = null;
        for (Iterator iterator = organizers.iterator(); iterator.hasNext();) {
            organizer1 = (Organizer)iterator.next();
            if(organizer1.getName() == organizerName)
                break;
        }
        return organizer1;
    }
}
