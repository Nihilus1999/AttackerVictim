import React from 'react';
import { Alert } from 'react-native';
import { Apiconexion } from '../APIcomunic/APIconex';
import { idUsuario } from '../componentes/Login';
import { EnviarNotifiacion1, EnviarNotifiacion2, EnviarNotifiacion3, EnviarNotifiacion4 } from '../Notificaciones/Alerta';
import { idVictima } from '../componentes/Login';
import { idRelacion } from '../componentes/Login';




export var sep = '';


const CalcSep = async () => {
  try {
    const response = await Apiconexion.get('/cmcapp-backend-1.0/api/operaciones/distancia-separacion/' + idRelacion);
    const responseData = response.data;
    const distanceResponse = responseData.response;
    console.log('distancia: ', distanceResponse);
    sep = distanceResponse;

    if (sep === null || isNaN(sep)) {
      Alert.alert('No existe historico para poder calcular una distancia de separacion');
    } else if (sep <= 10) {
      Alert.alert('Alerta', 'El atacante se encuentra muy cerca de usted', [
        {
          text: 'Ok',
          onPress: async () => {
            console.log('Ok Pressed');

            // Llamar a la función EnviarNotifiacion1 para hacer post de notifiacion en la BD
            await EnviarNotifiacion1();
          },

        },
      ]);
    } else if (sep > 10 && sep <= 30) {
      Alert.alert('Metros que te separan del atacante mas cercano: ', sep.toString(), [
        {
          text: 'Ok',
          onPress: async () => {
            console.log('Ok Pressed');

            // Llamar a la función EnviarNotifiacion3 para hacer post de notifiacion en la BD
            await EnviarNotifiacion2();
          },

        },
      ]);

    } else if (sep > 30 && sep <= 50) {
      Alert.alert('Metros que te separan del atacante mas cercano: ', sep.toString(), [
        {
          text: 'Ok',
          onPress: async () => {
            console.log('Ok Pressed');

            // Llamar a la función EnviarNotifiacion2 para hacer post de notifiacion en la BD
            await EnviarNotifiacion3();
          },

        },
      ]);
    } else if (sep > 50) {
      Alert.alert('Metros que te separan del atacante mas cercano: ', sep.toString(), [
        {
          text: 'Ok',
          onPress: async () => {
            console.log('Ok Pressed');

            // Llamar a la función EnviarNotifiacion4 para hacer post de notifiacion en la BD
            await EnviarNotifiacion4();
          },

        },
      ]);
    }


  } catch (error) {
    console.error('Error en la solicitud GET:', error);
  }
};

export default CalcSep;


