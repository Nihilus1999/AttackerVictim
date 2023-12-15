import React from 'react';
import AddUserController from '../../../Controllers/AddUserController';
import Navbar from '../../../Components/Navbar/Navbar';
import Footer from '../../../Components/Footer/Footer';

function AddUserView() {
  return (
    <div>
      <Navbar />
        <h1>Añadir Usuario</h1>
        <div>
          <AddUserController /> 
        </div>
      <Footer />
    </div>
  );
}

export default AddUserView;

