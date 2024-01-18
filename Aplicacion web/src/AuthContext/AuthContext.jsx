import React, { createContext, useContext, useState } from 'react';

const AuthContext = createContext(null);

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
    const [authState, setAuthState] = useState({
        isAuthenticated: !!localStorage.getItem('isAuthenticated')
    });

    const login = () => {
        localStorage.setItem('isAuthenticated', 'true');
        setAuthState({
            isAuthenticated: true
        });
    };

    const logout = () => {
        localStorage.removeItem('isAuthenticated');
        setAuthState({
            isAuthenticated: false
        });
    };

    return (
        <AuthContext.Provider value={{ authState, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};
