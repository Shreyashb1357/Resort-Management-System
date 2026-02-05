// import { Routes, Route, Navigate } from "react-router-dom";
// import PublicLayout from "../shared/layouts/PublicLayout";
// import Home from "../features/public/Home";

// export default function AppRoutes() {
//   return (
//     <Routes>
//       <Route element={<PublicLayout />}>
//         <Route path="/" element={<Navigate to="/home" />} />
//         <Route path="/home" element={<Home />} />
//       </Route>
//     </Routes>
//   );
// }







import { Routes, Route , Navigate } from "react-router-dom";

// /* PUBLIC */
import Home from "../features/public/Home";
import ResortList from "../features/public/ResortList";
import ResortDetails from "../features/public/ResortDetails";
import Login from "../features/public/Login";
import Register from "../features/public/Register";
import ProtectedRoute from "../shared/components/ProtectedRoute";


// /* USER */
import UserDashboard from "../features/user/Dashboard";
import Profile from "../features/user/Profile";
import Bookings from "../features/user/Bookings";
import Service from "../features/user/BookingServices";
import BookingServices from "../features/user/BookingServices";
import Payment from "../features/user/Payment";
import ChangePassword from "../features/user/ChangePassword";
import BookingHistory from "../features/user/BookingHistory";
import ExistingBooking from "../features/user/ExistingBooking";
import BookingRooms from "../features/user/BookingRooms";
// import Reviews from "../features/user/Reviews";
// import Recommendations from "../features/user/Recommendations";

// /* OWNER */
// import OwnerDashboard from "../features/owner/Dashboard";
// import OwnerResorts from "../features/owner/Resorts";
// import Rooms from "../features/owner/Rooms";
// import OwnerBookings from "../features/owner/Bookings";
// import Services from "../features/owner/Services";
// import OwnerReviews from "../features/owner/Reviews";
// import Reports from "../features/owner/Reports";

// /* ADMIN */
// import AdminDashboard from "../features/admin/Dashboard";
// import MasterData from "../features/admin/MasterData";
// import Users from "../features/admin/Users";
// import AdminResorts from "../features/admin/Resorts";
// import AdminBookings from "../features/admin/Bookings";
// import AdminPayments from "../features/admin/Payments";
// import Pricing from "../features/admin/Pricing";
// import AuditLogs from "../features/admin/AuditLogs";

// /* SUPER ADMIN */
// import Admins from "../features/superAdmin/Admins";
// import Roles from "../features/superAdmin/Roles";
// import System from "../features/superAdmin/System";

function AppRoutes() {
  return (
    <Routes>

      {/* PUBLIC*/}
      <Route path="/" element={<Home />} />
      <Route path="/home" element={<Home />} />
      <Route path="/resorts" element={<ResortList />} />
      <Route path="/resort/:id" element={<ResortDetails />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />  
     
      
      {/* USER */}
      <Route path="/user/dashboard" element={<ProtectedRoute allowedRoles={["USER"]}><UserDashboard /></ProtectedRoute>}/>

     <Route path="/user/dashboard" element={<UserDashboard />} />
      <Route path="/user/profile" element={<Profile />} />
      <Route path="/user/bookings" element={<Bookings />} />
      <Route path="/user/booking/:bookingId/services" element={<BookingServices />} />
      <Route path="/user/payments" element={<Payment />} />
      <Route path="/user/change-password" element={<ChangePassword />} />
      <Route path="/user/bookingsHistory" element={<BookingHistory />} />
      <Route path="/user/existing-bookings" element={<ExistingBooking />} />
      <Route path="/user/booking/:bookingId" element={<BookingRooms />} />

      {/* <Route path="/user/reviews" element={<Reviews />} />
      <Route path="/user/recommendations" element={<Recommendations />} /> */}

      {/* OWNER */}
      {/* <Route path="/owner/dashboard" element={<OwnerDashboard />} />
      <Route path="/owner/resorts" element={<OwnerResorts />} />
      <Route path="/owner/rooms" element={<Rooms />} />
      <Route path="/owner/bookings" element={<OwnerBookings />} />
      <Route path="/owner/services" element={<Services />} />
      <Route path="/owner/reviews" element={<OwnerReviews />} />
      <Route path="/owner/reports" element={<Reports />} /> */}

      {/* ADMIN */}
      {/* <Route path="/admin/dashboard" element={ <ProtectedRoute allowedRoles={["ADMIN"]}> <AdminDashboard /> </ProtectedRoute> }/> */}


      {/* <Route path="/admin/dashboard" element={<AdminDashboard />} />
      <Route path="/admin/master" element={<MasterData />} />
      <Route path="/admin/users" element={<Users />} />
      <Route path="/admin/resorts" element={<AdminResorts />} />
      <Route path="/admin/bookings" element={<AdminBookings />} />
      <Route path="/admin/payments" element={<AdminPayments />} />
      <Route path="/admin/pricing" element={<Pricing />} />
      <Route path="/admin/audit-logs" element={<AuditLogs />} /> */}

      {/* SUPER ADMIN */}
      {/* <Route path="/super-admin/admins" element={<Admins />} />
      <Route path="/super-admin/roles" element={<Roles />} />
      <Route path="/super-admin/system" element={<System />} /> */}

    </Routes>
  );
}

export default AppRoutes;
