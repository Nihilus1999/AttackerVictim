import { View, Text, Button, Alert } from 'react-native';
import React, { useEffect } from 'react';
import MainStack from './navigation/MainStack';
import { idUsuario } from './componentes/Login';
import { obtenerUbicacion } from './Ubicaciones/UbicacionsConst';



const App = () => {
  /*useEffect(() => {
      obtenerUbicacion(); // Se ejecuta inmediatamente
      const interval = setInterval(() => {
        obtenerUbicacion();
      }, 5000);

      return () => {
        clearInterval(interval);
      };
    
  }, []);*/

  

  

  return <MainStack />;
};

export default App;