import React, { useState, useEffect } from 'react';
import UserModel from '../Models/UserModel';
import { useNavigate } from 'react-router-dom';



function ViewUserController() {
  const navigate = useNavigate();
  const [users, setUsers] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchUsers = async () => {
      setIsLoading(true);
      setError(null);
      try {
        const usersData = await UserModel.getAllUsers();
        const activeUsers = usersData['response'].filter(user => user._activate === true);
        setUsers(activeUsers);
      } catch (error) {
        setError(error.message);
      } finally {
        setIsLoading(false);
      }
    };

    fetchUsers();
  }, []);

  const handleDelete = async (user) => {
    setIsLoading(true);
    setError(null);
    try {
        const usersData = await UserModel.deteteUser(user);
        console.log('Despues de borrado: ', usersData);
        location.reload();
    } catch (error) {
        setError(error.message);
    } finally {
        setIsLoading(false);
    }
  };

  const handleEdit = (userId) => {
    navigate(`/editar-usuario/${userId}`);
  };

  if (isLoading) return <p>Cargando usuarios...</p>;
  if (error) return <p>Ha ocurrido un error: {error}</p>;

  return (
    <div>
      <h2>Lista de Usuarios</h2>
      <div className='divTabla'>
        <table className='tablaUsuarios'>
          <thead>
            <tr>
              <th>Nombre</th>
              <th>Apellido</th>
              <th>Correo</th>
              <th>Dirección MAC</th>
              <th>Cédula</th>
              <th>Alias</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {users.map(user => (
              <tr key={user.id}>
                  <td>{user._nombre}</td>
                  <td>{user._apellido}</td>
                  <td>{user._correo}</td>
                  <td>{user._direccion_mac}</td>
                  <td>{user._cedula}</td>
                  <td>{user._alias}</td>
                  <td className='botonesAccion'>
                      <button onClick={() => handleEdit(user.id)}>Editar</button>
                      <button onClick={() => handleDelete(user)}>Borrar</button>
                  </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ViewUserController;
