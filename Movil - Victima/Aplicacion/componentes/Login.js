import React from 'react';
import { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet, Alert} from 'react-native';
import { Apiconexion } from '../APIcomunic/APIconex';

export var idUsuario = '';
export var idVictima = '';
export var idRelacion = '';
export var alias = '';

////200 se econtro, 401 erro de contraseña , 404 no existe usuario
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

    if (response.status === 200){
    console.log('Mensjae de exito satus 200')
    try {
      const response2 = await Apiconexion.get('/cmcapp-backend-1.0/api/victima/todos');
      const data = response2.data.response;
      const usuarioEncontrado = data.find(
        (usuario) => usuario._usuario._alias === nombre && usuario._usuario._clave === clave
      );
      const response3 = await Apiconexion.get('/cmcapp-backend-1.0/api/relacion/todos');
      const data2 = response3.data.response;
  
      if (usuarioEncontrado) {
        Alert.alert('Inicio de sesión exitoso');
        idUsuario = usuarioEncontrado._usuario.id;
        idVictima = usuarioEncontrado.id;
  
        const casoEncontrado = data2.find(
          (caso) => caso._usuario_victima.id === idVictima
        )
      
        idRelacion = casoEncontrado.id;
  
        navigation.navigate('Menu')
        console.log('id del usuario que ingreso : ',idUsuario)
        console.log('id de la victima', idVictima)
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
      Alert.alert('EL Usuario no exitse')
    } else if (error.response && error.response.status === 401) {
      console.log('Error 401: Clave incorrecta');
      Alert.alert('Clave Incorrecta')
    } else {
      console.log('Error:', error);
    }
    
  }

  /*try {
    const response = await Apiconexion.get('/cmcapp-backend-1.0/api/victima/todos');
    const data = response.data.response;
    const usuarioEncontrado = data.find(
      (usuario) => usuario._usuario._alias === nombre && usuario._usuario._clave === clave
    );
    const response2 = await Apiconexion.get('/cmcapp-backend-1.0/api/relacion/todos');
    const data2 = response2.data.response;

    if (usuarioEncontrado) {
      Alert.alert('Inicio de sesión exitoso');
      idUsuario = usuarioEncontrado._usuario.id;
      idVictima = usuarioEncontrado.id;

      const casoEncontrado = data2.find(
        (caso) => caso._usuario_victima.id === idVictima
      )
    
      idRelacion = casoEncontrado.id;

      navigation.navigate('Menu')
      console.log("id del usuario que ingreso : ",idUsuario)
    } else {

      Alert.alert('Inicio de sesión fallido', 'Nombre y/o clave incorrectos');
      
    }
  } catch (error) {
    Alert.alert('Error', 'No se pudo realizar la solicitud');
    
  }*/
};
     //////////////////// Login sin LDAP ////////////////////////


     const LoginGet = async (nombre,clave) => {

      try {
        const response = await Apiconexion.get('/cmcapp-backend-1.0/api/victima/todos');
        const data = response.data.response;
        const usuarioEncontrado = data.find(
          (usuario) => usuario._usuario._alias === nombre && usuario._usuario._clave === clave
        );
        const response2 = await Apiconexion.get('/cmcapp-backend-1.0/api/relacion/todos');
        const data2 = response2.data.response;
    
        if (usuarioEncontrado) {
          Alert.alert('Inicio de sesión exitoso');
          idUsuario = usuarioEncontrado._usuario.id;
          idVictima = usuarioEncontrado.id;
    
          const casoEncontrado = data2.find(
            (caso) => caso._usuario_victima.id === idVictima
          )
        
          idRelacion = casoEncontrado.id;
    
          navigation.navigate('Menu')
          console.log("id del usuario que ingreso : ",idUsuario)
        } else {
    
          Alert.alert('Inicio de sesión fallido', 'Nombre y/o clave incorrectos');
          
        }
      } catch (error) {
        Alert.alert('Error', 'No se pudo realizar la solicitud');
        
      }


      }

  return (
    <View style={styles.container}>
      <Text style={styles.title}>AttackerVcitim Vict</Text>
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

/*import React, { useState } from 'react';
import { View, TextInput, Button, Alert } from 'react-native';
import axios from 'axios';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async () => {
    try {
      // Obtener los datos del usuario desde la API
      const response = await axios.get('worm-finer-gar.ngrok-free.app/cmcapp-backend-1.0/api/usuario/todos', {
        params: {
          username: username,
        },
      });

      const userData = response.data;

      // Verificar si los datos coinciden
      if (userData && userData.password === password) {
        // Autenticación exitosa
        console.log('Inicio de sesión exitoso');
        // Realizar acciones adicionales (redirección, almacenamiento en estado, etc.)
      } else {
        // Autenticación fallida
        Alert.alert('Error', 'Credenciales inválidas');
      }
    } catch (error) {
      console.error(error);
      Alert.alert('Error', 'Error al intentar iniciar sesión');
    }
  };

  return (
    <View>
      <TextInput
        placeholder="Nombre de usuario"
        value={username}
        onChangeText={text => setUsername(text)}
      />
      <TextInput
        placeholder="Contraseña"
        secureTextEntry
        value={password}
        onChangeText={text => setPassword(text)}
      />
      <Button title="Iniciar sesión" onPress={handleLogin} />
    </View>
  );
};

export default Login;*/

