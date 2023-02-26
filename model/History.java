package model;

import java.util.ArrayList;

public class History {
    public ArrayList<Double> axlelist = new ArrayList<>();
    public void addAxle(double axle){
        axlelist.add(axle);
        if(axlelist.size()>1920) axlelist.remove(0);
    }

}
