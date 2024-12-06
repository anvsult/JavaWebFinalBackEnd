import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import FriendsPage from "./pages/FriendsPage";
import ProfilePage from "./pages/ProfilePage";
import MySideBar from "./components/MySideBar";
import PostsPage from "./pages/PostsPage";
import PostModal from "./components/PostModal";
import UsersPage from "./pages/UsersPage";
import {useEffect, useState} from "react";
import usePersistentState from "./hooks/usePersistentState";

function App() {
const [selectedUserId, setSelectedUserId] = usePersistentState("selectedUserId", null);
  return (
      <Router>
        <div style={{ display: "flex", height: "100vh" }}>

          {selectedUserId
              ? <MySideBar userId={selectedUserId}/>
              : null}
          <div style={{ flex: 1, padding: "20px", overflowY: "auto" }}>
            <Routes>
                  <Route path="/" element={<UsersPage onLogin={setSelectedUserId}/>} />
                  <Route path="/posts" element={<PostsPage selectedUserId={selectedUserId}/>} />
                  <Route path="/posts/users/:userId" element={<PostsPage selectedUserId={selectedUserId}/>} />
                  <Route path="/posts/edit/:postId" element={<PostModal />} />
                  <Route path="/profile/:userId" element={<ProfilePage />} />
                  <Route path="/friendships/:userId" element={<FriendsPage />} />
            </Routes>
          </div>
        </div>
      </Router>
  );
}

export default App;
