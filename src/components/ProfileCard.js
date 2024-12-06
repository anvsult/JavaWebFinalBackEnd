import React from 'react';
import { Button, Card } from 'react-bootstrap';
import '../styles/ProfileCard.css';
import {useNavigate} from "react-router-dom";
import {format} from "date-fns";

function ProfileCard({ profile, onDelete }) {
    const navigate = useNavigate();

    const handleFriendshipsClick = () => {
        navigate(`/friendships/${profile.userId}`);
    }
    const handlePostsClick = () => {
        navigate(`/posts/users/${profile.userId}`);
    }

    const handleProfileClick = () => (
        navigate(`/profile/${profile.userId}`)
    )


    return (
        <div className="d-flex justify-content-center align-items-center vh-100">
            <Card style={{ width: '22rem', borderRadius: '15px' }} className="mb-3 shadow-lg">
                <Card.Header
                    className="bg-teal text-white text-center rounded-top"
                    onClick={handleProfileClick}
                    style={{ cursor: "pointer" }}>
                    <h3>Profile</h3>
                </Card.Header>
                <Card.Body className="text-center">
                    <Card.Img
                        variant="top"
                        src={profile.profilePictureUrl}
                        alt="Profile"
                        className=" profile-picture"
                    />
                    <Card.Title className="card-title mt-3">{profile.userName}</Card.Title>
                    <div className={"text-start"}>
                        <Card.Text className="text-muted">
                            <strong>Email:</strong> {profile.email}
                        </Card.Text>
                        <Card.Text className="text-muted">
                            <strong>Date of Birth:</strong> {profile.dob
                            ? format(new Date(profile.dob), 'dd/MM/yyyy')
                            : "N/A"}
                        </Card.Text>
                        <Card.Text className="text-muted">
                            <strong>Registered on:</strong> {profile.registeredAt
                            ? format(new Date(profile.registeredAt), 'dd/MM/yyyy')
                            : "N/A"}
                        </Card.Text>
                        <Card.Text>{profile.bio}</Card.Text>
                    </div>
                </Card.Body>
                <Card.Footer className="d-flex justify-content-around">
                    <Button className="profile-buttons rounded-4" variant="outline-teal" onClick={handleFriendshipsClick}>
                        Friends
                    </Button>
                    <Button className="profile-buttons rounded-4" variant="outline-teal" onClick={handlePostsClick}>
                        Posts
                    </Button>


                </Card.Footer>
            </Card>
        </div>
    );
}

export default ProfileCard;
