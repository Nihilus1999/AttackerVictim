import { View, Text, Button } from 'react-native'
import React, {useState} from 'react'
import MainStack from './navigation/MainStack';


var fecha = new Date();
export var fechamili = Date.parse(fecha);
export var idUsuario = '';


const App = () => {

  console.log(fechamili)
  return (
    
    <MainStack/>
   
  )
}

export default App;