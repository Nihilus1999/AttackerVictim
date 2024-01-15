import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginController from './Controllers/LoginController';
import Dashboard from './Views/Dashboard/Dashboard';
import SegureZone from './Views/SegureZone/SegureZone';
import Settings from './Views/Settings/Settings.jsx';
import './Views/LoginView/LoginView.css';
import UserConfigView from './Views/UserConfig/UserConfigView/UserConfigView.jsx';
import AddUserView from './Views/UserConfig/AddUserView/AddUserView.jsx';
import ViewUserView from './Views/UserConfig/ViewUserView.jsx';
import EditUserView from './Views/UserConfig/EditUserView/EditUserView.jsx';
import CasesController from './Controllers/CasesController.jsx';
import CaseDetail from './Views/CaseDetail/CaseDetail.jsx';
import SegureZoneDetail from './Views/SegureZoneDetail/SegureZoneDetail.jsx';
import Navbar from './Components/Navbar/Navbar.jsx';
import Footer from './Components/Footer/Footer.jsx';
import Notificaciones from './Views/Notificaciones/Notificaciones.jsx';

function App() {
  return (
    <Router>
      <Navbar />
        <Notificaciones />
        <Routes>
            <Route index element={<LoginController />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/add-segure-zone/:caseId" element={<SegureZone />} />
            <Route path="/settings" element={<Settings />} />
            <Route path="/user-config" element={<UserConfigView />} />
            <Route path="/add-user" element={<AddUserView />} />
            <Route path="/view-user" element={<ViewUserView />} />
            <Route path="/editar-usuario/:userId" element={<EditUserView />} />
            <Route path="/cases" element={<CasesController />} />
            <Route path="/cases/:caseId" element={<CaseDetail />} />
            <Route path="/segure-zone/:zoneId/case/:caseId" element={<SegureZoneDetail />} />
        </Routes>
        <Footer />
    </Router>
  );
}

export default App;
