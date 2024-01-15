import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

function Navbar() {
  return (
    <>
      <nav className="navbar navbar-expand-lg" id='navbarMain'>
          <div className="container-fluid">
              <>
                  <Link to={'/dashboard'} className="navbar-brand">
                      AttackerVictim
                  </Link>
                  <div className="collapse navbar-collapse" id="navbarNav">
                      <>
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
                        </ul>
                      </>
                      <div className="nav-item dropdown">
                          <button className='nav-link dropdown-toggle' type='button' data-bs-toggle="dropdown" aria-expanded="false">
                              <i className="fa-solid fa-user" style={{marginRight: '6px'}}></i>
                              <strong>Pedro</strong>
                          </button>
                          <ul className="dropdown-menu">
                              <li><Link to={'/'} className="dropdown-item">Recetas personales</Link></li>
                              <li><hr className="dropdown-divider"/></li>
                              <li><button className='dropdown-item'>Cerrar Sesión</button></li>
                          </ul>
                      </div>
                  </div>
              </>
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
