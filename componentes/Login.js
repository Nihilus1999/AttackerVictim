import React from 'react';
import { useState } from 'react';
import { View, Text, TextInput, Button, StyleSheet} from 'react-native';


const Login = ({navigation}) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = () => {

  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>AttackerVcitim Vict</Text>
      <Text style={styles.title}>Inicie sesión</Text>
      
      <TextInput
        style={styles.input}
        placeholder="Nombre de usuario"
        value={username}
        onChangeText={setUsername}
      />
      <TextInput
        style={styles.input}
        placeholder="Contraseña"
        value={password}
        onChangeText={setPassword}
        secureTextEntry
      />
      <Button 
      title="Iniciar sesión"  
      style={styles.boton}
      onPress={() => navigation.navigate('Menu')}
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