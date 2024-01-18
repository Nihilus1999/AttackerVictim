import React from 'react';
import Card from '../../Components/Card/Card';
import userImage from '../../Images/usuarios.png';
import distanciaImage from '../../Images/distancia2.png';
import intervalosImage from '../../Images/intervalos.png';
import zonaSeguraImage from '../../Images/zona_segura.png';
import { useEffect } from 'react';
import './Dashboard.css';
import { useAuth } from '../../AuthContext/AuthContext';
import { useNavigate } from "react-router-dom";

function Dashboard() {
    const { authState } = useAuth();
    const navigate = useNavigate();
    
    useEffect(() => {
        if (!authState.isAuthenticated) {
            navigate('/');
            return;
        }
    }, [authState.isAuthenticated, navigate])

    return (
        <div className='backgroundDashboard'>
            <Card imageSrc={userImage} buttonText="Usuarios" navigateTo="/user-config" />
            <Card imageSrc={zonaSeguraImage} buttonText="Zonas seguras" navigateTo="/cases" />
            <Card imageSrc={intervalosImage} buttonText="Notificaciones" navigateTo="/notification" />
            <Card imageSrc={distanciaImage} buttonText="Ultima ubicación" navigateTo="/casesLastUbication" />
        </div>
    );
}

export default Dashboard;
