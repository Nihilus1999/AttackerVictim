import React, { useState } from 'react';
import UserModel from '../Models/UserModel';

function AddUserController() {
    const [user, setUser] = useState(new UserModel('', '', '', '', '', '', '', ''));

    const handleInputChange = (event) => {
        setUser(prevUser => {
          const updatedUser = new UserModel(
            prevUser._nombre,
            prevUser._apellido,
            prevUser._alias,
            prevUser._cedula,
            prevUser._correo,
            prevUser._direccion_mac,
            prevUser._clave
          );
          updatedUser[event.target.name] = event.target.value;
          return updatedUser;
        });
      };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
          const data = await user.addUser();
            if(data.success) {
                console.log("Usuario añadido con éxito:", data);
            } else {
                console.log("Error al añadir usuario:", data);
            }
          } catch (error) {
          console.error('Error al añadir usuario:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit} className='formulario'>
        <input type="text" name="_nombre" placeholder='Nombres' value={user._nombre} onChange={handleInputChange} />
        <input type="text" name="_apellido" placeholder='Apellidos' value={user._apellido} onChange={handleInputChange} />
        <input type="text" name="_alias" placeholder='Username' value={user._alias} onChange={handleInputChange} />
        <input type="text" name="_cedula" placeholder='Cedula' value={user._cedula} onChange={handleInputChange} />
        <input type="text" name="_correo" placeholder='Correo' value={user._correo} onChange={handleInputChange} />
        <input type="text" name="_direccion_mac" placeholder='MAC' value={user._direccion_mac} onChange={handleInputChange} />
        <input type="password" name="_clave" placeholder='Contraseña' value={user._clave} onChange={handleInputChange} />
        <button type="submit">Añadir Usuario</button>
        </form>
    );
}

export default AddUserController;
