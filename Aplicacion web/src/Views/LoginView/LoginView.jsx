//import React from 'react';

function LoginView(props) {
    console.log(props);

    return (
        <div className="login-container">
            <form onSubmit={props.onSubmit} className="login-form">
                <h2>Iniciar sesión</h2>
                {props.error && <p style={{color: 'red'}}>{props.error}</p>}
                <div className="input-group">
                    <label>Usuario:</label>
                    <input 
                        type="text" 
                        value={props.username} 
                        onChange={props.onUsernameChange} 
                        required 
                    />
                </div>
                <div className="input-group">
                    <label>Contraseña:</label>
                    <input 
                        type="password" 
                        value={props.password} 
                        onChange={props.onPasswordChange} 
                        required 
                    />
                </div>
                <button type="submit" disabled={props.isLoading}>
                    {props.isLoading ? 'Cargando...' : 'Entrar'}
                </button>
            </form>
        </div>
    );
}

export default LoginView;