import React from 'react';
import ViewUserController from '../../Controllers/ViewUserController';
import Navbar from '../../Components/Navbar/Navbar';
import Footer from '../../Components/Footer/Footer';

function ViewUser() {
  return (
    <div>
      <Navbar />
      <h1>Usuarios</h1>
      <ViewUserController />
      <Footer />
    </div>
  );
}

export default ViewUser;
