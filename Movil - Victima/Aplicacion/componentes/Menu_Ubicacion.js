
import { View, Text, TouchableOpacity, StyleSheet} from 'react-native'
import React from 'react'
import CalcSep from '../Ubicaciones/CalcDistSep'
import DetAtaSeg from '../Ubicaciones/AtaZonSeg'



const MenuUbi = () => {
    
  return (
    <View style={styles.container}>

      <Text style={styles.title}>
        Opciones de Ubicacion
      </Text>
        <TouchableOpacity style={styles.button} onPress={() => DetAtaSeg()} >
           
            
            <Text style={styles.texto}>Determinar si Atacante esta en zona segura</Text>

        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => CalcSep()} >
           
            
            <Text style={styles.texto}>Calcular Distancia de separacion</Text>

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

export default MenuUbi;