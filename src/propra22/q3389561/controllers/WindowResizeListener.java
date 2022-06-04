package propra22.q3389561.controllers;

import propra22.q3389561.models.WindowResizeEvent;

import java.util.EventListener;

public interface WindowResizeListener extends EventListener {

    void windowResized(WindowResizeEvent e);

}
