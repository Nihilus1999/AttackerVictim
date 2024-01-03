import { View, Text } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import Login from '../componentes/Login';
import Menu from '../componentes/Menu';
import Ubicacion from '../componentes/Ubicacion';


const Stack = createNativeStackNavigator();

const MainStack = () => {
  return (
    <NavigationContainer>
        <Stack.Navigator>
            <Stack.Screen
            name='Inicio'
            component={Login}
            />
             <Stack.Screen
            name='Menu'
            component={Menu}
            />

            <Stack.Screen
            name='Mapa'
            component={Ubicacion}
            />

            
            
        </Stack.Navigator>

    </NavigationContainer>
  )
}

export default MainStack;