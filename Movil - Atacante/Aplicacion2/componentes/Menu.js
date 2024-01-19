import { View, Text, TouchableOpacity, StyleSheet} from 'react-native'
import React , {useEffect} from 'react'
import { obtenerUbicacion, tracking } from '../Ubicaciones/UbicacionsConst'

const Menu = ({navigation}) => {
  
  return (
    <View style={styles.container}>

      <Text style={styles.title}>
        Menú de Opciones
      </Text>
        
        <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Tracking')}>
           
            
            <Text style={styles.texto}>Iniciar Rastreo</Text>

        </TouchableOpacity>
        
        <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Mapa')}>
           
            
            <Text style={styles.texto}>Ubicación</Text>
            

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
        marginLeft:20
      
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