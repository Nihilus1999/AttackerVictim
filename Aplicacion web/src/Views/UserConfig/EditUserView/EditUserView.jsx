import React, { useState, useEffect } from 'react';
import UserModel from '../../../Models/UserModel';
import { useParams, useNavigate } from 'react-router-dom';

function EditUserView() {
  const [user, setUser] = useState({
    _nombre: '',
    _apellido: '',
    _alias: '',
    _cedula: '',
    _correo: '',
    _direccion_mac: '',
    _clave: ''
  });
  const { userId } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const userData = await UserModel.getUser(userId);
        console.log(userData['response']);
        setUser(userData['response']);
      } catch (error) {
        console.error('Error al obtener datos del usuario:', error);
        // Manejar el error
      }
    };

    fetchUser();
  }, [userId]);

  const handleInputChange = (event) => {
    setUser({ ...user, [event.target.name]: event.target.value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await UserModel.updateUser(userId, user);
      navigate('/view-user');
    } catch (error) {
      console.error('Error al actualizar el usuario:', error);
    }
  };

  return (
    <div>
      <h2>Editar Usuario</h2>
        <form className='formEditUser' onSubmit={handleSubmit}>
        <input type="text" name="_nombre" value={user._nombre} onChange={handleInputChange} />
        <input type="text" name="_apellido" value={user._apellido} onChange={handleInputChange} />
        <input type="text" name="_alias" value={user._alias} onChange={handleInputChange} />
        <input type="text" name="_cedula" value={user._cedula} onChange={handleInputChange} />
        <input type="text" name="_direccion_mac" value={user._direccion_mac} onChange={handleInputChange} />
        <input type="text" name="_correo" value={user._correo} onChange={handleInputChange} />
        <input type="text" name="_clave" value={user._clave} onChange={handleInputChange} />
        <button type="submit">Guardar Cambios</button>
        </form>
    </div>
  );
}

export default EditUserView;
