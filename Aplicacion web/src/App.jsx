import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginController from './Controllers/LoginController';
import Dashboard from './Views/Dashboard/Dashboard';
import View2 from './Views/View2/View2';
import View3 from './Views/View3/View3';
import View4 from './Views/View4/View4';
import View5 from './Views/View5/View5';
import Settings from './Views/Settings/Settings.jsx';
import './Views/LoginView/LoginView.css';
import './Views/UserConfig/GlobalCssUserConfig.css';
import UserConfigView from './Views/UserConfig/UserConfigView/UserConfigView.jsx';
import AddUserView from './Views/UserConfig/AddUserView/AddUserView.jsx';
import ViewUserView from './Views/UserConfig/ViewUserView.jsx';
import EditUserView from './Views/UserConfig/EditUserView/EditUserView.jsx';

function App() {
  return (
    <Router>
        <Routes>
            <Route index element={<LoginController />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/view2" element={<View2 />} />
            <Route path="/view3" element={<View3 />} />
            <Route path="/view4" element={<View4 />} />
            <Route path="/view5" element={<View5 />} />
            <Route path="/settings" element={<Settings />} />
            <Route path="/user-config" element={<UserConfigView />} />
            <Route path="/add-user" element={<AddUserView />} />
            <Route path="/view-user" element={<ViewUserView />} />
            <Route path="/editar-usuario/:userId" element={<EditUserView />} />
            
        </Routes>
    </Router>
  );
}
{/* <Route path="/add-user" element={<AddUser />} />
<Route path="/delete-user" element={<DeleteUser />} />
 */}

export default App;
