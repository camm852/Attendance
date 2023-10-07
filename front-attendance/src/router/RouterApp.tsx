import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Attendance from "../views/Attendance";
import NewAttendance from "../views/NewAttendance";
import Customer from "../views/Customer";
import Employee from "../views/Employee";
import Assignment from "../views/Assignment";

const RouterApp = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Attendance />} />
        <Route path="/customers" element={<Customer />} />
        <Route path="/employees" element={<Employee />} />
        <Route path="/assignments" element={<Assignment />} />

        <Route path="/new-attendance" element={<NewAttendance />} />
      </Routes>
    </Router>
  );
};

// function NotAuth({ children }: { children: JSX.Element }) {
//   const location = useLocation();
//   const getAuthlocalStorage = window.localStorage.getItem("auth");

//   if (getAuthlocalStorage !== null) {
//     const authInfo: IAuthInformation = JSON.parse(getAuthlocalStorage);

//     if (
//       authInfo.email.length > 6 &&
//       authInfo.email.includes("@" && ".com") &&
//       authInfo.name.length > 3 &&
//       authInfo.token.length > 13
//     ) {
//       return <Navigate to="/managment" state={{ from: location }} replace />;
//     }
//     return children;
//   }
//   return children;
// }

// function IsAuth({ children }: { children: JSX.Element }) {
//   const location = useLocation();
//   const getAuthlocalStorage = window.localStorage.getItem("auth");

//   if (getAuthlocalStorage !== null) {
//     const authInfo: IAuthInformation = JSON.parse(getAuthlocalStorage);

//     if (
//       authInfo.email.length > 6 &&
//       authInfo.email.includes("@" && ".com") &&
//       authInfo.name.length > 2 &&
//       authInfo.token.length > 13
//     ) {
//       return children;
//     }
//     return <Navigate to="/" state={{ from: location }} replace />;
//   }
//   return <Navigate to="/" state={{ from: location }} replace />;
// }

export default RouterApp;
