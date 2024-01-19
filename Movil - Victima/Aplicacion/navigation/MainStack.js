import { View, Text } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import Login from '../componentes/Login';
import Menu from '../componentes/Menu';
import Ubicacion from '../componentes/Ubicacion';
import MenuUbi from '../componentes/Menu_Ubicacion';
import CalcDistSep from '../Ubicaciones/CalcDistSep';
import MapWithPolygon from '../Ubicaciones/poligono';
import Seguimiento from '../Ubicaciones/Seguimiento';
import CountdownAlert from '../Notificaciones/Inamovilidad';


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

            <Stack.Screen
            name='Menu de Ubicaciones'
            component={MenuUbi}
            />

            <Stack.Screen
            name='Distancia'
            component={CalcDistSep}
            />

            <Stack.Screen
            name='ZonasSeguras'
            component={MapWithPolygon}
            />

            <Stack.Screen
            name='Rastreo'
            component={Seguimiento}
            />

            <Stack.Screen
            name='TiempoControl'
            component={CountdownAlert}
            />

            
            
        </Stack.Navigator>

    </NavigationContainer>
  )
}

export default MainStack;