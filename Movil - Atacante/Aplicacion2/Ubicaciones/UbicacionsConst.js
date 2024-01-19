import React, { useEffect } from 'react';
import * as Location from 'expo-location';
import { Alert } from 'react-native';
import { idUsuario } from '../componentes/Login';

export const obtenerUbicacion = async () => {

    try {
      const { status } = await Location.requestForegroundPermissionsAsync();

      if (status !== 'granted') {
        console.log('Permiso de ubicación denegado');
        return;
      }

      const currentLocation = await Location.getCurrentPositionAsync({});
      const { latitude, longitude } = currentLocation.coords;

      const locationInfo = `Latitud: ${latitude}\nLongitud: ${longitude}`;
      console.log('Ubicación actual:', locationInfo);
      Alert.alert('Ubicación actual', locationInfo);
      console.log('id de usuario actual:', idUsuario);

    } catch (error) {
      console.log('Error al obtener la ubicación:', error);
    }
  };

  
  