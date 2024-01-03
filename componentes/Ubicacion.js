import React, {useState,useEffect} from 'react';
import MapView, {Marker} from 'react-native-maps';
import { StyleSheet, View, Button } from 'react-native';
import * as Location from 'expo-location';
import { Apiconexion } from '../APIcomunic/conexionAPI';

export default function Ubicacion() {
  const [mapRegion, setMapRegion] = useState({
    latitude: 37.78825,
    longitude: -122.4324,
    latitudeDelta: 0.0922,
    longitudeDelta: 0.0421,
  });

  const userLocation = async () => {
    let {status} = await Location.requestForegroundPermissionsAsync();
    if (status !== 'granted'){
      setErrorMsg('Permission to accesslocation was denied');
    }
    let location = await Location.getCurrentPositionAsync({enableHighAccuracy: true});
    setMapRegion({
      latitude: location.coords.latitude,
      longitude: location.coords.longitude,
      latitudeDelta: 0.0922,
      longitudeDelta: 0.0421,
    });
    console.log(location.coords.latitude, location.coords.longitude);
  }

  useEffect (() => {
    userLocation();
  }, []);

  return (
    <View style={styles.container}>
      <MapView style={styles.map} 
      region={mapRegion}
      >
        <Marker coordinate={mapRegion} title='Marker' />

      </MapView>
      <Button title='Mostrar Ubicacion' onPress={userLocation}/>
      <Button title='Enviar Ubicacion' onPress={sendUbicacion}/>
    </View>
  );
}

const sendUbicacion = async () => {
 
  try {
    
    const response = await Apiconexion.post('/cmcapp-backend-1.0/api/historico', {
      _fecha: 122343,
      _estadoConexion: false,
      _latitud: 40.1235,
      _longitud: -140.988,
      _usuario: {
        id: 2
      }
    });

    console.log(response.data);
  } catch (error) {
    console.log(error);
  }
};



const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    marginHorizontal: 16,    
    alignItems: 'center',
    marginLeft:20
  },
  map: {
    width: '100%',
    height: '80%',
  },
});             




//este de abajo no es el codigo definitivo

/*const sendUbicacion = async () => {
  const fechaActual = new Date();
 
    const response = await Apiconexion.post ('/cmcapp-backend-1.0/api/historico',{
        _id: 15,
      _estadoConexion: 1,
      _fecha: '2023-12-30 20:00:00',
      _latitud: 37.7833,
      _longitud: -122.4167,
      _id_usuario: 1

    })

    .then(function (response) {
      console.log(response);
    })
    .catch(function (error) {
      console.log(error);
    });  
  
};*/