import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import Swal from 'sweetalert2'

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
       <App /> 
    </React.StrictMode>
)