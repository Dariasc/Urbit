package com.dariasc.urbital;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class CelestialBody implements CelestialParent {

    @Getter
    private Set<CelestialBody> children;

    @Getter
    private float mass;
    @Getter
    private float eccentricity;
    @Getter
    private float semiMajorAxis;

    public static class Builder {

        private Set<CelestialBody> children = new HashSet<>();

        private float eccentricity;
        private float semiMajorAxis;
        private float mass;

        public Builder(float mass, float eccentricity, float semiMajorAxis) {
            this.mass = mass;
            this.eccentricity = eccentricity;
            this.semiMajorAxis = semiMajorAxis;
        }

        public Builder withChild(CelestialBody celestialBody) {
            children.add(celestialBody);
            return this;
        }

        public CelestialBody build() {
            return new CelestialBody(children, mass, eccentricity, semiMajorAxis);
        }

    }


}
