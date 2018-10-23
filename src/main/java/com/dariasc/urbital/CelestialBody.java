package com.dariasc.urbital;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class CelestialBody implements CelestialParent {

    @Getter
    private Set<CelestialBody> children;

    @Getter
    private String name;
    @Getter
    private float mass;
    @Getter
    private Orbit orbit;

    public Shape body() {
        float rad = Urbital.system.getMassMultiplier() * mass;
        return new Ellipse2D.Float((Urbital.w / 2) - rad, (Urbital.h / 2) - rad, rad*2, rad*2);
    }

    public Shape orbit() {
        return new Ellipse2D.Float((Urbital.w / 2) - orbit.getPeriapsis(), (Urbital.h / 2) - orbit.getSemiMinorAxis(), orbit.getSemiMajorAxis() * 2, orbit.getSemiMinorAxis() * 2);
    }

    public static class Builder {

        private Set<CelestialBody> children = new HashSet<>();

        private String name;
        private float mass;
        private Orbit orbit;

        public Builder(String name, float mass) {
            this.name = name;
            this.mass = mass;
            this.orbit = new Orbit(0, 0);
        }

        public Builder(String name, float mass, Orbit orbit) {
            this.name = name;
            this.mass = mass;
            this.orbit = orbit;

            System.out.println("[" + name + "] " + orbit.getPeriod() + " days");
        }

        public Builder withChild(CelestialBody celestialBody) {
            children.add(celestialBody);
            return this;
        }

        public CelestialBody build() {
            return new CelestialBody(children, name, mass, orbit);
        }

    }

}
