
import { View, Text, TouchableOpacity, StyleSheet} from 'react-native'
import React from 'react'
import { EnviarSOS } from '../Notificaciones/Alerta';
import DetermIDzonaseg, { MostrarZonaSegura } from '../Ubicaciones/ZonaSegura';
import { TiempoControl, handleButtonPress } from '../Notificaciones/Inamovilidad';


const Menu = ({navigation}) => {
  return (
    <View style={styles.container}>

      <Text style={styles.title}>
        Menú de Opciones
      </Text>
        <TouchableOpacity style={styles.button} onPress={async () => {await MostrarZonaSegura();}}> 
           
            
            <Text style={styles.texto}>Descargar Zonas Seguras</Text>

        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Menu de Ubicaciones')}>
           
            
            <Text style={styles.texto}>Verificar Lugar de Atacante</Text>

        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={async () => {await EnviarSOS();}} >
           
            
            <Text style={styles.texto}>Enviar SOS</Text>

        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Mapa')}>
           
            
            <Text style={styles.texto}>Ubicación</Text>
            

        </TouchableOpacity>

        <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Rastreo')}>
           
            
            <Text style={styles.texto}>Iniciar Rastreo</Text>
            

        </TouchableOpacity>

        <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('ZonasSeguras')}>
           
            
            <Text style={styles.texto}>Zonas Seguras</Text>
            

        </TouchableOpacity>

        <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('TiempoControl')} >
           
            
            <Text style={styles.texto}>Tiempo de Control</Text>
            

        </TouchableOpacity>

        
    </View>
    
  )
}


const styles = StyleSheet.create({
    button: {
        alignSelf: 'center',
        paddingVertical: 15,
        width: '70%',
        borderRadius: 30,
        backgroundColor: 'black',
        color:'white', 
        marginVertical: 15
    },

    container: {
        flex: 1,
        justifyContent: 'center',
        marginHorizontal: 16,
        backgroundColor: '#d3d3d3',
        alignItems: 'center',
        marginLeft:20,
        marginBottom: 45 //////////fue el ultima estilo que agregue a al container para que todos los botones quedasen mas o menos dentro
      
      },

      texto: {
        color:'#FFE4E1',
        textAlign:'center',
        fontSize: 24,
        alignContent: 'center',
      
      },

      title: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 24,
      }
})

export default Menu;