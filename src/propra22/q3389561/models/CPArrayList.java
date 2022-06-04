package propra22.q3389561.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CPArrayList extends ArrayList<CPoint> {

    //========================== Konstruktor ============================

    /**
     * Konstruktor. Erstellt eine neue Liste an <code>CPoints</code>.
     */
    public CPArrayList(){
        super();
    }


    //======================== Override Methoden =====================

    /**
     * Fügt der Liste einen neuen <code>CPoint</code> analog der add-Methode von
     * ArrayList (Vgl. {@link java.util.ArrayList#add(Object)} ) hinzu, wenn dieser (ein gleicher) noch nicht vorhanden ist.
     * @param cPoint <code>CPoint</code>, der hinzugefügt werden soll
     * @return <code>true</code>, wenn cPoint hinzugefügt worden ist, sonst <code>false</code>.
     */
    @Override
    public boolean add(CPoint cPoint) {
        if(!this.contains(cPoint)){
            return super.add(cPoint);
        }else{
            return false;

        }
    }

    //============================ Weitere Methoden ===============================

    /**
     * Sortiert die Liste lexikographisch. {@link CPoint#compareTo(CPoint)}).
     */
    public CPArrayList sorted() {
        CPArrayList clist = new CPArrayList();
        clist.addAll(this.stream().toList());
        Collections.sort(clist);
        return clist;
    }

    /**
     * Sortiert diese Liste nach y-Werten. Es ist p < q, wenn p.y < q.y ODER (p.y = q.y UND p.x < q.x)
     */
    public CPArrayList sortedByY(){

        CPArrayList clist = new CPArrayList();
        clist.addAll(this.stream().toList());
        for(CPoint p : clist){
            p.switchXY();
        }
        clist = clist.sorted();
        for(CPoint p: clist){
            p.switchXY();
        }
        return clist;
    }


    /**
     * <p>Gibt den lexikographisch kleinsten <code>CPoint</code> aus.</p>
     * <p>Interpretiert man <code>CPoints</code> als Punkte in einem Koordinatensystem (Ursprung links oben analog Screen)
     * , so ist dies der Punkt am weitesten Links (kleinste x-Koordinate) mit der kleinsten y-Koordinate</p>
     * @return null, wenn die Liste leer ist, sonst den ersten Wert von {@link #sorted()}.
     */
    public CPoint returnLeft(){
       return this == null || this.isEmpty() ? null : this.sorted().get(0);
    }

    /**
     * <p>Gibt den lexikographisch größten <code>CPoint</code> aus.</p>
     * <p>Interpretiert man <code>CPoints</code> als Punkte in einem Koordinatensystem (Ursprung links oben analog Screen)
     * , so ist dies der Punkt am weitesten rechts (größte x-Koordinate) mit der größten y-Koordinate</p>
     * @return null, wenn die Liste leer ist, sonst den letzten Wert von {@link #sorted()}.
     */
    public CPoint returnRight(){
        return this == null || this.isEmpty() ? null : this.sorted().get(this.size()-1);
    }

    /**
     * <p>Gibt den lexikographisch kleinsten <code>CPoint</code> von {@link #sortedByY()} aus.</p>
     * <p>Interpretiert man <code>CPoints</code> als Punkte in einem Koordinatensystem (Ursprung links oben analog Screen),
     * so ist dies der Punkt am weitesten oben (kleinsten y-Koordinate) mit der größten x-Koordinate</p>
     * @return null, wenn die Liste leer ist, sonst den letzten Wert von {@link #sortedByY()}.
     */
    public CPoint returnTop(){
        return this == null  || this.isEmpty() ? null : this.sortedByY().get(0);
    }

    /**
     * <p>Gibt den lexikographisch größten <code>CPoint</code> von {@link #sortedByY()} aus.</p>
     * <p>Interpretiert man <code>CPoints</code> als Punkte in einem Koordinatensystem (Ursprung links oben analog Screen),
     * so ist dies der Punkt am weitesten unten (größte y-Koordinate) mit der größten x-Koordinate</p>
     * @return null, wenn die Liste leer ist, sonst den letzten Wert von {@link #sortedByY()}.
     */
    public CPoint returnBottom(){
        return this == null  || this.isEmpty() ? null : this.sortedByY().get(this.size()-1);
    }
}
