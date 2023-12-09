import React from 'react';
import Navbar from '../../Components/Navbar/Navbar';
import Card from '../../Components/Card/Card';
import Footer from '../../Components/Footer/Footer';
import userImage from '../../Images/usuarios.png';
import distanciaImage from '../../Images/distancia2.png';
import intervalosImage from '../../Images/intervalos.png';
import zonaSeguraImage from '../../Images/zona_segura.png';
import './Dashboard.css';

function Dashboard() {

    return (
        <div>
            <Navbar />
        
            <div className="dashboard">
            <div className="bg"></div>
            <div className="bg bg2"></div>
            <div className="bg bg3"></div>
                <Card imageSrc={userImage} buttonText="Usuarios" navigateTo="/user-config" />
                <Card imageSrc={distanciaImage} buttonText="Distancia minima" navigateTo="/view2" />
                <Card imageSrc={intervalosImage} buttonText="Intervalos de tiempo" navigateTo="/view3" />
                <Card imageSrc={zonaSeguraImage} buttonText="Zonas seguras" navigateTo="/view4" />
            </div>
            
            <Footer />
        </div>
    );
}

export default Dashboard;
