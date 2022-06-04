package propra22.q3389561.models;

import java.awt.*;
import java.util.EventObject;

public class WindowResizeEvent extends EventObject {

    //=================== Attribute==============
    private Dimension oldSize,newSize;

    //====================== Konstruktor=================
    /**
     * Konstruktor für Event, wenn sich die Fenstergröße verändert.
     * @param source eigentiches Objekt, dessen Größe sich verändert
     * @param oldSize alte Größe <code>Dimension</code>>
     * @param newSize neue Größe <code>Dimension</code>
     */
    public WindowResizeEvent(Object source, Dimension oldSize, Dimension newSize) {
        super(source);
        this.oldSize = oldSize;
        this.newSize = newSize;
    }

    //===================== Getter & Setter ===============


    public Dimension getOldSize() {
        return oldSize;
    }

    public void setOldSize(Dimension oldSize) {
        this.oldSize = oldSize;
    }

    public Dimension getNewSize() {
        return newSize;
    }

    public void setNewSize(Dimension newSize) {
        this.newSize = newSize;
    }
}
