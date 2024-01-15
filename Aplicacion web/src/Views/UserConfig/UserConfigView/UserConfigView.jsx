import React from 'react';
import './UserConfigView.css';
import { useNavigate } from 'react-router-dom';

function UserConfigView() {
    const navigate = useNavigate();

    return (
        <div>
            <h2>Configuración de Usuarios</h2>
            <div className='botonesUserConfig'>
                <button onClick={() => navigate('/add-user')}>Añadir Usuario</button>
                <button onClick={() => navigate('/view-user')}>Consultar Usuario</button>
            </div>
        </div>
        );
}

export default UserConfigView;
