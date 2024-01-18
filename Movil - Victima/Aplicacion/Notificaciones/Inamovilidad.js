/*import { Alert } from 'react-native';

export const TiempoControl = () => {
  Alert.alert('Tiempo de Control', 'Tiempo');

  setTimeout(() => {
    Alert.alert('Tiempo de Control Finalizado', 'Alerta Enviada');
  }, 5000);
};*/


import React, { useEffect, useState } from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { EnviarSOS } from './Alerta';
import { idRelacion } from '../componentes/Login';
import { Apiconexion } from '../APIcomunic/APIconex';

export var conteo = '';

const CountdownAlert = () => {
  const [showAlert, setShowAlert] = useState(false);
  const [countdown, setCountdown] = useState(conteo);
  let countdownInterval;

  useEffect(() => {
    getTime(); // Llamar a getTime solo una vez al montar el componente
  }, []);

  useEffect(() => {
    if (showAlert) {
      countdownInterval = setInterval(() => {
        setCountdown((prevCountdown) => prevCountdown - 1);
      }, 1000);
    } else {
      clearInterval(countdownInterval);
    }

    return () => {
      clearInterval(countdownInterval);
    };
  }, [showAlert]);

  useEffect(() => {
    if (countdown === 0) {
      clearInterval(countdownInterval);
      setShowAlert(false);
      setCountdown(conteo);
      EnviarSOS();
      console.log('Tiempo Finalizado');
      console.log(conteo);
    }
  }, [countdown]);

  const handleStartCountdown = () => {
    setShowAlert(true);
  };

  const handleCancelCountdown = () => {
    setShowAlert(false);
    setCountdown(conteo);
  };

  const getTime = async () => {
    try {
      const response = await Apiconexion.get('/cmcapp-backend-1.0/api/relacion/' + idRelacion);
      const data = response.data.response;
      const tiempoEncontrado = data._tiempo;

      if (tiempoEncontrado) {
        console.log('El tiempo del usuario es', tiempoEncontrado);
        // Guardar el valor de tiempoEncontrado en el estado si es necesario
        conteo = tiempoEncontrado;
        setCountdown(tiempoEncontrado);
      }
    } catch (error) {
      // Manejar el error si ocurre
    }
    console.log('Tiempo');
  };

  return (
    <View style={styles.container}>
      {!showAlert && (
        <TouchableOpacity onPress={handleStartCountdown} style={styles.button}>
          <Text style={styles.buttonText}>Iniciar Conteo Regresivo</Text>
        </TouchableOpacity>
      )}

      {showAlert && (
        <View style={styles.alertContainer}>
          <Text style={styles.text}>Tiempo Restante para enviar Alerta:</Text>
          <Text style={styles.countdown}>{countdown}</Text>
          <TouchableOpacity onPress={handleCancelCountdown} style={styles.button}>
            <Text style={styles.buttonText}>Cancelar</Text>
          </TouchableOpacity>
        </View>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 16,
  },
  alertContainer: {
    backgroundColor: '#f5f5f5',
    padding: 10,
    marginTop: 10,
    alignItems: 'center', // Centrar elementos horizontalmente
  },
  text: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 8,
  },
  countdown: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 8,
    textAlign: 'center', // Centrar texto horizontalmente
  },
  button: {
    backgroundColor: '#808080',
    padding: 10,
    borderRadius: 5,
    marginTop: 10,
  },
  buttonText: {
    color: 'white',
    fontSize: 16,
    fontWeight: 'bold',
    textAlign: 'center',
  },
});

export default CountdownAlert;

const getTime = async () => {
  try {
    const response = await Apiconexion.get('/cmcapp-backend-1.0/api/relacion/' + idRelacion);
    const data = response.data.response;
    const tiempoEncontrado = data._tiempo;
    
    if (tiempoEncontrado) {
      console.log('El tiempo del usuario es', tiempoEncontrado);
      // Guardar el valor de tiempoEncontrado en el estado si es necesario
      conteo = tiempoEncontrado;
    }
  } catch (error) {
    // Manejar el error si ocurre
  }
  console.log('Tiempo');
};