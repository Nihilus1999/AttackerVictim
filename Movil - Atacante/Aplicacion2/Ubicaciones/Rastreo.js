import { View, Text, StyleSheet } from 'react-native'
import React,{useEffect} from 'react'
import { obtenerUbicacion } from './UbicacionsConst';
import { sendUbicacion } from '../componentes/Ubicacion';


const Rastreo = () => {

    useEffect(() => {
        obtenerUbicacion(); // Se ejecuta inmediatamente
        const interval = setInterval(() => {
          obtenerUbicacion();
          sendUbicacion();
        }, 5000);

        
  
        return () => {
          clearInterval(interval);
        };
      
    }, []);

  return (
    <View style={styles.container}>
      <View style={styles.box}>
        <Text style={styles.title}>Enviando tu ubicacion...</Text>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#eaeaea', // Fondo gris
    justifyContent: 'flex-end', // Centrado vertical en la parte inferior
    alignItems: 'center',
    paddingBottom: 200, // Espacio inferior para dejar margen
  },
  box: {
    backgroundColor: 'black', // Recuadro negro
    padding: 20,
    borderRadius: 10,
  },
  title: {
    fontSize: 24,
    color: 'white',
    textAlign: 'center',
  },
});

export default Rastreo;