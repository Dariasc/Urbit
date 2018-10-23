package com.dariasc.urbital;

import lombok.Data;

@Data
public class Orbit {

    private float eccentricity;
    private float semiMajorAxis;
    private float semiMinorAxis;

    private float periapsis;
    private float apoapsis;

    private float period;

    public Orbit(float eccentricity, float semiMajorAxis) {
        this.eccentricity = eccentricity;
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMajorAxis * (float) Math.pow(1 - Math.pow(eccentricity, 2), 0.5);

        this.periapsis = semiMajorAxis * (1 - eccentricity);
        this.apoapsis = semiMajorAxis * (1 + eccentricity);

        this.period = 2 * (float) Math.PI * (float) Math.sqrt(Math.pow(semiMajorAxis, 3) / (Urbital.G * 50));
    }

}
