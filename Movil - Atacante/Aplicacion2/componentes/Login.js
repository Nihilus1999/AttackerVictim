import React from 'react';
import { useState, useEffect } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert} from 'react-native';
import { Apiconexion } from '../APIcomunic/conexionAPI';

export var idUsuario = '';
export var idAtacante = '';
export var alias = '';

const Login = ({navigation}) => {
  const [nombre, setNombre] = useState('');
  const [clave, setClave] = useState('');

  

const handleLogin = async (nombre, clave) => {

  try {
    const response = await Apiconexion.post( 
      '/cmcapp-backend-1.0/api/login/usuario',
      {
        _alias: nombre,
        _clave: clave,
      },
      {
        headers: {
          'Content-Type': 'application/json', 
        },
      }  
    );

    console.log(response.data);
    Alert.alert('Usuario Encontrado');
    alias = nombre;

    if (response.status === 200){
    console.log('Mensjae de exito satus 200')
    try {
      const response2 = await Apiconexion.get('/cmcapp-backend-1.0/api/usuario/alias/'+alias);
      const data = response2.data.response;
      /*const usuarioEncontrado = data.find(
        (usuario) => usuario._alias === nombre && usuario._clave === clave
      );*/
  
      if (data) {
        Alert.alert('Inicio de sesión exitoso');
        idUsuario = data.id;
  
  
        navigation.navigate('Menu')
        console.log("id del usuario que ingreso : ",idUsuario)
      } else {
  
        Alert.alert('Inicio de sesión fallido', 'Nombre y/o clave incorrectos');
        
      }
    } catch (error) {
      Alert.alert('Error', 'No se pudo realizar la solicitud');
      
    }
    
    }
    
  } catch (error) {
    if (error.response && error.response.status === 404) {
      console.log('Error 404: No existe usuario');
      Alert.alert('EL Usuario no exitse Error 404')
    } else if (error.response && error.response.status === 401) {
      console.log('Error 401: Clave incorrecta');
      Alert.alert('Clave Incorrecta Error 401')
    } else {
      console.log('Error:', error);
    }
    
  }

  
  ///////////////Login sin LDAP////////////////
  /*try {
    const response = await Apiconexion.get('/cmcapp-backend-1.0/api/atacante/todos');
    const data = response.data.response;
    const usuarioEncontrado = data.find(
      (usuario) => usuario._usuario._alias === nombre && usuario._usuario._clave === clave
    );


    if (usuarioEncontrado) {
      Alert.alert('Inicio de sesión exitoso');
      idUsuario = usuarioEncontrado._usuario.id;
      idAtacante = usuarioEncontrado.id;

      navigation.navigate('Menu')
      console.log("id del usuario que ingreso : ",idUsuario)
      console.log("id del atacante que ingreso : ",idAtacante)
    } else {

      Alert.alert('Inicio de sesión fallido', 'Nombre y/o clave incorrectos');
      
    }
  } catch (error) {
    Alert.alert('Error', 'No se pudo realizar la solicitud');
    
  }*/
  /////////////////LOGIN SIN LDAP/////////////////////////
};

/////////Login sin LDAP haciendo get///////////
const LoeginGET = async (nombre, clave)  => {           
  try {
    const response = await Apiconexion.get('/cmcapp-backend-1.0/api/atacante/todos');
    const data = response.data.response;
    const usuarioEncontrado = data.find(
      (usuario) => usuario._usuario._alias === nombre && usuario._usuario._clave === clave
    );


    if (usuarioEncontrado) {
      Alert.alert('Inicio de sesión exitoso');
      idUsuario = usuarioEncontrado._usuario.id;
      idAtacante = usuarioEncontrado.id;

      navigation.navigate('Menu')
      console.log("id del usuario que ingreso : ",idUsuario)
      console.log("id del atacante que ingreso : ",idAtacante)
    } else {

      Alert.alert('Inicio de sesión fallido', 'Nombre y/o clave incorrectos');
      
    }
  } catch (error) {
    console.log(error)
    Alert.alert('Error', 'No se pudo realizar la solicitud');
    
  }
  
}


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
      onPress={() => handleLogin(nombre,clave)}
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




 

