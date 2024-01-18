import { View, Text, Alert } from 'react-native'
import React from 'react'
import { idVictima } from '../componentes/Login'
import { Apiconexion } from '../APIcomunic/APIconex'
import MapView, {Polygon} from 'react-native-maps'

export var zonasID ='';
//export var zona = 1;

export var zonaspolygon = [];
export var poligonos = [];
export var transformedZonaspolygon = [];

export const MostrarZonaSegura = () => {

    DetermIDzonaseg();
    console.log('estos son mis arrays de arrays con cada una de las coordenadas de las zonas')
    console.log(zonasID)
    

  
}


const DetermIDzonaseg = async () => {
    try {
        const response = await Apiconexion.get('/cmcapp-backend-1.0/api/zona_segura/victima/'+idVictima);
        const zonasSeguras = response.data.response;
        const idszona = zonasSeguras.map(zona => zona.id);
        zonasID = idszona;

        console.log('Ids de sus zonas de seguridad',zonasID);
        console.log('Id de la victima',idVictima);
        obtenerCoordenadasZonas(zonasID);

      } catch (error) {
        console.error(error);
      }
      /////////////Se buscan todos los puntos que conforman una zona segura
      //obtenerCoordenadasZonas(zonasID);
      //dibujarpoligonos(zonaspolygon);
      
}

export default DetermIDzonaseg;

export const obtenerCoordenadasZonas = async (zonasID) => {

  zonaspolygon = [];

    for (let i = 0; i < zonasID.length; i++) {
        const numzona = zonasID[i];

        try {
            const response = await Apiconexion.get('/cmcapp-backend-1.0/api/coordenadas/zona_segura/'+zonasID[i]);
        
            const coordenadasEncontradas = [];

            console.log('Zona id ',zonasID[i])
        
            for (const zona of response.data.response) {
              const latitud = zona._latitud;
              const longitud = zona._longitud;
              coordenadasEncontradas.push({ latitud, longitud });
             
              poligonos = coordenadasEncontradas;
        
              console.log(`Latitud: ${latitud}, Longitud: ${longitud}`);
            }

            zonaspolygon.push(coordenadasEncontradas);
            

            console.log('//////////////Array con las coordenadas de la zona///////////////////////')
            console.log('ARRAY CON TODAS LAS COORDENADAS DE LA ZONA')
            
        
            Alert.alert('Zonas Descargadas, consultar en  "Zonas Seguras"')
          } catch (error) {
            console.error('Error al obtener las coordenadas:', error);
            return [];
          }
        
      }
      console.log('//////////////Array de todas las coordenadas de todas las zonas///////////////////////');
      console.log(zonaspolygon);

      // Transformar el formato de las coordenadas
   transformedZonaspolygon = zonaspolygon.map((poligono) =>
  poligono.map(({ latitud, longitud }) => ({ latitude: latitud, longitude: longitud }))
);

      return transformedZonaspolygon;
  };

