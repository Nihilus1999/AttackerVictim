package com.ucab.cmcapp.logic.dtos.extras;

import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;

import java.awt.geom.Path2D;
import java.util.*;

public class DeterminarAtacanteZonaSeguraDto {


    /**
     * Verifica si un atacante se encuentra dentro de una zona segura.
     *
     * @param AtacanteCoordenadas Coordenadas del último atacante.
     * @param ZonasSeguras Lista de posibles zonas seguras.
     * @param CoordenadasZonas Lista de posibles coordenadas.
     * @return Objeto `AtacanteDentroZonaSeguraDto` con la información del atacante dentro de la zona segura.
     */
    public AtacanteDentroZonaSeguraDto AtacanteDentroZonaSegura(Historico_UsuarioDto AtacanteCoordenadas, List<Zona_SeguraDto> ZonasSeguras, List<CoordenadaDto> CoordenadasZonas) {
        AtacanteDentroZonaSeguraDto resultDto = new AtacanteDentroZonaSeguraDto();
        Double attackerLatitude = AtacanteCoordenadas.get_latitud();
        Double attackerLongitude = AtacanteCoordenadas.get_longitud();
        Map<String, List<Double>> latitudesMap = new HashMap<>();
        Map<String, List<Double>> longitudesMap = new HashMap<>();
        List<String> zoneKeys = new ArrayList<>();

        for (Zona_SeguraDto zona : ZonasSeguras) {
            for (CoordenadaDto coordenada : CoordenadasZonas) {
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

            boolean insideSafeZone = calculoCoordenadasArea(attackerLatitude, attackerLongitude, latitudeArray, longitudeArray);
            if (insideSafeZone) {
                resultDto.set_dentro(true);
                resultDto.get_zonas_seguras().add(zoneName);
                resultDto.set_latitud(attackerLatitude);
                resultDto.set_longitud(attackerLongitude);
            }
        }

        return resultDto;
    }

    /**
     * Calcula si unas coordenadas se encuentran dentro de un área determinada.
     *
     * @param AtacanteLatitud  Latitud de la persona.
     * @param AtacanteLongitud Longitud de la persona.
     * @param AreaLatitud   Latitudes del área.
     * @param AreaLongitud  Longitudes del área.
     * @return `true` si las coordenadas se encuentran dentro del área, `false` en caso contrario.
     */
    public boolean calculoCoordenadasArea(Double AtacanteLatitud, Double AtacanteLongitud, Double[] AreaLatitud, Double[] AreaLongitud) {
        // Crear un objeto Path2D para representar el polígono de la zona
        Path2D.Double zonaPoligono = new Path2D.Double();
        zonaPoligono.moveTo(AreaLongitud[0], AreaLatitud[0]);
        for (int i = 1; i < AreaLatitud.length; i++) {
            zonaPoligono.lineTo(AreaLongitud[i], AreaLatitud[i]);
        }
        zonaPoligono.closePath();

        // Comprobar si la persona se encuentra dentro de la zona determinada
        return zonaPoligono.contains(AtacanteLongitud, AtacanteLatitud);
    }
}