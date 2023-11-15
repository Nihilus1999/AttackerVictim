import React from 'react';
import './Footer.css';

function Footer() {
  return (
    <footer className="footer">
      <div className="footer-content">
        © 2023 AttackVictim. Todos los derechos reservados.
      </div>
      <div className="footer-links">
        <a href="/dashboard">Home</a> | 
        <a href="/settings">Configuración</a> | 
        <a href="/logout">Cerrar Sesión</a>
      </div>
    </footer>
  );
}

export default Footer;
