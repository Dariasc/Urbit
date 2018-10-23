package com.dariasc.urbital.ui;

import com.dariasc.urbital.CelestialBody;
import com.dariasc.urbital.Urbital;

import javax.swing.*;
import java.awt.*;

public class UrbitalWindow extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.setBackground(Color.BLACK);

        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

        g.setColor(Color.YELLOW);
        g.fill(Urbital.system.getParent().body());
        for (CelestialBody body : Urbital.system.getChildren()) {
            g.setColor(Color.WHITE);
            g.draw(body.orbit());
        }
    }
}
