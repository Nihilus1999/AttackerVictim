import { useState } from 'react';
import UserModel from '../Models/LoginModel';
import LoginView from '../Views/LoginView/LoginView';
import { useNavigate } from 'react-router-dom';

function LoginController() {
    const [model] = useState(new UserModel());
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    const handleUsernameChange = (e) => {
        model.username = e.target.value;
        setUsername(model.username);
    }

    const handlePasswordChange = (e) => {
        model.password = e.target.value;
        setPassword(model.password);
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        setIsLoading(true);
        setError(null);
        try {
            const data = await model.login();
            console.log('data: ', data);
            if (data.success) {
                console.log("Login exitoso:", data);
                navigate("/dashboard");
            } else {
                setError(data.description || "Error durante el login.");
            }
        } catch (err) {
            setError("Hubo un error al comunicarse con el servidor.");
        } finally {
            setIsLoading(false);
        }
    }

    return <LoginView 
                username={username} 
                password={password} 
                onUsernameChange={handleUsernameChange} 
                onPasswordChange={handlePasswordChange} 
                onSubmit={handleSubmit}
                isLoading={isLoading}
                error={error}
            />;
}

export default LoginController;