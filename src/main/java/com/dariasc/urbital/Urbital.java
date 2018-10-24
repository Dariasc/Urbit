package com.dariasc.urbital;

import com.dariasc.urbital.ui.UrbitalWindow;

import javax.swing.*;

public class Urbital {

    public static final double G = 6.674 * Math.pow(10,-11);

    public static int w = 800, h = 600;
    public static CelestialSystem system;

    public static void main(String[] args) {
        system = toySystem();
        system.getParent().injectChildren();

        JFrame frame = new JFrame("Urbit");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new UrbitalWindow());
        frame.setSize(w, h);
        frame.setVisible(true);
    }

    public static CelestialSystem toySystem() {
        return new CelestialSystem(new CelestialBody.Builder("Sol", 50)
                .withChild(new CelestialBody.Builder("Kerbin", 20, new Orbit(0.6f, 200))
                        .build())
                .build());
    }

    public static CelestialSystem solarSystem() {
        return new CelestialSystem(new CelestialBody.Builder("Sun", 1.989e30f, new Orbit(0, 0))
                .withChild(new CelestialBody.Builder("Earth", 5.972e24f, new Orbit(0.017f, 1.496e11f))
                        .build())
                .build());
    }

    public static CelestialSystem earthSystem() {
        return new CelestialSystem(new CelestialBody.Builder("Earth", 5.972e24f, new Orbit(0, 0))
                .withChild(new CelestialBody.Builder("Moon", 7.34767309e22f, new Orbit(0.0549f, 379700000f))
                        .build())
                .build());
    }

}
