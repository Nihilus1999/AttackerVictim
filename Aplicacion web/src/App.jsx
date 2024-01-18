import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginController from './Controllers/LoginController';
import Dashboard from './Views/Dashboard/Dashboard';
import SegureZone from './Views/SegureZone/SegureZone';
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
import NotificationView from './Views/Notificaciones/NotificationView.jsx'
import { AuthProvider } from './AuthContext/AuthContext.jsx';
import LastUbication from './Views/LastUbication/LastUbication.jsx';
import LastUbicationDetail from './Views/LastUbicationDetail/LastUbicationDetail.jsx';

function App() {
  return (
    <AuthProvider>
      <Router>
        <Navbar />
          <Notificaciones />
          <Routes>
              <Route index element={<LoginController />} />
              <Route path="/dashboard" element={<Dashboard />} />
              <Route path="/add-segure-zone/:caseId" element={<SegureZone />} />
              <Route path="/user-config" element={<UserConfigView />} />
              <Route path="/add-user" element={<AddUserView />} />
              <Route path="/view-user" element={<ViewUserView />} />
              <Route path="/editar-usuario/:userId" element={<EditUserView />} />
              <Route path="/cases" element={<CasesController />} />
              <Route path="/notification" element={<NotificationView />} />
              <Route path="/cases/:caseId" element={<CaseDetail />} />
              <Route path="/casesLastUbication" element={<LastUbication />} />
              <Route path="/casesLastUbication/:caseId" element={<LastUbicationDetail />} />
              <Route path="/segure-zone/:zoneId/case/:caseId" element={<SegureZoneDetail />} />
              <Route path="*" element={<LoginController />} />
          </Routes>
          <Footer />
      </Router>
    </AuthProvider>
  );
}

export default App;
