import React from 'react';
import AddUserController from '../../../Controllers/AddUserController';

function AddUserView() {
  return (
    <div>
        <h1>Añadir Usuario</h1>
        <div>
          <AddUserController /> 
        </div>
    </div>
  );
}

export default AddUserView;

