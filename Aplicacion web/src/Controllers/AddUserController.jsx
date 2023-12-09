import React, { useState } from 'react';
import UserModel from '../Models/UserModel';

function AddUserController() {
    const [user, setUser] = useState(new UserModel('', '', '', '', '', '', '', ''));

    const handleInputChange = (event) => {
        setUser(prevUser => {
          const updatedUser = new UserModel(
            prevUser.nombres,
            prevUser.apellidos,
            prevUser.username,
            prevUser.cedula,
            prevUser.correo,
            prevUser.mac,
            prevUser.tipoUsuario,
            prevUser.contraseña
          );
          updatedUser[event.target.name] = event.target.value;
          return updatedUser;
        });
      };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
        // Llamada asíncrona a addUser
        await user.addUser();
        console.log('Usuario añadido con éxito');
        // Aquí podrías limpiar el formulario o redirigir al usuario
        } catch (error) {
        console.error('Error al añadir usuario:', error);
        // Manejo de errores, por ejemplo, mostrar un mensaje al usuario
        }
    };

    return (
        <form onSubmit={handleSubmit}>
        <input type="text" name="nombres" placeholder='Nombres' value={user.nombres} onChange={handleInputChange} />
        <input type="text" name="apellidos" placeholder='Apellidos' value={user.apellidos} onChange={handleInputChange} />
        <input type="text" name="username" placeholder='Username' value={user.username} onChange={handleInputChange} />
        <input type="text" name="cedula" placeholder='Cedula' value={user.cedula} onChange={handleInputChange} />
        <input type="text" name="correo" placeholder='Correo' value={user.correo} onChange={handleInputChange} />
        <input type="text" name="mac" placeholder='MAC' value={user.mac} onChange={handleInputChange} />
        <input type="text" name="tipoUsuario" placeholder='Tipo Usuario' value={user.tipoUsuario} onChange={handleInputChange} />
        <input type="password" name="contraseña" placeholder='Contraseña' value={user.contraseña} onChange={handleInputChange} />
        <button type="submit">Añadir Usuario</button>
        </form>
    );
}

export default AddUserController;
