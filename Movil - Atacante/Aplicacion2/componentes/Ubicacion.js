import React, {useState,useEffect} from 'react';
import MapView, {Marker} from 'react-native-maps';
import { StyleSheet, View, Text, TouchableOpacity, Alert } from 'react-native';
import * as Location from 'expo-location';
import { Apiconexion } from '../APIcomunic/conexionAPI';
import { idUsuario } from './Login';

export var longi = ''; //variable para almacenar la longitud del usuario
export var lati = ''; // variable para almacenar la latitud del usuario

export default function Ubicacion({navigation}) {
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
    longi = location.coords.longitude; //se almacena la longitud en la variable global longi que se creo
    lati = location.coords.latitude;   //se almacena la latitud en la variable global lati que se creo
    setMapRegion({
      latitude: location.coords.latitude,
      longitude: location.coords.longitude,
      latitudeDelta: 0.0922,
      longitudeDelta: 0.0421,
    });
    console.log(location.coords.latitude, location.coords.longitude);

    Alert.alert(
      'Coordenadas actuales',
      `Latitud: ${location.coords.latitude}\nLongitud: ${location.coords.longitude}`,
    );
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
       <TouchableOpacity style={styles.boton} title='Mostrar Ubicacion' onPress={userLocation} >

       <Text style={styles.texto}>Mostrar Ubicacion</Text>

       </TouchableOpacity>
       <TouchableOpacity style={styles.boton} title='Enviar Ubicacion' onPress={sendUbicacion} >

       <Text style={styles.texto}>Enviar mi ubicacion</Text>

       </TouchableOpacity>
    </View>
  );
}

export const sendUbicacion = async () => {

  try {
    const response = await Apiconexion.post(
      '/cmcapp-backend-1.0/api/historico',
      {
        _fecha: new Date(),
        _estadoConexion: true,
        _latitud: lati,
        _longitud: longi,
        _usuario: {
          id: idUsuario,
        },
      },
      {
        headers: {
          'Content-Type': 'application/json', 
        },
      }
    );

    console.log(response.data);

    Alert.alert('Informacion enviada con exito');
    
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

  boton: {
    alignSelf: 'center',
    paddingVertical: 15,
    width: '70%',
    borderRadius: 30,
    backgroundColor: 'black',
    color:'white', 
    marginVertical: 15
},

texto: {
  color:'#FFE4E1',
  textAlign:'center',
  fontSize: 24,
  alignContent: 'center',

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