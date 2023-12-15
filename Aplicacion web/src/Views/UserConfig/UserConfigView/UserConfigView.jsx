import React from 'react';
import Navbar from '../../../Components/Navbar/Navbar';
import Footer from '../../../Components/Footer/Footer';
import './UserConfigView.css';
import { useNavigate } from 'react-router-dom';

function UserConfigView() {
    const navigate = useNavigate();

    return (
        <div>
            <Navbar />
            <h2>Configuración de Usuarios</h2>
            <div className='botonesUserConfig'>
                <button onClick={() => navigate('/add-user')}>Añadir Usuario</button>
                <button onClick={() => navigate('/view-user')}>Consultar Usuario</button>
            </div>
            <Footer />
        </div>
        );
}

export default UserConfigView;
