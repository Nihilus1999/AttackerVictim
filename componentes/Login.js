import React from 'react';
import { useState, useEffect } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert} from 'react-native';
import { Apiconexion } from '../APIcomunic/conexionAPI';


const Login = ({navigation}) => {
  const [nombre, setNombre] = useState('');
  const [clave, setClave] = useState('');

const handleLogin = async (nombre, clave) => {
  try {
    const response = await Apiconexion.get('/cmcapp-backend-1.0/api/atacante/todos');
    const data = response.data.response;
    const usuarioEncontrado = data.find(
      (usuario) => usuario._usuario._nombre === nombre && usuario._usuario._clave === clave
    );


    if (usuarioEncontrado) {
      Alert.alert('Inicio de sesión exitoso');
      navigation.navigate('Menu')
    } else {

      Alert.alert('Inicio de sesión fallido', 'Nombre y/o clave incorrectos');
      
    }
  } catch (error) {
    Alert.alert('Error', 'No se pudo realizar la solicitud');
    
  }
};


  return (
    <View style={styles.container}>
      <Text style={styles.title}>AttackerVcitim Atac</Text>
      <Text style={styles.title}>Inicie sesión</Text>
      
      <TextInput
        style={styles.input}
        placeholder="Nombre de usuario"
        value={nombre}
        onChangeText={setNombre}
      />
      <TextInput
        style={styles.input}
        placeholder="Contraseña"
        value={clave}
        onChangeText={setClave}
        secureTextEntry
      />
      <Button 
      title="Iniciar sesión"  
      style={styles.boton}
      onPress={() => handleLogin(nombre, clave)}
      /*onPress={() => navigation.navigate('Menu')}*/
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#d3d3d3',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 24,
  },

  input: {
    borderWidth: 2,
    padding: 10,
    marginVertical: 8,
    width: '70%',
    borderRadius: 20,
  },
});

export default Login;