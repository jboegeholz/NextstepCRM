package de.creatronix.artist3k.controller.form;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import de.creatronix.artist3k.model.Organizer;

public class OrganizerListForm extends ActionForm {

    /**
     *
     */
    private static final long serialVersionUID = 7736771856153561270L;

    private Collection<Organizer> organizers;

    public void setOrganizers(Collection<Organizer> allOrganizers) {
        this.organizers = allOrganizers;

    }

    public Collection<Organizer> getOrganizers() {
        return organizers;
    }

}
