import React from 'react';
import AddUserController from '../../../Controllers/AddUserController';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../../../AuthContext/AuthContext';
import { useEffect } from 'react';

function AddUserView() {
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
    <div>
        <div>
          <AddUserController /> 
        </div>
    </div>
  );
}

export default AddUserView;

