package com.dariasc.urbital;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class CelestialBody implements CelestialParent {

    @Getter @Setter
    private CelestialBody parent;
    @Getter @NonNull
    private Set<CelestialBody> children;

    @Getter @NonNull
    private String name;
    @Getter @NonNull
    private float mass;
    @Getter @NonNull
    private Orbit orbit;

    public void init() {
        if (parent != null) {
            orbit.init();
        }
    }

    public Shape body() {
        float rad = Urbital.system.getMassMultiplier() * mass;
        return new Ellipse2D.Float((Urbital.w / 2) - rad, (Urbital.h / 2) - rad, rad*2, rad*2);
    }

    public Shape orbit() {
        return new Ellipse2D.Float((Urbital.w / 2) - orbit.getPeriapsis(), (Urbital.h / 2) - orbit.getSemiMinorAxis(), orbit.getSemiMajorAxis() * 2, orbit.getSemiMinorAxis() * 2);
    }

    public void injectChildren() {
        // Will inject this parent instance into children instances
        for (CelestialBody child : children) {
            child.parent = this;
            child.injectChildren();
        }
        orbit.setBody(this);
        // Can assure that all children will be initialized before init() is called
        this.init();
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
