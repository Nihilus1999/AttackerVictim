import React from 'react';
import './Footer.css';

function Footer() {
  const year = new Date().getFullYear(); // Obtener el año actual

  return (
      <footer className="footerStyle" style={{}}>
          <p>© {year} RecipeApp. Todos los derechos reservados.</p>
      </footer>
  );
}

export default Footer;
