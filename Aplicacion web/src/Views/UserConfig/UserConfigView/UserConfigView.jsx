import React from 'react';
import { useNavigate } from 'react-router-dom';
import './UserConfigView.css';
import { useAuth } from '../../../AuthContext/AuthContext';
import { useEffect } from 'react';

function UserConfigView() {
    const navigate = useNavigate();
    const { authState } = useAuth();

    useEffect(() => {
        if (!authState.isAuthenticated) {
            navigate('/');
            return;
        }
    }
    , [authState.isAuthenticated, navigate]);

    return (
        <div className='background'>
            <div className='backgroundConfig'>
                <h2>Configuración de Usuarios</h2>
                <div className='botonesUserConfig'>
                    <button onClick={() => navigate('/add-user')}>Añadir Usuario</button>
                    <button onClick={() => navigate('/view-user')}>Consultar Usuario</button>
                </div>
            </div>
        </div>
        );
}

export default UserConfigView;
