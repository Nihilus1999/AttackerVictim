//import React from 'react';

function LoginView(props) {
    console.log(props);

    return (
        <div className="background">
            <div className="formLogin">
                <h1 style={{textAlign: 'center'}}>Iniciar sesión</h1>
                <form onSubmit={props.onSubmit}>
                    {props.error && <p style={{color: 'red', textAlign: 'center'}}>{props.error}</p>}
                    <div className="row inputsLogin">
                        <div className="col-8">
                            <div className="form-floating mb-3">
                                <input 
                                    type="text" 
                                    className="form-control"
                                    id="floatingInput"
                                    placeholder=""
                                    value={props.username} 
                                    onChange={props.onUsernameChange} 
                                    required 
                                />
                                <label htmlFor="floatingInput">Alias</label>
                            </div>
                        </div>

                        <div className="col-8">
                            <div className="form-floating mb-3">
                                <input 
                                    type="password" 
                                    className="form-control"
                                    id="floatingPassword"
                                    placeholder=""
                                    value={props.password}
                                    onChange={props.onPasswordChange} 
                                    required 
                                />
                                <label htmlFor="floatingPassword">Contraseña</label>
                            </div>
                        </div>
                        <button className="btn btn-primary" id="loginBtn" type="submit" disabled={props.isLoading}>
                            {props.isLoading ? 'Cargando...' : 'Entrar'}
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default LoginView;