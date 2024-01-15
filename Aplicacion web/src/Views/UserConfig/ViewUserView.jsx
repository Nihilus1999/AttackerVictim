import React from 'react';
import ViewUserController from '../../Controllers/ViewUserController';
import './ViewUserView.css'

function ViewUser() {
  return (
    <div>
      <h1>Usuarios</h1>
      <ViewUserController />
    </div>
  );
}

export default ViewUser;
