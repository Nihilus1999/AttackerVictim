import React from 'react';
import { useNavigate } from 'react-router-dom';
import './Card.css';

function Card({ imageSrc, buttonText, navigateTo, isUserConfig }) {
  const navigate = useNavigate();

  return (
    <div className="card" onClick={() => navigate(navigateTo)}>
        <img src={imageSrc} alt={buttonText} className="card-image" />
        <h3 className="card-h3">{buttonText}</h3>
    </div>
  );
}

export default Card;
