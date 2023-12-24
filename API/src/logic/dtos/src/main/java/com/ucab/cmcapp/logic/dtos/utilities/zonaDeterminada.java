package com.ucab.cmcapp.logic.dtos.utilities;

import java.awt.geom.Path2D;

public class zonaDeterminada {
    public static void main(String[] args) {
        // Coordenadas de la zona determinada
        double[] zonaLatitudes = {37.7749, 37.7754, 37.7752};
        double[] zonaLongitudes = {-122.4194, -122.4192, -122.4198};

        // Coordenadas de la persona
        double personaLatitud = 37.774788;
        double personaLongitud = -122.419408;

        // Crear un objeto Path2D para representar el polígono de la zona
        Path2D.Double zonaPoligono = new Path2D.Double();
        zonaPoligono.moveTo(zonaLongitudes[0], zonaLatitudes[0]);
        for (int i = 1; i < zonaLatitudes.length; i++) {
            zonaPoligono.lineTo(zonaLongitudes[i], zonaLatitudes[i]);
        }
        zonaPoligono.closePath();

        // Comprobar si la persona se encuentra dentro de la zona determinada
        boolean estaEnZona = zonaPoligono.contains(personaLongitud, personaLatitud);

        if (estaEnZona) {
            System.out.println("La persona se encuentra en la zona determinada.");
        } else {
            System.out.println("La persona NO se encuentra en la zona determinada.");
        }
    }
}