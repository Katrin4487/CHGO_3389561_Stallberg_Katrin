package propra22.q3389561.controllers;

import propra22.q3389561.models.WindowResizeEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Klasse für Monitor für Veränderungen in der Fenstergröße
 */
public class WindowResizeMonitor implements Runnable{

    private static final HashMap<Window,WindowResizeMonitor> WINDOW_MAP = new HashMap<Window,WindowResizeMonitor>();

    private List<WindowResizeListener> listeners = new ArrayList<WindowResizeListener>();
    private boolean run = false;
    private Window window;

    /**
     * Privater Konstruktor
     * @param window Fenster <code>Window</code>, das beobachtet werden soll
     */
    private WindowResizeMonitor(Window window){
        this.window = window;
    }

    /**
     * Das <code>Window</code> window bekommt einen <code>WindowResizeListener</code>
     * listener.
     * @param window <code>Window</code>, das einen <code>WindowResizeListener</code> bekommt
     * @param listener <code>WindowResizeListener</code>, der dem <code>Window</code> angefügt wird
     */
    public static void register(Window window, WindowResizeListener listener){
        WindowResizeMonitor monitor = (WindowResizeMonitor) WINDOW_MAP.get(window);

        if(monitor==null){
            monitor = new WindowResizeMonitor(window);
            WINDOW_MAP.put(window,monitor);
        }
        monitor.add(listener);
    }

    /**
     * Der <code>WindowResizeListener</code> listener wird vom Window <code>window</code>
     * wieder entfernt (soweit vorhanden)
     * @param window <code>Window</code>, das einen <code>WindowResizeListener</code> besizt
     * @param listener <code>WindowResizeListener</code>, der dem <code>Window</code> window angefügt ist
     *                 und entfernt werden soll
     */
    public static void unregister(Window window, WindowResizeListener
            listener) {
        WindowResizeMonitor monitor = (WindowResizeMonitor)
                WINDOW_MAP.get(window);

        if (monitor != null) {
            monitor.remove(listener);
        }
    }

    /**
     * Fügt <code>WindowResizeListener</code> listener zu den laufenen Listenern hinzu
     * @param listener <code>WindowResizeListener</code>, der hinzugefügt werden soll
     */
    private synchronized void add(WindowResizeListener listener) {
        listeners.add(listener);

        if (!run) {
            run = true;
            new Thread(this).start();
        }
    }

    private synchronized void remove(WindowResizeListener listener) {
        listeners.remove(listener);

        if (run && listeners.isEmpty()) {
            run = false;
        }
    }


    @Override
    public void run() {
        Dimension oldSize = window.getSize();

        try {
            while (run) {
                Thread.sleep(100);

                Dimension curSize = window.getSize();
                if (!oldSize.equals(curSize)) {
                    fireWindowResizeEvent(new WindowResizeEvent(window,
                            oldSize, curSize));

                    oldSize = curSize;
                }
            }
        } catch (InterruptedException e) {
        }
    }


    private void fireWindowResizeEvent(WindowResizeEvent event) {
        Iterator it = listeners.iterator();

        while (it.hasNext()) {
            WindowResizeListener l = (WindowResizeListener) it.next();
            l.windowResized(event);
        }
    }

}
