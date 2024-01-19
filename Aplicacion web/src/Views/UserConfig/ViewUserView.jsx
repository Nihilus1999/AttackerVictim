import React from 'react';
import ViewUserController from '../../Controllers/ViewUserController';
import './ViewUserView.css'
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../../AuthContext/AuthContext';
import { useEffect } from 'react';

function ViewUser() {
  const navigate = useNavigate();
  const { authState } = useAuth();

  useEffect(() => {
      if (!authState.isAuthenticated) {
          navigate('/');
          return;
      }
  }
  , [authState.isAuthenticated, navigate]);
  
  return (
    <div className='background'>
      <h1>Casos</h1>
      <div className='cardBackground'>
        <ViewUserController />
      </div>
    </div>
  );
  
}

export default ViewUser;
