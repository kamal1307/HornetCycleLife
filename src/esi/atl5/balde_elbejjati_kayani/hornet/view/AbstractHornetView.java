package esi.atl5.balde_elbejjati_kayani.hornet.view;

import esi.atl5.balde_elbejjati_kayani.hornet.model.Game;
import esi.atl5.balde_elbejjati_kayani.hornet.mvc.HornetModel;
import esi.atl5.balde_elbejjati_kayani.hornet.mvc.HornetView;
import javafx.scene.Parent;

/**
 * Communication between model and view
 * @author Alpha,Mohamed,Kamal
 */
public abstract class AbstractHornetView extends Parent implements HornetView {

    private HornetModel model;

    /**
     * Transfer model to view
     */
    public void setModel(HornetModel model) {       
        if (this.model != null) {
            this.model.removeHornetListener(this);
        }
        this.model = model;
        model.addHornetListener(this);
       
    }

    /**
     * return model
     * @return
     */
    public HornetModel getModel() {
        return model;
    }

}
