import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

function Navbar() {
  return (
    <nav className="navbar">
      <Link to="/dashboard" className="nav-item">Home</Link>
      <Link to="/settings" className="nav-item">Settings</Link>
      <Link to="/" className="nav-item">Cerrar Sesión</Link>
    </nav>
  );
}

export default Navbar;
