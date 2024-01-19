import { View, Text, Alert } from 'react-native'
import React from 'react'
import { Apiconexion } from '../APIcomunic/APIconex';
import { idRelacion } from '../componentes/Login';
import { EnviarZona } from '../Notificaciones/Alerta';

export var dentro = '';

const DetAtaSeg = async () => {
  try {
    const response = await Apiconexion.get('/cmcapp-backend-1.0/api/operaciones/atacante_dentro_Zona_Segura/' + idRelacion);
    const responseData = response.data;
    
    if (responseData && responseData.response && responseData.response._dentro !== null) {
      const dentroResponse = responseData.response._dentro;
      console.log(dentroResponse);
      dentro = dentroResponse;
      zona = responseData.response._zonas_seguras;

      console.log('dentro: ', dentro);

      if (dentro === false) {
        Alert.alert('Zona asegurada', 'No hay atacantes dentro', [
          {
            text: 'Ok',
            onPress: () => console.log('Ok Pressed'),
          },
        ]);
      } else {
        Alert.alert('La zona no está segura', `La zona es: ${zona}`, [
          {
            text: 'Ok',
            onPress: () => console.log('Ok Pressed'),
          },
        ]);
        await EnviarZona();
      }
    } else {
      console.log('La respuesta del servidor es nula o no contiene la propiedad _dentro');
      Alert.alert('La Victima puede que no tenga zona segura definida ni el atacante un histroico de ubicacion');
    }
  } catch (error) {
    console.error('Error en la solicitud GET:', error);
  }
};

export default DetAtaSeg;