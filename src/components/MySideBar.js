import React, {useEffect, useState} from "react";
import '../styles/MySideBar.css';
import {useNavigate, useParams} from "react-router-dom";
import {getData} from "../services/api-services";

function Sidebar({userId}) {
    const [profile, setProfile] = useState({});
    const [error, setError] = useState(null);
    const navigate = useNavigate();
    const handleLogoClick = () => (
        navigate("/posts")
    )
    const handleProfileClick = () => (
        navigate(`/profile/${userId}`)
    )

    useEffect(() => {
        fetchProfile(userId);
    }, [userId]);

    const fetchProfile = async (userId) => {
        const API_URL = `http://localhost:8080/users/${userId}`;
        try {
            const data = await getData(API_URL)
            setProfile(data)
        } catch (error) {
            console.error("Error fetching profile: ", error);
            setError('Invalid username or user not found');
        }
    };

    return (
        <div className="sidebar d-flex flex-column align-items-center bg-teal p-4 itim-regular">
            <h1 className="text-white mb-4"
                onClick={handleLogoClick}
                style={{ cursor: "pointer" }}>
            Linkify</h1>

            <img
                src={profile.profilePictureUrl}
                alt="Profile"
                className="rounded-circle mb-3 sidebar-img "
                onClick={handleProfileClick}
                style={{ cursor: "pointer" }}
            />

            <h2 className="text-white"
                onClick={handleProfileClick}
                style={{ cursor: "pointer" }}>
                {profile.userName}</h2>

        </div>
    );
}

export default Sidebar;