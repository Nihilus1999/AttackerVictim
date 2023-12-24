/*import { View, Text } from 'react-native'
import React from 'react'

const Ubicacion = () => {
  return (
    <View>
      <Text>aqui se mostrara la ubicacion en tiempo real en google maps</Text>
    </View>
  )
}

export default Ubicacion;*/


import React, {useState,useEffect} from 'react';
import MapView, {Marker} from 'react-native-maps';
import { StyleSheet, View, Button } from 'react-native';
import * as Location from 'expo-location';

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
    </View>
  );
}

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

