import React, { useState } from 'react';
import UserModel from '../Models/UserModel';
import './AddUserController.css';
import Swal from 'sweetalert2';

function AddUserController() {
    const [user, setUser] = useState(new UserModel('', '', '', '', '', '', '', ''));
    const [user2, setUser2] = useState(new UserModel('', '', '', '', '', '', '', ''));
    const [distancia, setDistancia] = useState('');

    const handleInputChange = (event) => {
      setUser(prevUser => {
        const updatedUser = new UserModel(
          prevUser._nombre,
          prevUser._apellido,
          prevUser._alias,
          prevUser._cedula,
          prevUser._correo,
          prevUser._direccion_mac,
          prevUser._clave,
          prevUser._tipo_usuario
        );
        updatedUser[event.target.name] = event.target.value;
        return updatedUser;
      });
    };

    const handleInputChange2 = (event) => {
      setUser2(prevUser2 => {
        const updatedUser2 = new UserModel(
          prevUser2._nombre,
          prevUser2._apellido,
          prevUser2._alias,
          prevUser2._cedula,
          prevUser2._correo,
          prevUser2._direccion_mac,
          prevUser2._clave,
          prevUser2._tipo_usuario
        );
        updatedUser2[event.target.name] = event.target.value;
        return updatedUser2;
      });
    };

    const handleInputChange3 = (event) => {
      setDistancia(event.target.value);
      console.log(distancia);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {

          const victim = new UserModel(
            user._nombre,
            user._apellido,
            user._alias,
            user._cedula,
            user._correo,
            user._direccion_mac,
            user._clave,
            1
          ); 

          const atack = new UserModel(
            user2._nombre,
            user2._apellido, 
            user2._alias,
            user2._cedula,
            user2._correo,
            user2._direccion_mac,
            user2._clave,
            2
          );

          console.log('Victima: ',victim);
          console.log('Atacante: ',atack);
          console.log('Distancia: ',distancia);
          var idVictim = '';
          var idAtack = '';
          var idAtackTable = '';
          var idVictimTable = '';

          //AÑADIR VICTIMA
          const data = await victim.addUser();

          if(data.success) {
            const userNew = await UserModel.getUserByNick(victim._alias);
            console.log('Usuario victima: ',userNew);

            const victim2 = userNew['response'];
            idVictim = victim2.id;

            const victima = await UserModel.addVictima(victim2.id);

            idVictimTable = victima['response'].id;

          } else {
            console.log("Error al añadir usuario:", data);
          }

          //AÑADIR ATACANTE
          const data2 = await atack.addUser();
            
          if(data2.success) {
            const userNew = await UserModel.getUserByNick(atack._alias);
            console.log('Usuario atacante: ',userNew);

            const atack2 = userNew['response'];
            idAtack = atack2.id;

            const atacante = await UserModel.addAtacante(atack2.id);
            idAtackTable = atacante['response'].id;

          } else {
            console.log("Error al añadir usuario:", data2);
          }

          //AÑADIR RELACION CON DISTANCIA
          const data3 = await UserModel.addRelacionVictimaAtacante(idVictim, idAtack, distancia, idAtackTable, idVictimTable);

          if(data3.success) {
            Swal.fire({
              title: 'Hecho!',
              text: 'Se ha registrado el caso correctamente!',
              icon: 'success',
              confirmButtonText: 'Seguir'
            }).then((result) => {
              if (result.isConfirmed) {
                window.location.href = '/dashboard';
              }
            });
          } else {
            console.log("Error al añadir relacion:", data3);
          }

          } catch (error) {
          Swal.fire({
            title: 'Error!',
            text: 'Ocurrio un error al registrar el caso',
            icon: 'error',
            confirmButtonText: 'Seguir'
          }).then((result) => {
            if (result.isConfirmed) {
              window.location.href = '/dashboard';
            }
          });
        }
    };

    return (
      <div className='background'>
        <form onSubmit={handleSubmit} className='formulario'>
          <div className='colVictim'>
            <h1>Datos de Victima</h1>
            <input type="text" name="_nombre" placeholder='Nombres' value={user._nombre} onChange={handleInputChange} />
            <input type="text" name="_apellido" placeholder='Apellidos' value={user._apellido} onChange={handleInputChange} />
            <input type="text" name="_alias" placeholder='Username' value={user._alias} onChange={handleInputChange} />
            <input type="text" name="_cedula" placeholder='Cedula' value={user._cedula} onChange={handleInputChange} />
            <input type="text" name="_correo" placeholder='Correo' value={user._correo} onChange={handleInputChange} />
            <input type="text" name="_direccion_mac" placeholder='MAC' value={user._direccion_mac} onChange={handleInputChange} />
            <input type="password" name="_clave" placeholder='Contraseña' value={user._clave} onChange={handleInputChange} />
          </div>
          <div className='colAtack'>
            <h1>Datos de Atacante</h1>
            <input type="text" name="_nombre" placeholder='Nombres' value={user2._nombre} onChange={handleInputChange2} />
            <input type="text" name="_apellido" placeholder='Apellidos' value={user2._apellido} onChange={handleInputChange2} />
            <input type="text" name="_alias" placeholder='Username' value={user2._alias} onChange={handleInputChange2} />
            <input type="text" name="_cedula" placeholder='Cedula' value={user2._cedula} onChange={handleInputChange2} />
            <input type="text" name="_correo" placeholder='Correo' value={user2._correo} onChange={handleInputChange2} />
            <input type="text" name="_direccion_mac" placeholder='MAC' value={user2._direccion_mac} onChange={handleInputChange2} />
            <input type="password" name="_clave" placeholder='Contraseña' value={user2._clave} onChange={handleInputChange2} />
          </div>
          <div className='colDistancia'>
            <h1>Distancia máxima de acercamiento</h1>
            <input type="number" name="_distancia" placeholder='Distancia' value={distancia} onChange={handleInputChange3} />
          </div>
        
        <button type="submit">Añadir Usuario</button>
        </form>
      </div>
    );
}

export default AddUserController;
