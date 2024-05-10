import { Route, Routes } from 'react-router-dom';
import UserList from './componentes/user/UserList';
import Home from './componentes/Home';
import UserForm from './componentes/user/UserForm';
import NotFound from './componentes/NotFound';

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/user" element={<UserList />} />
      <Route path="/user/new" element={<UserForm />} />
      <Route path="*" element={<NotFound />} />
    </Routes>
  );
}

export default AppRoutes;