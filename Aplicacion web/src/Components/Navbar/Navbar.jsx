import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';
import { useAuth } from '../../AuthContext/AuthContext';

function Navbar() {
    const { logout } = useAuth();
    const user = JSON.parse(localStorage.getItem('isAuthenticated'));

  return (
    <>
      <nav className="navbar navbar-expand-lg" id='navbarMain'>
            <div className="container-fluid">
                {user === null ? (
                    <>
                    <Link to ={'/'} className="navbar-brand">AttackVictim</Link>
                        <div className="collapse navbar-collapse" id="navbarNav">
                        </div>
                    </>
                ) : (
                    <>
                        <Link to={'/dashboard'} className="navbar-brand">
                            AttackVictim
                        </Link>
                        <div className="collapse navbar-collapse" id="navbarNav">
                            <ul className="navbar-nav">
                                <li className="nav-item">
                                    <Link to={'/user-config'} className="nav-link">
                                        Usuarios
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link to={'/cases'} className="nav-link">
                                        Zonas Seguras
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link to={'/notification'} className="nav-link">
                                        Notificaciones
                                    </Link>
                                </li>
                                <li className="nav-item">
                                    <Link to={'/casesLastUbication'} className="nav-link">
                                        Ultima ubicación
                                    </Link>
                                </li>
                            </ul>
                            <div className="nav-item dropdown">
                                <button className='nav-link dropdown-toggle' type='button' data-bs-toggle="dropdown" aria-expanded="false"><i className="fa-solid fa-user" style={{marginRight: '6px'}}></i><strong>Usuario</strong></button>
                                <ul className="dropdown-menu">
                                    <li><button className='dropdown-item' onClick={logout}>Cerrar Sesión</button></li>
                                </ul>
                            </div>
                        </div>
                    </>
                )}
            </div>
        </nav>
    </>
    // <nav className="navbar">
    //   <Link to="/dashboard" className="nav-item">Home</Link>
    //   <Link to="/settings" className="nav-item">Settings</Link>
    //   <Link to="/" className="nav-item">Cerrar Sesión</Link>
    // </nav>





    
  );
}

export default Navbar;
