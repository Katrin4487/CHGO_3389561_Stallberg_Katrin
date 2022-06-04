package propra22.q3389561.models;

/**
 * Klasse für Punkte im zweidimensionalen Raum x- und y-Koordinaten.
 *
 */
public class CPoint implements Comparable<CPoint> {

    //======================= Attribute ==================
    private int x,y;


    // ===================== Konstruktoren ===============
    /**
     * Konstruktor für einen CPoint.
     * @param x x-Koordinate des CPoints (int)
     * @param y y-Koordinate des Points(int)
     */
    public CPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    // ====================== Getter & Setter =================


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // ===================== Überschriebene Methoden ==========


    /**
     * Vergleicht den Punkt p mit einem Objekt obj. Wenn obj von der Klasse CPoint ist und die gleiche x- sowie die
     * y-Koordinate wie p hat, wird true ausgegeben sonst false.
     * @param obj Objekt, mit dem das vorhandene verglichen werden soll.
     * @return true, wenn obj von Typ CPoint ist und die gleiche x- sowie die gleiche y-Koordinate hat wie der gegebene
     * Punkt.
     */
    @Override
    public boolean equals(Object obj) {
        if(this.getClass() == obj.getClass()){
            CPoint p = (CPoint) obj;
            return p.getX() == ((CPoint) obj).getX() && this.getY() == ((CPoint) obj).getY();
        }else{
            return false;
        }
    }

    /**
     * Gibt den vorhandenen CPoint als String in der Form <code>"x</code> <code>y"</code> aus.
     * @return String der Form "x y"
     */
    @Override
    public String toString() {
        return Integer.toString(this.getX())+" "+Integer.toString(this.getY());
    }


    /**
     * <p>Vergleicht diesen <code>CPoint</code> p mit cPoint.</p>
     * <p>Wenn p und cPoint nicht gleich sind
     * (Vgl. {@link #equals(Object) equals(Object o)}), dann gilt:
     * p < cPoint, wenn p.x < cPoint.x ODER ( p.x = cPoint.x UND p.y < cPoint.y). Sonst ist p > q.</p>
     * @param cPoint, <code>CPoint</code>, mit dem verglichen werden soll.
     * @return 0, wenn p = cPoint, -1, wenn p < cPoint, 1 sonst
     */
    @Override
    public int compareTo(CPoint cPoint) {
        if(this.equals(cPoint)){
            return 0;
        }
        if(this.getX()< cPoint.getX() || this.getX()== cPoint.getX() && this.getY()< cPoint.getY()){
            return -1;
        }
        return 1;
    }


    //==================== Weiter Methoden ========================

    /**
     * vertauscht x und y des <code>CPoint</code>.
     */
    public void switchXY(){
        int ry = this.getY();
        this.setY(this.getX());
        this.setX(ry);
    }

    /**
     * Erzeugt aus einem String der Form "<code>int</code> <code>int</code>" einen <code>CPoint</code>.
     * Der erste Integer ist x und der zweite ist y.
     * @param cpString String der zwei mit Leerzeichen voneinander getrennte Integerwerte als String enthält.
     * @return <code>CPoint</code> mit x und y aus String oder null
     */
    public static CPoint cpointFromString(String cpString){
        if(cpString == null || cpString.trim().split(" ").length<2){
            return null;
        }else{
            try {
                String[] s = cpString.trim().split(" ");
                int sx = Integer.parseInt(s[0]);
                int sy = Integer.parseInt(s[1]);
                return new CPoint(sx,sy);
            }catch (NumberFormatException nfe){
                nfe.printStackTrace();
                return null;
            }
        }
    }

}
