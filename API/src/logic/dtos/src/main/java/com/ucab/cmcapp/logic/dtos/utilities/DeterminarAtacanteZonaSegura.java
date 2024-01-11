package com.ucab.cmcapp.logic.dtos.utilities;

import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;

import java.awt.geom.Path2D;
import java.util.*;

public class DeterminarAtacanteZonaSegura {

    public AtacanteDentroZonaSeguraDto verifyAttackerInSafeZone(Historico_UsuarioDto lastAttackerCoordinate, List<Zona_SeguraDto> posibleZones, List<CoordenadaDto> posiblesCoordenadas) {
        AtacanteDentroZonaSeguraDto resultDto = new AtacanteDentroZonaSeguraDto();
        Double attackerLatitude = lastAttackerCoordinate.get_latitud();
        Double attackerLongitude = lastAttackerCoordinate.get_longitud();
        Map<String, List<Double>> latitudesMap = new HashMap<>();
        Map<String, List<Double>> longitudesMap = new HashMap<>();
        List<String> zoneKeys = new ArrayList<>();

        for (Zona_SeguraDto zona : posibleZones) {
            for (CoordenadaDto coordenada : posiblesCoordenadas) {
                if (zona.getId() == coordenada.get_zona_segura().getId()) {
                    String zoneName = zona.get_nombre();
                    latitudesMap.computeIfAbsent(zoneName, k -> new ArrayList<>()).add(coordenada.get_latitud());
                    longitudesMap.computeIfAbsent(zoneName, k -> new ArrayList<>()).add(coordenada.get_longitud());
                    if (!zoneKeys.contains(zoneName)) {
                        zoneKeys.add(zoneName);
                    }
                }
            }
        }

        resultDto.set_dentro(false); // Establecer en false por defecto

        for (String zoneName : zoneKeys) {
            List<Double> latitudeList = latitudesMap.get(zoneName);
            List<Double> longitudeList = longitudesMap.get(zoneName);
            Double[] latitudeArray = latitudeList.toArray(new Double[0]);
            Double[] longitudeArray = longitudeList.toArray(new Double[0]);

            boolean insideSafeZone = calculateCoordinatesInArea(attackerLatitude, attackerLongitude, latitudeArray, longitudeArray);
            if (insideSafeZone) {
                resultDto.set_dentro(true);
                resultDto.get_zonas_seguras().add(zoneName);
                resultDto.set_latitud(attackerLatitude);
                resultDto.set_longitud(attackerLongitude);
            }
        }

        return resultDto;
    }

    public boolean calculateCoordinatesInArea(Double personLatitude, Double personLongitude, Double[] areaLatitudes, Double[] areaLongitudes) {
        // Crear un objeto Path2D para representar el polígono de la zona
        Path2D.Double zonaPoligono = new Path2D.Double();
        zonaPoligono.moveTo(areaLongitudes[0], areaLatitudes[0]);
        for (int i = 1; i < areaLatitudes.length; i++) {
            zonaPoligono.lineTo(areaLongitudes[i], areaLatitudes[i]);
        }
        zonaPoligono.closePath();

        // Comprobar si la persona se encuentra dentro de la zona determinada
        return zonaPoligono.contains(personLongitude, personLatitude);
    }
}