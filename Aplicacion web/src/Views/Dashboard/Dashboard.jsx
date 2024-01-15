import React from 'react';
import Card from '../../Components/Card/Card';
import userImage from '../../Images/usuarios.png';
import distanciaImage from '../../Images/distancia2.png';
import intervalosImage from '../../Images/intervalos.png';
import zonaSeguraImage from '../../Images/zona_segura.png';
import './Dashboard.css';

function Dashboard() {

    return (
        <div>
        
            <div className="dashboard">
            <div className="bg"></div>
            <div className="bg bg2"></div>
            <div className="bg bg3"></div>
                <Card imageSrc={userImage} buttonText="Usuarios" navigateTo="/user-config" />
                <Card imageSrc={zonaSeguraImage} buttonText="Zonas seguras" navigateTo="/cases" />
            </div>
            
        </div>
    );
}

export default Dashboard;
