import { View, Text,Alert } from 'react-native'
import React from 'react'
import { Apiconexion } from '../APIcomunic/APIconex';
import { idUsuario } from '../componentes/Login';

export async function EnviarNotifiacion1() {
    try {
      const response = await Apiconexion.post(
        '/cmcapp-backend-1.0/api/notificacion',
        {
          _tipo: 'Alerta 1',
          _fecha: new Date(),
          _descripcion: 'Alerta de cercania nivel ALTO enviada',
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
  
      Alert.alert(
        'Alerta de Tipo 1 Enviada',
        'Alerta de cercania nivel ALTO ha sido enviada',
        [
          {
            text: 'Aceptar',
            onPress: () => console.log('Aceptar Pressed'),
          },
        ],
        { cancelable: false }
      );
      
    } catch (error) {
      console.log(error);
    }
  }

  export async function EnviarNotifiacion2() {
    try {
      const response = await Apiconexion.post(
        '/cmcapp-backend-1.0/api/notificacion',
        {
          _tipo: 'Alerta 2',
          _fecha: new Date(),
          _descripcion: 'Alerta de cercania nivel MEDIO enviada',
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
  
      Alert.alert(
        'Alerta de Tipo 2 Enviada',
        'Alerta de nivel MEDIO ha sido enviada',
        [
          {
            text: 'Aceptar',
            onPress: () => console.log('Aceptar Pressed'),
          },
        ],
        { cancelable: false }
      );
      
    } catch (error) {
      console.log(error);
    }
  }

  export async function EnviarNotifiacion3() {
    try {
      const response = await Apiconexion.post(
        '/cmcapp-backend-1.0/api/notificacion',
        {
          _tipo: 'Alerta 3',
          _fecha: new Date(),
          _descripcion: 'Alerta de cercania nivel MODERADO enviada',
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
  
      Alert.alert(
        'Alerta de Tipo 3 Enviada',
        'Alerta de nivel MODERADO ha sido enviada',
        [
          {
            text: 'Aceptar',
            onPress: () => console.log('Aceptar Pressed'),
          },
        ],
        { cancelable: false }
      );
      
    } catch (error) {
      console.log(error);
    }
  }

  export async function EnviarNotifiacion4() {
    try {
      const response = await Apiconexion.post(
        '/cmcapp-backend-1.0/api/notificacion',
        {
          _tipo: 'Alerta 4',
          _fecha: new Date(),
          _descripcion: 'Alerta de cercania nivel BAJO enviada',
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
  
      Alert.alert(
        'Alerta de Tipo 4 Enviada',
        'Alerta de nivel BAJO ha sido enviada',
        [
          {
            text: 'Aceptar',
            onPress: () => console.log('Aceptar Pressed'),
          },
        ],
        { cancelable: false }
      );
      
    } catch (error) {
      console.log(error);
    }
  }

  export async function EnviarSOS() {
    try {
      const response = await Apiconexion.post(
        '/cmcapp-backend-1.0/api/notificacion',
        {
          _tipo: 'Alerta SOS',
          _fecha: new Date(),
          _descripcion: 'Alerta SOS enviada',
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
  
      Alert.alert(
        'Alerta de Tipo SOS',
        'Alerta nivel de EMERGENCIA ha sido enviada',
        [
          {
            text: 'Aceptar',
            onPress: () => console.log('Aceptar Pressed'),
          },
        ],
        { cancelable: false }
      );
      
    } catch (error) {
      console.log(error);
    }
  }
  export async function EnviarZona() {
    try {
      const response = await Apiconexion.post(
        '/cmcapp-backend-1.0/api/notificacion',
        {
          _tipo: 'Alerta ZONA',
          _fecha: new Date(),
          _descripcion: 'Alerta de Zona Enviada',
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
  
      Alert.alert(
        'Alerta ZONA',
        'Alerta nivel de ZONA ha sido enviada',
        [
          {
            text: 'Aceptar',
            onPress: () => console.log('Aceptar Pressed'),
          },
        ],
        { cancelable: false }
      );
      
    } catch (error) {
      console.log(error);
    }
  }

  
  