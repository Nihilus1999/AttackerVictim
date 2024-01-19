import React, { useEffect, useState } from 'react';
import { View, PermissionsAndroid } from 'react-native';
import MapView, { Polygon, Marker } from 'react-native-maps';
import * as Location from 'expo-location';
import { poligonos, transformedZonaspolygon, zonaspolygon } from './ZonaSegura';

//const zonasID = transformedZonaspolygon;
  



const MapWithPolygon = () => {
  const [currentLocation, setCurrentLocation] = useState(null);

  useEffect(() => {
    // Solicitar permiso para acceder a la ubicación del dispositivo
    const requestLocationPermission = async () => {
      try {
        const { status } = await Location.requestForegroundPermissionsAsync();
        if (status === 'granted') {
          // Obtener la ubicación actual del dispositivo
          const location = await Location.getCurrentPositionAsync({ accuracy: Location.Accuracy.High });
          const { latitude, longitude } = location.coords;
          setCurrentLocation({ latitude, longitude });
        } else {
          console.log('Permiso de ubicación denegado');
        }
      } catch (error) {
        console.error('Error al obtener la ubicación: ', error);
      }
    };

    requestLocationPermission();
  }, []);

  // Centrar el mapa en la ubicación actual
  const centerMapOnLocation = () => {
    if (currentLocation) {
      const { latitude, longitude } = currentLocation;
      mapRef.current.animateToRegion({
        latitude,
        longitude,
        latitudeDelta: 0.01,
        longitudeDelta: 0.01,
      });
    }
  };

  const mapRef = React.createRef();

  useEffect(() => {
    centerMapOnLocation();
  }, [currentLocation]);
//console.log(zonasID)
  return (
    <View style={{ flex: 1 }}>
      <MapView
        ref={mapRef}
        style={{ flex: 1 }}
        showsUserLocation={true}
        followsUserLocation={true}
      >
        {transformedZonaspolygon.map((coordenadasPoligono, index) => (
          <Polygon
            key={index}
            coordinates={coordenadasPoligono}
            fillColor="rgba(0, 255, 0, 0.5)"
            strokeColor="rgba(0, 0, 255, 0.5)"
          />
        ))}
        {currentLocation && (
          <Marker coordinate={currentLocation} title="Mi Ubicación" pinColor="blue" />
        )}
      </MapView>
    </View>
  );
};

export default MapWithPolygon;






/* este codigo de abajo genera un poligono en caracas con esas coordenadas

import React, {useEffect} from 'react';
import { View } from 'react-native';
import MapView, { Polygon } from 'react-native-maps';

const MapWithPolygon = ({navigation}) => {
    const coordenadasPoligono = [
        { latitude: 10.488011, longitude: -66.879193 },
        { latitude: 10.500252, longitude: -66.894059 },
        { latitude: 10.492720, longitude: -66.902305 },
        { latitude: 10.484269, longitude: -66.891306 },
      ];
      

  return (
    <View style={{ flex: 1 }}>
      <MapView style={{ flex: 1 }}>
        <Polygon
          coordinates={coordenadasPoligono}
          fillColor="rgba(0, 255, 0, 0.5)"
          strokeColor="rgba(0, 0, 255, 0.5)"
        />
      </MapView>
    </View>
  );
};

export default MapWithPolygon;  */



 