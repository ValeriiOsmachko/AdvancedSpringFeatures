package com.ua.osmachko.profilingcontroller;

/**
 * Created by Valerii_Osmachko on 4/24/2017.
 */
public class ProfilingController implements ProfilingControllerMBean{

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
