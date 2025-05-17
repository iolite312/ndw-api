package me.iolite.ndw_api.helpers;

import java.util.ArrayList;
import java.util.List;

public class RDconverter {

    public static List<Double> rdtowgs(List<Double> rd) {
        double x = rd.get(0);
        double y = rd.get(1);

        double dX = (x - 155000) * Math.pow(10, -5);
        double dY = (y - 463000) * Math.pow(10, -5);

        double SomN = (3235.65389 * dY) + (-32.58297 * Math.pow(dX, 2)) + (-0.2475 * Math.pow(dY, 2)) +
                (-0.84978 * Math.pow(dX, 2) * dY) + (-0.0655 * Math.pow(dY, 3)) +
                (-0.01709 * Math.pow(dX, 2) * Math.pow(dY, 2)) + (-0.00738 * dX) +
                (0.0053 * Math.pow(dX, 4)) + (-0.00039 * Math.pow(dX, 2) * Math.pow(dY, 3)) +
                (0.00033 * Math.pow(dX, 4) * dY) + (-0.00012 * dX * dY);

        double SomE = (5260.52916 * dX) + (105.94684 * dX * dY) + (2.45656 * dX * Math.pow(dY, 2)) +
                (-0.81885 * Math.pow(dX, 3)) + (0.05594 * dX * Math.pow(dY, 3)) + (-0.05607 * Math.pow(dX, 3) * dY) +
                (0.01199 * dY) + (-0.00256 * Math.pow(dX, 3) * Math.pow(dY, 2)) + (0.00128 * dX * Math.pow(dY, 4)) +
                (0.00022 * Math.pow(dY, 2)) + (-0.00022 * Math.pow(dX, 2)) + (0.00026 * Math.pow(dX, 5));

        double latitude = 52.15517 + 0.000012 + (SomN / 3600);
        double longitude = 5.387206 + (SomE / 3600);
        latitude = Math.round(latitude * 1000000d) / 1000000d;
        longitude = Math.round(longitude * 1000000d) / 1000000d;
        return List.of(latitude, longitude);
    }
}
