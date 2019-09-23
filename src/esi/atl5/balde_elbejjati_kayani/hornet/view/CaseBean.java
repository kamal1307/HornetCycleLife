//@pbt je ne vois pas de test du bean

package esi.atl5.balde_elbejjati_kayani.hornet.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

/**
 * Create a composant CaseBean
 * @author Alpha,Mohamed,Kamal
 */
public class CaseBean extends Parent {

    private final BooleanProperty ALIVE;
    private final ObjectProperty<Color> COLOR;
    private final Rectangle RECTANGLE;

    private PropertyChangeSupport propertySupport;

    /**
     * Constructor of this class.
     */
    public CaseBean() {
        ALIVE = new SimpleBooleanProperty(true);
        COLOR = new ObjectPropertyBase<Color>() {
            @Override
            public Object getBean() {
                return this;
            }

            @Override
            public String getName() {
                return "Color";
            }
        };

        RECTANGLE = new Rectangle();
       // RECTANGLE.setStroke(Color.AQUA);
        
       RECTANGLE.setHeight(15);
        RECTANGLE.setWidth(15);
        setColor(Color.RED);
        getChildren().add(RECTANGLE);
    }

    /**
     * Set state of hornet. death or alive
     * @param alive
     */
    public final void setAlive(boolean alive) {
        this.ALIVE.set(alive);

        RECTANGLE.setFill(alive ? COLOR.get() : Color.TRANSPARENT);
    }

    /**
     * Check if hornet is alive
     * @return true if hornet alive 
     */
    public final boolean isAlive() {
        return ALIVE.get();
    }

    /**
     * Return property of ALIVE
     * @return ALIVE
     */
    public final BooleanProperty onProperty() {
        return ALIVE;
    }

    /**
     * Obtain Color
     * @return Color
     */
    public final Color getColor() {
        return COLOR.get();
    }

    /**
     * Change color if hornet death or alive
     * @param color
     */
    public final void setColor(Color color) {
        this.COLOR.set(color);
        RECTANGLE.setFill(isAlive() ? getColor() : Color.TRANSPARENT);
    }

    /**
     * Obtain property of color
     * @return
     */
    public final ObjectProperty<Color> colorProperty() {
        return COLOR;
    }

    /**
     * Add listener in parameter
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove listener in parameter
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
