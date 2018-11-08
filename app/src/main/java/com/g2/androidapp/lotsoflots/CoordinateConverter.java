package com.g2.androidapp.lotsoflots;

public class CoordinateConverter {

    CoordinateConverter(){

    }

    static LatLonCoordinate convert(float y_coord, float x_coord) {
        SVY21Coordinate geo = new SVY21Coordinate(y_coord, x_coord);
        LatLonCoordinate answer = SVY21.computeLatLon(geo);
        return answer;
    }
}
