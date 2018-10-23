package com.dariasc.urbital;

import lombok.Getter;

import java.util.Set;

public class CelestialSystem implements CelestialParent {

    @Getter
    private CelestialBody parent;

    private CelestialSystem(CelestialBody body) {
        parent = body;
    }

    @Override
    public Set<CelestialBody> getChildren() {
        return parent.getChildren();
    }
}
