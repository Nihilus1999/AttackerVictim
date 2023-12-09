import React from 'react';
import Navbar from '../../Components/Navbar/Navbar';
import Footer from '../../Components/Footer/Footer';
import { useNavigate } from 'react-router-dom';

function UserConfigView() {
    const navigate = useNavigate();

    return (
        <div>
            <Navbar />
            <h2>Configuración de Usuarios</h2>
            <button onClick={() => navigate('/add-user')}>Añadir Usuario</button>
            <button onClick={() => navigate('/delete-user')}>Borrar Usuario</button>
            <button onClick={() => navigate('/edit-user')}>Editar Usuario</button>
            <button onClick={() => navigate('/view-user')}>Consultar Usuario</button>
            <Footer />
        </div>
        );
}

export default UserConfigView;
