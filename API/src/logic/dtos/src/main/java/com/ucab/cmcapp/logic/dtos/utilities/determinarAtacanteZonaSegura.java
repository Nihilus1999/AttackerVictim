package com.ucab.cmcapp.logic.dtos.utilities;

import com.ucab.cmcapp.logic.dtos.dtos.Atacante_Dentro_Zona_SeguraDto;
import com.ucab.cmcapp.logic.dtos.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.dtos.Historico_UsuarioDto;
import com.ucab.cmcapp.logic.dtos.dtos.Zona_SeguraDto;

import java.awt.geom.Path2D;
import java.util.*;

/*
public class determinarAtacanteZonaSegura {

    public Atacante_Dentro_Zona_SeguraDto verifyAttackerInSafeZone(Historico_UsuarioDto lastAttackerCoordinate, List<Zona_SeguraDto> posibleZones,List<CoordenadaDto> posiblesCoordenadas) {
        Atacante_Dentro_Zona_SeguraDto resultDto = new Atacante_Dentro_Zona_SeguraDto();
        Double attackerLatitude = lastAttackerCoordinate.get_latitud();
        Double attackerLongitude = lastAttackerCoordinate.get_longitud();
        Map<String, List<Double>> latitudesMap = new HashMap<>();
        Map<String, List<Double>> longitudesMap = new HashMap<>();
        List<Double> latitudes;
        List<Double> longitudes;
        List<String> zoneKeys = new ArrayList<>();

        for(Zona_SeguraDto zona : posibleZones){
            for(CoordenadaDto coordenada : posiblesCoordenadas){
                if(zona.getId() == coordenada.get_zona_segura().getId()){
                    if (!latitudesMap.containsKey(zona.get_nombre())) { // no se verifica longitudeMap por que ya empieza vacio tambien
                        latitudes = new ArrayList<>();
                        longitudes = new ArrayList<>();
                        latitudesMap.put(zona.get_nombre(), latitudes);
                        longitudesMap.put(zona.get_nombre(), longitudes);
                        zoneKeys.add(zona.get_nombre());
                    }
                    latitudesMap.get(zona.get_nombre()).add(coordenada.get_latitud());
                    longitudesMap.get(zona.get_nombre()).add(coordenada.get_longitud());
                }
            }
        }

        boolean insideSafeZone;
        Double[] latitudeArray;
        Double[] longitudeArray;
        List<Double> auxLatList;
        List<Double> auxLonList;

        resultDto.set_dentro(false); // Establecer en false por defecto

        for (String zoneName : zoneKeys) {
            auxLatList = latitudesMap.get(zoneName);
            auxLonList = longitudesMap.get(zoneName);
            latitudeArray = new Double[auxLatList.size()];
            longitudeArray = new Double[auxLonList.size()];

            for (int i = 0; i < auxLatList.size(); i++) {
                latitudeArray[i] = auxLatList.get(i);
            }

            for (int i = 0; i < auxLonList.size(); i++) {
                longitudeArray[i] = auxLonList.get(i);
            }

            insideSafeZone = calculateCoordinatesInArea(attackerLatitude, attackerLongitude, latitudeArray, longitudeArray);
            if (insideSafeZone) {
                resultDto.set_dentro(insideSafeZone);
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


 */

public class determinarAtacanteZonaSegura {

    public Atacante_Dentro_Zona_SeguraDto verifyAttackerInSafeZone(Historico_UsuarioDto lastAttackerCoordinate, List<Zona_SeguraDto> posibleZones, List<CoordenadaDto> posiblesCoordenadas) {
        Atacante_Dentro_Zona_SeguraDto resultDto = new Atacante_Dentro_Zona_SeguraDto();
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